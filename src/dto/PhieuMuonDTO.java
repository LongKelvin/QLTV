package dto;

import java.time.*;
import java.math.*;

public class PhieuMuonDTO
{
	private String mapm;
   // string hoten;
	private LocalDateTime ngaymuon = LocalDateTime.MIN;
	private LocalDateTime hantra = LocalDateTime.MIN;
	private String masach;
	private String madg;
	private int soluong;
	private BigDecimal mucphat = new BigDecimal(0);
	private String hoten;

	public final String getMapm()
	{
		return mapm;
	}
	public final void setMapm(String value)
	{
		mapm = value;
	}
	public final String getMasach()
	{
		return masach;
	}
	public final void setMasach(String value)
	{
		masach = value;
	}
	public final String getMadg()
	{
		return madg;
	}
	public final void setMadg(String value)
	{
		madg = value;
	}
	public final LocalDateTime getNgaymuon()
	{
		return ngaymuon;
	}
	public final void setNgaymuon(LocalDateTime value)
	{
		ngaymuon = value;
	}
	public final LocalDateTime getHantra()
	{
		return hantra;
	}
	public final void setHantra(LocalDateTime value)
	{
		hantra = value;
	}
   // public string Hoten { get => hoten; set => hoten = value; }
	public final int getSoluong()
	{
		return soluong;
	}
	public final void setSoluong(int value)
	{
		soluong = value;
	}
	public final BigDecimal getMucphat()
	{
		return mucphat;
	}
	public final void setMucphat(BigDecimal value)
	{
		mucphat = value;
	}
	public final String getHoten()
	{
		return hoten;
	}
	public final void setHoten(String value)
	{
		hoten = value;
	}

	public PhieuMuonDTO()
	{
	}


//	public PhieuMuonDTO(String mapm1, String masach1, String madg1, java.time.LocalDateTime ngaymuon1, java.time.LocalDateTime hantra1, String hoten1)
//	{
//		this(mapm1, masach1, madg1, ngaymuon1, hantra1, hoten1, 0);
//	}

//	public PhieuMuonDTO(String mapm1, String masach1, String madg1, java.time.LocalDateTime ngaymuon1, java.time.LocalDateTime hantra1)
//	{
//		this(mapm1, masach1, madg1, ngaymuon1, hantra1, "", 0);
//	}

//C# TO JAVA CONVERTER NOTE: Java does not support optional parameters. Overloaded method(s) are created above:
//ORIGINAL LINE: public PhieuMuonDTO(string mapm1, string masach1, string madg1, DateTime ngaymuon1, DateTime hantra1, string hoten1 = "", decimal mucphat1 = 0)
	public PhieuMuonDTO(String mapm1, String masach1, String madg1, LocalDateTime ngaymuon1, LocalDateTime hantra1, String hoten1, BigDecimal mucphat1)
	{
		setMapm(mapm1);
		setMasach(masach1);
		setMadg(madg1);
		setNgaymuon(ngaymuon1);
		setHantra(hantra1);
		setHoten(hoten1);
		setMucphat(mucphat1);
	}

	public final String GetProperty(String property)
	{
		String ans = "";

		if (property.equals("Tên đọc giả"))
		{
		   // ans = Hoten;
		}
		if (property.equals("Mã phiếu mượn"))
		{
			ans = getMapm();
		}

		return ans;
	}

//	public PhieuMuonDTO(DataRow row)
//	{
//		setMapm(row.get(0).toString());
//		setMasach(row.get(1).toString());
//		setMadg(row.get(2).toString());
//		setNgaymuon(LocalDateTime.parse(row.get(3).toString()));
//		setHantra(LocalDateTime.parse(row.get(4).toString()));
//		setHoten(row.get(5).toString());
//		setSoluong(Integer.parseInt(row.get(6).toString()));
//		String tmp = row.get(7).toString();
//		setMucphat(BigDecimal.Parse(tmp));
//
//	}
//
//	public final void NewReceipt(DataRow row)
//	{
//		setMapm(row.get(0).toString());
//		setMasach(row.get(1).toString());
//		setMadg(row.get(2).toString());
//		setNgaymuon(LocalDateTime.parse(row.get(3).toString()));
//		setHantra(LocalDateTime.parse(row.get(4).toString()));
//		setSoluong(Integer.parseInt(row.get(5).toString()));
//	}

	public final boolean IsOverdue()
	{
		return (LocalDateTime.now().compareTo(getHantra()) <= 0);
	}

	public final LocalDateTime CalDueDate(QuyDinhPhieuMuonDTO rule)
	{
		return getNgaymuon().plusDays(rule.getSongaymuontoida());
	}

}