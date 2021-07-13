import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.ArrayList;

public class TextFileFactory {
   public static boolean luuFile(ArrayList<KhachHang>dsKH,String path){
       try 
       {
           FileOutputStream fos = new FileOutputStream(path);
           OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
           BufferedWriter bw = new BufferedWriter(osw);

           for(KhachHang kh: dsKH){
               String line = kh.getMa() +";"+kh.getTen();
               bw.write(line);
               bw.newLine();
           }

           bw.close();
           osw.close();
           fos.close();
           return true;
       } 
       catch (Exception ex) 
       {
           
           ex.printStackTrace();
       }
    return false;

   }
    
}
