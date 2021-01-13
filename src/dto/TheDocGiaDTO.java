package dto;

import java.time.*;

public class TheDocGiaDTO
{
	private String madg;
	private String maloaidg;
	private String hoten;
	private LocalDateTime ngaysinh = LocalDateTime.MIN;
	private String diachi;
	private String email;
	private LocalDateTime ngaylapthe = LocalDateTime.MIN;
	private LocalDateTime ngayhethan = LocalDateTime.MIN;
	private int sosachdangmuon;
	private double tongtienno;
	private int luotmuon;

	public final String getMadg()
	{
		return madg;
	}
	public final void setMadg(String value)
	{
		madg = value;
	}
	public final String getHoten()
	{
		return hoten;
	}
	public final void setHoten(String value)
	{
		hoten = value;
	}
	public final LocalDateTime getNgaysinh()
	{
		return ngaysinh;
	}
	public final void setNgaysinh(LocalDateTime value)
	{
		ngaysinh = value;
	}
	public final String getDiachi()
	{
		return diachi;
	}
	public final void setDiachi(String value)
	{
		diachi = value;
	}
	public final String getEmail()
	{
		return email;
	}
	public final void setEmail(String value)
	{
		email = value;
	}
	public final LocalDateTime getNgaylapthe()
	{
		return ngaylapthe;
	}
	public final void setNgaylapthe(LocalDateTime value)
	{
		ngaylapthe = value;
	}
	public final LocalDateTime getNgayhethan()
	{
		return ngayhethan;
	}
	public final void setNgayhethan(LocalDateTime value)
	{
		ngayhethan = value;
	}
	public final int getSosachdangmuon()
	{
		return sosachdangmuon;
	}
	public final void setSosachdangmuon(int value)
	{
		sosachdangmuon = value;
	}
	public final double getTongtienno()
	{
		return tongtienno;
	}
	public final void setTongtienno(double value)
	{
		tongtienno = value;
	}
	public final String getMaloaidg()
	{
		return maloaidg;
	}
	public final void setMaloaidg(String value)
	{
		maloaidg = value;
	}
	public final int getLuotmuon()
	{
		return luotmuon;
	}
	public final void setLuotmuon(int value)
	{
		luotmuon = value;
	}
}