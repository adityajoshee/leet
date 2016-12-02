package adityajoshee.dsa.array;

/**
 * Created by aditya on 8/12/16.
 */

// element is called majority element if freq > n/2
public class MajorityElement {
    public static void main(String args[]){
        int[] arr = new int[]{1,2,3,3,2};
        System.out.println(findMajorityElement(arr));
    }

    private static int findMajorityElement(int[] arr){
        int major = arr[0];
        int count = 1;

        for(int i=1; i<arr.length; i++){
            if(arr[i]==major){
                count++;
            }
            else{
                if(count==0){
                    if(i+1==arr.length){ // element at i was the last element so no major
                        return -1;
                    }
                    major = arr[i+1]; // major will be the next element
                    count=1;
                }
                else{
                    count--;
                }
            }
        }
        if(count>0){
            return findCount(arr,major);
        }
        return -1;
    }

    private static int findCount(int[] arr, int candidate){
        int count = 0;
        for(int i:arr){
            if(i==candidate){
                count++;
            }
        }
        if(count>arr.length/2){
            return candidate;
        }
        return -1;
    }
}
