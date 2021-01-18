package dal;

import dto.*;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SachDAL
{
	private Connection connection;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	DBUtils dbUltils = new DBUtils();



	public SachDAL() {
		dbUltils = new DBUtils();
		connection = dbUltils.getConnection();
	}

	public final java.util.ArrayList<SachDTO> LoadListBooks()
	{
		connection = dbUltils.getConnection();
		java.util.ArrayList<SachDTO> ListSach = new java.util.ArrayList<>();
		String query = "SELECT MASACH, TENSACH, TACGIA, TENTHELOAI, NXB, NAMXB, NGAYNHAP, DONGIA, SACH.SOLUONG, LUOTMUON";
		query += " FROM SACH, THELOAISACH";
		query += " WHERE SACH.MATHELOAI=THELOAISACH.MATHELOAI";
		query += " ORDER BY THELOAISACH.MATHELOAI  ASC";

		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				SachDTO sachDTO = new SachDTO();
				sachDTO.setMasach(resultSet.getString("MASACH"));
				sachDTO.setTensach(resultSet.getString("TENSACH"));
				sachDTO.setTacgia((resultSet.getString("TACGIA")));
				sachDTO.setTheloai(resultSet.getString("TENTHELOAI"));
				sachDTO.setNxb((resultSet.getString("NXB")));
				sachDTO.setNamxb(Integer.parseInt(resultSet.getString("NAMXB")));
				sachDTO.setNgaynhap(resultSet.getTimestamp("NGAYNHAP").toLocalDateTime());
				sachDTO.setDongia((int) Math.round(Float.parseFloat(resultSet.getString("DONGIA"))));
				sachDTO.setSoluong(Integer.parseInt(resultSet.getString("SOLUONG")));
				sachDTO.setLuotmuon(Integer.parseInt(resultSet.getString("LUOTMUON")));
				ListSach.add(sachDTO);
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


		return ListSach;
	}

	public final java.util.ArrayList<SachDTO> SelectListBookByKeyWord(String sKeyword)
	{
		connection = dbUltils.getConnection();
		java.util.ArrayList<SachDTO> ListSach = new java.util.ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement( " SELECT MASACH, TENSACH, TACGIA, TENTHELOAI,  NXB, NAMXB, NGAYNHAP, DONGIA, SACH.SOLUONG, LUOTMUON "+
					" FROM SACH ,THELOAISACH "+
					" WHERE (MASACH LIKE CONCAT('%',?,'%'))"+
					" OR (TENSACH LIKE CONCAT('%',?,'%'))"+
					" OR (TACGIA LIKE CONCAT('%',?,'%'))"+
					" OR (THELOAISACH.TENTHELOAI LIKE CONCAT('%',?,'%'))"+
					" ORDER BY THELOAISACH.MATHELOAI  ASC");
			preparedStatement.setString(1, sKeyword);
			preparedStatement.setString(2, sKeyword);
			preparedStatement.setString(3, sKeyword);
			preparedStatement.setString(4, sKeyword);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				SachDTO sachDTO = new SachDTO();
				sachDTO.setMasach(resultSet.getString("MASACH"));
				sachDTO.setTensach(resultSet.getString("TENSACH"));
				sachDTO.setTacgia((resultSet.getString("TACGIA")));
				sachDTO.setTheloai(resultSet.getString("TENTHELOAI"));
				sachDTO.setNxb((resultSet.getString("NXB")));
				sachDTO.setNamxb(Integer.parseInt(resultSet.getString("NAMXB")));
				sachDTO.setNgaynhap(resultSet.getTimestamp("NGAYNHAP").toLocalDateTime());
				sachDTO.setDongia((int) Math.round(Float.parseFloat(resultSet.getString("DONGIA"))));
				sachDTO.setSoluong(Integer.parseInt(resultSet.getString("SOLUONG")));
				sachDTO.setLuotmuon(Integer.parseInt(resultSet.getString("LUOTMUON")));
				ListSach.add(sachDTO);
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


		return ListSach;
	}

	public final boolean Edit(SachDTO sachDTO)
	{
		connection = dbUltils.getConnection();

		try {
			preparedStatement = connection.prepareStatement("UPDATE SACH SET TENSACH =?, TACGIA =?, TENTHELOAI =?, NXB =?, NAMXB =?,\n" +
					"\t\tNGAYNHAP =?, DONGIA =?, SACH.SOLUONG =?, LUOTMUON =?\n" +
					"\t\tWHERE MASACH =?");
			preparedStatement.setString(1,sachDTO.getTensach());
			preparedStatement.setString(2,sachDTO.getTacgia());
			preparedStatement.setString(3,sachDTO.getTheloai());
			preparedStatement.setString(4,sachDTO.getNxb());
			preparedStatement.setInt(5,sachDTO.getNamxb());
			preparedStatement.setString(6,sachDTO.getNgaynhap().toString());
			preparedStatement.setInt(7,sachDTO.getDongia());
			preparedStatement.setInt(8,sachDTO.getSoluong());
			preparedStatement.setInt(9,sachDTO.getLuotmuon());
			preparedStatement.setString(10,sachDTO.getMasach());
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

	public final boolean UpdateSoLuong_LuotMuon(SachDTO sachDTO)
	{
		connection = dbUltils.getConnection();
		try {
			preparedStatement = connection.prepareStatement("UPDATE SACH SET SOLUONG = SOLUONG - 1 , LUOTMUON = LUOTMUON + 1 WHERE MASACH = ? ");
			preparedStatement.setString(1,sachDTO.getMasach());
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

	public final boolean Add(SachDTO sachDTO)
	{
		connection = dbUltils.getConnection();

		try {
			preparedStatement = connection.prepareStatement("INSERT INTO SACH (MASACH, TENSACH, TACGIA, MATHELOAI, NXB, NAMXB, NGAYNHAP, DONGIA, SOLUONG, LUOTMUON) VALUES (?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(2,sachDTO.getTensach());
			preparedStatement.setString(3,sachDTO.getTacgia());
			preparedStatement.setString(4,sachDTO.getTheloai());
			preparedStatement.setString(5,sachDTO.getNxb());
			preparedStatement.setInt(6,sachDTO.getNamxb());
			preparedStatement.setString(7,sachDTO.getNgaynhap().toString());
			preparedStatement.setInt(8,sachDTO.getDongia());
			preparedStatement.setInt(9,sachDTO.getSoluong());
			preparedStatement.setInt(10,sachDTO.getLuotmuon());
			preparedStatement.setString(1,sachDTO.getMasach());
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

	public final boolean Delete(SachDTO sachDTO)
	{
		connection = dbUltils.getConnection();

		try {
			preparedStatement = connection.prepareStatement("DELETE FROM SACH WHERE MASACH = ?");
			preparedStatement.setString(1, sachDTO.getMasach());
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


	public final java.util.ArrayList<SachDTO> LoadListBooks_ForfrmMuon()
	{
		connection = dbUltils.getConnection();
		String query = "SELECT MASACH, TENSACH, TACGIA, TENTHELOAI, NXB, NAMXB";
		query += " FROM SACH, THELOAISACH";
		query += " WHERE SACH.MATHELOAI=THELOAISACH.MATHELOAI";
		query += " AND (SOLUONG > = 1)";
		query += " ORDER BY THELOAISACH.MATHELOAI  ASC";
		ArrayList<SachDTO> ListSach = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				SachDTO sachDTO = new SachDTO();
				sachDTO.setMasach(resultSet.getString("MASACH"));
				sachDTO.setTensach(resultSet.getString("TENSACH"));
				sachDTO.setTacgia((resultSet.getString("TACGIA")));
				sachDTO.setTheloai(resultSet.getString("TENTHELOAI"));
				sachDTO.setNxb((resultSet.getString("NXB")));
				sachDTO.setNamxb(Integer.parseInt(resultSet.getString("NAMXB")));
				ListSach.add(sachDTO);
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

		return ListSach;
	}




	public final java.util.ArrayList<SachDTO> SelectByKeyWord(String sKeyword)
	{

		java.util.ArrayList<SachDTO> ListSach = new java.util.ArrayList<>();
		connection = dbUltils.getConnection();

		try {
			preparedStatement = connection.prepareStatement( " SELECT MASACH, TENSACH, TACGIA, THELOAISACH.TENTHELOAI "+
					" FROM SACH INNER JOIN THELOAISACH "+
					" ON SACH.MATHELOAI = THELOAISACH.MATHELOAI"+
					" WHERE (MASACH LIKE CONCAT('%',?,'%'))"+
					" OR (TENSACH LIKE CONCAT('%',?,'%'))"+
					" OR (TACGIA LIKE CONCAT('%',?,'%'))"+
					" OR (THELOAISACH.TENTHELOAI LIKE CONCAT('%',?,'%'))"+
					" ORDER BY THELOAISACH.MATHELOAI  ASC");
			preparedStatement.setString(1, sKeyword);
			preparedStatement.setString(2, sKeyword);
			preparedStatement.setString(3, sKeyword);
			preparedStatement.setString(4, sKeyword);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				SachDTO sachDTO = new SachDTO();
				sachDTO.setMasach(resultSet.getString("MASACH"));
				sachDTO.setTensach(resultSet.getString("TENSACH"));
				sachDTO.setTacgia((resultSet.getString("TACGIA")));
				sachDTO.setTheloai(resultSet.getString("TENTHELOAI"));
				ListSach.add(sachDTO);
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


		return ListSach;
	}

	public final boolean UpdateLuotMuon_SoLuong(SachDTO sachDTO)
	{
		connection = dbUltils.getConnection();
		try {
			preparedStatement = connection.prepareStatement("UPDATE SACH SET LUOTMUON = LUOTMUON +1, SOLUONG = SOLUONG - 1 WHERE MASACH = ? ");
			preparedStatement.setString(1,sachDTO.getMasach());
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

	public final boolean Update_SoLuong_Khi_XoaPM(SachDTO sachDTO)
	{
		connection = dbUltils.getConnection();
		try {
			preparedStatement = connection.prepareStatement("UPDATE SACH SET  SOLUONG = SOLUONG + 1 WHERE MASACH = ? ");
			preparedStatement.setString(1,sachDTO.getMasach());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Login SQL Error, Cannot get information");
			return false;

		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}