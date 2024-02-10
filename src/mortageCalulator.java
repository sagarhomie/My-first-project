import java.text.NumberFormat;
import java.util.Scanner;

public class mortageCalulator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Principal:");
        int principal = scanner.nextInt();
        
        System.out.println("Annual Interest Rate:");
        double Interest = scanner.nextDouble();
        
        System.out.println("Period(years):");
        int period = scanner.nextInt();
        double Mortage;
        Mortage=(double)((principal*Interest*period))/100;
        NumberFormat mortageFormatted=NumberFormat.getCurrencyInstance();
        String morttt=mortageFormatted.format(Mortage);
        System.out.println("Mortage:"+mortageFormatted);

        
    }
    
}
