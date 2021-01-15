package utils;

import dal.*;
import dto.PhieuMuonDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestPhieuMuonDAL {
    PhieuMuonDAL phieuMuonDAL;
    public void TestSelectAllPM() throws IOException {
        ArrayList<PhieuMuonDTO> ListPhieuMuon = new ArrayList<>();
        ListPhieuMuon = phieuMuonDAL.Select();

        System.out.println("\nSELECT ALL PM: \n");
        for (PhieuMuonDTO data:ListPhieuMuon
        ) {
            System.out.println("\n" + data.getMapm());
            System.out.println("\n" + data.getMasach());
            System.out.println("\n" + data.getHoten());
            System.out.println("\n" + data.getMadg());
            System.out.println("\n" + data.getSoluong());
            System.out.println("\n" + data.getHantra());
            System.out.println("\n" + data.getMucphat());
            System.out.println("\n" + data.getNgaymuon());
            System.out.println("\n-----------------------------");
        }
        System.out.println("RECORD IN DATABASE: "+ListPhieuMuon.stream().count());
    }

    public void TestSelectByKey(String key) throws IOException {
        ArrayList<PhieuMuonDTO> ListPhieuMuon = new ArrayList<>();
        ListPhieuMuon = phieuMuonDAL.SelectByKeyWord(key);

        System.out.println("\nSELECT  PM BY KEY : "+ key + "\n");
        assert ListPhieuMuon != null;
        for (PhieuMuonDTO data:ListPhieuMuon
        ) {
            System.out.println("\n" + data.getMapm());
            System.out.println("\n" + data.getMasach());
            System.out.println("\n" + data.getHoten());
            System.out.println("\n" + data.getMadg());
            System.out.println("\n" + data.getSoluong());
            System.out.println("\n" + data.getHantra());
            System.out.println("\n" + data.getMucphat());
            System.out.println("\n" + data.getNgaymuon());
            System.out.println("\n-----------------------------");

        }
        System.out.println("RECORD IN DATABASE: "+ListPhieuMuon.stream().count());
    }

    public void TestSelectByKey_FullProperties(String key) throws IOException {
        ArrayList<PhieuMuonDTO> ListPhieuMuon = new ArrayList<>();
        ListPhieuMuon = phieuMuonDAL.SelectByKeyWord(key);

        System.out.println("\nSELECT PM BY KEY_FULL PROPERTIES : "+ key + "\n");
        assert ListPhieuMuon != null;
        for (PhieuMuonDTO data:ListPhieuMuon
        ) {
            System.out.println("\n" + data.getMapm());
            System.out.println("\n" + data.getMasach());
            System.out.println("\n" + data.getHoten());
            System.out.println("\n" + data.getMadg());
            System.out.println("\n" + data.getSoluong());
            System.out.println("\n" + data.getHantra());
            System.out.println("\n" + data.getMucphat());
            System.out.println("\n" + data.getNgaymuon());
            System.out.println("\n-----------------------------");
        }
        System.out.println("RECORD IN DATABASE: "+ListPhieuMuon.stream().count());
    }

    public void TestDeletePM(String MAPM) throws IOException, SQLException {
        ArrayList<PhieuMuonDTO> ListPhieuMuon = new ArrayList<>();
        PhieuMuonDTO phieuMuonDTO = new PhieuMuonDTO();
        phieuMuonDTO.setMasach(MAPM);
        boolean result = phieuMuonDAL.DeleteReceipt(String.valueOf(10),MAPM);


        if(result)
            System.out.println("DELETE PM CODE : "+phieuMuonDTO.getMasach() + " SUCCESS");
    }

    public TestPhieuMuonDAL() {
        phieuMuonDAL = new PhieuMuonDAL();
    }
}
