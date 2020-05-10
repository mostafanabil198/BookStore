/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author elshamey
 */
public class Queries {
    
    private static Queries instance = null;
    private String username;
    private boolean manager;
    private static Connection conn = null;
    private ArrayList<CartItem> cart;
    
    public ArrayList<CartItem> getCart(){
        return cart;
    }
    
    public void addToCart(CartItem c) {
        for(CartItem ci : cart){
            if(ci.getIsbn() == c.getIsbn()){
                ci.addQuantity(c.getQuantity());
                return;
            }
        }
        cart.add(c);
    }
    
    public String removeFromCart(int isbn){
        for(CartItem ci : cart){
            if(ci.getIsbn() == isbn){
                cart.remove(ci);
                return "";
            }
        }
        return "Wrong ISBN, Not in cart!";
    }
    
    public void emptyCart(){
        cart.clear();
    }
    

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
        cart = new ArrayList<>();
    }
    
    public static Queries getInstance() throws ClassNotFoundException, SQLException{
        if (instance == null){
            conn=get_connection();
            instance = new Queries();
        }
        return instance;
    }
    
    public void closeCon() throws SQLException{
        conn.close();
    }

    
    private static Connection get_connection() throws ClassNotFoundException, SQLException{
        if (conn == null) {
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/BookStore";
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection(myUrl, "root", "alahly1907mohamed");
        }
        return conn;
    }
    
    public String modify(String query) {
        String error = "";
        try {
            // create our mysql database connection
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
            // create the java statement
            Statement st = (Statement) conn.createStatement();
            // execute the query, and get a java resultset
            rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                b = new Book(rs.getInt("ISBN"), rs.getString("title"), rs.getString("publisher_name"), rs.getInt("publication_year"), rs.getString("category"), rs.getInt("copies_no"), rs.getInt("threshold"), rs.getFloat("price"));
            }
            rs.close();
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
            // create the java statement
            Statement st = (Statement) conn.createStatement();
            // execute the query, and get a java resultset
            rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                u = new User(rs.getString("username"), rs.getString("email"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("password"), rs.getInt("manager"), rs.getString("phone"), rs.getString("address"));
            }
            rs.close();
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
            // create the java statement
            Statement st = (Statement) conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                Book b = new Book(rs.getInt("ISBN"), rs.getString("title"), rs.getString("publisher_name"), rs.getInt("publication_year"), rs.getString("category"), rs.getInt("copies_no"), rs.getInt("threshold"), rs.getFloat("price"));
                list.add(b);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return list;
    }
    
    public CartItem select_cart(String query, int quantity) {
        CartItem item = null;
        try {
            // create our mysql database connection
            // create the java statement
            Statement st = (Statement) conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                item = new CartItem(rs.getInt("ISBN"), rs.getString("title"), rs.getString("publisher_name"), rs.getString("category"), rs.getInt("copies_no"), rs.getFloat("price"), quantity);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return item;
    }
    
    public ArrayList<BookOrder> select_books_orders(String query) {
        ArrayList<BookOrder> list = new ArrayList<>();
        try {
            // create our mysql database connection
            // create the java statement
            Statement st = (Statement) conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                BookOrder order = new BookOrder(rs.getInt("ISBN"), rs.getDate("date"), rs.getInt("quantity"));
                list.add(order);
            }
            rs.close();
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
            // create the java statement
            Statement st = (Statement) conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                User order = new User(rs.getString("username"), rs.getString("email"), rs.getString("first_name"),rs.getString("last_name"));
                list.add(order);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return list;
    }
    
    public boolean checkCreditCard(String query){
        boolean valid = false;
        try {
            // create our mysql database connection
            // create the java statement
            Statement st = (Statement) conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                valid = true;
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return valid;
    }
    
    public boolean checkout(String query) throws SQLException {
        boolean rs = true;
        
        try {
            // create our mysql database connection
            conn.setAutoCommit(false);
            // create the java statement
            Statement st = (Statement) conn.createStatement();
            // execute the query, and get a java resultset
            String[] queries = query.split(";");
            for(String s : queries){
                st.execute(s);
                System.out.println("--" + s);
            }
            conn.commit();
            conn.setAutoCommit(true);
            st.close();
        } catch (Exception e) {
            rs = false;
            conn.rollback();
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return rs;
    }

    public float get_total_sales(String query){
        float total = 0;
        try {
            // create our mysql database connection
            // create the java statement
            Statement st = (Statement) conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                total = rs.getFloat("SUM(quantity)");
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return total;
    }
    
    public ArrayList<String> get_best_customers(String query) {
        ArrayList<String> list = new ArrayList<>();
        try {
            // create our mysql database connection
            // create the java statement
            Statement st = (Statement) conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                String s = rs.getString("username");
                list.add(s);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return list;
    }
    
    public ArrayList<String> get_best_books(String query) {
        ArrayList<String> list = new ArrayList<>();
        try {
            // create our mysql database connection
            // create the java statement
            Statement st = (Statement) conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                String s = rs.getString("title");
                list.add(s);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return list;
    }
     public boolean checkUserExist(String query){
        boolean Exist = false;
        try {
            // create our mysql database connection
            // create the java statement
            Statement st = (Statement) conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                Exist = true;
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return Exist;
    }

}
