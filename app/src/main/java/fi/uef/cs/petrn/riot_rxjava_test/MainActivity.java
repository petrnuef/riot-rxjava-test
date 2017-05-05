package fi.uef.cs.petrn.riot_rxjava_test;


import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONObject;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private String apiKey = "RGAPI-c31971df-9fc5-457e-a45a-22cd5be9903e";

    private String TAG = "MainActivity";

    OkHttpClient client = new OkHttpClient();

    final Observable<Integer> serverDownloadObservable = Observable.create(emitter -> {
        SystemClock.sleep(10000); // simulate delay
        emitter.onNext(5);
        emitter.onComplete();
    });

    final Observable<String> dataFromRiot = Observable.create(emitter ->  {
        String url = "https://euw.api.pvp.net/api/lol/euw/v1.4/summoner/by-name/heihermanni?api_key=" + apiKey;
        Log.i(TAG, "kutsutaan " + url);
        emitter.onNext(run(url));
        emitter.onComplete();

    });

    String run(String url) throws IOException {
        Request req = new Request.Builder()
                .url(url)
                .build();

        Response r = client.newCall(req).execute();
        return r.body().string().toString();
    }

    CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.first);
        view.setOnClickListener(v-> {
            view.setEnabled(false);
            Disposable subscribe = dataFromRiot
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(string -> {
                        updateTheUserInterface(string);
                        v.setEnabled(true); //
                    });
            disposable.add(subscribe);
        });
    }

    private void updateTheUserInterface(String i) {
        TextView v = (TextView) findViewById(R.id.resultView);
        String jsonData = i;
        try {
            JSONObject object = new JSONObject(jsonData);
            JSONObject o = (JSONObject) object.get("heihermanni");
            Log.i(TAG, o.toString());
        } catch(Exception e) {
            Log.i(TAG, "error: " + e);
        }

        v.setText(i);
    }
}
