import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter how many elements you want the array to have: ");
        int howMany = readSafelyIntegerNumber(100_000);
        int[] glasses = new int[howMany];
        System.out.println("Enter your " + howMany + " elements: ");

        for (int i = 0; i < howMany; i++) {
            glasses[i] = readSafelyIntegerNumber(1_000_000);
        }

        countRoundsWithArrayList(glasses);
        countRoundsWithArray(glasses);
    }

    private static void countRoundsWithArrayList(int[] arr) {
        List<Integer> glasses = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            glasses.add(arr[i]);
        }

        int roundsCount = 0;
        boolean changedSize = false;

        do {
            changedSize = false;
            for (int j = 0; j < glasses.size() - 2; j++) {
                if (glasses.get(j).equals(glasses.get(j + 1)) && glasses.get(j).equals(glasses.get(j + 2))) {
                    glasses.remove(j);
                    glasses.remove(j);
                    glasses.remove(j);

                    roundsCount++;
                    changedSize = true;
                }
            }
        } while (changedSize);

        System.out.println("Number of rounds with ArrayList: " + roundsCount);
    }

    private static void countRoundsWithArray(int[] glasses) {
        int roundsCount = 0;
        boolean changedSize = false;

        do {
            changedSize = false;
            for (int i = 0; i < glasses.length - 2; i++) {
                if (glasses[i] == glasses[i + 1] && glasses[i] == glasses[i + 2]) {
                    int[] newArr = new int[glasses.length - 3];

                    for (int j = 0; j < i; j++) {
                        newArr[j] = glasses[j];
                    }

                    for (int k = i + 3; k < glasses.length; k++) {
                        newArr[k - 3] = glasses[k];
                    }

                    glasses = newArr;

                    roundsCount++;
                    changedSize = true;
                }
            }
        } while (changedSize);

        System.out.println("Number of rounds with Array: " + roundsCount);
    }

    private static int readSafelyIntegerNumber(int boundary) {
        while (true) {
            try {
                int number = scan.nextInt();
                if (number > 0 && number <= boundary) {
                    return number;
                } else
                    System.out.println("Invalid input. Please enter a positive integer number between 1 and " + boundary);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter positive integer number between 1 and " + boundary);
                scan.next();
            }
        }
    }
}
