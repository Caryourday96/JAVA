/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Badmus
 */
public class Insert {
    private String Time;
    private String Pickup;
    private String Destination;
    private String ID;
    private String Passenger;
    private String Amount;
    private String Acc;
    private String Tel;
    
    public Insert ( String Time, String Pickup , String Destination , String ID , String Passenger, String Amount, String Acc, String Tel)
    {
        this.Time = Time;
        this.Pickup = Pickup;
        this.Destination = Destination;
        this.ID = ID;
        this.Passenger = Passenger;
        this.Amount = Amount;
        this.Acc = Acc;
        this.Tel = Tel;
    }

    Insert(String string, String string0, String string1, String string2, String string3, String string4, String string5) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getTime()
    {
        return Time;
    }
    
     public String getPickup()
    {
        return Pickup;
    }
     
     public String getDestination()
    {
        return Destination;
    }
     
     public String getID()
    {
        return ID;
    }
     
      public String getPassenger()
    {
        return Passenger;
    }
      
       public String getAmount()
    {
        return Amount;
    }
       
     public String getAcc()
    {
        return Acc;
    }
     
    public String getTel()
    {
        return Tel;
    }
}



