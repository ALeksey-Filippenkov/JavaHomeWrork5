import java.util.Random;
import java.util.Scanner;

public class Task3 {
    
    static Random random = new Random();
    Scanner in = new Scanner(System.in);

    public int[] CreatArray() {
        System.out.print("Пожалуйста введите длину массива: ");
        try (Scanner in = new Scanner(System.in)) {
            int size = in.nextInt();
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = random.nextInt(100);
            }
            return array;
        }
    }

    public void HeapSort(int[] array) {
        int n = array.length;
        int i = (n - 2) / 2;
        while (i >= 0) {
            HeapIfy(array, i--, n);
        }

        while (n > 0) {
            array[n - 1] = Pop(array, n);
            n--;
        }
    }

    public void HeapIfy(int[] array, int i, int size) {
        int left = Left(i);
        int right = Right(i);

        int largest = i;

        if (left < size && array[left] > array[i]) {
            largest = left;
        }

        if (right < size && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            BubleSort(array, i, largest);
            HeapIfy(array, largest, size);
        }
    }

    public void BubleSort(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int Left(int i) {
        return (2 * i + 1);
    }

    public int Right(int i) {
        return (2 * i + 2);
    }

    public int Pop(int[] array, int size) {
        if (size <= 0) {
            return -1;
        }
        int top = array[0];
        array[0] = array[size - 1];
        HeapIfy(array, 0, size - 1);
        return top;
    }
}
