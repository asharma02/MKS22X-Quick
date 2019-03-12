
import java.util.*;

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
public int partition ( int [] data, int start, int end){
  Random random = new Random();
  int randomindex = random.nextInt(data.length);
  int pivot = randomindex; //pivot is random
  int wherepart = start; //where you are partitioning from, begin with the start index
  for (int i = start; i <= end - 1; i++) {  //begin at start, loop through end
    if (data[i] < data[pivot]) { //if it is less than the pivot
      swap(data, i, wherepart); //swap the partition and the index you are at
      wherepart++; //move up the partition(the start)
    }
  }
  swap(data, wherepart, pivot);
        // swap the partition with the part
  return wherepart; //this is the pivot you return
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
   return 0;
 }


}
