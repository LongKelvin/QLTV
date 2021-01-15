package dal;

import dto.*;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhieuTraDAL {

    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    DBUtils dbUltils = new DBUtils();

    public PhieuTraDAL() {
        dbUltils = new DBUtils();
        connection = dbUltils.getConnection();
    }

    public final boolean CreateReturnReceipt(PhieuTraDTO returnReceipt) {

        /*
        trả sach
        tìm sách bằng mã sách, mã phiếu mượn
        load ma sach len update lại masach trong phiếu mượn
        => update lai so luong sach && soluongsachDang muon

        nếu số lượng >1
	    thì xóa mã sách khỏi ma sách đang mượn
	    tạo phiếu trẩ có PK (mapm,masach)
        nếu số lượng = 1
	    xóa pm ra khỏi hệ thống
	    tạo phiếu trả có mapm và ms
        * */


        ArrayList<PhieuMuonDTO> phieuMuon = new ArrayList<>();
        PhieuMuonDAL phieuMuonDAL = new PhieuMuonDAL();
        phieuMuon = phieuMuonDAL.Select_MaSach_By_MaPhieuMuon(returnReceipt.getMapm());
        String maSach = phieuMuon.get(0).getMasach();
        PhieuMuonDTO pm = phieuMuon.get(0);

        int soLuong = pm.getSoluong();

        if (soLuong == 1) {
            //xoa phieu muon ra khoi he thong
            PhieuMuonDTO phieuMuonCanXoa = new PhieuMuonDTO();
            phieuMuonCanXoa.setMapm(pm.getMapm());
            phieuMuonDAL.XoaPhieuMuon(phieuMuonCanXoa);
        } else {
            if (maSach.contains(returnReceipt.getMasach())) {
                maSach = maSach.replace(returnReceipt.getMasach(), "");
                phieuMuon.get(0).setSoluong(phieuMuon.get(0).getSoluong() - 1);
                phieuMuon.get(0).setMasach(maSach); //update ma sach trong phieu muon
                // Update SoLuong Sach Trong Phieu Muon KhiTra Sach
                phieuMuonDAL.SuaPhieuMuon(phieuMuon.get(0));

                //Update lai so luong sach co ma sach bang ma sach da tra
                SachDAL sachDAL = new SachDAL();
                SachDTO sachDTO = new SachDTO();
                sachDTO.setMasach(returnReceipt.getMasach());
                sachDAL.Update_SoLuong_Khi_XoaPM(sachDTO);
            }

        }


        String query = "";
        query += "INSERT INTO PHIEUTRA (MAPM, MASACH, MADG, NGAYTRA, TIENPHAT)";
        query += " VALUES ( ? , ? , ? , ? , ? )";

        connection = dbUltils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, returnReceipt.getMapm());
            preparedStatement.setString(2, returnReceipt.getMasach());
            preparedStatement.setString(3, returnReceipt.getMadg().toString());
            preparedStatement.setString(4, String.valueOf(returnReceipt.getTienphat()));
            preparedStatement.setString(5, returnReceipt.getNgaytra().toString());
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
}