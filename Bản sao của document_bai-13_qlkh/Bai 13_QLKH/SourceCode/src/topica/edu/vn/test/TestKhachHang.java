package topica.edu.vn.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import topica.edu.vn.io.SerializeFileFactory;
import topica.edu.vn.model.KhachHang;

public class TestKhachHang {

	static ArrayList<KhachHang>dsKH=new ArrayList<KhachHang>();
	
	public static void menu()
	{
		System.out.println("1.Nhập khách hàng");
		System.out.println("2.Xuất khách hàng");
		System.out.println("3.Tìm kiếm khách hàng");
		System.out.println("4.Sắp xếp khách hàng");
		System.out.println("5.Lưu khách hàng");
		System.out.println("6.Đọc khách hàng");
		System.out.println("7.Thống kế theo nhà mạng");
		System.out.println("8.Thoát");
		int chon=0;
		System.out.println("Bạn chọn chức năng[1..8]:");
		chon=new Scanner(System.in).nextInt();
		switch(chon)
		{
		case 1:
			xuLyNhap();
			break;
		case 2:
			xuLyXuat();
			break;
		case 3:
			xuLyTim();
			break;
		case 4:
			xuLySapXep();
			break;
		case 5:
			xuLyLuu();
			break;
		case 6:
			xuLyDoc();
			break;
		case 7:
			xuLyThongKe();
			break;
		case 8:
			xuLyThoat();
			break;
		default:
			
				break;
		}
	}
	
	private static void xuLyThoat() {
		System.out.println("Cám ơn bạn đã dùng phần mềm! bye bye");
		System.exit(0);
	}

	private static void xuLyThongKe() {
		int n=0;
		for(KhachHang kh: dsKH)
		{
			if(kh.getPhone().startsWith("098"))
			{
				n++;
			}
		}
		System.out.println("Có "+n+" khách hàng Viettel");
	}

	private static void xuLyDoc() {
		dsKH=SerializeFileFactory.docFile("f:\\dulieukhachhang.db");
		System.out.println("Đã đọc file thành công");
	}

	private static void xuLyLuu() {
		boolean kt=SerializeFileFactory.luuFile(dsKH, "f:\\dulieukhachhang.db");
		if(kt==true)
		{
			System.out.println("Đã lưu file thành công");
		}
		else
		{
			System.out.println("Đã lưu file thất bại");
		}
	}

	private static void xuLySapXep() {
		Collections.sort(dsKH);
		System.out.println("Đã sắp xếp số điện thoại xong rồi");
	}

	private static void xuLyTim() {
		String phone="090";
		System.out.println("===============================");
		System.out.println("Khách hàng có đầu số 090:");
		System.out.println("Mã\tTên\tPhone");
		for(KhachHang kh: dsKH)
		{
			if(kh.getPhone().startsWith(phone))
			{
				System.out.println(kh);
			}
		}
		System.out.println("===============================");
	}

	private static void xuLyXuat() {
		System.out.println("================================");
		System.out.println("Mã\tTên\tPhone");
		for(KhachHang kh:dsKH)
		{
			System.out.println(kh);
		}
		System.out.println("================================");
	}

	private static void xuLyNhap() {
		KhachHang kh=new KhachHang();
		System.out.println("Mời bạn nhập mã:");
		int ma=new Scanner(System.in).nextInt();
		System.out.println("Mời bạn nhập tên:");
		String ten=new Scanner(System.in).nextLine();
		System.out.println("Mời bạn nhập số phone:");
		String phone=new Scanner(System.in).nextLine();
		
		kh.setMa(ma);
		kh.setTen(ten);
		kh.setPhone(phone);
		
		dsKH.add(kh);
	}

	public static void main(String[] args) {
		while(true)
		{
			menu();
		}
	}

}
