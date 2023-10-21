package WebServices.TP1.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehicle")
public class Vehicle {
    private String id;
    private String brand;
    private int year;
    private int number_place;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumber_place() {
        return number_place;
    }

    public void setNumber_place(int number_place) {
        this.number_place = number_place;
    }
}
