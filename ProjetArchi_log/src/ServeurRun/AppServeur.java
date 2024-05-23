package ServeurRun;

import bserveur.Serveur;
import serveurMediatheque.Service.ServiceEmprunt;
import serveurMediatheque.Service.ServiceReserve;
import serveurMediatheque.Service.ServiceRetour;

import java.io.IOException;

public class AppServeur {
    public static void main(String[] args) {
        try {
            new Thread(new Serveur(3000, ServiceReserve.class)).start();
            new Thread(new Serveur(4000, ServiceEmprunt.class)).start();
            new Thread(new Serveur(5000, ServiceRetour.class)).start();
        } catch (IOException e) {
            System.err.println("Pb lors de la création du serveur : " +  e);
        }
    }
}
