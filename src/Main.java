import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(calc(in.nextLine()));
    }

    public static String calc(String input){
        String result;
        Calc c = new Calc();

        if(input.length()>3){
                throw new IllegalStateException();
        }

        String[] aa = input.split(" ");

        try {
            c.a = Integer.parseInt(aa[0]);
            c.arabic1 = true;
        } catch (NumberFormatException e) {
            c.arabic1 = false;
            switch (aa[0]){
                case "I" -> c.a = 1;
                case "II" -> c.a = 2;
                case "III" -> c.a = 3;
                case "IV" -> c.a = 4;
                case "V" -> c.a = 5;
                case "VI" -> c.a = 6;
                case "VII" -> c.a = 7;
                case "VIII" -> c.a = 8;
                case "IX" -> c.a = 9;
                case "X" -> c.a = 10;
                default -> throw e;
            }
        }
        try{
            c.b = Integer.parseInt(aa[2]);
            c.arabic2 = true;
        } catch (NumberFormatException e) {
            c.arabic2 = false;
            switch (aa[2]){
                case "I" -> c.b = 1;
                case "II" -> c.b = 2;
                case "III" -> c.b = 3;
                case "IV" -> c.b = 4;
                case "V" -> c.b = 5;
                case "VI" -> c.b = 6;
                case "VII" -> c.b = 7;
                case "VIII" -> c.b = 8;
                case "IX" -> c.b = 9;
                case "X" -> c.b = 10;
                default -> throw e;
            }
        }
        if (c.arabic1^c.arabic2){
            try {
                throw new Exception();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        c.operation = aa[1];
        if (c.a > 0 & c.a <= 10 & c.b > 0 & c.b <= 10) {
            switch (c.operation) {
                case "+" -> {
                    if (c.arabic1 & c.arabic2) {
                        result = Integer.toString(c.sum());
                    } else {
                        result = convert(c.sum());
                    }
                    ;
                }
                case "-" -> {
                        if (c.arabic1 & c.arabic2) {
                            result = Integer.toString(c.deduct());
                        } else {
                            result = convert(c.deduct());
                        }
                        ;
                    }
                case "/" -> {
                        if (c.arabic1 & c.arabic2) {
                            result = Integer.toString(c.division());
                        } else {
                            result = convert(c.division());
                        }
                        ;
                    }
                case "*" -> {
                        if (c.arabic1 & c.arabic2) {
                            result = Integer.toString(c.mult());
                        } else {
                            result = convert(c.mult());
                        }
                        ;
                    }
                default -> throw new IllegalStateException("Unexpected value: " + c.operation);
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

    static class Calc{
        int a;
        int b;
        String operation;
        boolean arabic1;
        boolean arabic2;

        int sum(){
            int result = a + b;
            return result;
        }
        int deduct(){
            int result = a - b;
            return result;
        }
        int mult(){
            int result = a * b;
            return result;
        }
        int division(){
            int result = a / b;
            return result;
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
        number /= 10;

        String result = romanThousands + romanHundreds + romanTens + romanOnes;
        return result;
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
