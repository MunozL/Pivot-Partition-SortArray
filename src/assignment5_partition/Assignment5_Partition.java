/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment5_partition;

/**
 *
 * @author Lmuno
 */
public class Assignment5_Partition {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String BLANKS = " "; // A String of two blanks
        int i, pivot, partition; // Array index
        int[] data = {100, 80, 23, 50, 88, 70, 60, 90, 20, 72, 40, 8, 9};

        Partition part = new Partition();//Instance of Partition class
        Insertion is = new Insertion();//Instance of Insertion Class

        // Print the array before sorting:
        System.out.println("Here is the entire original array:");
        for (i = 0; i < data.length; i++) {
            System.out.print(data[i] + BLANKS);
        }
        System.out.println();

        //calculation of the pivot.  To calculate the pivot you should use the median-of-Three partitioning. Once the pivot has been 
        //calculated call the partition() method passing to it the starting index, the ending index, the pivot, and the array of data
        int leftIndex = 0; //left most #
        int rightIndex = data.length - 1;//right most  #
        int medianCenterNum = (leftIndex + rightIndex) / 2; // middle  #

        // Sort the left, center, and right values to determine the pivot
        if (data[leftIndex] > data[medianCenterNum]) //If the # on the left index is bigger than the # in the middle
        {
            swap(data, leftIndex, medianCenterNum);//Then swap them. Left to middle. Middle to left
        }

        if (data[leftIndex] > data[rightIndex])//if the # in the left is bigger than the # in the right variable
        {
            swap(data, leftIndex, rightIndex);//then swap them. Left got to rightIndex and right goes to left variable
        }
        if (data[medianCenterNum] > data[rightIndex])//if the # in the middle is bigger than the one in the right
        {
            swap(data, medianCenterNum, rightIndex);//then swap them. Middle to right and right to middle
        } //after getting pivot # swap it to the most right index

        swap(data, medianCenterNum, rightIndex - 1);
        pivot = data[rightIndex - 1];

        part.partitionIt(data, leftIndex, rightIndex, pivot);//call partitio method
        partition = part.partitionIt(data, leftIndex, rightIndex, pivot);//assign to partition variable
        System.out.println("\nThe pivot is: " + pivot + " and the partition is at index: " + partition);

        System.out.println("\nAfter partitioning the numbers are now :");
        for (i = 0; i < data.length; i++) {
            System.out.print(data[i] + BLANKS);
        }
        System.out.println();

        // Sort the lower partition using insertion sort. Display all with for loop
        is.insertionSort(data, leftIndex, partition - 1);//call the insertionSort method and pass dataarray , left index and parittion -1 as arguments
        System.out.println("\nAfter sorting the lower partition the numbers are now:");
        for (i = 0; i < data.length; i++) {
            System.out.print(data[i] + BLANKS);
        }
        System.out.println();

        // Sort the upper partition using insertion sort.Disolay all with for loop
        is.insertionSort(data, partition + 1, rightIndex);
        System.out.println("\nAfter sorting the upper partition the numbers are now:");
        for (i = 0; i < data.length; i++) {
            System.out.print(data[i] + BLANKS);
        }
        System.out.println();

        System.out.println("\nThe entire array is now sorted");
    }

    //swap static method to swap left right and middle to help determenine pivot
    private static void swap(int[] data, int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

}
