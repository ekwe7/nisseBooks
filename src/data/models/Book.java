package data.models;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int pages;
    private int edition;
    private int quantity;
    private int id;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getEdition() {
        if(edition % 10 == 1) return edition + "st" + "edition";
        if(edition % 10 == 2) return edition + "st" + "edition";
        if(edition % 10 == 3) return edition + "st" + "edition";
        return edition + "th" + "edition";
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
