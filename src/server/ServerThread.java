package server;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import xml.BreakfastMenu;
import xml.Document;
import xml.Food;
import xml.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.net.*;
import java.util.ArrayList;


/**
 * This thread is responsible to handle client connection.
 *
 */
public class ServerThread extends Thread{
    Socket socket;
    public ServerThread(Socket s) {
        this.socket = s;
    }

    public void run()
    {
        try {
            //response
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("A client request received at "+socket);
            //pass xml
            Parser parser=new Parser();
            out.println("Server says: "+ parser.createXML());
            socket.close();
        }
        catch(IOException e)
        {
            System.out.println("Error: ");
            e.printStackTrace();
        }
    }

}