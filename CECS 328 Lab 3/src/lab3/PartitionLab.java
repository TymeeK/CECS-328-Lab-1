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
        System.out.println("Please enter a number from 1 to " + n);
        int k = in.nextInt();
    
        boolean check = true;
        while (check) {
            if (k > n) {
                System.out.println("Please enter a number between 1 and " + n);
                k = in.nextInt();
            }

            else {
                check = false;
            }
            quickSelect(k, array, start, end);
        }
        
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
        int[] tempArray = {array[start], array[middle], array[end]};
        
        Arrays.sort(tempArray);
        System.out.println(Arrays.toString(tempArray));
        int pivot = tempArray[1];
        boolean check = true;
        int i = 0;
        int j = end; 
        while (check) {
            if (array[j] >= pivot) {
                j--;
            }

            if (array[i] <= pivot) {
                
            }
        }
        return 5;
        
        
    }
}
