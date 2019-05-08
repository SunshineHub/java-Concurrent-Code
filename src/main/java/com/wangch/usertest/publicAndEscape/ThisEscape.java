package com.wangch.usertest.publicAndEscape;

public class ThisEscape {
    Long time;
    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            public void onEvent(Event e) {
                doSomething(e);
            }
        });
        this.time = System.currentTimeMillis();
    }


    void doSomething(Event e) {
        System.out.println(this.time);
    }


    interface EventSource {
        void registerListener(EventListener e);
    }


    interface EventListener {
        void onEvent(Event e);
    }


    interface Event {

    }
}

