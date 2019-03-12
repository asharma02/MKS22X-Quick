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
    Random random = new Random();
	  int randomindex = random.nextInt(end - start + 1);
	  int pivot = randomindex; //pivot is random
    swap(data, pivot, start);
	  int wherepart = start; //where you are partitioning from, begin with the start index
	  for (int i = start; i <= end - 1; i++) {  //begin at start, loop through end
	    if (data[i] < data[pivot]) { //if it is less than the pivot
	      swap(data, i, wherepart); //swap the partition and the index you are at
	      wherepart++; //move up the partition(the start)
	    }
	  }
	  swap(data, wherepart, end);
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
   int part = partition(data, 0, data.length - 1) ; //get partition, start at 0, end at the end index
   while (part != k) { //until the partition and wanted index are not the same
     if (k > part) {
       part = partition(data, part, data.length - 1);
     }//if its larger, update the partition by starting at the current part RIGHT SIDE
     else {//if its less,  update partiion by ending at current part LEFT SIDE
       part = partition(data, 0, part);
     }
   }
   return data[part]; //return the k smallest which will be at the partition index
 }

 public static void main(String[] args) {
    int[]ary = {2, 10, 15, 23, 0, 5} ;
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
