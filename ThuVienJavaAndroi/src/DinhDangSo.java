import java.text.DecimalFormat;

public class DinhDangSo {
    public static void main(String[] args) {
        double toan = 4;
        double ly = 8;
        double hoa = 4;
        
        double dTB = (toan+ly+hoa)/3;
        System.out.println("Diem trung binh la "+dTB);
        DecimalFormat dcm = new DecimalFormat("#.##");
        System.out.println("Diem trung binh la " + dcm.format(dTB));

    }
    
}
