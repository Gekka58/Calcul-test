import java.util.Scanner;

public class Main {


    private int value1;
    private int value2;
    private String input;
    private String result;
    private char operacion;
    private int rez;
    static String[] Rome = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
            "IX", "V", "IV", "I" };
    static int[] Arab = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.console();

    }

    public String calc(String inputString) throws Exception {
        char[] chars = new char[20];
        for (int i = 0; i < inputString.length(); i++) {
            chars[i] = inputString.charAt(i);
            if (chars[i] == '+') {
                operacion = chars[i];

            } if (chars[i] == '-'){
                operacion = chars[i];


            } if (chars[i] == '*'){
                operacion = chars[i];


            }if  (chars[i] == '/'){
                operacion = chars[i];


            }
        }
        String[] str = inputString.split("[+*/-]");
        if (str.length == 2){
            String values1 = str[0].trim().toUpperCase();
            String values2 = str[1].trim().toUpperCase();

            if (ifOperandArabian(values1) && ifOperandArabian(values2)) {
                value1 = stringToInt(values1);
                value2 = stringToInt(values2);
                calculacions(value1,value2);
                result = intToString(rez);
                print(result);

            }else if (ifOperandRoman(values1) && ifOperandRoman(values2)){
                value1 = rometoArab(values1);
                value2 = rometoArab(values2);
                calculacions(value1,value2);
                if (rez>0) {
                    result = convertNumToRoman(rez);
                    print(result);
                }else {
                    throw  new Exception();
                }

            }else {
                throw new Exception();
            }
        }
        else {
            throw new Exception();
        }
        return result;
    }

    private int stringToInt(String str) {

        int number;
        number = Integer.parseInt(str);
        return number;
    }

    private String intToString(int rez){
        String number =String.format("%d", rez);
        return number;
    }

    private void calculacions(int val1, int val2) throws Exception{

        switch(operacion){

            case '+':
                rez = val1 + val2;
                break;
            case '-':
                rez = val1 - val2;
                break;
            case '*':
                rez = val1 * val2;
                break;
            case '/':
                if (val2!=0) {
                    rez = val1 / val2;
                    break;
                }else {
                    throw new Exception();
                }
        }
    }

    static boolean ifOperandRoman(String operand1) {
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        boolean check = false;
        for (String s : roman) {
            if (s.equals(operand1)) {
                check = true;
                break;
            }
        }
        return check;
    }

    static boolean ifOperandArabian(String operand1){
        String[] roman = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        boolean check = false;
        for(String s: roman){
            if(s.equals(operand1)){
                check = true;
                break;
            }
        }
        return check;
    }

    private int rometoArab(String rome) {

        StringBuffer romeNumber = new StringBuffer(rome);
        int arabNumber = 0, i = 0;
        if (romeNumber.length() > 0) {
            while (true) {
                do {
                    if (Rome[i].length() <= romeNumber.length()) {
                        if (Rome[i].equals(romeNumber.substring(0,
                                Rome[i].length()))) {
                            arabNumber += Arab[i];
                            romeNumber.delete(0, Rome[i].length());
                            if (romeNumber.length() == 0)
                                return arabNumber;
                        } else
                            break;
                    } else
                        break;
                } while (true && romeNumber.length() != 0);
                i++;
            }
        }
        return arabNumber;

    }

    private String convertNumToRoman (int value) {
        String result = "";
        while (value > 0){
            if ((value / 1000) >= 1){
                result = result + "M";
                value = value - 1000;
            }
            else if  ((value / 500) >= 1){
                result = result + "D";
                value = value - 500;
            }
            else if ((value / 100) >= 1){
                result = result + "C";
                value = value - 100;
            }
            else if ((value / 50) >= 1){
                result = result + "L";
                value = value - 50;
            }
            else if ((value / 40) >=1){
                result = result + "XL";
                value = value -40;
            }
            else if ((value / 10) >= 1){
                result = result + "X";
                value = value - 10;
            }
            else if ((value / 1) >= 1){
                switch ((value / 1)) {
                    case 9:
                        result = result + "IX";
                        value = value - 9;
                        break;
                    case 8:
                        result = result + "VIII";
                        value = value - 8;
                        break;
                    case 7:
                        result = result + "VII";
                        value = value - 7;
                        break;
                    case 6:
                        result = result + "VI";
                        value = value - 6;
                        break;
                    case 5:
                        result = result + "V";
                        value = value - 5;
                        break;
                    case 4:
                        result = result + "IV";
                        value = value - 4;
                        break;
                    case 3:
                        result = result + "III";
                        value = value - 3;
                        break;
                    case 2:
                        result = result + "II";
                        value = value - 2;
                        break;
                    case 1:
                        result = result + "I";
                        value = value - 1;
                        break;
                }
            }
        }
        return result;
    }

    private void console() throws Exception {
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        calc(input);

    }
    private void print(String massage){
        System.out.println(massage);
    }

}
