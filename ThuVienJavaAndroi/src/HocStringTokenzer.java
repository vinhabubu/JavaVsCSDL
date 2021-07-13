import java.util.StringTokenizer;

public class HocStringTokenzer {
    public static void main(String[] args) { 
        String s = "hoc , hoc ,hoc nua ,....... . ,hoc mai";
        StringTokenizer token = new StringTokenizer(s);
        while(token.hasMoreTokens()){
            System.out.println(token.nextToken());
        }
        System.out.println("------------");
        StringTokenizer token2 = new StringTokenizer(s, ",");
        while(token2.hasMoreTokens()){
            System.out.println(token2.nextToken());
        }
        StringTokenizer token3 = new StringTokenizer(s, ", hoc");
        while(token3.hasMoreTokens()){
            System.out.println(token3.nextToken());
        }
    }

    
}
