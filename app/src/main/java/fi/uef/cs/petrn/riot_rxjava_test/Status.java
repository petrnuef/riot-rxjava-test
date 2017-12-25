package fi.uef.cs.petrn.riot_rxjava_test;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Petri on 25.12.2017.
 */

public class Status {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status_code")
    @Expose
    private int status_code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }
}
