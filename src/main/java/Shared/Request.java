package Shared;

import Client.User;
import org.json.JSONObject;

import java.io.Serializable;

public class Request implements Serializable {
    private String command;
    private User user =null;
    private JSONObject json;

    public Request(String command) {
        this.command=command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JSONObject getJson() {

        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }
}
