package adityajoshee.dsa.datastructure.binarytree;

/**
 * Created by aditya.joshee on 6/18/17.
 */
public class SortedArrayToBBST {
    public static void main(String args[]){
        int[] sortedArr = {0,1,2,4,6,7,9};
        BinarySearchTreeOps.inOrder(createBBST(sortedArr));
    }
    private static BinaryNode createBBST(int[] sortedArr){
        return null;//TODO
    }
}
