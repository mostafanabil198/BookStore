/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

/**
 *
 * @author elshamey
 */
public class Book {
    private int isbn, copies, threshold;
    private String title, publication, publisher, category;
    private float price;

    public Book(){
        
    }
    public Book(int isbn, String title, String publisher, String publication, String category, int copies, int threshold, float price){
        this.isbn = isbn;
        this.title = title;
        this.publication = publication;
        this.publisher = publisher;
        this.category = category;
        this.copies = copies;
        this.threshold = threshold;
        this.price = price;
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

    public String getPublication() {
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
    
}
