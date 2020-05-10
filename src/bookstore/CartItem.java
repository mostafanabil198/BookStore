/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

/**
 *
 * @author mostafanabil198
 */
public class CartItem {
    private int isbn, copies, threshold, publication, quantity;
    private String title, publisher, category;
    private float price;

    public CartItem(){
        
    }
    public CartItem(int isbn, String title, String publisher, String category, int copies, float price, int quantity){
        this.isbn = isbn;
        this.title = title;
        this.publication = publication;
        this.publisher = publisher;
        this.category = category;
        this.copies = copies;
        this.threshold = threshold;
        this.price = price;
        this.quantity = quantity;
    }
    
    public void addQuantity(int quantity){
        this.quantity += quantity;
    }
    
    public int getIsbn() {
        return isbn;
    }

    public int getCopies() {
        return copies;
    }

    public int getThreshold() {
        return threshold;
    }

    public String getTitle() {
        return title;
    }

    public int getPublication() {
        return publication;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
}
