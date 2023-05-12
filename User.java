package org.example;

public class User{
    private String UserName ;
    private String Email;
    private String Password;
    private int ID;
    public Cart cart;
    public User(){}

    public User(String UserName , String Email ,String Password , int id){
        this.Email = Email;
        this.Password = Password;
        this.UserName = UserName;
        this.cart = new Cart();
    }
    //  Retrieve all products from the card
    public Cart getCart() {
        return cart;
    }
    //  Get Email
    public String getEmail() {
        return Email;
    }
    //  Get password
    public String getPassword() {
        return Password;
    }
    //  Get username
    public String getName() {
        return UserName;
    }
}