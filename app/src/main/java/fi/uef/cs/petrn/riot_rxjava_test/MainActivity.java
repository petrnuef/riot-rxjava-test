package fi.uef.cs.petrn.riot_rxjava_test;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.resultLvl) TextView lvl;
    @BindView(R.id.resultName) TextView name;
    @BindView(R.id.searchView) SearchView searchView;






    private String apiKey = "RGAPI-c31971df-9fc5-457e-a45a-22cd5be9903e"; //Developer key

    private String TAG = "MainActivity";

    private String username = "heihermanni";
    private String id = "0";

    OkHttpClient client = new OkHttpClient();



    final Observable<String> dataFromRiot = Observable.create(emitter ->  {
        //String username = "heihermanni";
        String url = "https://euw.api.pvp.net/api/lol/euw/v1.4/summoner/by-name/" + username + "?api_key=" + apiKey;
        Log.i(TAG, "kutsutaan " + url);
        emitter.onNext(run(url));
        emitter.onComplete();

    });

    final Observable<String> matchData = Observable.create(emitter -> {
        String url = "https://euw.api.pvp.net/api/lol/euw/v2.2/matchlist/by-summoner/" + id + "?api_key=" + apiKey;
        Log.i(TAG, "kutsutaan " + url);
        emitter.onNext(run(url));
        emitter.onComplete();
    });

    String run(String url) {
        Request req = new Request.Builder()
                .url(url)
                .build();
        try {
            Response r = client.newCall(req).execute();
            return r.body().string().toString();
        } catch(Exception e) {
            Log.i(TAG, "error while loading data: " + e.toString());
            return "Error";
        }


    }

    CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Disposable subscribe = dataFromRiot
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(data -> {
                    updateTheUserInterface(data);

                });
        disposable.add(subscribe);

        //SearchView searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                username = s;

                Disposable subscribe = dataFromRiot
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(data -> {
                            updateTheUserInterface(data);

                        });
                disposable.add(subscribe);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

    /*
        firstButton.setOnClickListener(v-> {
            firstButton.setEnabled(false);
            Disposable subscribe = dataFromRiot
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(string -> {
                        updateTheUserInterface(string);
                        firstButton.setEnabled(true); //
                    });
            disposable.add(subscribe);
        });
        */
    }

    private void updateTheUserInterface(String i) {
        if(i == "Error") {
            Log.i(TAG, "Error päivityksessä");
            Toast t = Toast.makeText(getApplicationContext(), "Error while loading data", Toast.LENGTH_SHORT);
            t.show();
        } else {
            try {
                JSONObject object = new JSONObject(i);
                JSONObject o = (JSONObject) object.get(username.toLowerCase());
                name.setText(o.get("name").toString());
                lvl.setText(o.get("summonerLevel").toString());
                id = o.get("id").toString();
                Log.i(TAG, o.toString());
                Disposable subscribe = matchData
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(string -> {
                            updateMatchList(string);

                        });
                disposable.add(subscribe);
            } catch (Exception e) {
                Log.i(TAG, "error: " + e);
            }
        }

        //resultView.setText(i);
    }

    private void updateMatchList(String i) {
        Log.i(TAG, i);
    }
}
