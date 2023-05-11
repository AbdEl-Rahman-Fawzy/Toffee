public class User{
    private String UserName ;
    private String Email;
    private String Password;

    private Cart cart;
    public User(){}

    public User(String UserName , String Email ,String Password){
        this.Email = Email;
        this.Password = Password;
        this.UserName = UserName;
        this.cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getName() {
        return UserName;
    }
}