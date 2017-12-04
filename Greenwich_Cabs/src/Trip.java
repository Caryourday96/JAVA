/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Badmus
 */
public class Trip {
    private String trip_id, time, pickup, destination, driver_id, passenger_name, amount, account, telephone,date;

    public Trip(String time, String pickup, String destination, String driver_id, String passenger_name, String amount, String account, String telephone, String date) {
        this.time = time;
        this.pickup = pickup;
        this.destination = destination;
        this.driver_id = driver_id;
        this.passenger_name = passenger_name;
        this.amount = amount;
        this.account = account;
        this.telephone = telephone;
        this.date=date;
    }

    public Trip(String trip_id, String time, String pickup, String destination, String driver_id, String passenger_name, String amount, String account, String telephone, String date) {
        this.trip_id = trip_id;
        this.time = time;
        this.pickup = pickup;
        this.destination = destination;
        this.driver_id = driver_id;
        this.passenger_name = passenger_name;
        this.amount = amount;
        this.account = account;
        this.telephone = telephone;
        this.date = date;
    }

    
    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public String getPassenger_name() {
        return passenger_name;
    }

    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
}
