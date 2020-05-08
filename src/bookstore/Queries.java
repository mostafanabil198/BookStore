/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author elshamey
 */
public class Queries {

    
    private Connection get_connection() throws ClassNotFoundException, SQLException{
        String myDriver = "org.gjt.mm.mysql.Driver";
        String myUrl = "jdbc:mysql://localhost/BookStore";
        Class.forName("org.gjt.mm.mysql.Driver");
        Connection con = DriverManager.getConnection(myUrl, "root", "password");
        return con;
    }

    public String modify(String query) {
        String error = "";
        try {
            // create our mysql database connection
            Connection conn = get_connection();
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
        return error;
    }

    public Book select(String query) {
        ResultSet rs = null;
        Book b = null;
        try {
            // create our mysql database connection
            Connection conn = get_connection();
            // create the java statement
            Statement st = (Statement) conn.createStatement();
            // execute the query, and get a java resultset
            rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                b = new Book(rs.getInt("ISBN"), rs.getString("title"), rs.getString("publisher_name"), rs.getString("publication_year"), rs.getString("category"), rs.getInt("copies_no"), rs.getInt("threshold"), rs.getFloat("price"));
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return b;
    }
    
    public ArrayList<Book> select_books(String query) {
        ArrayList<Book> list = new ArrayList<>();
        try {
            // create our mysql database connection
            Connection conn = get_connection();
            // create the java statement
            Statement st = (Statement) conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                Book b = new Book(rs.getInt("ISBN"), rs.getString("title"), rs.getString("publisher_name"), rs.getString("publication_year"), rs.getString("category"), rs.getInt("copies_no"), rs.getInt("threshold"), rs.getFloat("price"));
                list.add(b);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return list;
    }
    public ArrayList<BookOrder> select_books_orders(String query) {
        ArrayList<BookOrder> list = new ArrayList<>();
        try {
            // create our mysql database connection
            Connection conn = get_connection();
            // create the java statement
            Statement st = (Statement) conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                BookOrder order = new BookOrder(rs.getInt("ISBN"), rs.getDate("date"), rs.getInt("quantity"));
                list.add(order);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return list;
    }

}
