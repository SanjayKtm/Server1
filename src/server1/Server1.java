
package server1;

import java.net.*;
import java.io.*;

public class Server1 {

    public static void main(String[] args) throws IOException {
        ServerSocket ss= new ServerSocket(777);
        Socket s= ss.accept();
        System.out.println("A connection established...");
        OutputStream obj=s.getOutputStream(); 
        PrintStream ps= new PrintStream(obj); //to send data to socket
        String str="Hello Client";
        ps.println(str);
        ps.println("Bye");
        s.close();
        ss.close();
        ps.close();
    }
    
}
