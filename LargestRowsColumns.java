import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LargestRowsColumns {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size n: ");
        int n = input.nextInt();
        input.close();

        int[][] matrix = new int[n][n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextInt(2);
            }
        }

        System.out.println("The random array is");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        int[] hitungBaris = new int[n];
        int maxBaris = 0;
        for (int i = 0; i < n; i++) {
            int hitung = 0;
            for (int j = 0; j < n; j++) {
                hitung += matrix[i][j];
            }
            hitungBaris[i] = hitung;
            if (hitung > maxBaris) {
                maxBaris = hitung;
            }
        }

        ArrayList<Integer> rowIndices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (hitungBaris[i] == maxBaris) {
                rowIndices.add(i);
            }
        }

        int[] hitungKolom = new int[n];
        int maxKolom = 0;
        for (int j = 0; j < n; j++) {
            int hitung = 0;
            for (int i = 0; i < n; i++) {
                hitung += matrix[i][j];
            }
            hitungKolom[j] = hitung;
            if (hitung > maxKolom) {
                maxKolom = hitung;
            }
        }

        ArrayList<Integer> colIndices = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (hitungKolom[j] == maxKolom) {
                colIndices.add(j);
            }
        }

        System.out.print("The largest row index: ");
        printList(rowIndices);
        System.out.print("The largest column index: ");
        printList(colIndices);
    }

    public static void printList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}