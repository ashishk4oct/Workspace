public class Test {

    public static void main(String[] args) {

        String s = toBinary(1);

    }































    private static String toBinary(int num) {
        if(num > 0){
            return toBinary1(num);
        }

        throw new RuntimeException("Negative not Supported");
    }

    private static String toBinary1(int num) {

        String s = "";
        while(num >= 2){
            s = (num%2) + s;
            num = num/2;
        }

        s = num+s;

        return s;
    }








}