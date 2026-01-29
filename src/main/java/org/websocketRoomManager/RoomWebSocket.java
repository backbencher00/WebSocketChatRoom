package org.websocketRoomManager;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.Set;

@ServerEndpoint("/ws/{room}")
public class RoomWebSocket {

    @OnOpen
    public void onOpen(Session session, @PathParam("room") String room) {
        RoomManager.joinRoom(room, session);
        System.out.println("Client joined room: " + room);
    }

    @OnMessage
    public void onMessage(String message, Session sender,
                          @PathParam("room") String room) throws IOException {
        String formatted = "Message in room [" + room + "]: " + message;
        System.out.println(formatted);

        for (Session client : RoomManager.getRoom(room)) {
            if (client.isOpen()) {
                client.getBasicRemote().sendText(formatted);
            }
        }
    }

    @OnClose
    public void onClose(Session session, @PathParam("room") String room) {
        RoomManager.leaveRoom(room, session);
        System.out.println("Client left room: " + room);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }
}