package dal;

import dto.*;
import utils.DBUtils;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NhanVienDAL {

    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    DBUtils dbUltils = new DBUtils();


    public NhanVienDAL() {
        dbUltils = new DBUtils();
        connection = dbUltils.getConnection();
    }


    public final boolean ThemNV(NhanVienDTO NhanVienDTO) {
        connection = dbUltils.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO NHANVIEN( HOTEN, NGAYSINH, MACHUCVU, NGAYVAOLAM, EMAIL, SDT, DIACHI, LUONG, TIENPHAT) " +
                    "VALUES( ? , ? , ? , ? , ? ,? , ? ,?, ? )");
            preparedStatement.setString(1, NhanVienDTO.getStrHoTen());
            preparedStatement.setString(2, NhanVienDTO.getDtNgaySinh().toString());
            preparedStatement.setString(3, NhanVienDTO.getStrMaChucVu());
            preparedStatement.setString(4, NhanVienDTO.getDtNgayVaoLam().toString());
            preparedStatement.setString(5, NhanVienDTO.getStrEmail());
            preparedStatement.setString(6, NhanVienDTO.getStrSoDT());
            preparedStatement.setString(7, NhanVienDTO.getStrDiaChi());
            preparedStatement.setString(8, String.valueOf(NhanVienDTO.getFlLuong()));
            preparedStatement.setString(9, String.valueOf(NhanVienDTO.getFlTienPhat()));
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

    public final boolean SuaNV(NhanVienDTO NhanVienDTO) {
        connection = dbUltils.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE [NHANVIEN] " +
                    "SET [HOTEN] =?, [NGAYSINH] =?, [MACHUCVU] =?, [NGAYVAOLAM] =?, " +
                    "[EMAIL] =?, [SDT] =?, [DIACHI] =?, [LUONG] =?, [TIENPHAT] =?," +
                    "WHERE [MANV] = ?");
            preparedStatement.setString(1, NhanVienDTO.getStrHoTen());
            preparedStatement.setString(2, NhanVienDTO.getDtNgaySinh().toString());
            preparedStatement.setString(3, NhanVienDTO.getStrMaChucVu());
            preparedStatement.setString(4, NhanVienDTO.getDtNgayVaoLam().toString());
            preparedStatement.setString(5, NhanVienDTO.getStrEmail());
            preparedStatement.setString(6, NhanVienDTO.getStrSoDT());
            preparedStatement.setString(7, NhanVienDTO.getStrDiaChi());
            preparedStatement.setString(8, String.valueOf(NhanVienDTO.getFlLuong()));
            preparedStatement.setString(9, String.valueOf(NhanVienDTO.getFlTienPhat()));
            preparedStatement.setString(10, NhanVienDTO.getStrMaNhanVien());

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

    public final boolean XoaNV(NhanVienDTO NhanVienDTO) throws SQLException {
        connection = dbUltils.getConnection();

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM NHANVIEN WHERE MANV = ?");
            preparedStatement.setString(1, NhanVienDTO.getStrMaNhanVien());
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



    public final java.util.ArrayList<NhanVienDTO> Select() {
        connection = dbUltils.getConnection();
        String query = "";
        query += "SELECT MANV, HOTEN, NGAYSINH, CHUCVUNV.CHUCVU, NGAYVAOLAM, EMAIL, SDT, DIACHI, LUONG, TIENPHAT ";
        query += "FROM NHANVIEN ";
        query += "INNER JOIN CHUCVUNV ON NHANVIEN.MACHUCVU = CHUCVUNV.MACHUCVU ";
        query += "ORDER BY MANV  ASC";


        java.util.ArrayList<NhanVienDTO> ListNhanVien = new java.util.ArrayList<NhanVienDTO>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NhanVienDTO nhanVienDTO = new NhanVienDTO();
                nhanVienDTO.setStrMaNhanVien(resultSet.getString("MANV"));
                nhanVienDTO.setStrHoTen(resultSet.getString("HOTEN"));

                //  nhanVienDTO.setDtNgaySinh(LocalDateTime.parse(resultSet.getString("NGAYSINH")));
                nhanVienDTO.setDtNgaySinh((resultSet.getTimestamp("NGAYSINH").toLocalDateTime()));

                nhanVienDTO.setStrMaChucVu(resultSet.getString("CHUCVU"));
                nhanVienDTO.setDtNgayVaoLam((resultSet.getTimestamp("NGAYVAOLAM").toLocalDateTime()));
                nhanVienDTO.setStrEmail(resultSet.getString("EMAIL"));
                nhanVienDTO.setStrSoDT(resultSet.getString("SDT"));
                nhanVienDTO.setStrDiaChi(resultSet.getString("DIACHI"));
                nhanVienDTO.setFlLuong(Float.parseFloat(resultSet.getString("LUONG")));
                nhanVienDTO.setFlTienPhat(Float.parseFloat(resultSet.getString("TIENPHAT")));
                ListNhanVien.add(nhanVienDTO);
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

        return ListNhanVien;
    }

    public final java.util.ArrayList<NhanVienDTO> SelectByKeyWord(String sKeyword) {
        connection = dbUltils.getConnection();
        java.util.ArrayList<NhanVienDTO> ListNhanVien = new java.util.ArrayList<NhanVienDTO>();

        try {
            preparedStatement = connection.prepareStatement("SELECT MANV, HOTEN, NGAYSINH, CHUCVUNV.CHUCVU, NGAYVAOLAM, EMAIL, SDT, DIACHI, LUONG, TIENPHAT\n" +
                    "        FROM NHANVIEN\n" +
                    "        INNER JOIN CHUCVUNV ON NHANVIEN.MACHUCVU = CHUCVUNV.MACHUCVU\n" +
                    "        WHERE(MANV LIKE CONCAT('%', ?, '%'))\n" +
                    "        OR(HOTEN LIKE CONCAT('%', ?, '%'))\n" +
                    "        OR(CHUCVUNV.CHUCVU LIKE CONCAT('%', ?, '%'))\n" +
                    "        ORDER BY MANV ASC");
            preparedStatement.setString(1, sKeyword);
            preparedStatement.setString(2, sKeyword);
            preparedStatement.setString(3, sKeyword);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NhanVienDTO nhanVienDTO = new NhanVienDTO();
                nhanVienDTO.setStrMaNhanVien(resultSet.getString("MANV"));
                nhanVienDTO.setStrHoTen(resultSet.getString("HOTEN"));
                nhanVienDTO.setDtNgaySinh((resultSet.getTimestamp("NGAYSINH").toLocalDateTime()));
                nhanVienDTO.setStrMaChucVu(resultSet.getString("CHUCVU"));
                nhanVienDTO.setDtNgayVaoLam((resultSet.getTimestamp("NGAYVAOLAM").toLocalDateTime()));
                nhanVienDTO.setStrEmail(resultSet.getString("EMAIL"));
                nhanVienDTO.setStrSoDT(resultSet.getString("SDT"));
                nhanVienDTO.setStrDiaChi(resultSet.getString("DIACHI"));
                nhanVienDTO.setFlLuong(Float.parseFloat(resultSet.getString("LUONG")));
                nhanVienDTO.setFlTienPhat(Float.parseFloat(resultSet.getString("TIENPHAT")));
                ListNhanVien.add(nhanVienDTO);
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


        return ListNhanVien;
    }

    public final int Select_IDENT_CURRENT(int IdentCurrent) {
        connection = dbUltils.getConnection();
        String query = "";
        query += " SELECT IDENT_CURRENT('NHANVIEN') as LastID ";

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                IdentCurrent = Integer.parseInt(resultSet.getString("LastID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Login SQL Error, Cannot get information");
            return -1;

        } finally {
            try {
                connection.close();
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return IdentCurrent;
    }
}