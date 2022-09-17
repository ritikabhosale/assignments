package com.tw.step.assignment4;

import java.util.ArrayList;
import java.util.List;

public class Notifier {
    private final List<Receiver> receivers;

    Notifier() {
        this.receivers = new ArrayList<>();
    }

    public void notifyReceivers(String lotId, double spaceOccupied) {
        for (Receiver receiver : this.receivers) {
            if (receiver.receiveNotificationOn(lotId, spaceOccupied)) {
                receiver.receive(lotId, spaceOccupied);
            }
        }
    }

    public void register(Receiver receiver) {
        this.receivers.add(receiver);
    }
}
