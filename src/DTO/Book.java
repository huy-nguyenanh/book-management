
package DTO;


public class Book {
    private String ISBN; // /\b(?:ISBN(?:: ?| ))?((?:97[89])?\d{9}[\dx])\b/i
    private String title;
    private Author author;
    private double price;

    public Book() {
    }

    public Book(String ISBN, String title, Author author, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book(Author author) {
        this.author = author;
    }

    public Book(String ISBN) {
        this.ISBN = ISBN;
    }


    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }


    public double getPrice() {
        return price;
    }

    public void setISBN(String ISBN) {
        if(ISBN != null)
            this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        if(title != null)
            this.title = title;
    }

    public void setAuthorID(Author author) {
        this.author = author;
    }

    public void setPrice(double price) {
        if(price > 0)
            this.price = price;
    }

    @Override
    public String toString() {
        return "\nBook information\n" 
                + "ISBN: " + ISBN + "\n"
                + "Title: " + title + "\n"
                + "AuthorID: " + author.getAuthorID() + "\n"
                + "AuthorName: " + author.getAuthorName() + "\n"
                + "Price: " + price + "\n";

                
    }
    
    
}
