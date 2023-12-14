/* No longer using, but wil keep for reference!

Example code from https://alvinalexander.com/java/edu/pj/jdbc/jdbc0002/

More from https://www.techielass.com/connect-to-a-sql-database-with-visual-studio-code/

import java.sql.*;

/**
 * JdbcInsert1.java - Demonstrates how to INSERT data into an SQL
 *                    database using Java JDBC.
 */
class JdbcInsert1 { 
  
    public static void main (String[] args) { 
        try { 
            String url = "jdbc:msql://200.210.220.1:1114/Demo"; 
            Connection conn = DriverManager.getConnection(url,"",""); 
            Statement st = conn.createStatement(); 
            st.executeUpdate("INSERT INTO Customers " + 
                "VALUES (1001, 'Simpson', 'Mr.', 'Springfield', 2001)"); 
            conn.close(); 
        } catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        } 
  
    }
} 
*/

CREATE DATABASE IF NOT EXISTS db;

USE db;

CREATE TABLE IF NOT EXISTS pieces(
    PieceID int,
    PlayerID int,
    isAlive boolean,
    pieceNumber int,
    xCoor int,
    yCoor int
);

CREATE TABLE IF NOT EXISTS players(
   PlayerID int,
   win boolean
);
