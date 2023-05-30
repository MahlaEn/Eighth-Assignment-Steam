package Shared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
public class ConnectDB {
    static Statement statement;
    static private Connection connection;
    public ConnectDB() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AP","postgres","12345678");
            statement = connection.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Statement getStatement() {
        return statement;
    }

    public static void setStatement(Statement statement) {
        ConnectDB.statement = statement;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        ConnectDB.connection = connection;
    }

    public ResultSet query(String sql){
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}