package HashTableStringI;

/*
“  a” --> “a”
“   I     love MTV ” --> “I love MTV”
"_ _ _abc_ _de_ _ --> abc_de"
前后空格都要删除掉；但是中间要留一个空格；
方法：还是可以用2个挡板，3个区域，同向而行
 */
public class RemoveSpace {
    public String removeSpaces(String input){
        char[] array = input.toCharArray();
        if (input.isEmpty()){
            return input;
        }
        int i = 0, j = 0;
        while (j < array.length){
            if (array[j] == ' ' ){
                if (i == 0){
                    j++;
                }else if (i != 0){
                    if (array[i - 1] != ' '){
                        array[i] = array[j];
                        i++;
                        j++;
                    }else{
                        j++;
                    }
                }
            } else {
                array[i] = array[j];
                i++;
                j++;
            }
        }
        if (i >0 && array[i-1] == ' '){
            i--;
        }
        return new String(array, 0, i);
    }

    public String removeSpaces2(String input){
        char[] array = input.toCharArray();
        if (input.isEmpty()){
            return input;
        }
        int i = 0;
        for (int j = 0; j < input.length(); j++){
            if (array[j] == ' ' && (i == 0 || array[i-1] == ' ')){
                continue;
            }
            array[i++] = array[j];

        }
        if (i >0 && array[i-1] == ' '){
            i--;
        }
        return new String(array, 0, i);
    }

    public static void main(String[] args) {
        RemoveSpace sol = new RemoveSpace();
        String input = "   a  ";
        String input2 = "   abc  de  ";
        System.out.println(sol.removeSpaces2(input));
    }
}
