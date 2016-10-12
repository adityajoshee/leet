package datastructure.tree;

/**
 * Created by aditya on 7/25/16.
 */
public class BinaryNode {

    private int data;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(int data){
        this.data = data;
    }
    public BinaryNode(){
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public BinaryNode setLeft(int leftValue){
        this.left = new BinaryNode(leftValue);
        return this.left;
    }

    public BinaryNode setRight(int rightValue){
        this.right = new BinaryNode(rightValue);
        return this.right;
    }

    public String toString(){
        return this==null?null:data+"";
    }
}
