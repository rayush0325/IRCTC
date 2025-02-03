package ticket_booking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@JsonIgnoreProperties(ignoreUnknown = true)

public class User {

    private String userId;
    private String name;
    //private String password;
    private  String hashedPassword;
    private List<Ticket> ticketsBooked;


    public User(){
        this.userId = ""+ UUID.randomUUID();
        this.ticketsBooked = new ArrayList<Ticket>();
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
//    public  void setPassword(String password){
//        this.password  = password;
//    }
    public void setHashPassword(String hashPassword){
        this.hashedPassword = hashPassword;
    }
    public String getHashedPassword(){
        return this.hashedPassword;
    }
    public List<Ticket> getTicketsBooked(){
        return this.ticketsBooked;
    }
    public String getUserId(){
        return this.userId;
    }
}
