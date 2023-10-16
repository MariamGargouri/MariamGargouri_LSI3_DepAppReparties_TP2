package Activite2_1;
//activite 2-1
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) 
	{
		try{
			  //connexion
			  System.out.println("je suis un client");
			  Socket socket=new Socket("10.25.12.63",1234); // Une socket va etre crée : domander une connexion du client au serveur 
			                                               // "10.25.12.63" c'est l'adresse ip de la machine du client et 1234 c'est le port
			  System.out.println("je suis un client connecté");
			  
			  // traitement
			  InputStream is = socket.getInputStream(); // Pour lire le flux qui est dans le port 1234
			  OutputStream os = socket.getOutputStream(); // Pour faire sortir le contenue de os et l'envoyer au serveur
			  
			  PrintWriter pw = new PrintWriter(os, true); // Envoie caractère par caractère
			  
			  InputStreamReader isr= new InputStreamReader(is); // Lire caractère par caractère 
			  BufferedReader br = new BufferedReader(isr); // Lire des chaines de caractères 
			  
			  int op1;
			  int op2;
			  String op;

			  System.out.println("donner le premier opérande");
			  Scanner scanner= new Scanner(System.in); // Je donne la main au utilisateur d'ecrire une valeur
			  op1=scanner.nextInt(); // nextInt pour lire un entier
			  
			  System.out.println("donner le deuxième opérande");
			  Scanner scanner1= new Scanner(System.in); // Je donne la main au utilisateur d'ecrire une valeur
			  op2=scanner.nextInt(); // nextInt pour lire un entier
			  
			  do
			  {
			  System.out.println("donner l'opération (+,-,*,/)");
			  op=scanner.nextLine(); // nextLine pour lire un caractère ou une chaine de caractères
			  } while (!op.equals("+") && !op.equals("-") && !op.equals("/") && !op.equals("*")  );
			  
			  
			  
			  pw.println(op1);// envoyer le premier opérande au serveur 
			  pw.println(op2);// envoyer le deuxième opérande au serveur 
			  pw.println(op);// envoyer l'opération au serveur 
			  			  
			  System.out.println(op1+" "+op+" "+" "+op2+" = "+br.readLine());


			  
			  //déconnexion
			  System.out.println("deconnexion client");
			  socket.close();
			}
			catch(Exception e) {e.printStackTrace();
}

	}

}
