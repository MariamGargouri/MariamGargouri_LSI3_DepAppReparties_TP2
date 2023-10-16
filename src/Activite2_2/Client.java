package Activite2_2;
//Activite 2-2
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java. util.Scanner;
import java.io.ObjectOutputStream;
public class Client {
	public static void main(String[] args) 
	{
		try{
			  //connexion
			  System.out.println("je suis un client");
			  Socket socket=new Socket("10.25.12.63",1234); // Une socket va etre crée : domander une connexion du client au serveur 
			                                               // "10.25.12.63" c'est l'adresse ip de la machine du client et 1234 c'est le port
			  System.out.println("je suis un client connecté");
			  
			  //partie traitement
			  InputStream is = socket.getInputStream(); // Pour lire le flux qui est dans le port 1234
	          OutputStream os = socket.getOutputStream(); // Pour faire sortir le contenue de os et l'envoyer au serveur
	          											 //is et os : pour la communication entre le client et le serveur
			  
			  ObjectOutputStream oos = new ObjectOutputStream(os);
			  
			  int op1;
			  int op2;
			  String op;

			  System.out.println("donner le premier opérant");
			  Scanner scanner= new Scanner(System.in); // Je donne la main au utilisateur d'ecrire une valeur
			  op1=scanner.nextInt(); // nextInt pour lire un entier
			  
			  System.out.println("donner le deuxième opérant");
			  Scanner scanner1= new Scanner(System.in); // Je donne la main au utilisateur d'ecrire une valeur
			  op2=scanner1.nextInt(); // nextInt pour lire un entier
			  
			  do
			  {
			  System.out.println("donner l'opération (+,-,*,/)");
			  Scanner scanner2= new Scanner(System.in); // Je donne la main au utilisateur d'ecrire un caractére
			  op=scanner2.nextLine(); // nextInt pour lire un une chaine de caractères ou un caractère
			  } while (!op.equals("+") && !op.equals("-") && !op.equals("/") && !op.equals("*")  );
			  
			  
			  Operation operation = new Operation (op1,op2,op.charAt(0));
			  oos.writeObject(operation);// envoyer un objet de type Operation au serveur

			  ObjectInputStream ois = new ObjectInputStream(is);
			  Operation operation1 = (Operation) ois.readObject(); //reception d'un objet du type Operation 
			     
			  System.out.println(op1+" "+op+" "+" "+op2+" = "+operation1.getResult());

			  
			  //déconnexion
			  System.out.println("deconnexion client");
			  socket.close();
			}
			catch(Exception e) {e.printStackTrace();
}


	}


}
