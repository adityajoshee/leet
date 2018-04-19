package adityajoshee.Y2K18.apr.D14;

import adityajoshee.dsa.datastructure.tree.binary.BinaryNode;

/**
 * Created by aditya.joshee on 4/13/18.
 */
public class ParserTree {
    public static void main(String[] args) {
        String strExp = "(3+(4*5))";
        char[] expr = strExp.toCharArray();
        BinaryNode node = getParserTreeForInfixExpr(expr);
        inorder(node);
    }

    private static BinaryNode getParserTreeForInfixExpr(char[] expr) {
        BinaryNode node = new BinaryNode();
        int i = 0;
        while (i<expr.length){
            if (expr[i]=='('){
                node.setLeft(new BinaryNode(expr[i+2]));
            }
        }
        //TODO
        return  null;
    }

    public static void inorder(BinaryNode binaryNode){
        if (binaryNode==null){
            return;
        }
        inorder(binaryNode.getLeft());
        System.out.println(binaryNode.getData());
        inorder(binaryNode.getRight());
    }
}
