package topica.edu.vn.model;

import java.io.Serializable;

public class KhachHang implements Serializable,Comparable<KhachHang>{
	private int ma;
	private String ten;
	private String phone;
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public KhachHang(int ma, String ten, String phone) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.phone = phone;
	}
	public KhachHang() {
		super();
	}
	public String toString() {
		return this.ma+"\t"+this.ten+"\t"+this.phone;
	}
	public int compareTo(KhachHang o) {
		return this.phone.compareToIgnoreCase(o.phone);
	}

}
