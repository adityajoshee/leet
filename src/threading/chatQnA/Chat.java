package threading.chatQnA;

import threading.chatQnA.liveEntities.Agent;
import threading.chatQnA.liveEntities.Customer;

/**
 * Created by adityajoshee on 22/05/16.
 */
public class Chat {
    public static void main(String args[]){
        ChatWindow chatWindow= new ChatWindow(); // shared resc
        Agent agent = new Agent("FoodPanda",chatWindow);
        Customer customer = new Customer("Aditya", chatWindow);
        Thread agentThread = new Thread(agent);
        Thread customerThread = new Thread(customer);
        agentThread.start();
        customerThread.start();
    }
}
