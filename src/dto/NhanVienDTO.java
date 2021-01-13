package dto;

import java.time.*;

public class NhanVienDTO
{
	private String strMaNhanVien;
	private String strHoTen;
	private LocalDateTime dtNgaySinh = LocalDateTime.MIN;
	private String strMaChucVu;
	private LocalDateTime dtNgayVaoLam = LocalDateTime.MIN;
	private String strEmail;
	private String strDiaChi;
	private String strSoDT;
	private double flLuong;
	private float flTienPhat;

	public final String getStrMaNhanVien()
	{
		return strMaNhanVien;
	}
	public final void setStrMaNhanVien(String value)
	{
		strMaNhanVien = value;
	}
	public final String getStrHoTen()
	{
		return strHoTen;
	}
	public final void setStrHoTen(String value)
	{
		strHoTen = value;
	}
	public final LocalDateTime getDtNgaySinh()
	{
		return dtNgaySinh;
	}
	public final void setDtNgaySinh(LocalDateTime value)
	{
		dtNgaySinh = value;
	}
	public final String getStrMaChucVu()
	{
		return strMaChucVu;
	}
	public final void setStrMaChucVu(String value)
	{
		strMaChucVu = value;
	}
	public final LocalDateTime getDtNgayVaoLam()
	{
		return dtNgayVaoLam;
	}
	public final void setDtNgayVaoLam(LocalDateTime value)
	{
		dtNgayVaoLam = value;
	}
	public final String getStrEmail()
	{
		return strEmail;
	}
	public final void setStrEmail(String value)
	{
		strEmail = value;
	}
	public final String getStrDiaChi()
	{
		return strDiaChi;
	}
	public final void setStrDiaChi(String value)
	{
		strDiaChi = value;
	}
	public final String getStrSoDT()
	{
		return strSoDT;
	}
	public final void setStrSoDT(String value)
	{
		strSoDT = value;
	}
	public final double getFlLuong()
	{
		return flLuong;
	}
	public final void setFlLuong(double value)
	{
		flLuong = value;
	}
	public final float getFlTienPhat()
	{
		return flTienPhat;
	}
	public final void setFlTienPhat(float value)
	{
		flTienPhat = value;
	}
}