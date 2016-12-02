package adityajoshee.threading.chatQnA.liveEntities;

import adityajoshee.threading.chatQnA.ChatWindow;

/**
 * Created by adityajoshee on 22/05/16.
 */


// the one who answers

public class Agent implements Runnable {

    String name ;
    ChatWindow chatWindow;
    String[] s2 = { "A:Hi", "A:I am good, what about you?", "A:Great!" };

    public Agent(String name, ChatWindow chatWindow){
        this.name=name;
        this.chatWindow=chatWindow;
    }

    @Override
    public void run() {
        try{
            for (int i = 0; i < s2.length; i++) {
                chatWindow.reply(s2[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reply(){
        System.out.println("Agent replying...");
    }

    public String getName() {
        return name;
    }

    public ChatWindow getChatWindow() {
        return chatWindow;
    }

}
