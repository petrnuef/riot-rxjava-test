package fi.uef.cs.petrn.riot_rxjava_test;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Petri on 25.12.2017.
 */

public class Match {
    @SerializedName("lane")
    private String lane;
    @SerializedName("gameId")
    private long gameId;
    @SerializedName("champion")
    private int champion;
    @SerializedName("platformId")
    private String platformId;
    @SerializedName("season")
    private int season;
    @SerializedName("queue")
    private int queue;
    @SerializedName("role")
    private String role;
    @SerializedName("timestamp")
    private long timestamp;

    public Match(String lane, long gameId, int champion, String platformId, int season, int queue, String role, long timestamp) {
        this.lane = lane;
        this.gameId = gameId;
        this.champion = champion;
        this.platformId = platformId;
        this.season = season;
        this.queue = queue;
        this.role = role;
        this.timestamp = timestamp;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public int getChampion() {
        return champion;
    }

    public void setChampion(int champion) {
        this.champion = champion;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
