package com.wol.systens.client;

import com.wol.systens.notification.INotification;

public class Client {
    private INotification notification;

    public Client(INotification notification) {
        this.notification = notification;
    }

    public void notification() {
        notification.send();
    }
}
