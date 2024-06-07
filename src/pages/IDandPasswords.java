package pages;

import java.util.HashMap;

public class IDandPasswords {


    HashMap<String, String> loginInfo = new HashMap<>();


    public IDandPasswords(){
        loginInfo.put("Chris","password");
        loginInfo.put("","");
    };

    public IDandPasswords(String username, String password) {
        loginInfo.put(username, password);
    }

    public HashMap getLoginInfo(){
        return loginInfo;
    }
}
