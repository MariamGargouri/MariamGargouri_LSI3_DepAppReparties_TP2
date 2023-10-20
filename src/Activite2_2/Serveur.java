package Activite2_2;
//Activite 2-2
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
		     										   //is et os : pour la communication entre le client et le serveur

		     ObjectInputStream ois = new ObjectInputStream(is);
		     Operation operation = (Operation) ois.readObject(); //reception d'un objet du type Operation 
		     
		     int op1= operation.getOp1();
		     int op2= operation.getOp2();
		     char op= operation.getOp();
		       
		     int result;
		     
		     switch(op) {
		     case '+': 
		    	 	result=op1+op2;
		    	 	break;
		     case '-':
		    	 	result=op1-op2;		       
		    	 	break;
		     case '*':
		    	 	result=op1*op2;			       
		    	 	break;
			 case '/':
			    	 result=op1/op2;			       
			    	 break;}
		     
			  ObjectOutputStream oos = new ObjectOutputStream(os);
			  Operation operation1 = new Operation (operation.getOp1(),operation.getOp2(), operation.getOp());
			  operation1.setResult(result);
			  oos.writeObject(operation1); //envoie au client un objet de type Operation

		     //déconnexion
		     System.out.println("deconnexion serveur");
		     socket.close();
		     serverSocket.close(); //liberation de tout ce qui est reservé
		  }
		  catch(Exception e) {e.printStackTrace();}

	}


}
