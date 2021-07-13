import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.spi.CalendarDataProvider;
import java.util.spi.CalendarNameProvider;

public class HocXuLyNgayThang {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        int nam = cal.get(Calendar.YEAR) ;
        System.out.println("Nam hien tai la " +nam);
        int thang = cal.get(Calendar.MONTH) + 1;
        int ngay = cal.get(Calendar.DATE);
        System.out.println("Date: " + ngay + "/" + thang + "/" + nam);
            
        
        Date t = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss aaa");
        System.out.println("---------");
        System.out.println("Hom nay la " + sdf.format(t));
    }
    
}
