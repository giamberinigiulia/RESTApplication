/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restapplication;

/**
 *
 * @author informatica
 */
public class RestApplication 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        GETMethod GET=new GETMethod();
        POSTMethod POST=new POSTMethod(7,"Marco","Bianchi","marco.bianchi@prova.com","3325673435");
        
    }
    
}
