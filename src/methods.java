public class methods {
    public static void main(String[] args){
        String message = "    Sagar Shrestha   ";
        
        System.out.println(message.endsWith("Shrestha"));//check whether message ends with shrestha
        System.out.println(message.startsWith("Sagar"));//check whether message starts with sagar
        System.out.println(message.length());//gives length of string
        System.out.println(message.indexOf("S"));//checks index of s
        System.out.println(message.indexOf("hello"));
        System.out.println(message.replace("a","@")); //replace a with @
        System.out.println(message);
        System.out.println(message.toLowerCase());
        System.out.println(message.trim());//removes spaces
    }
    
}
