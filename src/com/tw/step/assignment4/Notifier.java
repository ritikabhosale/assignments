package com.tw.step.assignment4;

import java.util.ArrayList;

public class Notifier {
    private final ArrayList<Receiver> receivers;

    Notifier(ArrayList<Receiver> receivers) {
        this.receivers = receivers;
    }

    public void notifyReceivers(String lotId, double spaceOccupied) {
        for (Receiver receiver : this.receivers) {
            receiver.receive(lotId, spaceOccupied);
        }
    }
}
