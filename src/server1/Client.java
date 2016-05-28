
package server1;

import java.net.Socket;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s= new Socket("localhost", 777);
        InputStream obj= s.getInputStream();
        BufferedReader br= new BufferedReader(new InputStreamReader(obj));
        String str;
        while((str=br.readLine())!=null){
            System.out.println(str);
        }
        s.close();
        br.close();
    }
}
