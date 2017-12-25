package fi.uef.cs.petrn.riot_rxjava_test;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MData {

    @SerializedName("gameId")
    @Expose
    private Integer gameId;
    @SerializedName("platformId")
    @Expose
    private String platformId;
    @SerializedName("gameCreation")
    @Expose
    private Integer gameCreation;
    @SerializedName("gameDuration")
    @Expose
    private Integer gameDuration;
    @SerializedName("queueId")
    @Expose
    private Integer queueId;
    @SerializedName("mapId")
    @Expose
    private Integer mapId;
    @SerializedName("seasonId")
    @Expose
    private Integer seasonId;
    @SerializedName("gameVersion")
    @Expose
    private String gameVersion;
    @SerializedName("gameMode")
    @Expose
    private String gameMode;
    @SerializedName("gameType")
    @Expose
    private String gameType;
    @SerializedName("teams")
    @Expose
    private List<Team> teams = null;
    @SerializedName("participants")
    @Expose
    private List<Participant> participants = null;
    @SerializedName("participantIdentities")
    @Expose
    private List<ParticipantIdentity> participantIdentities = null;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public Integer getGameCreation() {
        return gameCreation;
    }

    public void setGameCreation(Integer gameCreation) {
        this.gameCreation = gameCreation;
    }

    public Integer getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(Integer gameDuration) {
        this.gameDuration = gameDuration;
    }

    public Integer getQueueId() {
        return queueId;
    }

    public void setQueueId(Integer queueId) {
        this.queueId = queueId;
    }

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    public Integer getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    public String getGameVersion() {
        return gameVersion;
    }

    public void setGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<ParticipantIdentity> getParticipantIdentities() {
        return participantIdentities;
    }

    public void setParticipantIdentities(List<ParticipantIdentity> participantIdentities) {
        this.participantIdentities = participantIdentities;
    }

}