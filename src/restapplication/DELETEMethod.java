/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author informatica
 */
public class DELETEMethod 
{
    public DELETEMethod(String Id)
    {
        try 
        {
            URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees/"+Id); //connessione all'url fornito
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //viene aperta la connessione 
            conn.setRequestMethod("DELETE"); //viene definito il metodo utilizzato
            conn.setRequestProperty("Content-Type", "application/json"); //viene definito il tipo di file che il server deve fornire in risposta
            
            if (conn.getResponseCode() != 200) //controlla se il codice della risposta è diverso da 200
            {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            else
            {
                System.out.println("Cancellazione effettuata!!");
            }
            conn.disconnect(); //chiusura della connessione
        }
        catch (MalformedURLException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
    }
}
