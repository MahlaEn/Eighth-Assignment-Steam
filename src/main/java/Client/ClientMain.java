package Client;

import Shared.Request;

import java.io.*;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import com.google.gson.Gson;

import Shared.Response;
import org.json.JSONObject;


public class ClientMain {
    static boolean loggedIn=false;
    static User user=null;
    static Request request;
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket("127.0.0.1",1234);
            System.out.println("Connected to server!");
            InputStream input = socket.getInputStream();
            OutputStream output= socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            PrintWriter writer = new PrintWriter(output,true);
            while(true) {
                if(loggedIn){

                }
                else{
                    showMenu(writer);
                }
            }
        }
        catch (UnknownHostException e){
            System.out.println("Server not found: " + e.getMessage());
        }
        catch (IOException e){
            System.out.println("I/O error " + e.getMessage());
        }
    }
    public static void showMenu(PrintWriter writer) throws IOException {
        System.out.println("Enter command :\n" + "1)Login\n" + "2)SignUp" );
        int command=in.nextInt();
        switch (command) {
            case 1://Login
                request = new Request("Login");
                String username,password;
                System.out.println("Username : ");
                username=in.next();
                System.out.println("Password : ");
                password=in.next();
                JSONObject jsonobj = new JSONObject();
                jsonobj.put("Command","Login");
                jsonobj.put("username", username);
                jsonobj.put("password", password);
                request.setJson(jsonobj);
                writer.println(request.getJson());

                break;

            case 2://SignUp
                request = new Request("SignUp");
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
                request.setJson(jsonobj);
                writer.println(request.getJson());

        }
    }
}
