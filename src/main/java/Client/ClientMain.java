package Client;

import Shared.Request;

import java.io.*;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.sql.SQLException;
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
            Socket socket = new Socket("127.0.0.1",2345);
            System.out.println("Connected to server!");
            InputStream input = socket.getInputStream();
            OutputStream output= socket.getOutputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(input));
            PrintWriter out = new PrintWriter(output,true);
            while(true) {
                if(loggedIn){
                    out.println(Request.showUserPage());
                }
                else{
                    out.println(Request.showMenu());
                }
            }
        }
        catch (UnknownHostException e){
            System.out.println("Server not found: " + e.getMessage());
        }
        catch (IOException e){
            System.out.println("I/O error " + e.getMessage());
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
