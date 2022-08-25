package services.dao.rdb;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class RDBOperator {
    private static RDBOperator singleton;
    private String URL = "jdbc:mysql://localhost:3306/thoth";
    private String USERNAME = "hermes";
    private String PW = "censored";
    private Connection connection;

    /**
     * this is the class that communicate with mysql DB
     * see the file README in the same package of this file
     * @throws IOException
     */
    private RDBOperator() throws IOException {
        InputStream input = new FileInputStream("config.properties");
        Properties prop = new Properties();
        // load a properties file
        prop.load(input);
        // get the property value and print it out
        URL = "jdbc:mysql://" + prop.getProperty("db.url")
                + ":" + prop.getProperty("db.port")
                + "/" + prop.getProperty("db.schema");
        USERNAME = prop.getProperty("db.user");
        PW = prop.getProperty("db.password");
    }

    public static RDBOperator getInstance(){
        try{
            if(singleton == null) singleton = new RDBOperator();
        } catch (IOException e) {
            singleton = null;
        }
        return singleton;
    }

    private void startConnection() throws SQLException {
        if(connection == null)
            connection = DriverManager.getConnection(URL,USERNAME,PW);
    }

    private void closeConnection() throws SQLException {
        if(!connection.isClosed()) connection.close();
    }

    public ResultSet getPizzas(){
        try {
            startConnection();

            String query = "select * from pizza;";
            Statement statement;
            ResultSet result;

            statement = connection.createStatement();
            result = statement.executeQuery(query);

            closeConnection();
            return result;
        }
        catch (SQLException e) { return null; }
    }

    public ResultSet getDishes(){
        try {
            startConnection();

            String query = "select * from pietanza;";
            Statement statement;
            ResultSet result;

            statement = connection.createStatement();
            result = statement.executeQuery(query);

            closeConnection();
            return result;
        }
        catch (SQLException e) { return null; }
    }

    public ResultSet getDrinks(){
        try {
            startConnection();

            String query = "select * from bevanda;";
            Statement statement;
            ResultSet result;

            statement = connection.createStatement();
            result = statement.executeQuery(query);

            closeConnection();
            return result;
        }
        catch (SQLException e) { return null; }
    }

    public ResultSet getClassi(){
        try {
            startConnection();

            String query = "select * from classe;";
            Statement statement;
            ResultSet result;

            statement = connection.createStatement();
            result = statement.executeQuery(query);

            closeConnection();
            return result;
        }
        catch (SQLException e) { return null; }
    }

    public ResultSet getFormats(){
        try {
            startConnection();

            String query = "select * from formato;";
            Statement statement;
            ResultSet result;

            statement = connection.createStatement();
            result = statement.executeQuery(query);

            closeConnection();
            return result;
        }
        catch (SQLException e) { return null; }
    }

    public ResultSet getIngredients(){
        try {
            startConnection();

            String query = "select * from ingrediente;";
            Statement statement;
            ResultSet result;

            statement = connection.createStatement();
            result = statement.executeQuery(query);

            closeConnection();
            return result;
        }
        catch (SQLException e) { return null; }
    }

    public ResultSet getPFS(){
        try {
            startConnection();

            String query = "select * from pf;";
            Statement statement;
            ResultSet result;

            statement = connection.createStatement();
            result = statement.executeQuery(query);

            closeConnection();
            return result;
        }
        catch (SQLException e) { return null; }
    }

    public ResultSet getPIS(){
        try {
            startConnection();

            String query = "select * from pi;";
            Statement statement;
            ResultSet result;

            statement = connection.createStatement();
            result = statement.executeQuery(query);

            closeConnection();
            return result;
        }
        catch (SQLException e) { return null; }
    }

    public ResultSet getIPS(){
        try {
            startConnection();

            String query = "select * from ip;";
            Statement statement;
            ResultSet result;

            statement = connection.createStatement();
            result = statement.executeQuery(query);

            closeConnection();
            return result;
        }
        catch (SQLException e) { return null; }
    }
}
