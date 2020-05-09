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
    
    private static Queries instance = null;
    private String username;
    private boolean manager;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }
    private Queries(){
        
    }
    
    public static Queries getInstance(){
        return instance == null ? new Queries() : instance;
    }

    
    private Connection get_connection() throws ClassNotFoundException, SQLException{
        String myDriver = "org.gjt.mm.mysql.Driver";
        String myUrl = "jdbc:mysql://localhost/BookStore";
        Class.forName("org.gjt.mm.mysql.Driver");
        Connection con = DriverManager.getConnection(myUrl, "root", "alahly1907mohamed");
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
                b = new Book(rs.getInt("ISBN"), rs.getString("title"), rs.getString("publisher_name"), rs.getInt("publication_year"), rs.getString("category"), rs.getInt("copies_no"), rs.getInt("threshold"), rs.getFloat("price"));
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return b;
    }
    
    
    public User selectUser(String query) {
        ResultSet rs = null;
        User u = null;
        try {
            // create our mysql database connection
            Connection conn = get_connection();
            // create the java statement
            Statement st = (Statement) conn.createStatement();
            // execute the query, and get a java resultset
            rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                u = new User(rs.getString("username"), rs.getString("email"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("password"), rs.getInt("manager"), rs.getString("phone"), rs.getString("address"));
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return u;
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
                Book b = new Book(rs.getInt("ISBN"), rs.getString("title"), rs.getString("publisher_name"), rs.getInt("publication_year"), rs.getString("category"), rs.getInt("copies_no"), rs.getInt("threshold"), rs.getFloat("price"));
                list.add(b);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return list;
    }
    
    public ArrayList<CartItem> select_cart(String query) {
        ArrayList<CartItem> list = new ArrayList<>();
        try {
            // create our mysql database connection
            Connection conn = get_connection();
            // create the java statement
            Statement st = (Statement) conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                CartItem b = new CartItem(rs.getInt("ISBN"), rs.getString("title"), rs.getString("publisher_name"), rs.getString("category"), rs.getInt("copies_no"), rs.getFloat("price"), rs.getInt("quantity"));
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
    public ArrayList<User> select_User_to_promote (String query) {
        ArrayList<User> list = new ArrayList<>();
        try {
            // create our mysql database connection
            Connection conn = get_connection();
            // create the java statement
            Statement st = (Statement) conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                User order = new User(rs.getString("username"), rs.getString("email"), rs.getString("first_name"),rs.getString("second_name"));
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
