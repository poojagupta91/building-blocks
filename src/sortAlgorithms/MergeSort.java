package sortAlgorithms;

import java.io.FileReader;
import java.io.IOException;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] array ={ 37, 7, 2, 14, 35, 47, 10, 24, 44, 17, 34, 11, 16, 48, 1, 39, 6, 33, 43, 26, 40, 4, 28, 5, 38, 41, 42, 12, 13, 21, 29, 18, 3, 19, 0, 32, 46, 27, 31, 25, 15, 36, 20, 8, 9, 49, 22, 23, 30, 45 };
		//int[] array = readArray();
		int size = array.length;
		long inv_count = mergeSort(array,1,size);
		System.out.println("Inversion count : " + inv_count);
		printResult(array);
	}
	
	public static long mergeSort(int[] array, int p, int r){
		long inv_count = 0;
		if(p < r){
			int q = (p+r)/2;
			inv_count += mergeSort(array, p, q);
			inv_count += mergeSort(array, q+1, r);
			inv_count += merge(array,p,q,r);
		}
		return inv_count;
	}
	
	public static long merge(int[] array,int p,int q,int r){
		int n1 = q-p+1;
		int n2 = r-q;
		int i,j;
		int[] left = new int[n1];
		int[] right = new int[n2];
		long inv_count = 0;
		
		for(i=0;i < n1; i++){
			left[i] = array[p+i-1];
		}
		for(j=0;j < n2; j++){
			right[j] = array[q+j];
		}
		i=0;j=0;
		
		int k=p-1;
			while(i<n1 && j< n2){
				if(left[i] <= right[j]){
					array[k] = left[i];
					i++;
				}
				else{
					array[k] = right[j];
					j++;
					inv_count = inv_count + n1-i;
				}
				k++;
			}
			
		while (i<n1){
			array[k]= left[i];
			k++;
			i++;
		}
		
		return inv_count;
	}
	
	public static void printResult(int[] array){
		System.out.println("Sorted Array : ");
		for(int k=0;k<array.length;k++){
			System.out.print(array[k] + " ");
		}
		System.out.println();
	}
	
	public static int[] readArray(){
		int [] array = new int[100000];
		try {
			FileReader file = new FileReader("C:\\Users\\POOJA\\Documents\\GitHub\\building-blocks\\IntegerArray.txt");
			java.util.Scanner scan = new java.util.Scanner(file);
			int i = 0;
			while(scan.hasNextInt()){
				array[i] = scan.nextInt();
				i++;
			}
			scan.close();
			System.out.println(i);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return array;
	}
}
