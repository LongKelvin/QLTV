package utils;

import dal.*;
import dto.ChucVuNVDTO;
import dto.NhanVienDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestChucVuDAL {
    ChucVuNVDAL chucVuNVDAL;
    public void TestSelectAllPos() throws IOException {
        ArrayList<ChucVuNVDTO> ListChucVu = new ArrayList<>();
        ListChucVu = chucVuNVDAL.Select();

        System.out.println("\nSELECT ALL POS: \n");
        for (ChucVuNVDTO data:ListChucVu
        ) {
            System.out.println("\n" + data.getStrMaLoaiChucVu());
            System.out.println("\n" + data.getStrTenLoaiChucVu());

            System.out.println("\n-----------------------------");
        }
        System.out.println("RECORD IN DATABASE: "+ListChucVu.stream().count());
    }



    public void TestDeleteChucVu(String MACV) throws IOException, SQLException {
        ArrayList<ChucVuNVDTO> ListChucVu = new ArrayList<>();
        ChucVuNVDTO chucVuNVDTO = new ChucVuNVDTO();
        chucVuNVDTO.setStrMaLoaiChucVu(MACV);
        boolean result = chucVuNVDAL.XoaChucVu(chucVuNVDTO);


        if(result)
            System.out.println("DELETE POS CODE : "+chucVuNVDTO.getStrMaLoaiChucVu() + " SUCCESS");
    }

    public void TestUpdateChucVu(ChucVuNVDTO cv) throws IOException, SQLException {
        boolean result = chucVuNVDAL.SuaChucVu(cv);


        if(result)
            System.out.println("UPDATE POS CODE : "+cv.getStrMaLoaiChucVu() + " SUCCESS");
    }

    public void TestAddNewPos(String newPos) throws IOException, SQLException {
        ArrayList<ChucVuNVDTO> ListChucVu = chucVuNVDAL.Select();
        int LastID = Integer.parseInt( ListChucVu.get(ListChucVu.size()-1).getStrMaLoaiChucVu())+1;

        ChucVuNVDTO cv = new ChucVuNVDTO();
        cv.setStrTenLoaiChucVu(newPos);
        cv.setStrMaLoaiChucVu(String.valueOf(LastID));
        boolean result = chucVuNVDAL.ThemChucVu(cv);

        if(result)
            System.out.println("INSERT POS CODE : "+cv.getStrTenLoaiChucVu() + " SUCCESS");
    }

    public TestChucVuDAL() {
        chucVuNVDAL = new ChucVuNVDAL();
    }
}
