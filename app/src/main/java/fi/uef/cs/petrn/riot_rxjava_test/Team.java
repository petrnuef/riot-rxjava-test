package fi.uef.cs.petrn.riot_rxjava_test;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Team {

    @SerializedName("teamId")
    @Expose
    private Integer teamId;
    @SerializedName("win")
    @Expose
    private String win;
    @SerializedName("firstBlood")
    @Expose
    private Boolean firstBlood;
    @SerializedName("firstTower")
    @Expose
    private Boolean firstTower;
    @SerializedName("firstInhibitor")
    @Expose
    private Boolean firstInhibitor;
    @SerializedName("firstBaron")
    @Expose
    private Boolean firstBaron;
    @SerializedName("firstDragon")
    @Expose
    private Boolean firstDragon;
    @SerializedName("firstRiftHerald")
    @Expose
    private Boolean firstRiftHerald;
    @SerializedName("towerKills")
    @Expose
    private Integer towerKills;
    @SerializedName("inhibitorKills")
    @Expose
    private Integer inhibitorKills;
    @SerializedName("baronKills")
    @Expose
    private Integer baronKills;
    @SerializedName("dragonKills")
    @Expose
    private Integer dragonKills;
    @SerializedName("vilemawKills")
    @Expose
    private Integer vilemawKills;
    @SerializedName("riftHeraldKills")
    @Expose
    private Integer riftHeraldKills;
    @SerializedName("dominionVictoryScore")
    @Expose
    private Integer dominionVictoryScore;
    @SerializedName("bans")
    @Expose
    private List<Object> bans = null;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public Boolean getFirstBlood() {
        return firstBlood;
    }

    public void setFirstBlood(Boolean firstBlood) {
        this.firstBlood = firstBlood;
    }

    public Boolean getFirstTower() {
        return firstTower;
    }

    public void setFirstTower(Boolean firstTower) {
        this.firstTower = firstTower;
    }

    public Boolean getFirstInhibitor() {
        return firstInhibitor;
    }

    public void setFirstInhibitor(Boolean firstInhibitor) {
        this.firstInhibitor = firstInhibitor;
    }

    public Boolean getFirstBaron() {
        return firstBaron;
    }

    public void setFirstBaron(Boolean firstBaron) {
        this.firstBaron = firstBaron;
    }

    public Boolean getFirstDragon() {
        return firstDragon;
    }

    public void setFirstDragon(Boolean firstDragon) {
        this.firstDragon = firstDragon;
    }

    public Boolean getFirstRiftHerald() {
        return firstRiftHerald;
    }

    public void setFirstRiftHerald(Boolean firstRiftHerald) {
        this.firstRiftHerald = firstRiftHerald;
    }

    public Integer getTowerKills() {
        return towerKills;
    }

    public void setTowerKills(Integer towerKills) {
        this.towerKills = towerKills;
    }

    public Integer getInhibitorKills() {
        return inhibitorKills;
    }

    public void setInhibitorKills(Integer inhibitorKills) {
        this.inhibitorKills = inhibitorKills;
    }

    public Integer getBaronKills() {
        return baronKills;
    }

    public void setBaronKills(Integer baronKills) {
        this.baronKills = baronKills;
    }

    public Integer getDragonKills() {
        return dragonKills;
    }

    public void setDragonKills(Integer dragonKills) {
        this.dragonKills = dragonKills;
    }

    public Integer getVilemawKills() {
        return vilemawKills;
    }

    public void setVilemawKills(Integer vilemawKills) {
        this.vilemawKills = vilemawKills;
    }

    public Integer getRiftHeraldKills() {
        return riftHeraldKills;
    }

    public void setRiftHeraldKills(Integer riftHeraldKills) {
        this.riftHeraldKills = riftHeraldKills;
    }

    public Integer getDominionVictoryScore() {
        return dominionVictoryScore;
    }

    public void setDominionVictoryScore(Integer dominionVictoryScore) {
        this.dominionVictoryScore = dominionVictoryScore;
    }

    public List<Object> getBans() {
        return bans;
    }

    public void setBans(List<Object> bans) {
        this.bans = bans;
    }

}