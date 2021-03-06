/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author informatica
 */
public class GETMethod 
{
    public GETMethod()
    {
        try 
        {
            URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees"); //connessione all'url fornito
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //viene aperta la connessione 
            conn.setRequestMethod("GET"); //viene definito il metodo utilizzato
            conn.setRequestProperty("Accept", "application/json"); //viene definito il tipo di file che il server deve fornire in risposta

            if (conn.getResponseCode() != 200) //controlla se il codice della risposta è diverso da 200
            {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()))); //viene aperto un buffer per poter ricevedere e visualizzare a video il json con i dati richiesti al server

            int i; //serve per indicie del separatore
            ArrayList A=new ArrayList(); //array che conterrà tutte le righe del JSON
            String s=br.readLine(); //stringa contenente tutte le righe del JSON 
            for(int x=2;x<s.length();x++)
            {
               i= s.indexOf("}",x);
               A.add(s.substring(x, i));
               x=i+2;
            }
            for(int y=0;y<A.size();y++)
            {
                System.out.println(A.get(y).toString());
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
    
    public GETMethod(String Id)
    {
        try 
        {
            URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees/"+Id); //connessione all'url fornito --> inserimento dell'ID per avere le informazioni relative solo a quell'employee
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //viene aperta la connessione 
            conn.setRequestMethod("GET"); //viene definito il metodo utilizzato
            conn.setRequestProperty("Accept", "application/json"); //viene definito il tipo di file che il server deve fornire in risposta

            if (conn.getResponseCode() != 200) //controlla se il codice della risposta è diverso da 200
            {             
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()))); //viene aperto un buffer per poter ricevedere e visualizzare a video il json con i dati richiesti al server

            String output; //creazione della stringa d'output per la visualizzazione del JSON
            while ((output = br.readLine()) != null) //viene riempita la stringa d'output 
            {
                    System.out.println(output); //stampa a video
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
