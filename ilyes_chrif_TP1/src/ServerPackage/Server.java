package ServerPackage;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[]args){
        try {

            // Crée un socket serveur qui écoute sur le port 1234
            ServerSocket ssk = new ServerSocket(1234);
            System.out.println("Je suis un serveur en attente la connexion d'un client ");

            // Attends qu'un client se connecte et accepte la connexion
            Socket sk = ssk.accept();
            System.out.println("un client est connecté");

            // Obtient un flux de sortie pour envoyer des données au client
            OutputStream os = sk.getOutputStream();

            // Obtient un flux d'entrée pour recevoir des données du client
            InputStream is = sk.getInputStream();

            //on va lire nb  multiplier la valeur lue par 5 puis obtenir une réponse
            int x=is.read();
            int rep=x*5;
            os.write(rep);

            // Ferme le socket client
            sk.close();

            // Ferme le socket serveur
            ssk.close();
        }
        catch (Exception e)
        {
            // Gestion des exceptions qui affiche un message d'erreur en cas d'exception
            System.out.println("Erreur Serveur : " + e.getMessage()); //on peut utiliser e.printStackTrace(); aussi
        }



    }
}
