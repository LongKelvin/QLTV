package dal;

import utils.DBUtils;
import dto.LoginAccountDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDal {
    private final LoginAccountDto result = new LoginAccountDto();
    private final Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;


    public LoginDal() {
        DBUtils dbUltils = new DBUtils();
        connection = dbUltils.getConnection();
    }

    public String GetAccountType(String username) {
        String accountType = "";
        String query = "select MACHUCVU from TAIKHOANNV where TENTK='" + username + "'";

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                accountType = (resultSet.getString("MACHUCVU"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Login SQL Error, Cannot get information");
        } finally {
            try {
                connection.close();
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return accountType;
    }


    public LoginAccountDto CheckAccount(String username, String password) {

        String query = "SELECT TENTK, MATKHAU FROM TAIKHOANNV WHERE TENTK='" + username + "' and MATKHAU='" + password + "'";

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                result.setUsername(resultSet.getString("TENTK"));
                result.setPassword(resultSet.getString("MATKHAU"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Login SQL Error, Cannot get information");
        } finally {
            try {
                connection.close();
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;

    }
}
