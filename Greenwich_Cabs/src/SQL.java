

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Badmus
 */
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQL {

    private String username = "root";
    private String password = "root";
    private String DB_URL = "jdbc:mysql://localhost:8889/Greenwich_Cabs?zeroDateTimeBehavior=convertToNull";

    
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;

    public SQL() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, username, password);
        } catch (Exception ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This Method checks whether a Customer is registered or not using the
     * email address of the user
     */
    public boolean checkIfAccountExist(String username) {
        boolean ID_Found = false;

        try {

            Statement stmt = conn.createStatement();
            String sqlStatement = "select * from dispatchers where username='" + username + "';";
            rs = stmt.executeQuery(sqlStatement);

            if (rs.next()) {
                //Means username exist
                ID_Found = true;
            } else {
                    //Means username does not exist

            }

        } catch (SQLException ex) {
        }
        return ID_Found;
    }

    
    public boolean addTrip(Trip trip) {
        
        boolean status=false;
            java.util.Date date = new java.util.Date();
        
            SimpleDateFormat Date = new SimpleDateFormat("yyyy-MM-dd");
            String dateOfTrip = Date.format(date);
        
        try {

            String sql = "INSERT INTO trips( time, pickup, destination, driver_id, passenger_name, amount, account, telephone,date) "
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, trip.getTime());
            pstmt.setString(2, trip.getPickup());
            pstmt.setString(3, trip.getDestination());
            pstmt.setString(4, trip.getDriver_id());
            pstmt.setString(5, trip.getPassenger_name());
            pstmt.setString(6, trip.getAmount());
            pstmt.setString(7, trip.getAccount());
            pstmt.setString(8, trip.getTelephone());
            pstmt.setString(9, dateOfTrip);
            
   
        
            int return_ = pstmt.executeUpdate();

            if (return_ > 0) {
                status=true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean updateTrip(Trip trip) {
        
        boolean status=false;
        
        try {

            String sql = "UPDATE trips SET time=?,pickup=?,destination=?,"
                    + "driver_id=?,passenger_name=?,amount=?, " +
                     " account=?,telephone=? WHERE trip_id=?";
            
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, trip.getTime());
            pstmt.setString(2, trip.getPickup());
            pstmt.setString(3, trip.getDestination());
            pstmt.setString(4, trip.getDriver_id());
            pstmt.setString(5, trip.getPassenger_name());
            pstmt.setString(6, trip.getAmount());
            pstmt.setString(7, trip.getAccount());
            pstmt.setString(8, trip.getTelephone());
            pstmt.setString(9, trip.getTrip_id());
            
            int return_ = pstmt.executeUpdate();

            if (return_ > 0) {
                status=true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    
    
    public String registerDispatcher(Dispatcher dispatcher) {
        String response = "Registration Failed";

        boolean doesUserExist=checkIfAccountExist(dispatcher.getUsername());
        if(doesUserExist){
            return "Account Already Exist";
        }
        
        
        try {

            String sql = "INSERT INTO dispatchers(firstname, lastname, phone, username, password) VALUES (?,?,?,?,?)";
            
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, dispatcher.getFirstname());
            pstmt.setString(2, dispatcher.getLastname());
            pstmt.setString(3, dispatcher.getPhone());
            pstmt.setString(4, dispatcher.getUsername());
            pstmt.setString(5, dispatcher.getPassword());
            
            int return_ = pstmt.executeUpdate();

            if (return_ > 0) {
                response = "Your Registration was Successful, "+dispatcher.getUsername();
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

      public int loginDispatcher(String  username, String password) {
        int response = 0;

        //code 
        //0 - LOGIN FAILED
        //1 - LOGIN SUCCESS
        try {

            String sql = "SELECT * FROM dispatchers WHERE username=? AND password=? ";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                response = 1;
            }

        } catch (SQLException ex) {
        }
        return response;
    }

        public String registerDriver(Driver driver) {
        String response = "Registration Failed";

        
        try {

            String sql = "INSERT INTO drivers(firstname, lastname, driver_id) VALUES (?,?,?)";
            
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, driver.getFirstname());
            pstmt.setString(2, driver.getLastname());
            pstmt.setString(3, driver.getDriver_id());
            
            int return_ = pstmt.executeUpdate();

            if (return_ > 0) {
                response = "Registration Success";
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

    
        public void deleteTrip(String trip_id) {
        
        
        try {

            String sql = "DELETE FROM trips WHERE trip_id=?";
            
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, trip_id);
            
            int return_ = pstmt.executeUpdate();

            
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
        
    
        public ArrayList<Report> getReport(String date) {
        
   
        ArrayList<Report> Reports = new ArrayList<>();

        try {

            String sql = "SELECT driver_id AS 'driver_id', SUM(amount) AS 'Takings'  ,"
                    + " ((20/100) * SUM(amount) ) AS 'percentage' , COUNT(driver_id) AS 'Jobs_done' FROM trips WHERE date= ?" +
                            "GROUP BY driver_id;";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, date);
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                  String driver_id, takings, percentage, jobs_done;

                 driver_id=rs.getString("driver_id");
                 takings=rs.getString("Takings");
                 percentage=rs.getString("percentage");
                 jobs_done=rs.getString("Jobs_done");
                 

                 Report report= new Report(driver_id, takings, percentage, jobs_done);
                 
                 Reports.add(report);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Reports;
    }

        
    public ArrayList<Trip> getTrips(String whereClause) {
        
   
        ArrayList<Trip> Trips = new ArrayList<>();

        try {

            String sql = "SELECT * FROM trips ";

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                 String trip_id, time, pickup, destination, driver_id, passenger_name, amount, account, telephone,date;

                 trip_id=rs.getString("trip_id");
                 time=rs.getString("time");
                 pickup=rs.getString("pickup");
                 destination=rs.getString("destination");
                 driver_id=rs.getString("driver_id");
                 passenger_name=rs.getString("passenger_name");
                 amount=rs.getString("amount");
                 account=rs.getString("account");
                 telephone=rs.getString("telephone");
                 date=rs.getString("date");

                 Trip trip= new Trip(trip_id, time, pickup, destination, driver_id, passenger_name, amount, account, telephone, date);
                 Trips.add(trip);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Trips;
    }

    
}
