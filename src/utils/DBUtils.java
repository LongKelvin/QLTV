package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Properties;

/**
 * The Class DBUtils.
 */
public class DBUtils {

	/** The db url. */
	private String db_url = null;

	/** The db user. */
	private String db_user = null;

	/** The db password. */
	private String db_password = null;

	/** The db driver. */
	private String db_driver = null;

	/** Khởi tạo biến thực hiện kết nối tới cơ sở dữ liệu. */
	private Connection conn;

	/**
	 * Đọc file database.properties lấy các tham số và kết nối đến SQL Server.
	 * 
	 * @return: Connection
	 */
	public Connection getConnection() {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream("database.properties"));
			db_url = p.getProperty("db_url");
			db_user = p.getProperty("db_user");
			db_password = p.getProperty("db_password");
			db_driver = p.getProperty("db_driver");
			Class.forName(db_driver);
			conn = DriverManager.getConnection(db_url, db_user, db_password);
		} catch (FileNotFoundException e) {
			System.err.println("Không thấy tệp tin database.properties.");
		} catch (IOException e) {
			System.err.println("Có lỗi khi thao tác với tệp tin.");
		} catch (ClassNotFoundException e) {
			System.err.println("Không tìm thấy class.");
		} catch (SQLException e) {
			System.err.println("Lỗi kết nối cơ sở dư liệu.");
		}
		if (conn == null) {
			throw new NullPointerException("Kết nối không thành công.");
		}
		return conn;
	}

	/**
	 * Đếm số bản ghi trong bảng dữ liệu.
	 * 
	 * @param: 
	 * @return: numberRecord: Số bản ghi trong bảng dữ liệu
	 */
	public int countRecord(String tblName) {
		int numberRecord = 0;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		// Khởi tạo đối tượng chứa câu lệnh thực hiện tìm kiếm dữ liệu.
		StringBuffer sbCommand = new StringBuffer("select count(*)");
		sbCommand.append(" from ");
		sbCommand.append(tblName);
		try {
			connection = getConnection();
			preparedStatement = conn.prepareStatement(sbCommand.toString());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				numberRecord = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return numberRecord;
	}

	/**
	 * Chuyển xâu về dạng phù hợp trong câu lệnh SQL.<br>
	 * 
	 * @param val: giá trị xâu cần chuyển đổi.
	 * @return: xâu sau khi chuyển đổi.
	 */
	public static String makeSQLString(String val) {
		return ("'" + val + "'");
	}

	/**
	 * Chuyển đối tượng Calendar về xâu thời gian trong SQL.<br>
	 * 
	 * @param calendar đối tượng Calendar cần chuyển đổi.
	 *	 * @return xâu biểu diễn thời gian tương ứng.
	 */
	public static String makeSQLDate(Calendar calendar) {
		return ("'" + MyUtils.toString(calendar) + "'");
	}

	/**
	 * Chuyển số thực về dạng xâu biểu diễn số trong SQL.<br>
	 * 
	 * @param val
	 *            số cần chuyển đổi.
	 * @return xâu biểu diễn số cần chuyển đổi.
	 */
	public static String makeSQLNum(double val) {
		return Double.toString(val);
	}
}