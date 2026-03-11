import java.net.*;
import java.io.*;

public class ClientHandler implements Runnable {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String username;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        try {

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("Enter your username:");

            username = in.readLine();

            Server.clients.put(username, this);

            System.out.println(username + " joined");

            Server.broadcast(username + " joined the chat!", this);

            String message;

            while ((message = in.readLine()) != null) {

                if (message.startsWith("/msg")) {

                    String[] parts = message.split(" ", 3);

                    if (parts.length >= 3) {

                        String targetUser = parts[1];
                        String privateMessage = parts[2];

                        Server.sendPrivateMessage(
                                targetUser,
                                "(Private) " + username + ": " + privateMessage
                        );
                    }

                }

                else if (message.equals("/users")) {

                    out.println("Online Users: " + Server.clients.keySet());

                }

                else if (message.equals("/quit")) {

                    break;

                }

                else {

                    Server.broadcast(username + ": " + message, this);

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {

            Server.removeClient(username);

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void sendMessage(String message) {

        out.println(message);

    }

}