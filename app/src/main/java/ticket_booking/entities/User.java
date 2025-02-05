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
    private  String userName;
    private String userId;
    private String name;
    private  String hashedPassword;
    private List<Ticket> ticketsBooked;
    public User(){

    }
    //for signup
    public User(String userName, String name, String hashedPassword){
        this.name = name;
        this.userName = userName;
        this.hashedPassword = hashedPassword;
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

    public String getHashedPassword(){
        return this.hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public List<Ticket> getTicketsBooked(){
        return this.ticketsBooked;
    }

    public void setTicketsBooked(List<Ticket> ticketsBooked) {
        this.ticketsBooked = ticketsBooked;
    }

    public String getUserId(){
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
