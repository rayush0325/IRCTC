package ticket_booking;
import ticket_booking.entities.User;
import ticket_booking.services.BookingService;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {

        System.out.println("Choose option");
        System.out.println("1 : Sign Up");
        System.out.println("2 : Login");
        System.out.println("3 Search Train");
        System.out.println("4 : Exit");
        System.out.print("Enter option [1 .. 3] ");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        if(option == 4){
            System.out.println("Thanks for visiting IRCTC");
        }
        else{
            BookingService bookingService = new BookingService();
            switch (option){
                case 1://sign up
                    bookingService.signUp();
                    break;
                case 2://login
                    bookingService.login();
                    break;
                case 3://Search Train

            }
        }

    }

}
