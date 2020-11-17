package ConditionPrace;

public class conditionPrac {
    public static void main(String[] args) {
        conditionPrac sol = new conditionPrac();
        int sum = 0;
        for (int i = 4; i< 8; i++){
            if (i == 6){
                continue;
            }
            sum += i;
        }
        System.out.println(sum);
    }


}
