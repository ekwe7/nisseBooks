package dtos.responses;

import java.time.LocalDate;

public class findBookResponse {
    private int id;
    private String title;
    private String description;
    private double price;
    private LocalDate publishDat;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getPublishDat() {
        return publishDat;
    }

    public void setPublishDat(LocalDate publishDat) {
        this.publishDat = publishDat;
    }


}
