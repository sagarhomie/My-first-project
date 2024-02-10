import java.text.NumberFormat;

public class formatting {
    public static void main(String[] args){
         NumberFormat percent = NumberFormat.getPercentInstance();
         String result = percent.format(1234567.891);
         System.out.println(result);
    }
    
}
 