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
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class BookingService  {
    private final String filePath = "app/src/main/java/ticket_booking/localDb/users.json";
//    private User user;
//    private  List<String> userNames = new ArrayList<String>();
    public void signUp() throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name");
        String userName = scanner.next();
        System.out.println("Enter your name");//check availability
        String name = scanner.next();
        System.out.println("Enter password");
        String hashedPassword = UserSeviceUtil.createHashPassword(scanner.next());
//        scanner.close();
        User user = new User(userName, name, hashedPassword);
        saveUser(user);
        System.out.println("Sign up successful");
        System.out.println("Please login to continue");
        this.login();
    }
    public void login() throws IOException{
        File file = new File(filePath);
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<User> users = objectMapper.readValue(file, new TypeReference<ArrayList<User>>() {});

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name");
        String userName = scanner.nextLine();
        while(!UserSeviceUtil.validateUser(users, userName)){
            System.out.println("account with this user name not found\nRe-enter user name");
            userName = scanner.nextLine();
        }

        User user = getUser(users, userName);
        System.out.println("Enter password");
        String password = scanner.next();
        String userPassword = UserSeviceUtil.covertToPassword(user.getHashedPassword());
        while(!userPassword.equals(password)){
            System.out.println("Password incorrect\nRe-enter password");
            password = scanner.next();
        }
        scanner.close();
        System.out.println("Login successful \nWelcome "+user.getName());
    }

    private void saveUser(User user) throws IOException {
        try{

            File file = new File(filePath);
            ObjectMapper objectMapper = new ObjectMapper();

            List<User> users = objectMapper.readValue(file, new TypeReference<List<User>>(){});
            System.out.println(users.getClass().getName());
            users.add(user);

            objectMapper.writeValue(file, users);

        }
        catch (Exception ex){
            System.out.println("Error in sign up");
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }
    private User getUser(ArrayList<User> users, String userName){
        return users.stream().filter(user -> user.getUserName().equals(userName)).collect(Collectors.toList()).get(0);
    }

}
