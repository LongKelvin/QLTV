package dto;

import java.time.*;

public class SachDTO
{
	private String masach;
	private String tensach;
	private String tacgia;
	private String theloai;
	private String nxb;
	private int namxb;
	private LocalDateTime ngaynhap = LocalDateTime.MIN;
	private int dongia;
	private int soluong;
	private int luotmuon;

	public final String getTensach()
	{
		return tensach;
	}
	public final void setTensach(String value)
	{
		tensach = value;
	}
	public final String getTacgia()
	{
		return tacgia;
	}
	public final void setTacgia(String value)
	{
		tacgia = value;
	}
	public final String getTheloai()
	{
		return theloai;
	}
	public final void setTheloai(String value)
	{
		theloai = value;
	}
	public final String getNxb()
	{
		return nxb;
	}
	public final void setNxb(String value)
	{
		nxb = value;
	}
	public final int getNamxb()
	{
		return namxb;
	}
	public final void setNamxb(int value)
	{
		namxb = value;
	}
	public final LocalDateTime getNgaynhap()
	{
		return ngaynhap;
	}
	public final void setNgaynhap(LocalDateTime value)
	{
		ngaynhap = value;
	}
	public final int getDongia()
	{
		return dongia;
	}
	public final void setDongia(int value)
	{
		dongia = value;
	}
	public final int getSoluong()
	{
		return soluong;
	}
	public final void setSoluong(int value)
	{
		soluong = value;
	}
	public final int getLuotmuon()
	{
		return luotmuon;
	}
	public final void setLuotmuon(int value)
	{
		luotmuon = value;
	}
	public final String getMasach()
	{
		return masach;
	}
	public final void setMasach(String value)
	{
		masach = value;
	}


	public final boolean IsValid()
	{
		int current_year = LocalDateTime.now().getYear();

		return ((current_year - namxb) <= 8);
	}
}