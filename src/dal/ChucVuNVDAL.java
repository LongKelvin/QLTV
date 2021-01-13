package dal;

import dto.ChucVuNVDTO;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChucVuNVDAL {
    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    DBUtils dbUltils = new DBUtils();


    public ChucVuNVDAL() {
        dbUltils = new DBUtils();
        connection = dbUltils.getConnection();
    }

    public final boolean ThemChucVu(ChucVuNVDTO chucVu) {
        connection = dbUltils.getConnection();
        String query = "";
        query += "INSERT INTO CHUCVUNV";
        query += "VALUES " + chucVu.getStrMaLoaiChucVu() + ",";


        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Login SQL Error, Cannot get information");
            return false;
        } finally {
            try {
                connection.close();
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public final boolean XoaChucVu(ChucVuNVDTO chucVu) {
        connection = dbUltils.getConnection();
        String query = "";
        query += "DELETE FROM CHUCVUNV WHERE [MACHUCVU] = " + chucVu.getStrMaLoaiChucVu();

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Login SQL Error, Cannot get information");
            return false;
        } finally {
            try {
                connection.close();
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    public final boolean SuaChucVu(ChucVuNVDTO chucVu) {
        connection = dbUltils.getConnection();
        String query = "";
        query += "UPDATE CHUCVUNV SET CHUCVU =" + chucVu.getStrTenLoaiChucVu() + " WHERE MACHUCVU =" + chucVu.getStrMaLoaiChucVu();
        try {
            connection = dbUltils.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Login SQL Error, Cannot get information");
            return false;
        } finally {
            try {
                connection.close();
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public final java.util.ArrayList<ChucVuNVDTO> Select() {
        connection = dbUltils.getConnection();
        String query = "";
        query += "SELECT MACHUCVU, CHUCVU ";
        query += "FROM CHUCVUNV";

        ArrayList<ChucVuNVDTO> ListChucVu = new java.util.ArrayList<>();


        try {
            connection = dbUltils.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                ChucVuNVDTO result = new ChucVuNVDTO();
                result.setStrMaLoaiChucVu(resultSet.getString("MACHUCVU"));
                result.setStrTenLoaiChucVu(resultSet.getString("CHUCVU"));
                ListChucVu.add(result);
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


        return ListChucVu;
    }

}