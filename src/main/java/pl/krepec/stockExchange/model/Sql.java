package pl.krepec.stockExchange.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Sql {

private  List<String> userNameList = new ArrayList<>();
    public List<String> getDataFromDataBase(String columnName, String tableName) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gielda", "root","1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select "+ columnName + " from " +tableName+" where username='lol' and password = 'lol'");

            while (resultSet.next()){
                userNameList.add(resultSet.getString("cash"));

            }
           statement.close();
           connection.close();
        }
        catch (SQLException e){
            System.out.println("Wyjątek SQLException");
        }
        return userNameList;
    }


}
