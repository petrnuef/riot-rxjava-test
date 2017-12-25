package fi.uef.cs.petrn.riot_rxjava_test;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DamageTakenDiffPerMinDeltas {

    @SerializedName("10-20")
    @Expose
    private Double _1020;
    @SerializedName("0-10")
    @Expose
    private Double _010;

    public Double get1020() {
        return _1020;
    }

    public void set1020(Double _1020) {
        this._1020 = _1020;
    }

    public Double get010() {
        return _010;
    }

    public void set010(Double _010) {
        this._010 = _010;
    }

}