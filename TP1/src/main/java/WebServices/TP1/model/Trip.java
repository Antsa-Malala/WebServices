package WebServices.TP1.model;

import java.util.Date;

public class Trip {
    private String id;
    private int debut_km;
    private int end_km;
    private java.util.Date date_trip;

    private String vehicle_id;

    private Vehicle main_vehicle;


    // GETTERS AMD SETTERS


    public String getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDebut_km() {
        return debut_km;
    }

    public void setDebut_km(int debut_km) {
        this.debut_km = debut_km;
    }

    public int getEnd_km() {
        return end_km;
    }

    public void setEnd_km(int end_km) {
        this.end_km = end_km;
    }

    public Date getDate_trip() {
        return date_trip;
    }

    public void setDate_trip(Date date_trip) {
        this.date_trip = date_trip;
    }

    public Vehicle getMain_vehicle() {
        return main_vehicle;
    }

    public void setMain_vehicle(Vehicle main_vehicle) {
        this.main_vehicle = main_vehicle;
    }
}
