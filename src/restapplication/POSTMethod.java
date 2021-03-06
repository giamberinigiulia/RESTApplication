/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restapplication;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author informatica
 */
public class POSTMethod 
{
    public POSTMethod(int id,String nome,String cognome,String email,String telefono)
    {
        try
        {
            URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees"); //connessione all'url fornito
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //viene aperta la connessione 
            conn.setDoOutput(true);
            conn.setRequestMethod("POST"); //viene definito il metodo utilizzato
            conn.setRequestProperty("Content-Type", "application/json"); //viene definito il tipo di file che deve fornire in richiesta
            
            String body = "{\"employeeId\": " + id +",\"firstName\":\""+ nome + "\",\"lastName\":\"" + cognome + "\",\"email\":\"" + email + "\",\"phone\":\"" + telefono+ "\"}";

            OutputStream os = conn.getOutputStream();
            os.write(body.getBytes());
            os.flush();
            
            if (conn.getResponseCode() != 201) //controlla se il codice della risposta è diverso da 201
            {
                if(conn.getResponseCode() == 401) //controlla se il codice della risposta è uguale a 401
                {
                    throw new RuntimeException("Unauthorized");
                }
                if(conn.getResponseCode() == 403) //controlla se il codice della risposta è uguale a 403
                {
                    System.out.println("ID employees già utilizzato");
                }
                else
                {
                    throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                }
            }
            else
            {
                System.out.println("Inserimento riuscito!!");
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
