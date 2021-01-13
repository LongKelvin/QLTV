package dto;

import java.time.*;

public class PhieuTraDTO
{
	private String mapm;
	private String masach;
	private String madg;
	private LocalDateTime ngaytra = LocalDateTime.MIN;
	private int tienphat;

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
	public final LocalDateTime getNgaytra()
	{
		return ngaytra;
	}
	public final void setNgaytra(LocalDateTime value)
	{
		ngaytra = value;
	}
	public final int getTienphat()
	{
		return tienphat;
	}
	public final void setTienphat(int value)
	{
		tienphat = value;
	}

	public PhieuTraDTO()
	{
	}

	public PhieuTraDTO(String mapm1, String masach1, String madg1, LocalDateTime ngaytra1, int tienphat1)
	{
		setMapm(mapm1);
		setMasach(masach1);
		setMadg(madg1);
		setNgaytra(ngaytra1);
		setTienphat(tienphat1);
	}

//	public final void NewReturnReceipt(DataRow row)
//	{
//		setMapm(row.get(0).toString());
//		setMasach(row.get(1).toString());
//		setMadg(row.get(2).toString());
//		setNgaytra(LocalDateTime.parse(row.get(3).toString()));
//		setTienphat(Integer.parseInt(row.get(4).toString()));
//	}
//
//	public final int CalLibraryFine(int coefficient)
//	{
//		return coefficient * Integer.parseInt((LocalDateTime.now().toLocalDate() - getNgaytra().toLocalDate()).TotalDays.toString());
//	}
}