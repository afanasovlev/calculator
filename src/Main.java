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
    static class Calc{
        int a;
        int b;
        String operation;
        boolean arabic1;
        boolean arabic2;

        String calculation(String one, String two, String op){
            String result;
            try {
                a = Integer.parseInt(one.trim());
                arabic1 = true;
            } catch (NumberFormatException e) {
                arabic1 = false;
                switch (one){
                    case "I" -> a = 1;
                    case "II" -> a = 2;
                    case "III" -> a = 3;
                    case "IV" -> a = 4;
                    case "V" -> a = 5;
                    case "VI" -> a = 6;
                    case "VII" -> a = 7;
                    case "VIII" -> a = 8;
                    case "IX" -> a = 9;
                    case "X" -> a = 10;
                    default -> throw e;
                }
            }
            try{
                b = Integer.parseInt(two.trim());
                arabic2 = true;
            } catch (NumberFormatException e) {
                arabic2 = false;
                switch (two){
                    case "I" -> b = 1;
                    case "II" -> b = 2;
                    case "III" -> b = 3;
                    case "IV" ->b = 4;
                    case "V" ->b = 5;
                    case "VI" -> b = 6;
                    case "VII" -> b = 7;
                    case "VIII" -> b = 8;
                    case "IX" -> b = 9;
                    case "X" -> b = 10;
                    default -> throw e;
                }
            }
            if (arabic1^arabic2){
                try {
                    throw new Exception();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            operation = op;
            if (a > 0 & a <= 10 & b > 0 & b <= 10) {
                switch (operation) {
                    case "+" -> {
                        if (arabic1 & arabic2) {
                            result = Integer.toString(sum());
                        } else {
                            result = convert(sum());
                        }
                    }
                    case "-" -> {
                        if (arabic1 & arabic2) {
                            result = Integer.toString(deduct());
                        } else {
                            result = convert(deduct());
                        }
                    }
                    case "/" -> {
                        if (arabic1 & arabic2) {
                            result = Integer.toString(division());
                        } else {
                            result = convert(division());
                        }
                    }
                    case "*" -> {
                        if (arabic1 & arabic2) {
                            result = Integer.toString(multiplication());
                        } else {
                            result = convert(multiplication());
                        }
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + operation);
                }
            } else {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    throw new IllegalStateException();
                }
            }
            return result;
        }
        int sum(){
            return a + b;
        }
        int deduct(){
            return a - b;
        }
        int multiplication(){
            return a * b;
        }
        int division(){
            return a / b;
        }


    }
    public static String convert(int number) {
        if (number < 0 || number > 3999) {
            return "This number cannot be converted";
        }

        String romanOnes = romanDigit(number % 10, "I", "V", "X");
        number /= 10;

        String romanTens = romanDigit(number % 10, "X", "L", "C");
        number /= 10;

        String romanHundreds = romanDigit(number % 10, "C", "D", "M");
        number /= 10;

        String romanThousands = romanDigit(number % 10, "M", "", "");

        return romanThousands + romanHundreds + romanTens + romanOnes;
    }
    public static String romanDigit(int n, String one, String five, String ten){

        if(n >= 1)
        {
            if(n == 1)
            {
                return one;
            }
            else if (n == 2)
            {
                return one + one;
            }
            else if (n == 3)
            {
                return one + one + one;
            }
            else if (n==4)
            {
                return one + five;
            }
            else if (n == 5)
            {
                return five;
            }
            else if (n == 6)
            {
                return five + one;
            }
            else if (n == 7)
            {
                return five + one + one;
            }
            else if (n == 8)
            {
                return five + one + one + one;
            }
            else if (n == 9)
            {
                return one + ten;
            }

        }
        return "";
    }
}
