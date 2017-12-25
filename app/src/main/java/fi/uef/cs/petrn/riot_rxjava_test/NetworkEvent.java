package fi.uef.cs.petrn.riot_rxjava_test;

/**
 * Created by Petri on 25.12.2017.
 */

public class NetworkEvent {

    private int code;
    private Summoner user;

    public NetworkEvent(int code, Summoner user) {
        this.code = code;
        this.user = user;
    }

    public int getCode() {
        return this.code;
    }

    public Summoner getSummoner() {
        return this.user;
    }
}
