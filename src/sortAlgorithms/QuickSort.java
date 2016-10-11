package sortAlgorithms;

public class QuickSort {
	
	public static void quickSort(int[] A,int p,int r){
		if (p < r){
			int q = partition(A,p,r);
			quickSort(A,p,q-1);
			quickSort(A,q+1,r);
		}
	}
	
	public static int partition(int[] A,int p,int r){
		int x = A[r-1]; // choosing last element as pivot
		int i = p-2;
		int temp;
		
		for(int j=p-1;j<r;j++){
			if(A[j]<=x){
				i++;
				temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		temp = A[i+1];
		A[i+1] = A[r-1];
		A[r-1] = temp;
		return i+1;
	}
	
	public static void printResult(int[] array){
		System.out.println("Sorted Array : ");
		for(int k=0;k<array.length;k++){
			System.out.print(array[k] + " ");
		}
		System.out.println();
	}
	
	public static void choosePivot(int[] A, int rule){
		int temp;
		int size = A.length;
		switch(rule){
		 case 1 :  // first element is the pivot element 
			 	   temp = A[0];
			 	   A[0] = A[size-1];
			 	   A[size-1] = temp;
			 	   break;
		 case 2 : // last element is the pivot element 
			 	   break;
		 case 3 : // median is pivot 
			 	  int mid;	
			      if(size % 2 == 0){
			    	  mid = (size/2)-1;
			      }else 
			    	  mid = (size/2);
			      if(A[0] <= A[mid] && A[mid] <= A[size -1] || A[size -1] <= A[mid] && A[mid] <= A[0] ){
			    	  // mid element is the pivot
			    	  temp = A[size-1];
			    	  A[size-1] = A[mid];
			    	  A[mid] = temp;
			      }else if(A[mid] <= A[0] && A[0] <= A[size -1] || A[size-1] <= A[0] && A[0] <= A[mid]){
			    	  // first element is the pivot
			    	  choosePivot(A,1);
			      }else{
			    	  // last element is the pivot
			    	  choosePivot(A,2);
			      }
			    break;	  
		}
		
	}
	
	public static void main(String[] args) {
		int[] array ={3,9,8,4,6,10,2,5,7,1};
		int size = array.length;
		choosePivot(array, 2);
		quickSort(array, 1,size);
		printResult(array);
		//System.out.println("Comparisions :: " + cmp);

	}

}
