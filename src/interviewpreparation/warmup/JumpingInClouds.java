package interviewpreparation.warmup;

import java.io.*;
import java.util.*;

public class JumpingInClouds {

    private static int jumpingOnClouds(int[] clouds) {
        int cloudsLength = clouds.length;

        int DOUBLE_JUMP_CONS = 2;
        int nextPositionDouble = DOUBLE_JUMP_CONS;

        int countJump = 0;
        int FIRST_JUMP_POSITION = 1;
        for (int indexCloud = FIRST_JUMP_POSITION; indexCloud < cloudsLength; indexCloud++) {
            int nextPositionSingle = nextPositionDouble - 1;

            if (isJumpingSafe(nextPositionDouble, clouds)) {
                countJump++;
                indexCloud = nextPositionDouble;
                nextPositionDouble += DOUBLE_JUMP_CONS;
            } else if (isJumpingSafe(nextPositionSingle, clouds)) {
                countJump++;
                indexCloud = nextPositionSingle;
                nextPositionDouble = nextPositionSingle + DOUBLE_JUMP_CONS;
            }
        }

        return countJump;

    }

    private static boolean isJumpingSafe(int nextPositionDouble, int[] clouds) {
        if (isNextPositionValid(nextPositionDouble, clouds.length)) {
            return isNextCloudIsCumulus(clouds[nextPositionDouble]);
        }
        return false;
    }

    private static boolean isNextPositionValid(int nextPosition, int cloudsLength) {
        return nextPosition > 0 && nextPosition < cloudsLength;
    }

    private static boolean isNextCloudIsCumulus(int nextCloud) {
        int CUMULUS_CONS = 0;
        return nextCloud == CUMULUS_CONS;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

    /*private static int jumpingOnClouds(int[] clouds) {
        int cloudsLength = clouds.length;
        int nextPositionDouble = 2;
        if (cloudsLength < 1) nextPositionDouble = 1;

        int countJump = 0;
        for (int indexCloud = 1; indexCloud < cloudsLength; indexCloud++) {
            int nextPositionSingle = nextPositionDouble - 1;

            if (isNextPositionValid(nextPositionDouble, cloudsLength)) {
                if (isNextCloudIsCumulus(clouds[nextPositionDouble])) {
                    countJump++;
                    indexCloud = nextPositionDouble;
                    nextPositionDouble += 2;

                } else if (isNextPositionValid(nextPositionSingle, cloudsLength)) {
                    System.out.println(isNextCloudIsCumulus(clouds[nextPositionSingle]));
                    if (isNextCloudIsCumulus(clouds[nextPositionSingle])) {
                        countJump++;
                        indexCloud = nextPositionSingle;
                        nextPositionDouble = nextPositionSingle+2;
                    }
                }

            } else if (isNextPositionValid(nextPositionSingle, cloudsLength)) {
                System.out.println(isNextCloudIsCumulus(clouds[nextPositionSingle]));
                if (isNextCloudIsCumulus(clouds[nextPositionSingle])) {
                    countJump++;
                    indexCloud = nextPositionSingle;
                    nextPositionDouble = nextPositionSingle+2;
                }
            }
        }

        return countJump;

    }

    private static boolean isNextPositionValid(int nextPosition, int cloudsLength) {
        return nextPosition > 0 && nextPosition < cloudsLength;
    }

    private static boolean isNextCloudIsCumulus(int nextCloud) {
        return nextCloud == 0;
    }*/
