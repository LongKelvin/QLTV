package utils;

import dal.*;
import dto.PhieuMuonDTO;
import dto.PhieuTraDTO;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

public class TestPhieuTraDAL {
    PhieuTraDAL phieuTraDAL;

    public TestPhieuTraDAL() {
        phieuTraDAL = new PhieuTraDAL();
    }

    public void TestCreatePTr() throws IOException {
        PhieuTraDTO phieuTraDTO = new PhieuTraDTO();
        phieuTraDTO.setMapm("8");
        phieuTraDTO.setMasach("30");
        phieuTraDTO.setMadg("5");
        phieuTraDTO.setTienphat(15000);


        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        LocalDate date = dateTime.toLocalDate();

        phieuTraDTO.setNgaytra(dateTime);

        phieuTraDAL.CreateReturnReceipt(phieuTraDTO);

        System.out.println("\nCREATE Return Receipt: \n");

        System.out.println("\n" + phieuTraDTO.getMapm());
        System.out.println("\n" + phieuTraDTO.getMasach());
        System.out.println("\n" + phieuTraDTO.getMadg());


        System.out.println("\n-----------------------------");

    }
}
