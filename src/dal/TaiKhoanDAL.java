package dal;

import dto.*;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaiKhoanDAL
{
	private Connection connection;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	DBUtils dbUltils = new DBUtils();


	public TaiKhoanDAL(){
		dbUltils = new DBUtils();
		connection = dbUltils.getConnection();
	}
	public final boolean ThemTK(TaiKhoanDTO TaiKhoanDTO)
	{

		connection = dbUltils.getConnection();
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO TAIKHOANNV (TENTK, MATKHAU, MACHUCVU, MANV)  " +
					"VALUES( ? , ? , ? , ? )");
			preparedStatement.setString(1, TaiKhoanDTO.getStrTenTk());
			preparedStatement.setString(2, TaiKhoanDTO.getStrMatKhau());
			preparedStatement.setString(3, TaiKhoanDTO.getStrMaChucVu());
			preparedStatement.setString(4, String.valueOf(TaiKhoanDTO.getIntMaNV()));
			
			preparedStatement.executeQuery();

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

	public final boolean SuaTK(TaiKhoanDTO TaiKhoanDTO)
	{
		connection = dbUltils.getConnection();
		try {
			preparedStatement = connection.prepareStatement("UPDATE [TAIKHOANNV] " +
					"SET [TENTK] =?, [MATKHAU] =?, [MACHUCVU] =?, WHERE [MANV] = ?");
			preparedStatement.setString(1, TaiKhoanDTO.getStrTenTk());
			preparedStatement.setString(2, TaiKhoanDTO.getStrMatKhau());
			preparedStatement.setString(3, TaiKhoanDTO.getStrMaChucVu());
			preparedStatement.setString(4, String.valueOf(TaiKhoanDTO.getIntMaNV()));
			preparedStatement.executeQuery();

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

	public final boolean XoaTK(TaiKhoanDTO TaiKhoanDTO)
	{
		connection = dbUltils.getConnection();
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM TAIKHOANNV WHERE MANV = ?");
			preparedStatement.setInt(1, TaiKhoanDTO.getIntMaNV());
			preparedStatement.execute();
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



	public final java.util.ArrayList<TaiKhoanDTO> SelectByKeyWord(String sKeyword)
	{
		connection = dbUltils.getConnection();
		java.util.ArrayList<TaiKhoanDTO> ListTaiKhoan = new java.util.ArrayList<TaiKhoanDTO>();

		try {
			preparedStatement = connection.prepareStatement("SELECT TENTK, MATKHAU, MATK, MANV, MACHUCVU\n" +
					"        FROM TAIKHOANNV\n" +
					"        WHERE(MANV LIKE CONCAT('%', ?, '%'))");

			preparedStatement.setString(1, sKeyword);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				TaiKhoanDTO taiKhoanDTO = new TaiKhoanDTO();
				taiKhoanDTO.setStrTenTk(resultSet.getString("TENTK"));
				taiKhoanDTO.setStrMatKhau(resultSet.getString("MATKHAU"));
				taiKhoanDTO.setIntMaTk(Integer.parseInt(resultSet.getString("MATK")));
				taiKhoanDTO.setIntMaNV(Integer.parseInt (resultSet.getString("MANV")));
				taiKhoanDTO.setStrMaChucVu((resultSet.getString("MACHUCVU")));

				ListTaiKhoan.add(taiKhoanDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Login SQL Error, Cannot get information");
			return null;

		} finally {
			try {
				connection.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ListTaiKhoan;
	}
}