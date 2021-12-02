package server;

import GUI.ServerUI;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
     * A TCP server that runs on port 9090.  When a client connects, it
     * sends the client the current date and time, then closes the
     * connection with that client.  Arguably just about the simplest
     * server you can write.
     */
    public class ServerEnd {
    static ServerUI s;

    public ServerEnd(ServerUI s) throws IOException {
            int port = 9090;
            ServerSocket listener = new ServerSocket(port);
            System.out.println("Server started on 9090");
            //accept
            Socket socket = listener.accept();
            new ServerThread(socket).start();
            listener.close();
        }

        /**
         * Runs the server.
         */
        public static void main(String[] args) throws IOException {
            new ServerEnd(s);
        }
}
