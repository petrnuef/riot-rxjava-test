package fi.uef.cs.petrn.riot_rxjava_test;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Petri on 25.12.2017.
 */

public class MatchData {
    @SerializedName("matches")
    private List<Match> matches;
    @SerializedName("totalGames")
    private int totalGames;
    @SerializedName("startIndex")
    private int startIndex;
    @SerializedName("endIndex")
    private int endIndex;

    public MatchData(List<Match> matches, int totalGames, int startIndex, int endIndex) {
        this.matches = matches;
        this.totalGames = totalGames;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }


}
