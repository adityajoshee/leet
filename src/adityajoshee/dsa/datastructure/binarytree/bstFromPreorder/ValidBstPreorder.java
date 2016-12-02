    package adityajoshee.dsa.datastructure.binarytree.bstFromPreorder;

    /**
     * Created by aditya on 11/23/16.
     */
    //TODO : test
    public class ValidBstPreorder {
        public static void main(String args[]){
            int[] preorder = {40, 30, 35, 20, 80};//{6,3,0,5,4,8,7,9};//{3,2,5,1,7};
            System.out.println(isBstPossible(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, preorder.length-1));
        }

        /*
        li is root of current subtree
        ri is the index of the last element in the current subtree
        min, max range for the elements of current subtree
         */
        private static boolean isBstPossible(int[] preorder, int min, int max, int li, int ri){
            if (li==ri && preorder[li]>min && preorder[li]<max){ // if single node subtree...
                return true;
            }
            if (preorder[li]<=min || preorder[li]>=max ){ // if node value out of range
                return false;
            }
            int lsi = preorder[li+1]<preorder[li]?li+1:-1; // left subtree root index (-1 if no left subtree exits for node li)
            int rsi = findNextHigherElementIndex(preorder, li, ri); // right subtree root index (-1 if no right subtree exists for node li)

            boolean isLeftValid = (lsi==-1 || isBstPossible(preorder, min, preorder[li], lsi, rsi-1>lsi?rsi-1:lsi));
            boolean isRightValid =  (rsi==-1 || isBstPossible(preorder, preorder[li], max, rsi, ri));
            return isLeftValid && isRightValid;
        }

        private static int findNextHigherElementIndex(int[] preorder, int li, int ri){
            int x = -1; // -1 if no higher element on right side of li
            for (int i = li+1; i <= ri ; i++) {
                if (preorder[i]>preorder[li]){
                    x = i;
                    break;
                }
            }
            return x;
        }
    }