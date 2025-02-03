package ticket_booking.services;
import  com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import ticket_booking.entities.Ticket;
import ticket_booking.entities.Train;
import ticket_booking.entities.User;
import ticket_booking.util.UserSeviceUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.imageio.IIOException;
import javax.jws.soap.SOAPBinding;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BookingService  {
    public void signUp() throws IOException{
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        System.out.println("Enter your name");
        user.setName(scanner.next());
        System.out.println("Enter password");
        String hashPassword = UserSeviceUtil.createHashPassword(scanner.next());
        user.setHashPassword(hashPassword);
        saveUser(user);
    }
    public void login(){
    }
    private final String filePath = "app/src/main/java/ticket_booking/localDb/users.json";
    private void saveUser(User user) throws IOException {
        try{
            File file = new File(filePath);
            ObjectMapper objectMapper = new ObjectMapper();
            List<User> users = objectMapper.readValue(file, new TypeReference<List<User>>(){});
            users.add(user);
            objectMapper.writeValue(file, users);
            System.out.println("Sign up successful");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

}
