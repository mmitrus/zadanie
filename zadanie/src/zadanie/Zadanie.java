/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mmitrus
 */
public class Zadanie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String path = args[0];
        try {
          File(path);  
        } catch (IOException e) {
        }
        
    }
    
   public static void File(String filePath) throws IOException {
  FileReader fileReader = new FileReader(filePath);
  BufferedReader bufferedReader = new BufferedReader(fileReader);
  int foundIndexAmount;
  int foundIndexSep;
  String val;
  String kwota;
  String kwota2;
  BigDecimal suma = new BigDecimal(0);
  Map<String, Integer> kwotaOp = new HashMap<String, Integer>();
  
  try {
    String textLine = bufferedReader.readLine();
    do {
      
      
      foundIndexAmount = textLine.indexOf("@amount", 0);
  
      
      if (foundIndexAmount>0) { 
      val = textLine.substring(foundIndexAmount+1);
      
      foundIndexSep = val.indexOf(":", 0);
      if (foundIndexAmount>0) { 
      kwota = val.substring(foundIndexSep+1);
    BigDecimal kwotaD = new BigDecimal(0);
          kwotaD =  BigDecimal.valueOf(Double.parseDouble(kwota.replace("PLN", "").replace(",",".")));
            
      suma = suma.add(kwotaD);
   
              }
     
      }
  
      textLine = bufferedReader.readLine();
    } while (textLine != null);
  } finally {
    bufferedReader.close();
  }
  System.out.println(suma);
}
    
}


