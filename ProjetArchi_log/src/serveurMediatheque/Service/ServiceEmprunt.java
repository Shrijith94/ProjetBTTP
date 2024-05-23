package serveurMediatheque.Service;
import bserveur.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServiceEmprunt extends Service {


    public ServiceEmprunt(Socket client) {
        super(client);
    }

    @Override
    public void run() {
         try {
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);

			out.println("Quelle est votre numéro d'indentifiant?");
            int num_ident = Integer.parseInt(in.readLine());
            
		} catch (IOException e) {
			// Fin du service d'inversion
		}

		try {
			client.close();
		} catch (IOException e2) {
		}
    }
}
