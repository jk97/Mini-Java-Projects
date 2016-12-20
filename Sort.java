import java.util.*;
public class Sort{	
	public static int[] toSort;
	
	public static void main(String[] args){
      Scanner console = new Scanner(System.in);

      int[] arr1 = new int[10];

      for(int i = 0; i < arr1.length; i++) {

            arr1[i] = console.nextInt();
      }
      Sort test1 = new Sort(arr1);
      test1.bubbleSort();
      System.out.println();

      Sort test2 = new Sort(arr1);
      test2.selectionSort();
      System.out.println();

      Sort test3 = new Sort(arr1);
      test3.insertionSort();
      System.out.println();

      Sort test4 = new Sort(arr1);
      test4.mergeSort();
      System.out.println();
	}

	public Sort ( int[] arr){
		this.toSort = new int[arr.length];
		for ( int i = 0; i < arr.length; i++){
			this.toSort[i] = arr[i];
		}
	}

	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void bubbleSort(){
		
		for ( int j = 0 ; j < toSort.length; j++){
			for (int i = 0 ; i < toSort.length - 1; i++){
				if ( toSort[i] >= toSort[i + 1]){
					swap( toSort, i, i + 1); 
				} else if ( toSort[i] < toSort[i+1]){
				}
				if (i == toSort.length - j - 2){	
					print(toSort);
				}
				
			}
		}
		
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	public static int[] mergeSort2(int[] toSort){
	if ( toSort.length > 1){
			int[] left = Arrays.copyOfRange(toSort, 0, toSort.length / 2);
			int[] right = Arrays.copyOfRange(toSort, toSort.length / 2, toSort.length);
			
			mergeSort2(left);
			mergeSort2(right);
			
			merge(toSort, left, right);
		}		
		return toSort;
	}
	
	public static void mergeSort(){
		if ( toSort.length > 1){
			int[] left = Arrays.copyOfRange(toSort, 0, toSort.length / 2);
			int[] right = Arrays.copyOfRange(toSort, toSort.length / 2, toSort.length);
			
			mergeSort2(left);
			mergeSort2(right);
			
			merge(toSort, left, right);
		}
		print(toSort);
}
	
	public static int[] merge(int[] toSort, int[] left, int[] right){
		int x = 0;
		int y = 0;
		for ( int i = 0; i < toSort.length; i++){
			if(y >= right.length || (x < left.length && left[x] <= right[y])){
				toSort[i] = left[x];
				x++;
			} else {
				toSort[i] = right[y];
				y++;
			}
		}
		return toSort;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	

	
	public void selectionSort() {
		for(int k = 0; k < toSort.length - 1; k++) {
			swap(toSort, k, smallest(toSort, k));
			print(toSort);
		}
	}

	public int smallest(int[] toString, int start) {
		int hold = start;
		for(int i = start + 1; i < toString.length; i++) {
			if(toString[i] < toString[hold]) {
				hold = i;
			}
		}
		return hold;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void insertionSort(){
		for(int i = 0; i < toSort.length;i++){
			int temp = toSort[i];
			int tempplace = i;
			for ( int j = i - 1; j >= 0; j--){ //check sorted front
				if(i == 0 ){		//front doesn't need to be sorted
				
				} else if ( toSort[tempplace] < toSort[j] && tempplace != j){
					toSort = swap(toSort, tempplace, j);
					tempplace--;
				} 				
			}
		if ( i != 0){	
			print(toSort);
		}
			
		}
	}
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static int[] swap (int[] toSort1, int i1, int i2){
		int swap = toSort1[i1];
		toSort1[i1] = toSort1[i2];
		toSort1[i2] = swap;
		return toSort1;
	}
	
	
	
	
	
	public static void print(int[] toPrint){
		System.out.print("[");
		for (int i = 0; i < toPrint.length; i++){
			if ( i == toPrint.length - 1){
				System.out.print( toPrint[i]  );
			} else{
			System.out.print( toPrint[i] + ", " );
			}
		}
		System.out.println("]" );
	}
	
	
	
}
