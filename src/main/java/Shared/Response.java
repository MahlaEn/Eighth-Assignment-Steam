package Shared;

import org.json.JSONObject;

import java.io.File;
import java.io.Serializable;

public class Response implements Serializable {
    private File file;
    private JSONObject jsonObj;
    private String json;
    private String message;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public JSONObject getJsonObj() {
        return jsonObj;
    }

    public void setJsonObj(JSONObject jsonObj) {
        this.jsonObj = jsonObj;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
