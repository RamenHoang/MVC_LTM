package model.BEAN;

public class Wife {
	private String MaSV;
	private String Hoten;
	private String Gioitinh;
	private String Khoa;
	
	public Wife() {
		
	}
	
	public Wife(String MaSV, String Hoten, String Gioitinh, String Khoa) {
		this.MaSV = MaSV;
		this.Hoten = Hoten;
		this.Gioitinh = Gioitinh;
		this.Khoa = Khoa;
	}

	public String getMaSV() {
		return MaSV;
	}

	public void setMaSV(String maSV) {
		MaSV = maSV;
	}

	public String getHoten() {
		return Hoten;
	}

	public void setHoten(String hoten) {
		Hoten = hoten;
	}

	public String getGioitinh() {
		return Gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		Gioitinh = gioitinh;
	}

	public String getKhoa() {
		return Khoa;
	}

	public void setKhoa(String khoa) {
		Khoa = khoa;
	}
	
	
}
