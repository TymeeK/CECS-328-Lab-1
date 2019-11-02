import java.lang.Math;
import java.util.Scanner;


public class DivideAndConquer {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter an integer");
        int n = in.nextInt();
        System.out.println("The square root of " + n + " is "  + squareRoot(n));

        int[] testArray = {1, 3, 4, 6, 7, 8, 9, 10, 11};
        System.out.println("The smallest missing number in the array is " + missingNumber(testArray));
        
    }

    public static int squareRoot(int n) {
        boolean check = true;
        int middleNum = n / 2; 
        int tempNum = 0; 
        int multiplyNum;
        while (check) {
            multiplyNum = middleNum * middleNum;
            
            //I found the square root of n
            if (multiplyNum == n) {
                n = middleNum;
                check = false; 
            }

            //I did not find the square root of n
            //I will continue to divide by 2
            else if (multiplyNum > n){ 
                tempNum = middleNum;
                middleNum = middleNum / 2;
            }
            //If the square root is in between 2 numbers
            //I will take the higher number
            else if (tempNum - middleNum == 1) {
                n = tempNum;
                check = false;
            }
            else { 
                middleNum = (tempNum + middleNum) / 2;
            }
        }
        return n;
    }

    public static int missingNumber(int[] sortedArray) {
        
        int answer = 0;
        int begin = 0; 
        int end = sortedArray.length - 1;
        int middle;
        boolean check = true;
        
        while (check) {
            //Check if the beginning is greater than the end
            //If so, then return the end + 1;
            if (begin >= end) {
                answer = end + 1;
                check = false;
            }
            //If the beginning was not in order
            //Return begin
            if (begin != sortedArray[begin]) {
                answer = begin; 
                check = false;
            }
            middle = (begin + end) / 2;
    
            if (sortedArray[middle] == middle) {
                begin = middle + 1;
            }

            else if (sortedArray[middle] != middle) {
                end = middle;       

            }

        }
        return answer;
    }
}
