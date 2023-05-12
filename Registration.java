package org.example;
import javax.mail.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;


public class Registration {

    private DataBase database  = new DataBase();
    public DataBase getDatabase(){
        return database;
    }
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    //    Verify that the password and email are correct
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
        //  check if the password and email are correct
        if ( isValidEmailAndPassword( email,  password) ){
            OTPMessage myOtp = new OTPMessage();
            String otp1 = myOtp.Generate();
            //  System.out.println(otp1);
            myOtp.SendByMail(email , otp1);
            //  OTP verification
            for (int i =0 ; i < 3 ;i++){
                System.out.println("Please enter the OTP number :");
                String otp = scanner.nextLine();
                if (otp.equals(otp1)){
                    User user = new User(name, email,password,lastID);
                    database.AddToDatabase(user);
                    System.out.println("Registration done successfully ");
                    return user;
                }
            }
            return null;
        }
        else {
            System.out.println("Invalid email or password\n");
            return null;
        }
    }

    public boolean login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ur Email ");
        String email = scanner.nextLine();
        System.out.println("Enter ur Password ");
        String password = scanner.nextLine();
//      Check if the user is found in the database
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