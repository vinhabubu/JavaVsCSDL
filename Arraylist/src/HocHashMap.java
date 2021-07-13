import java.util.HashMap;

public class HocHashMap {
     public static void main(String[] args) {
        
    
    HashMap<Integer, String> ds3 = new HashMap<Integer, String>();
    ds3.put(001, "Vinh");
    ds3.put(002, "Vinh1");
    ds3.put(003, "Vinh2");
    ds3.put(004, "Vinh3");

    String nv = ds3.get(002);
    System.out.println(nv);
    System.out.println("Nhan vien cua cong ty la: ");

    for(String x: ds3.values()){
        //System.out.println("Nhan vien cua cong ty la: ");
        System.out.println(x);
    }

    System.out.println("So thanh vien trong cong ty: " + ds3.size());
    ds3.remove(002);
    System.out.println("So thanh vien trong cong ty: " + ds3.size());



     }
}
