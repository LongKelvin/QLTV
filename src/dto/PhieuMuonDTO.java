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



	public final boolean IsOverdue()
	{
		return (LocalDateTime.now().compareTo(getHantra()) <= 0);
	}

	public final LocalDateTime CalDueDate(QuyDinhPhieuMuonDTO rule)
	{
		return getNgaymuon().plusDays(rule.getSongaymuontoida());
	}

}