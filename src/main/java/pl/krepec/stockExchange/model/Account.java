package pl.krepec.stockExchange.model;

import java.util.List;

public class Account {

    private Sql sql = new Sql();

    public Boolean checkUserNameExist(String userName) {
        Boolean result = null;
        List<String> userNameList = sql.getDataFromDataBase("username", "users");
        for (String name : userNameList) {
            if (userName.equals(name)) {
                result = true;
                return result;
            } else
                result = false;
                return result;
        }

        return result;

    }

    public void LogIn(String userName, String password){
        sql.getDataFromDataBase("username", "users");
    }
}
