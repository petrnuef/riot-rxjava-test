package fi.uef.cs.petrn.riot_rxjava_test;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Summoner {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("accountId")
    @Expose
    private long accountId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("profileIconId")
    @Expose
    private int profileIconId;
    @SerializedName("revisionDate")
    @Expose
    private long revisionDate;
    @SerializedName("summonerLevel")
    @Expose
    private long summonerLevel;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }

    public long getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(long revisionDate) {
        this.revisionDate = revisionDate;
    }

    public long getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(long summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

}