package com.zyl.usertest.publicAndEscape;

public class Main {
    public static void main(String[] args) {
        ThisEscape.EventSource eventSource = new ThisEscape.EventSource() {
            @Override
            public void registerListener(ThisEscape.EventListener e) {

            }
        };
        ThisEscape thisEscape = new ThisEscape(eventSource);

        SafeListener.EventSource eventSource1 = new SafeListener.EventSource() {
            @Override
            public void registerListener(SafeListener.EventListener e) {

            }
        };
        SafeListener safeListener = SafeListener.newInstance(eventSource1);
    }
}
