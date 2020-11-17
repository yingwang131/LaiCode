package OA;

public class Stringchar {
    public static boolean isSpecial(String text){
        String tempT = alertText(text);
        return text.equals(tempT);
    }

    public static String alertText(String inputText){
        if(inputText == null || inputText.isEmpty()){
            return inputText;
        }
        // abcdefedcba=abcdefdcba
        // abcdefedcb+a(bcdefdcba)
        // abcdefedc+b(cdefdcba)
        // abcdefed+c(defdcba)
        // abcdefe+d(efdcba)
        // abcdef+e(fedcba)
        // abcde+f(edcba)
        // abcd+e(dcba)
        // abc+d(cba)
        // ab+c(ba)
        // a+b(a)
        // a ""
        // ""
        char tail=inputText.charAt(inputText.length()-1);
        String substring=inputText.substring(0,inputText.length()-1);
//        System.out.println(substring);
        String ans=alertText(substring);
        return tail+ ans;

    }
    //不懂这个程序怎么跑的；

    public static void main(String[] args) {
//        String text = "aaabbb";
//        String text1 = "a1a1b2";
        String text1 = "abcdefedcba";
//        String text1 = "fedcba";


        System.out.println(isSpecial(text1));
    }

}
