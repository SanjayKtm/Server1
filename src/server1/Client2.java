
package server1;

import java.io.*;
import java.net.*;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket s= new Socket("192.168.1.22" ,1011);//create a client socket
        DataOutputStream dos= new DataOutputStream(s.getOutputStream()); //to send data to server
        
        //to receive data from server
        BufferedReader br= new BufferedReader(new InputStreamReader(s.getInputStream()));
        
        //to read data from keyboard to send to server
        BufferedReader kb= new BufferedReader(new InputStreamReader(System.in));
        //now communicate with server
        
        String str, str1;
        while(!(str= kb.readLine()).equals("exit")){
            dos.writeBytes("Client: "+str+"\n");
            str1=br.readLine();
            System.out.println(str1);
        }
        s.close();
    }
}
