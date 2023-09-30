package ClientPackage;

import java.io.OutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[]args)
    {
        try {
            System.out.println("Je suis un client pas encore connecté...");

            // Crée un socket client et se connecte au serveur sur le port 1234
            Socket sk = new Socket("192.168.56.1", 1234);
            System.out.println("je suis un client connecté");

            // Obtient des flux d'entrée et de sortie pour communiquer avec le serveur
            OutputStream os = sk.getOutputStream();
            InputStream is = sk.getInputStream();

            //le client tape un entier x au clavier
            int x;
            Scanner sc= new Scanner(System.in);
            System.out.print("donner un nombre svp :");
            x=sc.nextInt();
            sc.close();// Ferme le scanner

            // le client envoiecet entier au serveur via le flux de sortie
            os.write(x);

            // Lire la réponse du serveur depuis le flux d'entrée
            int rep=is.read();
            System.out.println("le nombre nb :"+x+"*5 ="+rep);

            // Ferme le socket client
            sk.close();
            System.out.println("je suis déconnecter");
        }
        catch (Exception e)
        {
            // Gestion de l'exception qui affiche un message d'erreur
            System.out.println("Erreur de connexion au serveur : " + e.getMessage()); //on peut utiliser e.printStackTrace();

        }


    }

}
