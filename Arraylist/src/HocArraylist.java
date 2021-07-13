import java.util.ArrayList;

public class HocArraylist {

     private static ArrayList<Double> ds1;

    public static void main(String[] args) {
         ArrayList ds = new ArrayList() ;
         ds.add("An");
         ds.add("Binh");
         ds.add("Tuan");
         ds.add(2, "vvvvv");

         for(int i=0 ; i < ds.size() ; i++){
             String x = ds.get(i) + "" ;
             System.out.println(x);

         }

         System.out.println("####################");
         for(Object data: ds){
             System.out.println(data);
         }
         ArrayList<Double> ds1 = new ArrayList<Double>();
         for(int i=0; i < 10 ;i++){
             ds1.add(i*2.0);
            

         }
         for( double x: ds1){
             System.out.println(x);
         }

         ArrayList<Float> ds2 = new ArrayList<Float>();
         ds2.add(1.5f);
         ds2.add(1.6f);
         ds2.add(1.7f);
         ds2.add(1.8f);
         ds2.add(1.9f);
         System.out.println("So phan tu cua ds2 : " + ds2.size());
         ds2.add(1.9f);
         System.out.println("So phan tu cua ds2 : " + ds2.size());
         ds2.remove(3);
         System.out.println("So phan tu cua ds2 : " + ds2.size());
         for( float x: ds2){
            System.out.println(x);
        }
        System.out.println("--------------");
         ds2.set(2, 34.0f);
         for(float x: ds2){
             System.out.println(x);
         }



      

        }

    
    
}

