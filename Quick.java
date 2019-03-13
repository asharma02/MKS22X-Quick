import java.util.* ;
import java.io.* ;


public class Quick {

  /*Choose a random pivot element between the start and end index inclusive,
 Then modify the dataay such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding
 *   element is designated the pivot element.
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */
public static int partition (int [] data, int start, int end){
  int pivot = end;//set pivot to one side
  int part = start; //set start index
  for (int i = start; i <= end - 1; i++) { //loop through array
    if (data[i] < data[pivot]) { //if the current is less than the pivot
      swap(data, i, part);//swap the current with the start
      part++; //add to the partition
    }
  }
  swap(data, part, pivot); //switch the pivot back to the partition
  return part; //this will be the pivot that was moved
}

//private method to swap two indicies
private static void swap(int[] data, int first, int second) {
  int temp = data[first];
  data[first] = data[second];
  data[second] = temp;
}

/*return the value that is the kth smallest value of the dataay.
 */
 public static int quickselect(int []data, int k){
   return quickselecth(data, 0, data.length - 1, k); //call helper method with start = 0 and end = last index
 }

 private static int quickselecth(int[] data, int start, int end, int k) {
   if (start == end) {
            return data[start];
    } //if the start and end are the same, return that value
    int pivot = partition(data, start, end); //partition it
    if (pivot == k) {
      return data[pivot];
    } //when the pivot is the same as k, return the value at the pivot
    if (k < pivot) {
      return quickselecth(data, start, pivot - 1, k);
    } //if it is less, look at the left side of the of the pivot
    else {
      return quickselecth(data, pivot + 1, end, k); //if it is greater, look at the right side of the pivot
    }
 }



 public static void main(String[] args) {
    int[]ary = {2, 10, 15, 23, 0, 5, 2, 2, 2} ;
   System.out.println(quickselect(ary, 0)) ;
   System.out.println("Expected: 0\n\n") ;
  System.out.println(quickselect(ary, 1)) ; // would return 2
  System.out.println("Expected: 2\n\n") ;
  System.out.println(quickselect(ary, 2)) ; // would return 5
  System.out.println("Expected: 5\n\n") ;
  System.out.println(quickselect(ary, 3)) ; // would return 10
  System.out.println("Expected: 10\n\n") ;
  System.out.println(quickselect(ary, 4)) ; // would return 15
  System.out.println("Expected: 15\n\n") ;
  System.out.println(quickselect(ary, 5)) ; // would return 23
  System.out.println("Expected: 23\n\n") ;
 }




}
