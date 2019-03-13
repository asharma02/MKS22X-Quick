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
public static int partition ( int [] data, int start, int end){
  int pivot = end;
  int part = start;
  for (int i = start; i <= end - 1; i++) {
    if (data[i] < data[pivot]) {
      swap(data, i, part);
      part++;
    }
  }
  swap(data, part, pivot);
  return part;
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
   return quickselecth(data, 0, data.length - 1, k);
 }

 private static int quickselecth(int[] data, int start, int end, int k) {
   if (start == end) {
            return data[start];
    }
    int pivot = partition(data, start, end);
    if (pivot == k) {
      return data[pivot];
    }
    if (k < pivot) {
      return quickselecth(data, start, pivot - 1, k);
    }
    else {
      return quickselecth(data, pivot + 1, end, k);
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
