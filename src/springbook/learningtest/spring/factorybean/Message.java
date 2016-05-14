package springbook.learningtest.spring.factorybean;

/**
 * Created by kjnam on 2016. 5. 14..
 */
public class Message {
    String text;

    private Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Message newMessage(String text) {
        return new Message(text);
    }
}
