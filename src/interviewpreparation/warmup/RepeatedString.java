package interviewpreparation.warmup;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class RepeatedString {

    private static long repeatedString(String singleWord, long maxWordLength) {

        int countAInSingleWord = 0;

        for (int i = 0; i < singleWord.length(); i++) {
            if (singleWord.charAt(i) == 'a') countAInSingleWord++;
        }

        long countRepeat = maxWordLength / singleWord.length();
        long countAInWordRepeated = countAInSingleWord * countRepeat;

        long countRestCharOfWordNotYetCounted = maxWordLength % singleWord.length();

        for (int i=0; i<countRestCharOfWordNotYetCounted;i++){
            if (singleWord.charAt(i) == 'a') countAInWordRepeated++;
        }

        return countAInWordRepeated;

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
