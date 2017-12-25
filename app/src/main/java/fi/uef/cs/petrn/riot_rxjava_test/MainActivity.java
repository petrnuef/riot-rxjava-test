package fi.uef.cs.petrn.riot_rxjava_test;



import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;

import android.widget.TextView;
import android.widget.Toast;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.widget.Toast.LENGTH_SHORT;


public class MainActivity extends AppCompatActivity {

    public static final int CALL_OK     = 10;
    public static final int CALL_NOT_OK = 20;
    public static final int CALL_404    = 404;


    @BindView(R.id.resultLvl)   TextView lvl;
    @BindView(R.id.resultName)  TextView name;
    @BindView(R.id.error)       TextView errorView;
    @BindView(R.id.searchView)  SearchView searchView;
    @BindView(R.id.matches)     LinearLayout matches;
    @BindView(R.id.match)       LinearLayout match;
    @BindView(R.id.data)        LinearLayout data;



    private String apiKey = "RGAPI-6f470b90-d03b-4705-97ce-e8683dc1f20e"; //Developer key

    private String TAG = "MainActivity";

    private String username = "heihermanni";
    private String id = "0";


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNetworkUserEvent(NetworkUserEvent data) {
        switch(data.getCode()) {
            case 10:
                Log.i(TAG, "Data: " + data.getSummoner().getName());
                updateProfileData(data.getSummoner());
                break;
            case 20:
                updateProfileDataWithError("404");
                break;

            case 404:
                updateProfileDataWithError(data.getErrorMsg());
                break;
            default:
                break;
        }

    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onNetworkMatchEvent(NetworkMatchEvent data) {
        switch(data.getCode()) {
            case 10:
                break;
            case 20:
                break;
            default:
                break;
        }

    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onNetworkMatchesEvent(NetworkMatchesEvent data) {
        switch(data.getCode()) {
            case 10:
                updateMaches(data.getMatches());
                break;
            case 20:
                break;
            default:
                break;


        }
    }

    public void updateProfileData(Summoner summoner) {
        name.setVisibility(View.VISIBLE);
        lvl.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
        name.setText(summoner.getName());
        StringBuilder ss = new StringBuilder();
        ss.append("Level: ").append(summoner.getSummonerLevel());
        lvl.setText(ss.toString());
    }

    public void updateProfileDataWithError(String error) {
        Toast t = Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT);
        t.show();
        name.setVisibility(View.GONE);
        lvl.setVisibility(View.GONE);
        errorView.setText(error);
    }



    public void updateMaches(List<Match> matchesData) {
        final TextView[] matchViews = new TextView[matchesData.size()];
        matches.setVisibility(View.VISIBLE);
        data.setVisibility(View.GONE);
        match.setVisibility(View.GONE);
        final TextView t = new TextView(this);
        Match m = matchesData.get(1);
        t.setText("" + m.getGameId());
        Log.i("VITTU", "" + m.getGameId());
        matches.addView(t);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //https://euw1.api.riotgames.com//lol/match/v3/matches/3462045652?api_key=RGAPI-6f470b90-d03b-4705-97ce-e8683dc1f20e



        //Call<MatchData> matches = services.listMatches(apiKey);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //name.setText("das");
        NetworkTasks work = new NetworkTasks();
        work.execute();

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private class NetworkTasks extends AsyncTask<String, String, String> {

        private String TAG = "NetworkTasks";
        private String username = "heihermanni";
        private Retrofit retrofit = new Retrofit.Builder()
                                        .baseUrl("https://euw1.api.riotgames.com/")
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build();

        private RiotInterface service = retrofit.create(RiotInterface.class);

        private Summoner currentSummoner = null;

        @Override
        protected String doInBackground(String... params) {


            publishProgress("Starting");
            getUserInfo();

            return "moro";
        }

        protected void getUserInfo() {
            Call<Summoner> user = service.listSummoners(username, apiKey);

            try {
                Log.i(TAG, "Network call: Userdata");
                Response<Summoner> resp = user.execute();
                if(resp.code() != 200) {
                    Log.i(TAG, "Userdata response code != 200");
                    StringBuilder ss = new StringBuilder();
                    ss.append("Could not find user \"" + username + "\"");
                    EventBus.getDefault().post(new NetworkUserEvent(CALL_404, null, ss.toString()));
                } else {
                    Log.i(TAG, "Userdata responsecode 200");
                    currentSummoner = resp.body();
                    EventBus.getDefault().post(new NetworkUserEvent(CALL_OK, resp.body()));
                    getMachesInfo();
                }
            }   catch(Exception e) {
                Log.e(TAG, "Network call failed: " + e.toString());
                EventBus.getDefault().post(new NetworkUserEvent(CALL_NOT_OK, null));
            }
        }

        protected void getMachesInfo() {
            Call<MatchData> matches = service.listMatches(currentSummoner.getAccountId(), apiKey);
            try {
                Log.i(TAG, "Network request: matches");
                Response<MatchData> data = matches.execute();
                if(data.code() != 200) {
                    Log.e(TAG, "Networkcall for matches != 200");
                } else {
                    Log.i(TAG, "Matches responsecode 200");
                    Log.i(TAG, "" + data.body().getEndIndex());
                    List<Match> s = data.body().getMatches();
                    Match m = s.get(0);
                    Log.i(TAG, "" + m.getGameId());
                }

            } catch(Exception e) {
                Log.e(TAG, "Network request for matches failed");

            }
        }

        protected void onProgressUpdate(String... text) {
            Log.i(TAG, "onProgressUpdate: ");
        }


        protected void onPostExecute(String result) {
            Log.i(TAG, "onPostExecute: ");

        }


    }


}
