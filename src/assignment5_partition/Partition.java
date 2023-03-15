/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment5_partition;

/**
 *
 * @author Lmuno
 */
class Partition {

    public int partitionIt(int[] data, int left, int right, long pivot)//petition method with arguments for dataarray,left#,right#and pivot#
    {
        int leftPtr = left;             // right of first elem
        int rightPtr = right - 1;       // left of pivot

        while (true) {
            while (data[++leftPtr] < pivot)  //move leftPTR to the righ and  look for # bigger than pivot #
             ;
            while (data[--rightPtr] > pivot) //move rightPtr to the left and  look for #smaller than pivot #
             ;                                  //    (nop)
            if (leftPtr >= rightPtr) // if the pointers cross each other the partition is done. Return
            {
                break;
            } else // if they did not not crossed, swap eleements 
            {
                swap(data, leftPtr, rightPtr);  // swap elements
            }
        }  // end while(true)
        swap(data, leftPtr, right - 1);         // restore pivot
        return leftPtr;                 // return pivot location
    }  // end partitionIt()

    private void swap(int[] data, int index1, int index2) {

        int temp = data[index1];//put the # at index one in temp variable
        data[index1] = data[index2];//move the #at index 2 to index one
        data[index2] = temp;//now move the number being held in the temp variable into index2
    }

}
