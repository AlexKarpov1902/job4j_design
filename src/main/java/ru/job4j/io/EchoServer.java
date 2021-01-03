package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        boolean isExit = false;
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!isExit) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        if (str.contains("GET")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            if (str.contains("msg=Exit")) {
                                out.write("Buy.".getBytes());
                                isExit = true;
                            } else if (str.contains("msg=Hello")) {
                                out.write("Hello, dear friend.".getBytes());
                            } else {
                                out.write("What".getBytes());
                            }
                        }
                        System.out.println(str);
                        str = in.readLine();
                    }
                }
            }
        }
    }
}