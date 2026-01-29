package org.websocketRoomManager;

import org.glassfish.tyrus.server.Server;

public class WebSocketServer {

    public static void main(String[] args) {
        Server server = new Server("localhost", 8080, "/", null, RoomWebSocket.class);

        try {
            server.start();
            System.out.println("WebSocket server running at ws://localhost:8080/ws/{room}");
            System.in.read(); // keep running
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.stop();
        }
    }
}