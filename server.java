import java.net.*;
import java.io.*;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);  // server listening on port 1234
        System.out.println("Server started. Waiting for client...");
        Socket socket = server.accept(); // wait for client to connect
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String msgFromClient;
        while ((msgFromClient = in.readLine()) != null) {
            System.out.println("Client: " + msgFromClient);
            System.out.print("You: ");
            String reply = keyboard.readLine();
            out.println(reply);
        }

        socket.close();
        server.close();
    }
}
