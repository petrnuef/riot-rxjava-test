package fi.uef.cs.petrn.riot_rxjava_test;





import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by Petri on 25.12.2017.
 */

public interface RiotInterface {
    @GET("/lol/summoner/v3/summoners/by-name/{summonerName}")
    Call<Summoner> listSummoners(
            @Path("summonerName") String summonerName,
            @Query("api_key") String api_key
            );

    @GET("/lol/match/v3/matchlists/by-account/{accountId}")
    Call<MatchData> listMatches(
            @Path("accountId") int accountId,
            @Query("api_key") String api_key
            );
}
