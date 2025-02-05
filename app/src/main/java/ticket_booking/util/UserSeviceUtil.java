package ticket_booking.util;

import ticket_booking.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserSeviceUtil {
    public static  String createHashPassword(String password){
        String hashPassword = "";
        int N = password.length();
        for(int i = N-1 ; i >= 0 ; i--){
            hashPassword += password.charAt(i);
        }
        return hashPassword;
    }
    public static  String covertToPassword(String hashedPassword){
        String password = "";
        int N = hashedPassword.length();
        for(int i = N-1 ; i >= 0 ; i--){
            password += hashedPassword.charAt(i);
        }
        return password;
    }

    public static boolean validateUser(List<User> users, String userName){
        for (User user : users){
            if(userName.equals(user.getUserName())){
                return true;
            }
        }
        return false;
    }
}
