package comp_network;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class client {
    public static InetAddress host ; 
    public static final int port = 55555;
    
    public static void main(String[] args) 
    {
        try
        {
            host = InetAddress.getLocalHost() ; 
        }
        catch(IOException e )
        {
            System.out.println("connection failed");
            System.exit(1);
        }
        
        accessServer();
    }
    public static void accessServer()
    {
        Socket link = null ; 
        try
        {
            boolean found = true ;
            link = new Socket(host,port);
            Scanner input = new Scanner(link.getInputStream());
            PrintWriter output = new PrintWriter(link.getOutputStream() , true);
            Scanner usinput = new Scanner(System.in);
            String username , password,msg , resp ; 
            while(found)
            {
                System.out.println("enter username  ");
                username  = usinput.nextLine();
                System.out.println("enter password  ");
                 password = usinput.nextLine();
                 output.println(username);
                 output.println(password);
                 username = input.nextLine();
                 if(username.equals("hi login suc"))
                 {
                     found = false ; 
            do
            {
                System.out.print("please enter your message:  ");
                 
                 msg = usinput.nextLine();
                 output.println(msg);
                 resp = input.nextLine();
                 System.out.println(resp);
                 
            }while(!msg.equals("**hh**"));  
                 }
                 else 
                 {
                     System.out.println("username or password is incorrect try againe");
                     found = true ;
                 } 
            }
        }catch(IOException e )
        {
            System.exit(1);
        }
        finally
        {
             System.out.println("connection end sucessfully ");
            try {
                link.close();
            } catch (IOException ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("connection closed");
                System.exit(1);
            }
        }
    }
}
