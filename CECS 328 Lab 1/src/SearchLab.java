import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SearchLab {

    public static void main(String[] args) {
        int key; 
        int n = 0;
        int[] a;
        int userInput; 
        int newNumber;
        
        Scanner in = new Scanner(System.in);
        boolean check = true; 
        System.out.println("Please enter a positive integer");
        userInput = in.nextInt();
       
        while (check) {
   
            if (userInput < 0) {
                System.out.println("Please try again");
                userInput = in.nextInt();
            }   
            else {
                check = false; 
            }
        }

        n = userInput;
      
        //Assigning n amount of size to the array a
        a =  new int[n];
        
        Random randomNumber = new Random();

        //This generates random numbers and inserts them into the array
        for (int i = 0; i < n ; i++) {
            newNumber = randomNumber.nextInt(2001) - 1000;
            a[i] = newNumber; 
        }
        
        //Sorts the array 
        Arrays.sort(a);
       
        long timeEndLinear = 0;
        long timeEndBinary = 0;
         
        int average = 100;
        for (int i = 0; i < average; i++) {
            //Selects a random key from the array
            int selectKey = randomNumber.nextInt(n - 1);
            key = a[selectKey];

            long timeStartLinear = System.nanoTime();
            linearSearch(key, a);
            timeEndLinear += System.nanoTime() - timeStartLinear;
            
            long timeStartBinary = System.nanoTime();
            binarySearch(key, a);
            timeEndBinary += System.nanoTime() - timeStartBinary;
        }
        long linearRunTime = timeEndLinear / average; 
        long binaryRunTime = timeEndBinary / average;
        System.out.println("The average runtime for linear search is " + linearRunTime + " nanoseconds");
        System.out.println("The average runtime for binary search is " + binaryRunTime + " nanoseconds");

        n = 100000;
        key = 5000;

        long timeStartLinear = System.nanoTime(); 
        linearSearch(key, a);
        linearRunTime = System.nanoTime() - timeStartLinear;

        long timeStartBinary = System.nanoTime();
        binarySearch(key, a);
        binaryRunTime = System.nanoTime() - timeStartBinary;
        
        System.out.println("Worst case for linear search: " + linearRunTime + " nanoseconds");
        System.out.println("Worst case for binary search: " + binaryRunTime + " nanoseconds");
        
        //Calculating single line for binary search is x = binaryTimer / logn
        //I have to first convert the logn to base 2 because it is base 10 in java
        
        double logBaseTwo = 3 * (Math.log(n) / Math.log(2));
        double singleLine = binaryRunTime / logBaseTwo;
        
        System.out.println("Single line of binary search " + singleLine + " nanoseconds");
        //Now I set n = 10-9 and I have to calculate the running time for both algorithms
        n = 1000000000;
        logBaseTwo = (Math.log(n)) / Math.log(2);
        
        double worstCaseBinaryTime = singleLine * logBaseTwo; 

        System.out.println("Worst case running time for binary search when n = 10e9;\n" + worstCaseBinaryTime + " nanoseconds");
        //Now calculating the worst running time for linear search
        double newSingleLine = linearRunTime / logBaseTwo;
        double worstCaseLinearTime = newSingleLine * n;
        System.out.println("Worst case running time for linear search when n = 10e9;\n" + worstCaseLinearTime);
        
        
    }


    public static boolean linearSearch(int key, int[] sortedArray) {
        //This for loop will go through each element in the array until the
        //key matches an element in the array
        for (int i = 0; i < sortedArray.length; i++ ) {
            if (key == sortedArray[i]) {
                return true; 
            } 
        }

        return false;
    }

    public static boolean binarySearch(int key, int[] sortedArray) {
        int beginIndex = 0;
        int arrayLength = sortedArray.length - 1;
        int middle = (beginIndex + arrayLength) / 2;

        while (arrayLength >= beginIndex) {
           
            middle = (beginIndex + arrayLength) / 2;
            int amid = sortedArray[middle];
         
            
            if (key == amid) {
                return true; 
            }
            
            else if (amid < key) {
                beginIndex = middle + 1;
                
            }
            
            else if (amid > key) {
                arrayLength = middle - 1;
            }
        }
        return false; 
    }
}
