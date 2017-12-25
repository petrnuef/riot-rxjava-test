package fi.uef.cs.petrn.riot_rxjava_test;

/**
 * Created by Petri on 25.12.2017.
 */

public class NetworkUserEvent {
    private int code;
    private Summoner user;
    private String errorMsg;

    public NetworkUserEvent(int code, Summoner user, String errorMsg) {
        this.code = code;
        this.user = user;
        this.errorMsg = errorMsg;
    }

    public NetworkUserEvent(int code, Summoner user) {
        this.code = code;
        this.user = user;
    }

    public int getCode() {
        return this.code;
    }

    public Summoner getSummoner() {
        return this.user;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Summoner getUser() {
        return user;
    }

    public void setUser(Summoner user) {
        this.user = user;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
