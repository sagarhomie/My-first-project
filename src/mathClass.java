public class mathClass {
    public static void main(String[] args){
        int result = Math.round(1.1F);//does round off
        int r = (int)Math.ceil(1.1F);//returns ceiling number
        int s = (int) Math.floor(1.1F);//returns floor number
        int max = Math.max(1,2);//returns max number
        int min = Math.min(1,2);//returns min number
        double rand = Math.random();//returns random number
        double rand2=Math.round(Math.random()*100);//returns random number between 1 t0 100
        System.out.println(result);
        System.out.println(r);
        System.out.println(s);
        System.out.println(max);
        System.out.println(min);
        System.out.println(rand);
        System.out.println(rand2);
    }
    
}
