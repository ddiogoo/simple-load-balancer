package app;

import channel.Channel;

public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel(1000, 100000);
        channel.run();
    }
}
