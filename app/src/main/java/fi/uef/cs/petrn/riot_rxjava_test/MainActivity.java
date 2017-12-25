package fi.uef.cs.petrn.riot_rxjava_test;



import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {


    @BindView(R.id.resultLvl) TextView lvl;
    @BindView(R.id.resultName) TextView name;
    @BindView(R.id.searchView) SearchView searchView;






    private String apiKey = "RGAPI-6f470b90-d03b-4705-97ce-e8683dc1f20e"; //Developer key

    private String TAG = "MainActivity";

    private String username = "heihermanni";
    private String id = "0";












    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //https://euw1.api.riotgames.com//lol/summoner/v3/summoners/by-name/heihermanni?api_key=RGAPI-6f470b90-d03b-4705-97ce-e8683dc1f20e



        //Call<MatchData> matches = services.listMatches(apiKey);

        setContentView(R.layout.activity_main);
        NetworkTasks work = new NetworkTasks();
        work.execute();

    }

    private class NetworkTasks extends AsyncTask<String, String, String> {

        private String TAG = "NetworkTasks";

        @Override
        protected String doInBackground(String... params) {
            publishProgress("Starting");

            Retrofit retofit = new Retrofit.Builder()
                    .baseUrl("https://euw1.api.riotgames.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            RiotInterface service = retofit.create(RiotInterface.class);

            Call<Summoner> user = service.listSummoners("heihermanni", apiKey);

            try {
                Response<Summoner> data = user.execute();
                Log.i(TAG, "Call worked");
            } catch(Exception e) {
                Log.e(TAG, "Call didnt work: " + e.toString());
            }
            Log.i(TAG, "Starting");

            return "moi";
        }

        protected void onProgressUpdate(String... text) {
            Log.i(TAG, "onProgressUpdate: ");
        }


        protected void onPostExecute(String result) {
            Log.i(TAG, "onPostExecute: ");
        }


    }


}
