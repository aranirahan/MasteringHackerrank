package arrays;

import java.util.Scanner;

public class NewYearsChaos {
    private static void minimumBribes(int[] queues) {

        int queueIndexLength = queues.length - 1;

        int swapCount = 0;
        for (int i = queueIndexLength; i >= 0; i--) {

            int observePositionNumber = queues[i];
            int originalPositionNumber = i + 1;

            if (observePositionNumber != originalPositionNumber) {

                assertMinIndexWillObserveIsZero(i - 1);
                observePositionNumber = queues[i - 1];

                if (observePositionNumber == originalPositionNumber) {
                    swapCount++;
                    swapQueues(queues, i - 1, i);
                } else {
                    assertMinIndexWillObserveIsZero(i - 2);
                    observePositionNumber = queues[i - 2];

                    if (observePositionNumber == originalPositionNumber) {
                        swapCount += 2;
                        swapQueues(queues, i - 2, i - 1);
                        swapQueues(queues, i - 1, i);
                    } else {
                        System.out.println("Too chaotic");
                        return;
                    }

                }
            }
        }

        System.out.println(swapCount);
    }

    private static void assertMinIndexWillObserveIsZero(int i) {
        assert i >= 0;
    }

    private static void swapQueues(int[] array, int indexOrigin, int indexDestination) {
        int originValueOfDestination = array[indexDestination];
        array[indexDestination] = array[indexOrigin];
        array[indexOrigin] = originValueOfDestination;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            minimumBribes(a);
        }
        sc.close();
    }

}