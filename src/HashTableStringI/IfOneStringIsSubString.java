package HashTableStringI;
/*
“ab” is a substring of “bcabc”, return 2
“bcd” is not a substring of “bcabc”, return -1
"" is substring of "abc", return 0
 */

public class IfOneStringIsSubString {
    public int strStr(String large, String small){
        if (large == null || small == null || large.length() < small.length()){
            return -1;
        }
        if(small.length() == 0){
            return 0;
        }
        for (int i = 0; i <= large.length() - small.length(); i++){
            if (equals(large, i, small)){
                return i;
            }
        }
        return -1;
        //这层循环是large string index 一个一个往后走，并且判断 是不是和small string的内容一样？其实就是如果相等要返回那个index
        // 最重要的是这个for 里面带的这个 index i，这个i 要作为参数给到equal 函数里面，让equal函数里面的 i 逐次增加，如果不相等的话
        // 判断的过程是：a!=c;b!=c,c==c;
    }


    public boolean equals(String large, int start, String small){
        for (int j = 0; j <small.length(); j++){
            if (large.charAt(start + j) != small.charAt(j)){

                return false;
            }
        }
        return true;
        //这个函数首先拿了一个index i 即start从上面，根据这个start，在small string里面放个index j，如果 large的start+j == smll 的j
        //表明第一个字母就匹配上了，否则返回fasle到上面调用的地方，这时start=2了，再用large里面的第二个字母b和small的第一个字母c比较；
        // 当c == c的时候，j就++了，在equal里面不停的判断后面的2个字母是不是相等；
        // 如果b！=c的时候，return false，j一直是0 没有变，一但找到small的第一个字母和large相等，j就变了，赶紧check后面的
        // i 一直在边，j之后当 large 和small的字母匹配上才++；赶紧把剩下的查一下；
    }



    /*
    public boolean equals(String large, int start, String small){
       //上面的for loop 的写法也对，但是我就是不信邪，while的方法debug了半个小时；
       int j=0;
       while(j < small.length() && large.charAt(start+j) == small.charAt(j)){
           j++;
       }
       if (j == small.length()){
           return true;
       }
       return false;
    }

     */
    public static void main(String[] args) {
        IfOneStringIsSubString sol = new IfOneStringIsSubString();
        String s1 = "abcde";
        String s2 = "cde";
        System.out.println(sol.strStr(s1,s2));
    }
}
