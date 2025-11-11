package OrientationTask3_2;

import java.util.Random;

public class Task2 {

    public static void main(String[] args) {

        // The distribution table:
        // {cumulative %, age}
        int[][] table = {
                {16, 20},
                {34, 21},
                {52, 22},
                {68, 23},
                {82, 24},
                {89, 25},
                {94, 26},
                {96, 28},
                {98, 30},
                {100, 35}
        };

        int[] counts = new int[101];
        Random rnd = new Random();

        // Generate 1000 ages
        for (int i = 0; i < 1000; i++) {
            int x = rnd.nextInt(100) + 1;  // random 1–100
            int row = 0;

            // matching row
            while (x > table[row][0]) {
                row++;
            }

            int age = table[row][1];
            counts[age]++;
        }

        System.out.println("Age  Count");
        for (int age = 0; age < counts.length; age++) {
            if (counts[age] > 0) {
                System.out.println(age + "   " + counts[age]);
            }
        }
    }
}

