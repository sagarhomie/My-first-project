import java.lang.reflect.Array;
import java.util.Arrays;//to print array correctly 

public class array2 {
    public static void main(String[] args){
        int[] numbers = {2,1,4,5,6,7};
        System.out.println(Arrays.toString(numbers));
        System.out.println(numbers.length);
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

    }
    
}
