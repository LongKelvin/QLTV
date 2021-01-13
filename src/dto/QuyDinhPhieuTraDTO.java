package dto;

import java.time.*;

public class QuyDinhPhieuTraDTO
{
	private String maqd;
	private int tienphat;
	private LocalDateTime ngayra = LocalDateTime.MIN;
	private LocalDateTime ngayketthuc = LocalDateTime.MIN;

	public final String getMaqd()
	{
		return maqd;
	}
	public final void setMaqd(String value)
	{
		maqd = value;
	}
	public final LocalDateTime getNgayra()
	{
		return ngayra;
	}
	public final void setNgayra(LocalDateTime value)
	{
		ngayra = value;
	}
	public final LocalDateTime getNgayketthuc()
	{
		return ngayketthuc;
	}
	public final void setNgayketthuc(LocalDateTime value)
	{
		ngayketthuc = value;
	}
	public final int getTienphat()
	{
		return tienphat;
	}
	public final void setTienphat(int value)
	{
		tienphat = value;
	}
}