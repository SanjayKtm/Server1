
package server1;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.year;
import java.io.DataInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class ReceiveMessage extends Thread{
    String msg="";
    DataInputStream dis= null;
    JTextArea txt_area= null;
    public ReceiveMessage(DataInputStream d ,JTextArea a){
        this.dis= d;
        this.txt_area=a; 
    }
    
    public void run(){
        while(true){
            try {
                Date date= new Date();
                msg=dis.readUTF();
                txt_area.append("\n"+this.getName()+":"+msg+ "           "+ date.toString());               
            } catch (IOException ex) {
                Logger.getLogger(ReceiveMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
