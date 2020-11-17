package BitOperation;

public class HexadecimalRepresentation {
    public String hex(int number) {
        StringBuilder sb = new StringBuilder("0x");
        for (int i = 28; i >= 0; i -= 4) {
            int digit = (number >> i) & 15;
            if (digit < 10) {
                char curr = (char) (digit + '0');
                sb.append(curr);
            } else {
                char curr = (char) (digit - 10 + 'a');
                sb.append(curr);
            }
        }
        return sb.toString();
    }



    public String hex2(int number){
        //Assumption: number >= 0
        String prefix = "0x";
        if (number == 0) {
            return prefix + "0";
        }
        char[] base = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder sb = new StringBuilder();
        boolean isLeading = true;
        for (int i = 28; i >= 0; i -= 4) {
            char cur = base[(number >> i) & 0xf];
            if (cur != '0' || !isLeading) {
                sb.append(cur);
                isLeading = false;
            }
        }
        return prefix + sb.toString();
    }

    public static void main(String[] args) {
        HexadecimalRepresentation sol = new HexadecimalRepresentation();
        int number = 255;//0xFF
        int num = 15;//0xF
        System.out.println(sol.hex(number));

    }
}
