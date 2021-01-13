package dto;

public class TheLoaiSachDTO
{
	private String matheloai;
	private String tentheloai;

	public final String getMatheloai()
	{
		return matheloai;
	}
	public final void setMatheloai(String value)
	{
		matheloai = value;
	}
	public final String getTentheloai()
	{
		return tentheloai;
	}
	public final void setTentheloai(String value)
	{
		tentheloai = value;
	}

//	public final void NewCategory(DataRow temp)
//	{
//		setMatheloai(temp.get(0).toString());
//		setTentheloai(temp.get(1).toString());
//	}
}