package dal;

import dto.*;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class PhieuMuonDAL
{
	private Connection connection;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	DBUtils dbUltils = new DBUtils();

	public PhieuMuonDAL() {
		dbUltils = new DBUtils();
		connection = dbUltils.getConnection();
	}
	
	public final java.util.ArrayList<PhieuMuonDTO> LoadListReceipt()
	{
		connection = dbUltils.getConnection();
		java.util.ArrayList<PhieuMuonDTO> ListPhieuMuon = new java.util.ArrayList<>();
		String query = "";

		query += "SELECT temp.MAPM, MASACH, PHIEUMUON.MADG, NGAYMUON, HANTRA, DOCGIA.HOTEN, temp.SOLUONG, MUCPHAT ";
		query += "FROM PHIEUMUON, DOCGIA, (SELECT MAPM, count(MASACH) as SOLUONG FROM PHIEUMUON GROUP BY MAPM) as temp ";
		query += "WHERE DOCGIA.MADG = PHIEUMUON.MADG and PHIEUMUON.MAPM = temp.MAPM";

		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				PhieuMuonDTO phieuMuonDTO = new PhieuMuonDTO();
				phieuMuonDTO.setMapm(resultSet.getString("MAPM"));
				phieuMuonDTO.setMasach(resultSet.getString("MASACH"));
				phieuMuonDTO.setMadg((resultSet.getString("MADG")));
				phieuMuonDTO.setNgaymuon(resultSet.getTimestamp("NGAYMUON").toLocalDateTime());
				phieuMuonDTO.setHantra((resultSet.getTimestamp("HANTRA").toLocalDateTime()));
				phieuMuonDTO.setHoten(resultSet.getString("HOTEN"));
				phieuMuonDTO.setSoluong((resultSet.getInt("SOLUONG")));
				phieuMuonDTO.setMucphat(resultSet.getBigDecimal("MUCPHAT"));
				ListPhieuMuon.add(phieuMuonDTO);
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

		return ListPhieuMuon;
	}

	public final boolean DeleteReceipt(String bookID, String receiptID)
	{
		connection = dbUltils.getConnection();
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM  PHIEUMUON WHERE MAPM = ? AND MASACH = ?");
			preparedStatement.setString(1, receiptID);
			preparedStatement.setString(2, bookID);
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


	public final java.util.ArrayList<PhieuMuonDTO> DisplayListReceipt()
	{
		String query = "";

		query += "SELECT temp.MAPM, MASACH, PHIEUMUON.MADG, NGAYMUON, HANTRA, DOCGIA.HOTEN, temp.SOLUONG, MUCPHAT ";
		query += "FROM PHIEUMUON, DOCGIA, (SELECT MAPM, count(MASACH) as SOLUONG FROM PHIEUMUON GROUP BY MAPM) as temp ";
		query += "WHERE DOCGIA.MADG = PHIEUMUON.MADG and PHIEUMUON.MAPM = temp.MAPM";
		java.util.ArrayList<PhieuMuonDTO> ListPhieuMuon = new java.util.ArrayList<>();
		connection = dbUltils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				PhieuMuonDTO phieuMuonDTO = new PhieuMuonDTO();
				phieuMuonDTO.setMapm(resultSet.getString("MAPM"));
				phieuMuonDTO.setMasach(resultSet.getString("MASACH"));
				phieuMuonDTO.setMadg((resultSet.getString("MADG")));
				phieuMuonDTO.setNgaymuon(resultSet.getTimestamp("NGAYMUON").toLocalDateTime());
				phieuMuonDTO.setHantra((resultSet.getTimestamp("HANTRA").toLocalDateTime()));
				phieuMuonDTO.setHoten(resultSet.getString("HOTEN"));
				phieuMuonDTO.setSoluong((resultSet.getInt("SOLUONG")));
				phieuMuonDTO.setMucphat(resultSet.getBigDecimal("MUCPHAT"));
				ListPhieuMuon.add(phieuMuonDTO);
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

		return ListPhieuMuon;

	}

	public final java.util.ArrayList<PhieuMuonDTO> Search(String sKeyword)
	{
		java.util.ArrayList<PhieuMuonDTO> ListPhieuMuon = new java.util.ArrayList<PhieuMuonDTO>();

		connection = dbUltils.getConnection();
		java.util.ArrayList<NhanVienDTO> ListNhanVien = new java.util.ArrayList<NhanVienDTO>();

		try {
			preparedStatement = connection.prepareStatement("SELECT temp.MAPM, MASACH, PHIEUMUON.MADG, NGAYMUON, HANTRA, DOCGIA.HOTEN, SOLUONG, MUCPHAT "+
					"FROM PHIEUMUON, DOCGIA, (SELECT MAPM, count(MASACH) as SOLUONG FROM PHIEUMUON GROUP BY MAPM) as temp "+
					"WHERE DOCGIA.MADG = PHIEUMUON.MADG and PHIEUMUON.MAPM = temp.MAPM AND DOCGIA.HOTEN LIKE %?% OR temp.MAPM LIKE %?%");
			preparedStatement.setString(1, sKeyword);
			preparedStatement.setString(2, sKeyword);
			preparedStatement.setString(3, sKeyword);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				PhieuMuonDTO phieuMuonDTO = new PhieuMuonDTO();
				phieuMuonDTO.setMapm(resultSet.getString("MAPM"));
				phieuMuonDTO.setMasach(resultSet.getString("MASACH"));
				phieuMuonDTO.setMadg((resultSet.getString("MADG")));
				phieuMuonDTO.setNgaymuon(resultSet.getTimestamp("NGAYMUON").toLocalDateTime());
				phieuMuonDTO.setHantra((resultSet.getTimestamp("HANTRA").toLocalDateTime()));
				phieuMuonDTO.setHoten(resultSet.getString("HOTEN"));
				phieuMuonDTO.setSoluong((resultSet.getInt("SOLUONG")));
				phieuMuonDTO.setMucphat(resultSet.getBigDecimal("MUCPHAT"));
				ListPhieuMuon.add(phieuMuonDTO);
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

		return ListPhieuMuon;
	}

	public final java.util.ArrayList<PhieuMuonDTO> Select()
	{
		java.util.ArrayList<PhieuMuonDTO> ListPhieuMuon = new java.util.ArrayList<PhieuMuonDTO>();

		String query = "SELECT[MAPM],[MASACH],[MADG],[NGAYMUON],[HANTRA] ,[SOLUONG] FROM[PHIEUMUON]";

		connection = dbUltils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				PhieuMuonDTO phieuMuonDTO = new PhieuMuonDTO();
				phieuMuonDTO.setMapm(resultSet.getString("MAPM"));
				phieuMuonDTO.setMasach(resultSet.getString("MASACH"));
				phieuMuonDTO.setMadg((resultSet.getString("MADG")));
				phieuMuonDTO.setNgaymuon(resultSet.getTimestamp("NGAYMUON").toLocalDateTime());
				phieuMuonDTO.setHantra((resultSet.getTimestamp("HANTRA").toLocalDateTime()));
				//phieuMuonDTO.setHoten(resultSet.getString("HOTEN"));
				phieuMuonDTO.setSoluong((resultSet.getInt("SOLUONG")));
				//phieuMuonDTO.setMucphat(resultSet.getBigDecimal("MUCPHAT"));
				//ListPhieuMuon.add(phieuMuonDTO);
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

		return ListPhieuMuon;

	}

	public final java.util.ArrayList<PhieuMuonDTO> SelectByKeyWord(String sKeyword)
	{
		String query = "";
		query = "SELECT[MAPM],[MASACH],[MADG],[NGAYMUON],[HANTRA] ,[SOLUONG] FROM[PHIEUMUON]";
		query += " WHERE (MADG LIKE CONCAT('%',?,'%'))";
		query += " OR (MAPM LIKE CONCAT('%',?,'%'))";
		query += " OR (NGAYMUON LIKE CONCAT('%',?,'%'))";
		query += " OR (HANTRA LIKE CONCAT('%',?,'%'))";
		query += " ORDER BY MAPM  ASC";

		java.util.ArrayList<PhieuMuonDTO> ListPhieuMuon = new java.util.ArrayList<PhieuMuonDTO>();
		connection = dbUltils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sKeyword);
			preparedStatement.setString(2, sKeyword);
			preparedStatement.setString(3, sKeyword);
			preparedStatement.setString(4, sKeyword);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				PhieuMuonDTO phieuMuonDTO = new PhieuMuonDTO();
				phieuMuonDTO.setMapm(resultSet.getString("MAPM"));
				phieuMuonDTO.setMasach(resultSet.getString("MASACH"));
				phieuMuonDTO.setMadg((resultSet.getString("MADG")));
				phieuMuonDTO.setNgaymuon(resultSet.getTimestamp("NGAYMUON").toLocalDateTime());
				phieuMuonDTO.setHantra((resultSet.getTimestamp("HANTRA").toLocalDateTime()));
				//phieuMuonDTO.setHoten(resultSet.getString("HOTEN"));
				phieuMuonDTO.setSoluong((resultSet.getInt("SOLUONG")));
				//phieuMuonDTO.setMucphat(resultSet.getBigDecimal("MUCPHAT"));
				ListPhieuMuon.add(phieuMuonDTO);
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

		return ListPhieuMuon;
	}



	public final java.util.ArrayList<PhieuMuonDTO> Select_MaSach_By_MaPhieuMuon(String sKeyword)
	{
		java.util.ArrayList<PhieuMuonDTO> ListPhieuMuon = new java.util.ArrayList<PhieuMuonDTO>();

		String query = "SELECT[MAPM],[MASACH],[MADG],[NGAYMUON],[HANTRA] [SOLUONG] FROM[PHIEUMUON] ";
		query += "WHERE MAPM = ? ";

		connection = dbUltils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sKeyword);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				PhieuMuonDTO phieuMuonDTO = new PhieuMuonDTO();
				phieuMuonDTO.setMapm(resultSet.getString("MAPM"));
				phieuMuonDTO.setMasach(resultSet.getString("MASACH"));
				phieuMuonDTO.setMadg((resultSet.getString("MADG")));
				phieuMuonDTO.setNgaymuon(resultSet.getTimestamp("NGAYMUON").toLocalDateTime());
				phieuMuonDTO.setHantra((resultSet.getTimestamp("HANTRA").toLocalDateTime()));
				phieuMuonDTO.setSoluong(resultSet.getInt("SOLUONG"));
				ListPhieuMuon.add(phieuMuonDTO);
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
		return ListPhieuMuon;

	}

	public final boolean SuaPhieuMuon(PhieuMuonDTO phieuMuon)
	{
		String query = "";
		query += "UPDATE PHIEUMUON ";
		query += "SET MASACH = ? , MADG = ? , SOLUONG = ? ";
		query += " WHERE MAPM = ?";


		connection = dbUltils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, phieuMuon.getMasach());
			preparedStatement.setString(2, phieuMuon.getMadg());
			preparedStatement.setInt(3, phieuMuon.getSoluong());
			preparedStatement.setString(4, phieuMuon.getMapm());
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

	public final boolean UpdateSoLuongKhiTraSach(PhieuMuonDTO phieuMuon)
	{
		String query = "";
		query += "UPDATE PHIEUMUON ";
		query += "SET MASACH = ? , MADG = ? , SOLUONG = SOLUONG-1 ";
		query += " WHERE MAPM = ?";


		connection = dbUltils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, phieuMuon.getMasach());
			preparedStatement.setString(2, phieuMuon.getMadg());
			preparedStatement.setString(4, phieuMuon.getMapm());
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

	public final boolean ThemPhieuMuon(PhieuMuonDTO phieuMuon)
	{
		String query = "";

//		query += "INSERT INTO PHIEUMUON(MASACH, MADG, NGAYMUON, HANTRA, SOLUONG, MUCPHAT) ";
//		query += "VALUES ( @MASACH , @MADG , @NGAYMUON , @HANTRA , @SOLUONG , @MUCPHAT  )";

		query += "INSERT INTO PHIEUMUON(MASACH, MADG, NGAYMUON, HANTRA, SOLUONG, MUCPHAT) ";
		query += "VALUES ( ? , ? , ? , ? , ? , ? )";

		connection = dbUltils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, phieuMuon.getMasach());
			preparedStatement.setString(2, phieuMuon.getMadg());
			preparedStatement.setString(3, phieuMuon.getNgaymuon().toString());
			preparedStatement.setString(4, phieuMuon.getHantra().toString());
			preparedStatement.setInt(5, phieuMuon.getSoluong());
			preparedStatement.setString(6, phieuMuon.getMucphat().toEngineeringString());
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

	public final boolean XoaPhieuMuon(PhieuMuonDTO phieuMuon)
	{
		String query = "";

		query += "DELETE FROM  PHIEUMUON WHERE MAPM = ?";

		connection = dbUltils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, phieuMuon.getMapm());
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

}