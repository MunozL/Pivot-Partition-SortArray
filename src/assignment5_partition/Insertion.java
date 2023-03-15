/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment5_partition;

/**
 *
 * @author Lmuno
 */
class Insertion {

    public void insertionSort(int[] data, int left, int right) {
        int in, out;
        //  sorted on left out
        for (out = left + 1; out <= right; out++) {
            long temp = data[out];    // remove marked item
            in = out;                     // start shifts at out
            // until one is smaller,
            while (in > left && data[in - 1] >= temp) {
                data[in] = data[in - 1]; // shift item to right
                --in;                      // go left one position
            }
            data[in] = (int) temp;          // insert marked item
        }  // end for
        //  sorted on left of out
    }

}
