package fi.uef.cs.petrn.riot_rxjava_test;

import java.util.List;

/**
 * Created by Petri on 25.12.2017.
 */

public class NetworkMatchesEvent {
    private int code;
    private List<Match> matches;
    // Should never happen
    private String errorMsg;


    public NetworkMatchesEvent(int code, List<Match> matches) {
        this.code = code;
        this.matches = matches;
    }

    public NetworkMatchesEvent(int code, List<Match> matches, String errorMsg) {
        this.code = code;
        this.matches = matches;
        this.errorMsg = errorMsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
