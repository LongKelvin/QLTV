package dto;

import java.time.*;

public class QuyDinhSachDTO
{
	private String maqd;
	private int thoihansach;
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
	public final int getThoihansach()
	{
		return thoihansach;
	}
	public final void setThoihansach(int value)
	{
		thoihansach = value;
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
}