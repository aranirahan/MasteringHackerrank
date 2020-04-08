package interviewpreparation.warmup;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class SockMerchant {

    // Complete the sockMerchant function below.
    private static int sockMerchant(int n, int[] arr) {

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        int countAllPaired = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            int countPaired = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]){
                    countPaired++;
                    visited[j] = true;
                }
            }
            countAllPaired += (countPaired / 2);
        }

        return countAllPaired;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
//        int[] socks = new int[]{1, 2, 3, 3, 4};
//        sockMerchant(5, socks);
    }
}
