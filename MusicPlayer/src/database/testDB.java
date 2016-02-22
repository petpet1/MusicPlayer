package database;

import java.sql.*;

public class testDB
{

    static Connection c = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    public testDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        //System.out.println("Opened database successfully");
    }
    
    public static void addTables() {
        try
        {
            //Create/open database
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            
            //Create table
            stmt = c.createStatement();
            String sql = "CREATE TABLE SONGS" + 
                         "(ID INT PRIMARY KEY    NOT NULL,"+
                         "NAME          TEXT   NOT NULL,"+
                         "ARTIST        TEXT   NOT NULL,"+
                         "GENRE         TEXT   NOT NULL,"+
                         "POPULARITY    INT    NOT NULL,"+
                         "LOCATION      TEXT   NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();         
            }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println(e.getClass().getName() + ": "+ e.getMessage());
            System.exit(0);
        }
    }
    
    public static boolean q(String sql) {
        try{
        stmt = c.createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
        c.commit();

        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong here in the insert");
            return false;
        }
        return true;
    }
    
    public ResultSet select(String sql) {
        try{
            stmt = c.createStatement();
            rs = stmt.executeQuery(sql);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong here in the insert");
            return rs;
        }
        //System.out.println("IT ACTUALLY WORKED");

        return rs;
    }

    public boolean close() throws SQLException {
        stmt.close();
        c.close();
        return true;
    }
    
    public static void main(String[] args) {
            testDB a = new testDB();
            addTables();
            
            String sql = "INSERT INTO SONGS (ID,NAME,ARTIST,GENRE,POPULARITY, LOCATION) " +
                   "VALUES (1, 'Take me to church', 'Hoozier', 'RNB', 100,'songs/1.mp3');"; 
            q(sql);  
            sql = "INSERT INTO SONGS (ID,NAME,ARTIST,GENRE,POPULARITY, LOCATION) " +
                   "VALUES (2, 'Adorn', 'Miguel', 'RNB', 30,'songs/2.mp3');";
            q(sql);
            sql = "INSERT INTO SONGS (ID,NAME,ARTIST,GENRE,POPULARITY, LOCATION) " +
                   "VALUES (3, 'U Remind Me', 'Usher', 'RNB', 100,'songs/3.mp3');";
            q(sql);
            sql = "INSERT INTO SONGS (ID,NAME,ARTIST,GENRE,POPULARITY, LOCATION) " +
                   "VALUES (4, 'We Belong Together', 'Mariah Carey', 'RNB', 100,'songs/4.mp3');";
            q(sql);
            sql = "INSERT INTO SONGS (ID,NAME,ARTIST,GENRE,POPULARITY, LOCATION) " +
                   "VALUES (5, 'Body Party', 'Ciara', 'RNB', 60,'songs/5.mp3');";
            q(sql);
            sql = "INSERT INTO SONGS (ID,NAME,ARTIST,GENRE,POPULARITY, LOCATION) " +
                   "VALUES (6, 'Slow Motion', 'Mary J. Blige', 'RNB', 100,'songs/6.mp3');";
            q(sql);  
            sql = "INSERT INTO SONGS (ID,NAME,ARTIST,GENRE,POPULARITY, LOCATION) " +
                   "VALUES (7, 'Party', 'Beyonce', 'RNB', 100,'songs/7.mp3');";
            q(sql);  
            sql = "INSERT INTO SONGS (ID,NAME,ARTIST,GENRE,POPULARITY, LOCATION) " +
                   "VALUES (8, 'Someone New', 'Hoozier', 'RNB', 100,'songs/8.mp3');";
            q(sql);  
            sql = "INSERT INTO SONGS (ID,NAME,ARTIST,GENRE,POPULARITY, LOCATION) " +
                   "VALUES (9, 'Cherry Wine', 'Hoozier', 'RNB', 100,'songs/9.mp3');";
            q(sql);  
            sql = "INSERT INTO SONGS (ID,NAME,ARTIST,GENRE,POPULARITY, LOCATION) " +
                   "VALUES (10, 'Like Real People Do', 'Hoozier', 'RNB', 100,'songs/10.mp3');";
            q(sql); 
            sql = "INSERT INTO SONGS (ID,NAME,ARTIST,GENRE,POPULARITY, LOCATION) " +
                   "VALUES (11, 'Rap', 'Eminem', 'Hip-Hop', 100,'songs/11.mp3');";
            q(sql);  
            sql = "INSERT INTO SONGS (ID,NAME,ARTIST,GENRE,POPULARITY, LOCATION) " +
                   "VALUES (12, 'Jumping Jack Flash', 'Rolling Stones', 'Rock', 100,'songs/12.mp3');";
            q(sql);
            sql = "INSERT INTO SONGS (ID,NAME,ARTIST,GENRE,POPULARITY, LOCATION) " +
                   "VALUES (13, 'From Eden', 'Hoozier', 'RNB', 100,'songs/13.mp3');";
            q(sql); 
    }
}