/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo;

import java.util.ArrayList;

/**
 *
 * @author 160317J
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.MILLIS;

class GameDemo {
    
    /**
     * @param args the command line arguments
     */
    private static final String FILENAME = "C:\\Users\\admin\\Desktop\\GameLog.txt";
    
    static ArrayList<Inhabitants> al=new ArrayList<>();
    static LocalDateTime start; //Start time
    static LocalDateTime end; //End time
    static DateTimeFormatter dtf; //date time format
    
    public static void main(String[] args) {
        
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        
        start = LocalDateTime.now(); //start time
        Controller c = new Controller();        
        System.out.println("\n");       
    }
    public static void gameEnd(String result){
        
        end = LocalDateTime.now();//end time
        String duration=String.valueOf(MILLIS.between(start, end));            
        String logEntry="Game start: "+dtf.format(start)+" , End: " + dtf.format(end) + " , Result: "+result+" , Duration: "+duration+"ms.";
        writeRec(logEntry);
    }
    public static void writeRec(String logEntry){
        BufferedWriter bw = null;
	FileWriter fw = null;

        try {
		File file = new File(FILENAME);
		if (!file.exists()){   //create file if doesnt exist
                    file.createNewFile();
		}

		fw = new FileWriter(file.getAbsoluteFile(), true);
		bw = new BufferedWriter(fw);

		bw.write(logEntry);
                bw.newLine();
	} 
        catch (IOException e){
		e.printStackTrace();
	} 
        finally{
		try{
                    if (bw != null)
                    bw.close();

                    if (fw != null)
                    fw.close();
                }
                catch (IOException ex){
                    ex.printStackTrace();
                }
        }
        
    }
    
}
    

