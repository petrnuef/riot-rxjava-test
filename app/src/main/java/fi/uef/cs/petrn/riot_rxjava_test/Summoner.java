package fi.uef.cs.petrn.riot_rxjava_test;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Petri on 25.12.2017.
 */

public class Summoner {
    @SerializedName("profileIconId")
    private int profileIconId;
    @SerializedName("name")
    private String name;
    @SerializedName("summonerLevel")
    private long summonerLevel;
    @SerializedName("revisionDate")
    private long revisionDate;
    @SerializedName("id")
    private long id;
    @SerializedName("accountId")
    private long accountId;

    public Summoner(int profileIconId, String name, long summonerLevel, long revisionDate, long id, long accountId) {
        this.profileIconId = profileIconId;
        this.name = name;
        this.summonerLevel = summonerLevel;
        this.revisionDate = revisionDate;
        this.id = id;
        this.accountId = accountId;
    }


    public int getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(long summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public long getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(long revisionDate) {
        this.revisionDate = revisionDate;
    }

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



}
