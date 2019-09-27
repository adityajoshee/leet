package adityajoshee.Y2K19;

/**
 * Created by aditya.joshee on 2019-08-27.
 */
public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{1, 2, 1, 5, 7, 9}));
    }

    private static boolean canJump(int[] nums) {
        int range = 0;
        for(int i=0; i<=range; i++){
            if(i+nums[i]>range){
                //increase the range
                range = i+nums[i];
                if(range>=nums.length-1){
                    return true;
                }
            }
        }
        return false;
    }
}
