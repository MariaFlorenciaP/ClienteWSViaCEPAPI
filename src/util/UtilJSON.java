
package util;

import java.io.BufferedReader;
import java.io.IOException;


public class UtilJSON {
    
    public static String jsonToString(BufferedReader bufferedReader) throws IOException{
        String resposta, jsonToString = "";
        
        while((resposta = bufferedReader.readLine()) != null){
           jsonToString += resposta; 
        }
        
        return jsonToString;
        
    }
    
}
