package server1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;

public class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss= new ServerSocket(1000); //create a server socket
        Socket s= ss.accept(); //accept client connnection
        System.out.println("A connection is established...");
        PrintStream ps= new PrintStream(s.getOutputStream());  //to send data to client
        BufferedReader br= new BufferedReader(new InputStreamReader(s.getInputStream())); //to receive data from client
        BufferedReader kb= new BufferedReader(new InputStreamReader(System.in)); //to accept data drom keyboard to sent to client
        while(true) //server runs continuously
        {
            String str, str1;
            while((str=br.readLine())!=null){
                System.out.println(str);
                str1= kb.readLine();
                ps.println("Server:  +str1");
            }
            s.close();
            ss.close();
            System.exit(0);
        }
        
    }
}
