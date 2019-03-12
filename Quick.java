import java.util.* ;
import java.io.* ;


public class Quick {

  /*Choose a random pivot element between the start and end index inclusive,
 Then modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding
 *   element is designated the pivot element.
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */
public static int partition ( int [] data, int start, int end){
  int extent = end - start + 1; //length of data
  int pivot = (int)Math.abs(Math.random() * extent); //get random
  pivot += start; //add pivot to start (at beginning it will be 0)
  swap(data, pivot, start); //swap the pivot and start
  int original = data[start]; //store the original start (pivot)
  pivot = start; //set pivot equal to start
  start++ ; //init start
  while (start <= end) { //runs until the end
     if (data[start] > original) { //if its larger
       swap(data, end, start); //swap end with current start
       end-- ; //make end lower
     }
     else if (data[start] < original) { //if its smaller
       swap(data, start, pivot) ; //swap start with pivot
       start++; //index through start
       pivot++; //index through pivot
     }
     else {
       start++;  //if it is the same, just add to start
     }
   }
   return pivot; //return the end pivot you get
}

//private method to swap two indicies
private static void swap(int[] data, int first, int second) {
  int temp = data[first];
  data[first] = data[second];
  data[second] = temp;
}

/*return the value that is the kth smallest value of the array.
 */
 public static int quickselect(int []data, int k){
   int part = partition(data, 0, data.length - 1) ; //get partition, start at 0, end at the end index
   while (part != k) { //until the partition and wanted index are not the same
     if (k > part) {
       part = partition(data, part, data.length - 1);
     }//if its larger, update the partition by starting at the current part RIGHT SIDE
     else {//if its less,  update partiion by ending at current part LEFT SIDE
       part = partition(data, 0, part) ;
     }
   }
   return data[part]; //return the k smallest which will be at the partition index
 }




}
