/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.sql.Date;

/**
 *
 * @author tarek
 */
public class BookOrder {
    
    private int ISBN,quantity;
    private Date orderTime;
    public BookOrder(int ISBN , Date orderTime, int quantity){
        this.ISBN=ISBN;
        this.orderTime=orderTime;
        this.quantity=quantity;
    }
     public int getIsbn() {
        return this.ISBN;
    }

    public Date getDate() {
        return this.orderTime;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
