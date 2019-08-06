package arrayPractice;
import java.util.Arrays;
import java.util.Random;

public class FifteenArray {
    private  int[] num = new int[15];
    public FifteenArray() {
        generateNumbers(num);//生成随机数并存储
        Arrays.sort(num);
        printResult(num);
    }

    private void printResult(int[] num) {
        System.out.println("tha max is:" + num[num.length - 1] + "the min is:" + num[0]);
    }

    private void generateNumbers(int[] num) {
        Random r = new Random();
        for (int i = 0; i < num.length; i++) {
            num[i] = r.nextInt(111) + 5;
        }
    }
}
