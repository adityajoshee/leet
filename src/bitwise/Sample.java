package bitwise;

/**
 * Created by aditya on 9/24/16.
 */

// approach to generate object uid for sharded databases.
public class Sample {
    public static void main(String args[]){
        int shardId = 3429;
        int typeId = 1;
        int localId = 7075733;

        System.out.println(Long.toBinaryString(shardId));
        System.out.println(Long.toBinaryString(typeId));
        System.out.println(Long.toBinaryString(localId));

        int uid =  shardId << 46 | typeId << 36 | localId << 0;
        System.out.println(Long.toBinaryString(uid));
        System.out.println(uid);
    }
}