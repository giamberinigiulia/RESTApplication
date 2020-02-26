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
public class PATCHMethod 
{
    public PATCHMethod(int id,String nome,String cognome,String email,String telefono) 
    {
        try
        {
            String ID= String.valueOf(id);  //conversione dell'ID intero in stringa 
            URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees/"+ID); //connessione all'url fornito
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //viene aperta la connessione 
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json"); //viene definito il tipo di file che deve fornire in richiesta
            conn.setRequestProperty("Accept", "application/json");  //viene definito il tipo di file che il server deve fornire in risposta
            conn.setRequestMethod("PATCH"); //viene definito il metodo utilizzato
            
            String body = "{\"employeeId\": " + id +",\"firstName\":\""+ nome + "\",\"lastName\":\"" + cognome + "\",\"email\":\"" + email + "\",\"phone\":\"" + telefono+ "\"}";

            OutputStream os = conn.getOutputStream();

            os.write(body.getBytes());
            os.flush();
            
            if (conn.getResponseCode() != 200 || conn.getResponseCode() != 204) //controlla se il codice della risposta è diverso da 200
            {
                if(conn.getResponseCode() == 401) //controlla se il codice della risposta è uguale a 401
                {
                    throw new RuntimeException("Unauthorized");
                }
                if(conn.getResponseCode() == 403) //controlla se il codice della risposta è uguale a 403
                {
                    throw new RuntimeException("Forbidden: maybe you have to change the employee identification");
                }
                else
                {
                    throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                }
            }
            else
            {
                System.out.println("Aggiornamento di un record intero riuscito!!");
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
