package adityajoshee.dsa.array;

// Find an element in a rotated array
// Need log(N) approach


public class FindInRotatedArray {
	public static void main(String[] args){
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++){
			arr[i]=i;
		}
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();

		rotateArray3(arr,3);

		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();

		for(int i=0;i<arr.length;i++)
			System.out.println(find(arr,i));
	}

	private static int find(int[] arr, int x){
		System.out.println("Finding "+x);
		int l = 0, r = arr.length-1;
		return modBinarySearch(arr,l,r,x);
	}

	private static int modBinarySearch(int[] arr, int l, int  r, int x){
		while(l<=r){
			int mid = l + (r-l)/2;

			if(arr[mid]==x){
				return mid;
			}
			if(arr[l]<=arr[mid]){
				// left part is sorted
				if(x>=arr[l] && x<arr[mid]){
					r = mid-1;
				}
				else{
					l = mid+1;
				}
			}
			else{
				// right part is sorted
				if(x>arr[mid] && x<=arr[r]){
					l = mid+1;
				}
				else{
					r = mid-1;
				}
			}
		}
		return -1;
	}


	// shift elements one by one using temp variable for last element. O(n*r) time
	private static boolean rotateArray1(int[] list,int r){
		while(r-->0){
			int tmp = list[list.length-1];
			for(int i=list.length-1;i>0;i--){
				list[i]=list[i-1];
			}
			list[0]=tmp;
		}
		return true;
	}

	// using extra space O(N) and O(N) time
	public static int[] rotateArray2(int[] arr,int r){
		int[] output = new int[arr.length];
		for(int i: arr){
			int newIndex = (i+r)%(arr.length);
			output[newIndex] = arr[i];
		}
		return output;
	}

	// double reverse..first reverse in pair 0 to n-d and n-d+1 to n-1
	public static void rotateArray3(int[] arr, int d){
		reverse(arr,0,arr.length-d-1);
		reverse(arr,arr.length-d,arr.length-1);
		reverse(arr, 0, arr.length-1);
	}

	//reverse input array
	public static void reverse(int[] arr, int l, int r){
		while(l<r){
			int t = arr[l];
			arr[l] = arr[r];
			arr[r] = t;
			l++;r--;
		}
	}

}
