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
public static int selectpartition (int [] data, int start, int end){
  int pivot = end;//set pivot to one side
  int part = start; //set start index
  for (int i = start; i <= end - 1; i++) { //loop through dataay

    if (data[i] < data[pivot]) { //if the current is less than the pivot
      swap(data, i, part);//swap the current with the partiton (start at first)
      part++; //add to the partition
    }
  }
  swap(data, part, pivot); //switch the pivot back to the partition
  return part; //this will be the pivot that was moved
}


public static int partition (int [] data, int start, int end){
  if(start == end){ //check for best case
       return start;
  }
  Random random = new Random();
  int pivot = getmed(data, start, end);//set pivot to the median of the start end and middle
  swap(data, pivot, start); // move the pivot to the start
  pivot = start; //pivot value is whichside to the start
  int part = start + 1; //set partition to one index in front of the start
  while(part != end){ //run until the partition equals the end (all elements went through)
    int whichside = -50; //initialize
    if(data[part] == data[pivot]){ // if it is equal, random 50/50
      whichside = random.nextInt(2);
    }
    if(data[part] > data[pivot] || whichside == 0){ //swap it to the end (right of the partition) and lower end
      swap(data, part, end);
      end--;
    }
    else if(data[part] < data[pivot] || whichside == 1){  //otherwise, if it is less, just move on to the next one
      part++;
    }
  } //end the loop
  if(data[pivot] > data[part]){ //swap the pivot back
    swap(data, part, pivot); //if the pivot is larger, just switch
    return part;
  }
  else{
    swap(data, part - 1, pivot); //if it is one smaller, put it one behind the part
    return part - 1;
  }
}

//private method to swap two indicies
private static void swap(int[] data, int first, int second) {
  int temp = data[first];
  data[first] = data[second];
  data[second] = temp;
}

//gets the median which should be the pivot
private static int getmed(int[] data, int start, int end){
  if (data[start] > data[end] && data[start] < data[(end+start)/2]) {
    return start;
  }
  if (data[start] < data[end] && data[start] > data[(end+start)/2]) {
    return start;
  }
  if (data[end] > data[start] && data[end] < data[(end+start)/2])  {
    return end;
  }
  if (data[end] < data[start] && data[end] > data[(end+start)/2]) {
    return end;
  }
  else{
    return (end+start)/2;
  }
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

public static void quicksort(int []data){
  quicksorth(data, 0, data.length-1);
}

private static void quicksorth(int[] data, int start, int end) {
  if (start >= end) {
    return;
  }
  if (data.length <= 25) {
    insertionsort(data, start, end);
  }
  else {
  int pivot = partition(data, start, end);
  quicksorth(data, start, pivot-1);
  quicksorth(data, pivot+1, end);
}
}

private static void insertionsort(int[] data, int lo,int hi)  {
  for (int i = lo; i <= hi;i++){
    int temp = data[i]; //temp var
    int x = i;
    while (x > lo && data[x-1] > temp){ //while the number on the left is bigger
      data[x] = data[x-1];//switch
      x--;
    }
  data[x] = temp;
}
}









}
