package services.dao.rdb;


import java.io.*;
import java.sql.*;
import java.util.Properties;

public class RDBOperator {
    private static RDBOperator singleton;
    private String URL = ""; //expected: jdbc:mysql://localhost:3306/thoth
    private String USERNAME = "";
    private String PW = "";

    /**
     * this is the class that communicate with mysql DB
     * see the file README in the same package of this file
     * @throws IOException
     */
    private RDBOperator() throws IOException {
        InputStream input = this.getClass().getResourceAsStream("config.properties");
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
            throw new RuntimeException(e);
        }
        return singleton;
    }

    public Connection startConnection() throws SQLException {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(URL,USERNAME,PW);
            return connection;
        }
        catch (InstantiationException e) { throw new RuntimeException(e); }
        catch (IllegalAccessException e) { throw new RuntimeException(e); }
        catch (ClassNotFoundException e) { throw new RuntimeException(e); }
    }

    public void closeConnection(Connection conn) throws SQLException {
        if(!conn.isClosed()) conn.close();
    }

    /**
     * call startConnection() before this method!
     * AND call closeConnection() after!!
     * @return
     */
    public ResultSet getPizzas(Connection connection){
        try {
            String query = "select * from pizza;";
            Statement statement;
            ResultSet result;

            statement = connection.createStatement();
            result = statement.executeQuery(query);

            return result;
        }
        catch (SQLException e) { return null; }
    }
    /**
     * call startConnection() before this method!
     * AND call closeConnection() after!!
     * @return
     */
    public ResultSet getDishes(Connection connection){
        try {
            String query = "select * from pietanza;";
            Statement statement;
            ResultSet result;

            statement = connection.createStatement();
            result = statement.executeQuery(query);

            return result;
        }
        catch (SQLException e) { return null; }
    }
    /**
     * call startConnection() before this method!
     * AND call closeConnection() after!!
     * @return
     */
    public ResultSet getDrinks(Connection connection){
        try {
            String query = "select * from bevanda;";
            Statement statement;
            ResultSet result;

            statement = connection.createStatement();
            result = statement.executeQuery(query);

            return result;
        }
        catch (SQLException e) { return null; }
    }
    /**
     * call startConnection() before this method!
     * AND call closeConnection() after!!
     * @return
     */
    public ResultSet getClassi(Connection connection){
        try {
            String query = "select * from classe;";
            Statement statement;
            ResultSet result;

            statement = connection.createStatement();
            result = statement.executeQuery(query);

            return result;
        }
        catch (SQLException e) { return null; }
    }
    /**
     * call startConnection() before this method!
     * AND call closeConnection() after!!
     * @return
     */
    public ResultSet getFormats(Connection connection){
        try {
            String query = "select * from formato;";
            Statement statement;
            ResultSet result;

            statement = connection.createStatement();
            result = statement.executeQuery(query);

            return result;
        }
        catch (SQLException e) { return null; }
    }
    /**
     * call startConnection() before this method!
     * AND call closeConnection() after!!
     * @return
     */
    public ResultSet getIngredients(Connection connection){
        try {
            String query = "select * from ingrediente;";
            Statement statement;
            ResultSet result;

            statement = connection.createStatement();
            result = statement.executeQuery(query);

            return result;
        }
        catch (SQLException e) { return null; }
    }
    /**
     * call startConnection() before this method!
     * AND call closeConnection() after!!
     * @return
     */
    public ResultSet getPFS(Connection connection){
        try {
            String query = "select * from pf;";
            Statement statement;
            ResultSet result;

            statement = connection.createStatement();
            result = statement.executeQuery(query);

            return result;
        }
        catch (SQLException e) { return null; }
    }
    /**
     * call startConnection() before this method!
     * AND call closeConnection() after!!
     * @return
     */
    public ResultSet getPIS(Connection connection){
        try {
            String query = "select * from pi;";
            Statement statement;
            ResultSet result;

            statement = connection.createStatement();
            result = statement.executeQuery(query);

            return result;
        }
        catch (SQLException e) { return null; }
    }
    /**
     * call startConnection() before this method!
     * AND call closeConnection() after!!
     * @return
     */
    public ResultSet getIPS(Connection connection){
        try {
            String query = "select * from ip;";
            Statement statement;
            ResultSet result;

            statement = connection.createStatement();
            result = statement.executeQuery(query);

            return result;
        }
        catch (SQLException e) { return null; }
    }
}
