package CrossTraing1;
//RemoveAdjcentRepeatedCharI 和 ArrayDeduplicationI是一样的

public class RemoveAdjcentRepeatedCharI {
    public String deDup (String input){
        //这种方法缺心眼，不用
        if(input == null || input.length() == 0){
            return input;
        }
        if (input.length() <= 1){
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 1;
        for (int fast = 1; fast < array.length; fast++){
            if (array[fast] == array[slow-1]){
                continue;
            }else {
                array[slow]=array[fast];
                fast++;
                slow++;
            }
        }
        return new String(array,0,slow);
    }
    public String deDup2 (String input){
//        if a[f] != a[s-1], copy a[s]=a[j], s++, f++
//        if a[f] == a[s-1], don’t copy, f++
        if(input == null){
            return null;
        }
        if (input.length() <= 1){
            return input;
        }
        char[]array = input.toCharArray();
        int slow = 1;
        /* 那这里fast++，多加了，我咋就那么死心眼呢，我把if条件换一下就不行了？
        for ( int fast = 1; fast < array.length; fast++){
            if (array[fast] != array[slow-1]){
                array[slow] = array[fast];
                fast++;// 这里代码有问题，因为当我a[fast] !=a[slow-1]时，我要移动fast和slow，但是这个for loop里面还有一个fast++，所以说
                //这个fast 被加了2次，但如果把这个fast++删掉，那么else 也就不需要了，因为每次都要fast++，所以传统方法写成while最好,可以避免fast被加多遍
                slow++;
            }else {
                fast++;
            }
        }

         */
        for ( int fast = 1; fast < array.length; fast++){
            if(array[fast] == array[slow-1]){
                continue;
            }else{
                array[slow] = array[fast]; // 因为在for loop里面都得++；所以这里我就只移动slow
                slow++;
            }
        }



        return new String(array,0, slow);

    }
    public String deDup3 (String input){
        // if a[f] != a[s-1], copy a[s]=a[j], s++, f++
      //if a[f] == a[s-1], don’t copy, f++
        if(input == null){
            return null;
        }
        if (input.length() <= 1){
            return input;
        }
        char[]array = input.toCharArray();
        int slow = 1;
        int fast = 1;
        while (fast < array.length){
            if (array[fast] != array[slow-1]){
                array[slow++] = array[fast++];
            }else{
                fast++;
            }
        }
        return new String(array,0, slow);
    }

        public static void main(String[] args) {
        RemoveAdjcentRepeatedCharI sol = new RemoveAdjcentRepeatedCharI();
        String input = "abbc";
        System.out.println(sol.deDup2(input));
    }
}
