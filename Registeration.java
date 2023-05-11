import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
public class Registeration {
    private String name;
    private String UserEmail ;
    private String UserPassword ;
    private DataBase database ;
    public DataBase getDatabase(){
        return database;
    }
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    public boolean isValidEmailAndPassword(String email, String password) {
        Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        Matcher emailMatcher = emailPattern.matcher(email);
        Pattern passwordPattern = Pattern.compile(PASSWORD_REGEX);
        Matcher passwordMatcher = passwordPattern.matcher(password);

        return emailMatcher.matches() && passwordMatcher.matches();
    }
    public void Register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ur Name ");
        String name = scanner.nextLine();
        System.out.println("Enter ur Email ");
        String email = scanner.nextLine();
        System.out.println("Enter ur Password ");
        String password = scanner.nextLine();
        if( isValidEmailAndPassword( email,  password) ){
            User user = new User(name, email,password);
            System.out.println("Registration done successfully ");
        }
        else {
            System.out.println("Incorrect password or email");

            System.out.print("Enter 0 to exit or 1 to try again : ");
            boolean value = scanner.nextBoolean();
            if(value){
                Register();
            }
            else {
                return;
            }
        }
    }

    public boolean login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ur Email ");
        String email = scanner.nextLine();
        System.out.println("Enter ur Password ");
        String password = scanner.nextLine();
        if(database.IsExist(email , password)){
            return true;
        }
        else{
            System.out.println("User not logged in \n");
            return false;
        }
    }
}
