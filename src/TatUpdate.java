import datastructure.binarytree.BinaryNode;

import java.io.Serializable;

/**
 * Created by aditya.joshee on 07/08/14.
 */
public class TatUpdate extends BinaryNode implements Serializable
{
    public static void main(String args[]){
        for(int i=1;i<7100000;i=i+10001){
            System.out.println("update tat_data set tat_time_in_hours=tat_time_in_hours+24,last_modified_on=now() where service_type='NORMAL' and id between "+i+ " and "+(i+10000)+";");
        }
    }
    private void get(){
        System.out.println(getClass());
        System.out.println(getClass().getSuperclass());
        System.out.println(getClass().getGenericSuperclass());


    }

}
