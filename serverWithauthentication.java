/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp_network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class server {
   public static ServerSocket serversoket ; 
   public static final int port = 55555 ; 
   
   public static void main(String[] args)
   {
       try{
             serversoket = new ServerSocket(port);
             System.out.println("connection up ");
       }
       catch(IOException e )
       {
           System.out.println("the port isn't avilable ");
           System.exit(1);
       }
       while(true)
       {
           handelconnection();
       }
   }
       public static void handelconnection() 
       {
           Socket link = null ; 
           
           try
           {
               link = serversoket.accept();
               Scanner input = new Scanner(link.getInputStream()); // recive  from client 
               PrintWriter output = new PrintWriter(link.getOutputStream(), true); // send to client 
              boolean found = true ; 
                while(found)
                {
               String username = input.nextLine();
               String password = input.nextLine();
               int num = 0 ; 
               if(username.equals("anyuser") && password.equals("password"))
               {
                   output.println("hi login suc");
                   String msg = input.next();
                   found = false ; 
                while(!msg.equals("**hh**"))
               {
                   System.out.println("message received");
                   num++;
                   output.println("the message is: " + msg + "  message numbber: " + num);
                      msg = input.nextLine();
               }
               }
               else 
               {
                  output.println("username or password is not correct please try againe");
                  found = true ; 
                  
               }
                }
               
           }
           catch(IOException e )
           {
               System.exit(1);
           }
           finally{
               try {
                   link.close();
               } catch (IOException ex) {
                   Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
                   System.exit(1);
               }
           }
       }
               
      
   }


