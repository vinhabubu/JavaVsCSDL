import java.util.ArrayList;
public class TestKhachHang {

    public  static void testLuuFile() {

    
    
        ArrayList<KhachHang>dsKH = new ArrayList<KhachHang>();
        dsKH.add(new KhachHang("001", "Nguyen Vinh"));
        dsKH.add(new KhachHang("004", "Nguyen Khanh1 "));
        dsKH.add(new KhachHang("005", "Nguyen Khanh2"));
        dsKH.add(new KhachHang("003", "Nguyen Khanh3"));
        dsKH.add(new KhachHang("002", "Nguyen Khanh4"));
        dsKH.add(new KhachHang("006", "Nguyen Khanh5"));
        
       boolean kt = TextFileFactory.luuFile(dsKH,"f:\\dulieu23.txt");
        if (kt== true) {
            System.out.println("Luu file thanh cong");
            
        }
        else{
            System.out.println("Luu file that bai");
        }

    }
    

    public static void main(String[] args) {
        //testLuuFile();
        ArrayList<KhachHang>dsKH = TextFileFactory.docFile("f:\\dulieu23.txt");
        System.out.println("Danh sach khach hang nap vao may tinh la");
        System.out.println("Ma\t Ten");
        for(KhachHang kh:dsKH){
            
                System.out.println(kh);
            
            
        }
        
    }
    
}
