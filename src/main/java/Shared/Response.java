package Shared;

import org.json.JSONObject;

import java.io.File;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Response implements Serializable {
    private File file;
    private JSONObject jsonObj;
    private String json;
    private String message;

    public Response(String json) {
        this.json = json;
    }


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
    public static JSONObject Login(JSONObject json) throws SQLException {
        String username=json.getString("username");
        String password=json.getString("password");
        ConnectDB DB = new ConnectDB();
        ResultSet resultSet=(DB.query("SELECT * FROM \"Steam\".\"accounts\" \n"));
        while(resultSet.next()){
            if(resultSet.getString("Username").equals(username) && resultSet.getString("Password").equals(password)){
                json.put("status",true);
                return json;
            }
        }
        json.put("status",false);
        return json;
    }
    public static JSONObject SignUp(JSONObject json) {

        return null;
    }
}
