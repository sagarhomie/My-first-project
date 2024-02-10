import java.util.Scanner;

public class s {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter todays day");
        int date = input.nextInt();
        switch (date) {
            case 1:
            System.out.println("today is sunday");
                
                break;
            case 2:
            System.out.println("today is monday");
            break;
        
            default:
            System.out.println("wrong day2");
                break;
        }
    }
}
