import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(calc(in.nextLine()));
    }
    public static String calc(String input){
        Calc c = new Calc();

        String[] aa = input.split(" ");
        if(aa.length  > 3){
            throw new IllegalStateException();
        }
        if(aa.length == 1){
            for (char v : input.toCharArray()
                 ) {
                if(v == '+'){
                    c.operation = String.valueOf(v);
                }
                if(v == '-'){
                    c.operation = String.valueOf(v);
                }
                if(v == '*'){
                    c.operation = String.valueOf(v);
                }
                if(v == '/'){
                    c.operation = String.valueOf(v);
                }
            }
           aa = input.split("[+\\-*/]");
            return c.calculation(aa[0],aa[1],c.operation);
        }
        if(aa.length == 2){
            for (char v : input.toCharArray()
            ) {
                if(v == '+'){
                    c.operation = String.valueOf(v);
                }
                if(v == '-'){
                    c.operation = String.valueOf(v);
                }
                if(v == '*'){
                    c.operation = String.valueOf(v);
                }
                if(v == '/'){
                    c.operation = String.valueOf(v);
                }
            }
            aa = input.split("[+\\-*/]");
            return c.calculation(aa[0],aa[1],c.operation);
        }
        return c.calculation(aa[0], aa[2],aa[1]);

    }
}
