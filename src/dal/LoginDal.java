package dal;

import utils.DBUtils;
import dto.LoginAccountDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LoginDal {
    private final LoginAccountDto result = new LoginAccountDto();
    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    DBUtils dbUltils = new DBUtils();


    public LoginDal() {
        dbUltils = new DBUtils();
        connection = dbUltils.getConnection();
    }

    public String[] GetAccountType(String username) {

        connection = dbUltils.getConnection();
        String[] accountType = new String[2];
        String query = "select MACHUCVU, MANV from TAIKHOANNV where TENTK='" + username + "'";

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                accountType[0] = (resultSet.getString("MACHUCVU"));
                accountType[1] = (resultSet.getString("MANV"));
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
            connection = dbUltils.getConnection();
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
