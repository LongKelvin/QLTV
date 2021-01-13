package dto;

import java.time.*;

public class QuyDinhPhieuMuonDTO
{


	private String maqd;
	private int sosachtoida;
	private int songaymuontoida;
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
	public final int getSosachtoida()
	{
		return sosachtoida;
	}
	public final void setSosachtoida(int value)
	{
		sosachtoida = value;
	}
	public final int getSongaymuontoida()
	{
		return songaymuontoida;
	}
	public final void setSongaymuontoida(int value)
	{
		songaymuontoida = value;
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