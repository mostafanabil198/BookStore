/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.sql.*;
import java.util.Map;

/**
 *
 * @author elshamey
 */
public class Queries {
    
    public String modify(String query){
        String error = "";
        try {
            // create our mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/bookstore";
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection conn = DriverManager.getConnection(myUrl, "root", "alahly1907mohamed");

            // create the java statement
            Statement st = (Statement) conn.createStatement();
            // execute the query, and get a java resultset
            int rs = st.executeUpdate(query);
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            error = "ERROR:" + e.getMessage();
        }
        return  error;
    }
    
    public ResultSet select(String query)
    {
        ResultSet rs = null;
        try {
            // create our mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/bookstore";
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection conn = DriverManager.getConnection(myUrl, "root", "alahly1907mohamed");

            // create the java statement
            Statement st = (Statement) conn.createStatement();

            // execute the query, and get a java resultset
             rs = st.executeQuery(query);
             ResultSetMetaData r = rs.getMetaData();
      // iterate through the java resultset
      /*while (rs.next())
             {
             int id = rs.getInt("ISBN");
             ResultSetMetaData r rs
                 System.out.println((rs.getString("title")));
             // print the results
             }*/
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return rs;
    }
    
}
