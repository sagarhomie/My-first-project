public class Typecasting {
    public static void main(String args []){
        int myInt = 9;
        double myDouble = myInt;//automatically casting:int to double
        System.out.println(myInt);//output 9
        System.out.println(myDouble);//output 9.0
        double mysDouble=9.66D;
        int mysInt= (int)mysDouble;//mannual casting:double into int
        System.out.println(mysDouble);//output 9.66
        System.out.println(mysInt);//output 9
    }
    
}
