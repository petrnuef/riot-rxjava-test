package fi.uef.cs.petrn.riot_rxjava_test;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("platformId")
    @Expose
    private String platformId;
    @SerializedName("accountId")
    @Expose
    private Integer accountId;
    @SerializedName("summonerName")
    @Expose
    private String summonerName;
    @SerializedName("summonerId")
    @Expose
    private Integer summonerId;
    @SerializedName("currentPlatformId")
    @Expose
    private String currentPlatformId;
    @SerializedName("currentAccountId")
    @Expose
    private Integer currentAccountId;
    @SerializedName("matchHistoryUri")
    @Expose
    private String matchHistoryUri;
    @SerializedName("profileIcon")
    @Expose
    private Integer profileIcon;

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public Integer getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(Integer summonerId) {
        this.summonerId = summonerId;
    }

    public String getCurrentPlatformId() {
        return currentPlatformId;
    }

    public void setCurrentPlatformId(String currentPlatformId) {
        this.currentPlatformId = currentPlatformId;
    }

    public Integer getCurrentAccountId() {
        return currentAccountId;
    }

    public void setCurrentAccountId(Integer currentAccountId) {
        this.currentAccountId = currentAccountId;
    }

    public String getMatchHistoryUri() {
        return matchHistoryUri;
    }

    public void setMatchHistoryUri(String matchHistoryUri) {
        this.matchHistoryUri = matchHistoryUri;
    }

    public Integer getProfileIcon() {
        return profileIcon;
    }

    public void setProfileIcon(Integer profileIcon) {
        this.profileIcon = profileIcon;
    }

}