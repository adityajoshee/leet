package adityajoshee.threading.chatQnA;

/**
 * Created by adityajoshee on 22/05/16.
 */


// Shared Resource
public class ChatWindow {

    private static boolean hasAgentAnswered = true;

    public synchronized void ask(String msg) throws Exception{
        if(!hasAgentAnswered){
            wait();
        }
        System.out.println(msg);
        Thread.sleep(500);
        hasAgentAnswered=false;
        notify();
    }
    public synchronized void reply(String msg) throws Exception{
        if (hasAgentAnswered){
            wait();
        }
        System.out.println(msg);
        Thread.sleep(1000);
        hasAgentAnswered=true;
        notify();
    }
}
