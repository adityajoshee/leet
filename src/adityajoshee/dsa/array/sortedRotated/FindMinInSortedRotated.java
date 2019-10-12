package adityajoshee.dsa.array.sortedRotated;

/**
 * Created by aditya.j on 5/10/19.
 */
class FindMinInSortedRotated {
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int i=0, j=nums.length-1, mid = -1;
        while(i<=j){
            mid = i+(j-i)/2;
            if(mid>0 && nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            if(mid<nums.length-1 && nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[i]<nums[j]){
                return nums[i];
            }
            if(nums[mid]<nums[j]){
                j = mid-1;
            }
            if(nums[i]<nums[mid]){
                i = mid+1;
            }
        }
        return -1;
    }
}