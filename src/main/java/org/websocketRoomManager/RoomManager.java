package org.websocketRoomManager;

import jakarta.websocket.Session;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RoomManager {

    // roomId -> set of sessions
    private static final Map<String, Set<Session>> rooms = new ConcurrentHashMap<>();

    public static void joinRoom(String roomId, Session session) {
        rooms.computeIfAbsent(roomId, k -> ConcurrentHashMap.newKeySet())
             .add(session);
    }

    public static void leaveRoom(String roomId, Session session) {
        Set<Session> sessions = rooms.get(roomId);
        if (sessions != null) {
            sessions.remove(session);
            if (sessions.isEmpty()) {
                rooms.remove(roomId);
            }
        }
    }

    public static Set<Session> getRoom(String roomId) {
        return rooms.getOrDefault(roomId, Collections.emptySet());
    }
}