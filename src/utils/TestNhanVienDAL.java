package utils;

import dal.*;
import dto.NhanVienDTO;

import java.io.IOException;
import java.util.ArrayList;

public class TestNhanVienDAL {
    NhanVienDAL nhanVienDAL;
    public void TestSelectAllNhanVien() throws IOException {
        ArrayList<NhanVienDTO> ListNhanVien = new ArrayList<>();
        ListNhanVien = nhanVienDAL.Select();


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

    public TestNhanVienDAL() {
      nhanVienDAL = new NhanVienDAL();
    }
}
