package niuke.BitOperation;

import java.util.ArrayList;

public class SumSolution {

    public String binary2To10(String input) {
        ArrayList<Double> out = new ArrayList<>();
        char[] in = input.toCharArray();
        int len = input.length();
        if (len == 0) {
            return null;
        }
        for (int i = len - 1; i >= 0; i--) {
            double temp = 0;
            if (in[i] == '1') { //2 -> 10
                temp = 1 << len - i - 1;
            }
            int j = 0;
            while (temp / 10 != 0) {//13 -> [3,1]
                double num = temp % 10;
                temp = Math.floor(temp / 10);
                if (out.size() <= j) {
                    out.add(num);
                } else {
                    out.set(j, out.get(j) + num);
                }
                if (out.get(j) >= 10) { //进位
                    out.set(j, out.get(j) - 10);
                    if (out.size() <= j+1) {
                        out.add(1.0);
                    }else {
                        out.set(j + 1, out.get(j + 1) + 1);
                    }
                }
                j++;
            }
        }
        StringBuffer output = new StringBuffer();
        for (int j = out.size() - 1; j >= 0; j--) {
            output.append(out.get(j).intValue());
        }
        System.out.println(output.toString());
        return output.toString();
    }
}
