import java.util.ArrayList;

public class DataBase{
    private static final ArrayList<User> ArrayOfUsers = new ArrayList<>();

    static{
        ArrayOfUsers.add(new User("User1" , "User1@gmail.com","xx1"));
        ArrayOfUsers.add(new User("User2" , "User2@gmail.com","xx2"));
        ArrayOfUsers.add(new User("User3" , "User3@gmail.com","xx3"));
        ArrayOfUsers.add(new User("User4" , "User4@gmail.com","xx4"));
        ArrayOfUsers.add(new User("User5" , "User5@gmail.com","xx5"));
    }

    public boolean IsExist(String email , String password){
        boolean flag = false;
        for(User i : ArrayOfUsers){
            if (i.getEmail().contains(email) && i.getPassword().contains(password)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public User getUser(String email , String password){
        User newUser = new User();
        for(User i :ArrayOfUsers){
            if(i.getEmail().contains(email) && i.getPassword().contains(password)){
                newUser = i;
            }
        }
        return newUser;
    }

    public void AddToDatabase(User newUser){
        ArrayOfUsers.add(newUser);
    }
}