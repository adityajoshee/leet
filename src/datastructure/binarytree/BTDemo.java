package datastructure.binarytree;

/**
 * Created by aditya.joshee on 30/07/14.
 */
public class BTDemo {
    public static void main(String args[]){
        BinaryNode root =BinaryTreeOps.create(5);
        BinaryTreeOps.addLeft(root, 4);
        BinaryTreeOps.addRight(root,7);
        BinaryTreeOps.addLeft(root.getLeft(), 6);
        BinaryTreeOps.addRight(root.getRight(), 2);
        BinaryTreeOps.addLeft(root.getRight().getRight(), 18);
        BinaryTreeOps.addLeft(root.getLeft().getLeft(), 1);
        BinaryTreeOps.addRight(root.getRight().getRight(), 43);


        BinaryTreeOps.printAncestors(root,1);

    }
}
