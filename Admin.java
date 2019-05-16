import java.util.ArrayList;

public class Admin extends User {
    private ArrayList<String> emailList;

    public Admin() {
        super();
    }

    public ArrayList<String> getEmailList() {
        return emailList;
    }

    public boolean verifyRegister(String email){
        return  false;
    }

    public void removeAccount(String email){

    }
}
