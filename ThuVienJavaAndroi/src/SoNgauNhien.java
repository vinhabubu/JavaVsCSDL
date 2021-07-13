import java.util.Random;

public class SoNgauNhien {
    public static void main(String[] args) {
        int [] M = new int[5];
        Random rd = new Random();
        for(int i=0 ; i<M.length ; i++){
            M[i] = -50 + rd.nextInt(101);

            
        }
        System.out.println("Mang la ");
        for(int i=0 ; i<M.length ; i++){
            System.out.println(M[i]  + "\t");
        }
        
    }

   
}
