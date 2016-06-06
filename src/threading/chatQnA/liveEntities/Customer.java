package threading.chatQnA.liveEntities;

import threading.chatQnA.ChatWindow;

/**
 * Created by adityajoshee on 22/05/16.
 */

// the one asks
public class Customer implements Runnable{
    String name ;
    ChatWindow chatWindow;
    String[] s1 = { "C:Hi", "C:How are you ?", "C:I am also doing fine!" };


    public Customer(String name, ChatWindow chatWindow){
        this.name=name;
        this.chatWindow=chatWindow;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < s1.length; i++) {
                chatWindow.ask(s1[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ask(){
        System.out.println("Customer asking...");
    }

    public String getName() {
        return name;
    }

    public ChatWindow getChatWindow() {
        return chatWindow;
    }

}
