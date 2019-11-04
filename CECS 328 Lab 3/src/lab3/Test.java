package lab3;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        int[] array = new int[20]; 
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        System.out.println("Array:" + Arrays.toString(array));

        int temp = array[19];
        array[19] = 220;
        array[0] = temp;
        System.out.println("Array:" + Arrays.toString(array));
        System.out.println(array[19] + array[0]);
    }
}