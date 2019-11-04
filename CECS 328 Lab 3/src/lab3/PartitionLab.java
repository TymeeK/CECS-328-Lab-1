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
        quickSelect(k, array, start, end);
        //}
        
    }

    public static int quickSelect(int k, int[] newArray, int start, int end) {

        int index = partition(newArray, start, end);
        
        // if (index == k) {
        //     return newArray[index];
        // }
        // else if (index > k) {
        //     quickSelect(k, newArray, start, index - 1); //or index-1???   
        // }
        // else {
        //     quickSelect(k , newArray, index + 1, end);//or index+1???
        // }

        return 5;
    }

    public static int partition(int[] array, int start, int end) {
        int middle = end / 2;
              
        int pivot = array[end];

        System.out.println("Pivot: " + pivot);
        int i = start;
        int j = start + 1;
        int index = 0;


        while (j != end + 1) {
            
            if (array[j] < pivot) {
                i++;
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
            
            j++;
            
        }
        System.out.println("The pivot should not be moved" + Arrays.toString(array));
        index = i + 1;
        int temp = array[index];
        array[index] = pivot;
    
        for (int k = index + 1; k < end; k++) {
            int temp2 = array[k];
            System.out.println(temp2);
            array[k] = temp;
            array[k + 1] = temp2;
          
        }


        System.out.println("The pivot should be changed" + Arrays.toString(array));
        return index;        
    }
}
