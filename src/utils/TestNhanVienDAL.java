package utils;

import dal.*;
import dto.NhanVienDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestNhanVienDAL {
    NhanVienDAL nhanVienDAL;
    public void TestSelectAllNhanVien() throws IOException {
        ArrayList<NhanVienDTO> ListNhanVien = new ArrayList<>();
        ListNhanVien = nhanVienDAL.Select();

        System.out.println("\nSELECT ALL EMP: \n");
        for (NhanVienDTO data:ListNhanVien
             ) {
            System.out.println("\n" + data.getStrMaNhanVien());
            System.out.println("\n" + data.getStrHoTen());
            System.out.println("\n" + data.getStrMaChucVu());
            System.out.println("\n" + data.getStrDiaChi());
            System.out.println("\n" + data.getStrEmail());
            System.out.println("\n" + data.getStrSoDT());
            System.out.println("\n" + data.getDtNgaySinh());
            System.out.println("\n" + data.getDtNgayVaoLam());
            System.out.println("\n" + data.getFlLuong());
            System.out.println("\n" + data.getFlTienPhat());
            System.out.println("\n-----------------------------");
        }
        System.out.println("RECORD IN DATABASE: "+ListNhanVien.stream().count());
    }

    public void TestSelectByKey(String key) throws IOException {
        ArrayList<NhanVienDTO> ListNhanVien = new ArrayList<>();
        ListNhanVien = nhanVienDAL.SelectByKeyWord(key);

        System.out.println("\nSELECT  EMP BY KEY : "+ key + "\n");
        for (NhanVienDTO data:ListNhanVien
        ) {
            System.out.println("\n" + data.getStrMaNhanVien());
            System.out.println("\n" + data.getStrHoTen());
            System.out.println("\n" + data.getStrMaChucVu());
            System.out.println("\n" + data.getStrDiaChi());
            System.out.println("\n" + data.getStrEmail());
            System.out.println("\n" + data.getStrSoDT());
            System.out.println("\n" + data.getDtNgaySinh());
            System.out.println("\n" + data.getDtNgayVaoLam());
            System.out.println("\n" + data.getFlLuong());
            System.out.println("\n" + data.getFlTienPhat());
            System.out.println("\n-----------------------------");
        }
        System.out.println("RECORD IN DATABASE: "+ListNhanVien.stream().count());
    }

    public void TestDeleteNhanVien(String MANV) throws IOException, SQLException {
        ArrayList<NhanVienDTO> ListNhanVien = new ArrayList<>();
        NhanVienDTO nhanVien = new NhanVienDTO();
        nhanVien.setStrMaNhanVien(MANV);
        boolean result = nhanVienDAL.XoaNV(nhanVien);


        if(result)
            System.out.println("DELETE EMP CODE : "+nhanVien.getStrMaNhanVien() + " SUCCESS");
    }

    public TestNhanVienDAL() {
      nhanVienDAL = new NhanVienDAL();
    }
}
