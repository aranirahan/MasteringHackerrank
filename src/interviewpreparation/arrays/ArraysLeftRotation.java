package interviewpreparation.arrays;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ArraysLeftRotation {

    private static int[] rotLeft(int[] inputtedArrays, int countRotation) {

        ArrayList<Integer> arrayListRotated = new ArrayList<>();

        for (int inputtedInt : inputtedArrays) {
            arrayListRotated.add(inputtedInt);
        }

        for (int i = 0; i < countRotation; i++) {
            if (arrayListRotated.size() != 0) {
                arrayListRotated.add(arrayListRotated.get(0));
                arrayListRotated.remove(0);
            }
        }

        return convertListIntegerToArrayIntegers(arrayListRotated);
    }

    private static int[] convertListIntegerToArrayIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++) {
            ret[i] = iterator.next();
        }
        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
