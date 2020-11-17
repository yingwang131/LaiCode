package OA;

public class TwoStringSum {
    static int twoStringSum(String a, String b){
        int num1 = Integer.parseInt(a);
        int num2 = Integer.parseInt(b);
        int sum = num1 + num2;
        return sum;
    }

    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }



    public static void main(String[] args) {
        TwoStringSum sol = new TwoStringSum();
        String num1 = "99";
        String num2 = "99";
        System.out.println(sol.addBinary(num1,num2));
    }

}
