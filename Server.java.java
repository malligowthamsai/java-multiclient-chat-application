import java.net.*;
import java.io.*;
import java.util.*;

class Server {

    private static final int PORT = 1234;

    static Map<String, ClientHandler> clients = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("Chat Server Started...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            while (true) {

                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                ClientHandler client = new ClientHandler(socket);
                new Thread(client).start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void broadcast(String message, ClientHandler excludeUser) {

        for (ClientHandler client : clients.values()) {

            if (client != excludeUser) {
                client.sendMessage(message);
            }

        }
    }

    public static void sendPrivateMessage(String username, String message) {

        ClientHandler client = clients.get(username);

        if (client != null) {
            client.sendMessage(message);
        }
    }

    public static void removeClient(String username) {

        clients.remove(username);
        broadcast(username + " left the chat.", null);

    }

}