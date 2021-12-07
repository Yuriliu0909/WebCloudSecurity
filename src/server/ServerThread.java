package server;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import xml.Food;
import xml.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;


/**
 * This thread is responsible to handle client connection.
 */
public class ServerThread extends Thread {
    private final Socket socket;
    private final Parser parser;

    public ServerThread(Socket s) {
        this.socket = s;
        parser = new Parser();
    }

    public void run() {
        try {
            //Client request
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String req = bufferedReader.readLine();
            System.out.println("Client asks for: "+req);
            //response
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("A client request received at " + socket);
            //pass xml
            Food food = getFoodObject(req);
            out.println(food.toString());
            socket.close();
        } catch (IOException e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }
    }

    public Food getFoodObject(String request) {
        Food food = new Food();
        ArrayList<Food> foods = parser.getFoodItems();
        for (Food f : foods) {
            if (f.getName().contains(request)) {
                food = f;
            }
        }
        return food;
    }

}