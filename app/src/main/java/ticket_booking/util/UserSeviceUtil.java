package ticket_booking.util;

public class UserSeviceUtil {
    public static  String createHashPassword(String password){
        String hashPassword = "";
        int N = password.length();
        for(int i = N-1 ; i >= 0 ; i--){
            hashPassword += password.charAt(i);
        }
        return hashPassword;
    }
}
