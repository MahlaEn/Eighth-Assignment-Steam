package Shared;

import Client.User;
import Server.ServerMain;
import org.json.JSONObject;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Request implements Serializable {
    static Scanner in = new Scanner(System.in);
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

    public static JSONObject showMenu() throws IOException {
        System.out.println("Enter command :\n" + "1)Login\n" + "2)SignUp" );
        int command=in.nextInt();
        switch (command) {
            case 1://Login
                String username,password;
                System.out.println("Username : ");
                username=in.next();
                System.out.println("Password : ");
                password=in.next();
                JSONObject jsonobj = new JSONObject();
                jsonobj.put("Command","Login");
                jsonobj.put("username", username);
                jsonobj.put("password", password);
                return jsonobj;

            case 2://SignUp
                System.out.println("Username : ");
                username=in.next();
                System.out.println("Password : ");
                password=in.next();
                Date date;
                while(true) {
                    System.out.println("Birth Date : ");
                    String dateString = in.next();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        date = dateFormat.parse(dateString);
                        break;
                    }
                    catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
                    }
                }
                jsonobj = new JSONObject();
                jsonobj.put("Command","SignUp");
                jsonobj.put("username", username);
                jsonobj.put("password", password);
                jsonobj.put("Birthday",date);
                return jsonobj;
        }
        return null;
    }

    public static JSONObject showUserPage() throws IOException, SQLException {
        System.out.println("Enter command :\n" + "1)List of available games\n" + "2)info about a specific game\n" + "3)Download a game\n" + "4)Logout");
        int command=in.nextInt();
        switch (command){
            case 1://List of available games

                ConnectDB DB = new ConnectDB();
                ResultSet resultSet=(DB.query("select * from Games"));
                while(resultSet.next()){
                    System.out.println(resultSet.getString("Title"));
                }

            case 2://info about a specific game

            case 3://Download a game

            case 4://Logout

        }

        return null;
    }
}
