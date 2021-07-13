package topica.edu.vn.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;



import topica.edu.vn.io.SerializeFileFactory;
import topica.edu.vn.model.KhachHang;

public class TestKhachHang {
	static ArrayList<KhachHang>dsKh = new ArrayList<KhachHang>();
	public static void menu() {
		System.out.println("1.Nhap khach hang");
		System.out.println("2.Xuat khach hang");
		System.out.println("3.Tim kiem khach hang");
		System.out.println("4.Sap xep khach hang");
		System.out.println("5.Luu khach hang");
		System.out.println("6.Doc khach hang");
		System.out.println("7.Thong ke theo nha mang");
		System.out.println("8.Thoat");
		int chon = 0;
		System.out.println("Ban hay chon cac chuc nang tu 1 den 8");
		chon = new Scanner(System.in).nextInt();
		switch (chon) {
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

		
		}
	}

	private static void xuLyThoat() {
		// TODO Auto-generated method stub
		System.out.println("Cam on da dung phan mem");
		System.exit(0);
		
	}

	private static void xuLyThongKe() {
		// TODO Auto-generated method stub
		int n= 0;
		System.out.println("Vui long nhap vao dau so dien thoai ban muon thong ke");
		String phone = new Scanner(System.in).nextLine();
		for(KhachHang kh:dsKh) {
			if (kh.getPhone().startsWith(phone)) {
				n++;
			}
			
		}
		if ( phone == "098" ) {
			System.out.println("----------------------------------------");
			System.out.println("co "+n+" khach hang su dung mang Viettel co duoi la "+ phone);
			System.out.println("----------------------------------------");
		}
		else {
			System.out.println("----------------------------------------");
			System.out.println("co "+n+" khach hang su dung mang Vina duoi la " + phone);
			System.out.println("----------------------------------------");
		}
		
	}

	private static void xuLyDoc() {
		// TODO Auto-generated method stub
		dsKh = SerializeFileFactory.docFile("f:\\DuLieuKhachHang.txt");
		System.out.println("Doc file thanh cong");
		
	}

	private static void xuLyLuu() {
		// TODO Auto-generated method stub
		boolean kt = SerializeFileFactory.luuFile(dsKh, "f:\\DuLieuKhachHang.txt");
		if (kt == true) {
			System.out.println("Da luu file thanh cong");
			
		}
		else {
			System.out.println("Luu file that bai");
		}
	}

	private static void xuLySapXep() {
		// TODO Auto-generated method stub
		Collections.sort(dsKh);
		System.out.println("Da sap xep so dien thoai thanh cong");
	}

	private static void xuLyTim() {
		// TODO Auto-generated method stub
		System.out.println("Vui long nhap vao dau so dien thoai ban muon tim");
		String phone = new Scanner(System.in).nextLine();
		System.out.println("Danh sach khach hang ban muon tim  la ");
		System.out.println("------------------------------------");
		for(KhachHang kh:dsKh) {
			if (kh.getPhone().startsWith(phone)) {
				System.out.println(kh);
				
			}
		}
		System.out.println("------------------------------------");
	}

	private static void xuLyXuat() {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------------------");
		for(KhachHang kh:dsKh) {
			System.out.println(kh);
		}
		System.out.println("-----------------------------------------1");
	}

	private static void xuLyNhap() {
		// TODO Auto-generated method stub
		KhachHang kh = new KhachHang();
		System.out.println("Vui long nhap ma khach hang: ");
		int ma = new Scanner(System.in).nextInt();
		System.out.println("Vui long nhap ten khach hang: ");
		String ten = new Scanner(System.in).nextLine();
		System.out.println("Vui long nhap so dien thoai: ");
		String phone = new Scanner(System.in).nextLine();
		
		kh.setMa(ma);
		kh.setTen(ten);
		kh.setPhone(phone);
		dsKh.add(kh);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			menu();
			
		}
	}

}
