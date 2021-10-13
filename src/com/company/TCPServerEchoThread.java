package com.company;

import java.io.*;
import java.net.*;

public class TCPServerEchoThread extends Thread {
    private Socket socket;

    public TCPServerEchoThread(Socket socket) {
        super();
        this.socket = socket;
    }

    public void run() {
        //System.setProperty("line.separator", "\r\n"); // Mac users only
        try {
            String thread_ID = Long.toString(currentThread().getId());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String line;
            String xLine;
//            String echo_line;

            out.println(21415);
            out.println(290538);
            line = in.readLine();
            System.out.println(line);
            xLine = in.readLine();
            System.out.println(xLine);
            out.println(line + xLine);
            System.out.println(line + xLine);
//            line = in.readLine();
//            if (line != null) {
//                System.out.println("THREAD " + thread_ID + " received: " + line);
//                echo_line = "ECHO: " + line;
//                System.out.println("THREAD " + thread_ID + " returning: " + echo_line);
//                out.println(echo_line);
//
//
//
//
//            }
        } catch (IOException e1) {
            System.out.println("No I/O");
            // do nothing
        }

        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("No I/O");
            // do nothing
        }
    }
}