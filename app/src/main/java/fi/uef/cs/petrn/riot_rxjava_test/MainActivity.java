package fi.uef.cs.petrn.riot_rxjava_test;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
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

        Retrofit retofit = new Retrofit.Builder()
                .baseUrl("https://euw1.api.riotgames.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RiotInterface service = retofit.create(RiotInterface.class);

        Call<Summoner> user = service.listSummoners("heihermanni", apiKey);



        setContentView(R.layout.activity_main);






    }


}
