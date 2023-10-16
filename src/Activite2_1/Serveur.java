package Activite2_1;
//Activite 2-1
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
	public static void main(String[] args) 
	{
		 try 
		 {
		     System.out.println("je suis un serveur");
		     //connexion coté serveur
		     ServerSocket serverSocket = new ServerSocket(1234); //on a fait une reservation du port
		     System.out.println("je suis un serveur , j'atend un client");
		     Socket socket=serverSocket.accept(); // elle attend une connexion du client 
		     System.out.println("un client est connecté");
		     
		     //traitement
		     InputStream is = socket.getInputStream(); // elle prend le contenue de os du client
		     OutputStream os = socket.getOutputStream();// Pour envoyer la resultat au client
		     
		     InputStreamReader isr= new InputStreamReader(is); 
		     BufferedReader br = new BufferedReader(isr); 
			 PrintWriter pw = new PrintWriter(os, true); 

		     
		     int op1= Integer.parseInt(br.readLine());
		     int op2= Integer.parseInt(br.readLine());
		     String op= br.readLine();
		       
		     int rep=0;
		     switch(op) {
		     case "+": 
		    	 	rep=op1+op2;
		    	 	break;
		     case "-":
		    	 	rep=op1-op2;		       
		    	 	break;
		     case "*":
		    	 	rep=op1*op2;			       
		    	 	break;
			 case "/":
			    	 rep=op1/op2;			       
			    	 break;}
		     
			  pw.println(rep);// pour envoyer le resultat au client

		     


		     
		     //déconnexion
		     System.out.println("deconnexion serveur");
		     socket.close();
		     serverSocket.close(); //liberation de tout ce qui est reservé
		  }
		  catch(Exception e) {e.printStackTrace();}
		


	}

}
