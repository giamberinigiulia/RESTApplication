/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author informatica
 */
public class RestApplication 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        //GETMethod GET = new GETMethod();
        //POSTMethod POST = new POSTMethod(2,"Marco","Bianchi","marco.bianchi@prova.com","3325673435");
        //DELETEMethod DELETE = new DELETEMethod("2");
        //GETMethod GET_ID = new GETMethod("2");
        //PUTMethod PUT = new PUTMethod(3,"Pietro","Corso","gianni.verdi@prova.com","3325673435");
        //GETMethod GET = new GETMethod("2");
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String input;
        do
        {
            System.out.println("Scegliere una delle seguenti opzioni: ");
            System.out.println("1) GET");
            System.out.println("2) POST");
            System.out.println("3) DELETE");
            System.out.println("4) GET w ID");
            System.out.println("5) PUT"); //se effettuato con un ID non esistente non si blocca e genera un errore
            System.out.println("6) EXIT");
            input = console.readLine();
            switch(input)
            {
                case "1":
                    GETMethod GET = new GETMethod();
                    break;
                case "2":
                    System.out.println("Inserire l'ID: ");
                    int ID_post = Integer.parseInt(console.readLine());
                    System.out.println("Inserire il nome: ");
                    String nome = console.readLine();
                    System.out.println("Inserire il cognome: ");
                    String cognome = console.readLine();
                    System.out.println("Inserire l'email: ");
                    String email = console.readLine();
                    System.out.println("Inserire il numero telefonico: ");
                    String telefono = console.readLine();
                    POSTMethod POST = new POSTMethod(ID_post,nome,cognome,email,telefono);
                    break;
                case "3":
                    System.out.println("Inserire l'ID: ");
                    String ID_delete = console.readLine();
                    DELETEMethod DELETE = new DELETEMethod(ID_delete);
                    break;
                case "4":
                    System.out.println("Inserire l'ID: ");
                    String ID_get = console.readLine();
                    GETMethod GET_ID = new GETMethod(ID_get);
                    break;
                case "5":
                    System.out.println("Inserire l'ID: ");
                    int ID_put = Integer.parseInt(console.readLine());
                    System.out.println("Inserire il nome: ");
                    String nome_put = console.readLine();
                    System.out.println("Inserire il cognome: ");
                    String cognome_put = console.readLine();
                    System.out.println("Inserire l'email: ");
                    String email_put = console.readLine();
                    System.out.println("Inserire il numero telefonico: ");
                    String telefono_put = console.readLine();
                    PUTMethod PUT = new PUTMethod(ID_put,nome_put,cognome_put,email_put,telefono_put);
                    break;
                default:
                    break;
            }
        }while(!input.equals("6"));
    }
    
}
