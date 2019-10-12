package adityajoshee.Y2K19.oct;

/**
 * Created by aditya.joshee on 2019-10-02.
 */

class BstFromPreorder {
    public static void main(String[] args) {
        bstFromPreorder(new int[]{8,5,1,7});
    }
    public static TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==0) return null;
        return construct(0, preorder.length-1, preorder);
    }
    private static TreeNode construct(int ri, int max, int[] preorder){
        if(ri>=preorder.length  && ri<=max){
            return null;
        }
        TreeNode r = new TreeNode(preorder[ri]);
        Integer nextHigherIndex = nextHigherIndex(ri, max, preorder);
        if(nextHigherIndex != null){
            r.right = construct(nextHigherIndex, max, preorder);
        }
        if(nextHigherIndex!=null && ri+1 < nextHigherIndex){
            r.left = construct(ri+1, nextHigherIndex-1, preorder);
        }
        else if(nextHigherIndex==null){
            r.left = construct(ri+1, max, preorder);
        }
        return r;
    }
    private static Integer nextHigherIndex(int i, int max, int[] preorder){
        int j=i+1;
        while(j <= max){
            if(preorder[j]>preorder[i]){
                return j;
            }
            j++;
        }
        return null;
    }

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}