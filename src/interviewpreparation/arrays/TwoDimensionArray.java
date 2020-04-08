package interviewpreparation.arrays;

import java.io.*;
import java.util.*;

public class TwoDimensionArray {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] myTwoDimensionArray) {

        /*int[][] myTwoDimensionArray = {
                {0, 1, 2, 3, 4, 5},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };*/

        int biggestHourglassValue = Integer.MIN_VALUE;
        for (int i = 0; i < myTwoDimensionArray.length; i++) {
            for (int j = 0; j < myTwoDimensionArray[i].length; j++) {
//                System.out.print(myTwoDimensionArray[i][j] + " ");
                if (isMatrixCanBecomeHourglass(myTwoDimensionArray, i, j)) {

                    int[] hourglassLineOne = myTwoDimensionArray[i];
                    int[] hourglassLineTwo = myTwoDimensionArray[i + 1];
                    int[] hourglassLineThree = myTwoDimensionArray[i + 2];

                    int newHourglassValue = countValueOfHourglassLineOne(hourglassLineOne, j) +
                            countValueOfHourglassLineTwo(hourglassLineTwo, j) +
                            countValueOfHourglassLineThree(hourglassLineThree, j);

                    if (biggestHourglassValue < newHourglassValue)
                        biggestHourglassValue = newHourglassValue;
                }
            }
//            System.out.println();
        }
//        System.out.println(biggestHourglassValue);

        return biggestHourglassValue;

    }

    private static boolean isMatrixCanBecomeHourglass(int[][] myTwoDimensionArray, int i, int j) {
        return i + 2 < myTwoDimensionArray.length && j + 2 < myTwoDimensionArray[i].length;
    }

    private static int countValueOfHourglassLineOne(int[] hourglassLineOne, int j) {
        return hourglassLineOne[j] + hourglassLineOne[j + 1] + hourglassLineOne[j + 2];
    }

    private static int countValueOfHourglassLineTwo(int[] hourglassLineTwo, int j) {
        return hourglassLineTwo[j + 1];
    }

    private static int countValueOfHourglassLineThree(int[] hourglassLineThree, int j) {
        return countValueOfHourglassLineOne(hourglassLineThree, j);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
//        hourglassSum();
    }
}
