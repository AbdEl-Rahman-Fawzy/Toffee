import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
public class Registeration {

    private DataBase database  = new DataBase();
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
    public User Register(int lastID) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ur Name ");
        String name = scanner.nextLine();
        System.out.println("Enter ur Email ");
        String email = scanner.nextLine();
        System.out.println("Enter ur Password ");
        String password = scanner.nextLine();
        if( isValidEmailAndPassword( email,  password) ){
            User user = new User(name, email,password,lastID);
            database.AddToDatabase(user);
            System.out.println("Registration done successfully ");
            return user;
        }
        else {
            System.out.println("Wrong\n");
            return null;
        }
    }

    public boolean login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ur Email ");
        String email = scanner.nextLine();
        System.out.println("Enter ur Password ");
        String password = scanner.nextLine();

        if(database.IsExist(email , password)){
            System.out.println("Logged in successfully <3 \n");
            return true;
        }
        else{
            System.out.println("User not logged in \n");
            return false;
        }
    }
}
