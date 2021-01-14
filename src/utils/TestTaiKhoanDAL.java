package utils;

import dal.*;
import dto.NhanVienDTO;
import dto.TaiKhoanDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestTaiKhoanDAL {
    TaiKhoanDAL taiKhoanDAL;
    public void TestSelectAllTK(String key) throws IOException {
        ArrayList<TaiKhoanDTO> ListAccount = new ArrayList<>();
        ListAccount = taiKhoanDAL.SelectByKeyWord(key);

        System.out.println("\nSELECT ALL ACCOUNT: \n");
        for (TaiKhoanDTO data:ListAccount
        ) {
            System.out.println("\n" + data.getStrMaChucVu());
            System.out.println("\n" + data.getIntMaTk());
            System.out.println("\n" + data.getStrTenTk());
            System.out.println("\n" + data.getStrMatKhau());
            System.out.println("\n" + data.getStrMaChucVu());

            System.out.println("\n-----------------------------");
        }
        System.out.println("RECORD IN DATABASE: "+ListAccount.stream().count());
    }

    public void TestSelectByKey(String key) throws IOException {
        ArrayList<TaiKhoanDTO> ListAccount = new ArrayList<>();
        ListAccount = taiKhoanDAL.SelectByKeyWord(key);

        System.out.println("\nSELECT  ACCOUNT BY KEY : "+ key + "\n");
        for (TaiKhoanDTO data:ListAccount
        ) {
            System.out.println("\n" + data.getStrMaChucVu());
            System.out.println("\n" + data.getIntMaTk());
            System.out.println("\n" + data.getStrTenTk());
            System.out.println("\n" + data.getStrMatKhau());
            System.out.println("\n" + data.getStrMaChucVu());
            System.out.println("\n-----------------------------");
        }
        System.out.println("RECORD IN DATABASE: "+ListAccount.stream().count());
    }

    public void TestDeleteAccount(String MANV) throws IOException, SQLException {
        ArrayList<TaiKhoanDTO> ListAccount = new ArrayList<>();
        TaiKhoanDTO taiKhoanDTO = new TaiKhoanDTO();
        taiKhoanDTO.setIntMaNV(Integer.parseInt(MANV));
        boolean result = taiKhoanDAL.XoaTK(taiKhoanDTO);


        if(result)
            System.out.println("DELETE ACCOUNT CODE : "+taiKhoanDTO.getIntMaNV() + " SUCCESS");
    }

    public TestTaiKhoanDAL() {
        taiKhoanDAL = new TaiKhoanDAL();
    }
}
