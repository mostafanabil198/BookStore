/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.sql.*;

/**
 *
 * @author mostafanabil198
 */
public class BookStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        AddBook book = new AddBook(1);
        //book.setVisible(true);
        //String x[][] = {{"x","q"},{"z","w"}};
          Search s = new Search();
          s.setVisible(true);

     /*   try {
            // create our mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/bookstore";
            System.out.println("hna");
            Class.forName("org.gjt.mm.mysql.Driver");
            System.out.println("nashar");

            Connection conn = DriverManager.getConnection(myUrl, "root", "alahly1907mohamed");
            System.out.println("nashar111");

      // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "select * from `BookStore`.`books` where ISBN = 10 ;";

            // create the java statement
            Statement st = (Statement) conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

      // iterate through the java resultset
      while (rs.next())
             {
             int id = rs.getInt("ISBN");
             
                 System.out.println((rs.getString("title")));
             // print the results
             }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }*/
        
    }

}
