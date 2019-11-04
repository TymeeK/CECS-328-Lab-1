package lab3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PartitionLab {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a positive integer ");
        int start = 0;
        
        int n = in.nextInt();
        int[] array = new int[n];
        Random number = new Random();
        int newNumber;
        
        for (int i = 0; i < n; i++) {
            newNumber = number.nextInt(201) - 100;
            array[i] = newNumber;
        }
        int end = array.length - 1;

        System.out.println(Arrays.toString(array));
        // System.out.println("Please enter a number from 1 to " + n);
        // int k = in.nextInt();
    
        // boolean check = true;
        // while (check) {
        //     if (k > n) {
        //         System.out.println("Please enter a number between 1 and " + n);
        //         k = in.nextInt();
        //     }

        //     else {
        //         check = false;
        //     }
        int k = 0;
        int i = 0;
        int leastNumber = quickSelect(k, array, start, end, i);
        System.out.println("This is the least number: " + leastNumber);
        //}
        
    }

    public static int quickSelect(int k, int[] newArray, int start, int end, int i) {

        int index = partition(newArray, start, end);
        
        if (i == 2) {
            return index + 1;
        }
        else if (index > k) {
            return quickSelect(k, newArray, start, index - 1, i++); 
        }
        else {
            return quickSelect(k , newArray, index + 1, end, i++);
        }

        
    }

    public static int partition(int[] array, int start, int end) {              
        int pivot = array[end];
        System.out.println("End:" + end);
        System.out.println("Pivot: " + pivot);
        int i = start;
        int j = start + 1;
        int index = 0;


        while (j != end + 1) {
            
            if (array[j] < pivot) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                i++;
            }
            
            j++;
            
        }
        System.out.println("The pivot should not be moved" + Arrays.toString(array));
        index = i + 1;
        int temp = array[index];
        array[index] = pivot;
        array[end] = temp;
        System.out.println("Last element: " + array[end]);
        System.out.println("array at the index: " + array[index]);

        System.out.println("The pivot should be changed" + Arrays.toString(array));
        return index;        
    }
}
