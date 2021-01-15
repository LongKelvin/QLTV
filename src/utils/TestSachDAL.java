package utils;

import dal.*;
import dto.SachDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestSachDAL {
    SachDAL sachDAL;
    public void TestSelectAllSach() throws IOException {
        ArrayList<SachDTO> ListSach = new ArrayList<>();
        ListSach = sachDAL.LoadListBooks();

        System.out.println("\nSELECT ALL BOOK: \n");
        for (SachDTO data:ListSach
        ) {
            System.out.println("\n" + data.getMasach());
            System.out.println("\n" + data.getTensach());
            System.out.println("\n" + data.getNxb());
            System.out.println("\n" + data.getTheloai());
            System.out.println("\n" + data.getNamxb());
            System.out.println("\n" + data.getNgaynhap());
            System.out.println("\n" + data.getSoluong());
            System.out.println("\n" + data.getLuotmuon());
            System.out.println("\n" + data.getDongia());
            System.out.println("\n" + data.getNgaynhap());
            System.out.println("\n-----------------------------");
        }
        System.out.println("RECORD IN DATABASE: "+ListSach.stream().count());
    }

    public void TestSelectByKey(String key) throws IOException {
        ArrayList<SachDTO> ListSach = new ArrayList<>();
        ListSach = sachDAL.SelectByKeyWord(key);

        System.out.println("\nSELECT  BOOK BY KEY : "+ key + "\n");
        assert ListSach != null;
        for (SachDTO data:ListSach
        ) {
            System.out.println("\n" + data.getMasach());
            System.out.println("\n" + data.getTensach());
            System.out.println("\n" + data.getNxb());
            System.out.println("\n" + data.getTheloai());
            System.out.println("\n" + data.getNamxb());
            System.out.println("\n" + data.getNgaynhap());
            System.out.println("\n" + data.getSoluong());
            System.out.println("\n" + data.getLuotmuon());
            System.out.println("\n" + data.getDongia());
            System.out.println("\n" + data.getNgaynhap());
            System.out.println("\n-----------------------------");
        }
        System.out.println("RECORD IN DATABASE: "+ListSach.stream().count());
    }

    public void TestSelectByKey_FullProperties(String key) throws IOException {
        ArrayList<SachDTO> ListSach = new ArrayList<>();
        ListSach = sachDAL.SelectListBookByKeyWord(key);

        System.out.println("\nSELECT BOOK BY KEY_FULL PROPERTIES : "+ key + "\n");
        assert ListSach != null;
        for (SachDTO data:ListSach
        ) {
            System.out.println("\n" + data.getMasach());
            System.out.println("\n" + data.getTensach());
            System.out.println("\n" + data.getNxb());
            System.out.println("\n" + data.getTheloai());
            System.out.println("\n" + data.getNamxb());
            System.out.println("\n" + data.getNgaynhap());
            System.out.println("\n" + data.getSoluong());
            System.out.println("\n" + data.getLuotmuon());
            System.out.println("\n" + data.getDongia());
            System.out.println("\n" + data.getNgaynhap());
            System.out.println("\n-----------------------------");
        }
        System.out.println("RECORD IN DATABASE: "+ListSach.stream().count());
    }

    public void TestDeleteNhanVien(String MASACH) throws IOException, SQLException {
        ArrayList<SachDTO> ListSach = new ArrayList<>();
        SachDTO sachDTO = new SachDTO();
        sachDTO.setMasach(MASACH);
        boolean result = sachDAL.Delete(sachDTO);


        if(result)
            System.out.println("DELETE BOOK CODE : "+sachDTO.getMasach() + " SUCCESS");
    }

    public TestSachDAL() {
        sachDAL = new SachDAL();
    }
}
