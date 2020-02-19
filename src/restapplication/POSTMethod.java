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
            conn.setRequestProperty("Content-Type", "application/json"); //viene definito il tipo di file che il server deve fornire in risposta
            
            String body = "{\"employeeId\": " + id +",\"firstName\":\""+ nome + "\",\"lastName\":\"" + cognome + "\",\"email\":\"" + email + "\",\"phone\":\"" + telefono+ "\"}";
            //String body= "{\"employeeId\": 5, \"firstName\": \"Marco\", \"lastName\": \"Verdi\", \"email\": \"Marco.verdi%40pippo.com\", \"phone\": \"3245656781\"}";
            
            
            OutputStream os = conn.getOutputStream();
            //Stampare a video che l'inserimento è andato a buon fine
            /*if(conn.getResponseCode() == 200)
            {
                os.write("Inserimento effettuato");
            }*/
            os.write(body.getBytes());
            os.flush();
            
            if (conn.getResponseCode() != 201) //controlla se il codice della risposta è diverso da 200
            {
                if(conn.getResponseCode() == 401)
                {
                    throw new RuntimeException("Unauthorized");
                }
                if(conn.getResponseCode() == 403)
                {
                    throw new RuntimeException("Forbidden: maybe you have to change the employee identification");
                }
                else
                {
                    throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                }
            }
            
            
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
