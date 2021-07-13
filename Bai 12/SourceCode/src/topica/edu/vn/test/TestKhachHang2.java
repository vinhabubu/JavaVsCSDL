package topica.edu.vn.test;

import java.util.ArrayList;

import topica.edu.vn.io.SerializeFileFactory;
import topica.edu.vn.io.TextFileFactory;
import topica.edu.vn.model.KhachHang;

public class TestKhachHang2 {

	public static void testLuuFile()
	{
		ArrayList<KhachHang>dsKH=new ArrayList<KhachHang>();
		dsKH.add(new KhachHang("KH01", "Nguyễn Thị An"));
		dsKH.add(new KhachHang("KH02", "Trần Văn Bình"));
		dsKH.add(new KhachHang("KH03", "Hồ Thị Giải"));
		dsKH.add(new KhachHang("KH04", "Hoàng Ngọc Thoát"));
		
		boolean kt=SerializeFileFactory.luuFile(dsKH, "f:\\dulieu2.txt");
		if(kt==true)
		{
			System.out.println("Đã lưu file thành công");
		}
		else
		{
			System.out.println("Lưu file thất bại");
		}
	}
	public static void main(String[] args) {
		//testLuuFile();
		ArrayList<KhachHang>dsKH=SerializeFileFactory.docFile("f:\\dulieu2.txt");
		
		System.out.println("Danh sách khách hàng nạp vào máy tính là:");
		System.out.println("Mã\tTên");
		for(KhachHang kh:dsKH)
		{
			System.out.println(kh);
		}
	 }

}
