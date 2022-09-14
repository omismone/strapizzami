package com.omismone.strapizzami.services.dao.rdb;


import java.io.*;
import java.math.BigDecimal;
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
    /**
     * call startConnection() before this method!
     * AND call closeConnection() after!!
     * @return
     */
    public ResultSet getAdmins(Connection connection){
        try {
            String query = "select * from gestore;";
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
    public Boolean insertPizza(Connection connection, String name, String classe, Boolean visibility){
        try {
        	PreparedStatement statement;
            String query = "insert into pizza(NOME,CLASSE,VISIBILE) values (?,?,?);";
			statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, classe);
			statement.setInt(3, visibility ? 1 : 0);
			statement.executeUpdate();
			return true;
        }
        catch (SQLException e) { return false; }
    }
    /**
     * call startConnection() before this method!
     * AND call closeConnection() after!!
     * @return
     */
    public Boolean insertIngredient(Connection connection, String name, Boolean frozen, float price){
        try {
        	PreparedStatement statement;
            String query = "insert into ingrediente(NOME,SURGELATO,PREZZO) values (?,?,?);";
			statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setInt(2, frozen ? 1 : 0);
			statement.setBigDecimal(3, new BigDecimal(String.format("%.2f", price)));
			statement.executeUpdate();
			return true;
        }
        catch (SQLException e) { return false; }
    }
    /**
     * call startConnection() before this method!
     * AND call closeConnection() after!!
     * @return
     */
    public Boolean insertPI(Connection connection, String pizza_name, String ingredient_name){
        try {
        	PreparedStatement statement;
            String query = "insert into pi(PIZZA,INGREDIENTE) values (?,?);";
			statement = connection.prepareStatement(query);
			statement.setString(1, pizza_name);
			statement.setString(2, ingredient_name);
			statement.executeUpdate();
			return true;
        }
        catch (SQLException e) { return false; }
    }
    /**
     * call startConnection() before this method!
     * AND call closeConnection() after!!
     * @return
     */
    public Boolean insertPF(Connection connection, String pizza_name, String format_name, float price){
        try {
        	PreparedStatement statement;
            String query = "insert into pf(PREZZO,PIZZA,FORMATO) values (?,?,?);";
			statement = connection.prepareStatement(query);
			statement.setBigDecimal(1, new BigDecimal(String.format("%.2f", price)));
			statement.setString(2, pizza_name);
			statement.setString(3, format_name);
			statement.executeUpdate();
			return true;
        }
        catch (SQLException e) { return false; }
    }
    /**
     * call startConnection() before this method!
     * AND call closeConnection() after!!
     * @return
     */
    public Boolean insertClasse(Connection connection, String name, String description, int relevance){
        try {
        	PreparedStatement statement;
            String query = "insert into pf(NOME,DESCRIZIONE,IMPORTANZA) values (?,?,?);";
			statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, description);
			statement.setInt(3, relevance);
			statement.executeUpdate();
			return true;
        }
        catch (SQLException e) { return false; }
    }
    /**
     * call startConnection() before this method!
     * AND call closeConnection() after!!
     * @return
     */
    public Boolean insertFormat(Connection connection, String name){
        try {
        	PreparedStatement statement;
            String query = "insert into formato(NOME) values (?);";
			statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.executeUpdate();
			return true;
        }
        catch (SQLException e) { return false; }
    }
}
