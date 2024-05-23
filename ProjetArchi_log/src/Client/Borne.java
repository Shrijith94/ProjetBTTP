package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Borne {
    private final static int PORT = 4000;
    private final static String HOST = "localhost";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if(i==4000){
            Socket socket = null;
            try {
                // Cree une socket pour communiquer avec le service se trouvant sur la
                // machine host au port PORT

                socket = new Socket(HOST, PORT);
                // Cree les streams pour lire et ecrire du texte dans cette socket
                BufferedReader sin = new BufferedReader (new InputStreamReader(socket.getInputStream ( )));
                PrintWriter sout = new PrintWriter (socket.getOutputStream ( ), true);
                // Cree le stream pour lire du texte a partir du clavier
                // (on pourrait aussi utiliser Scanner)
                BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
                // Informe l'utilisateur de la connection
                System.out.println("Connecté au serveur " + socket.getInetAddress() + ":"+ socket.getPort());
                String line;
			    line = sin.readLine(); // 1�re question
			    System.out.println(line);

                System.out.print("->");
			    line = clavier.readLine();
			    sout.println(line);

            }
            catch (IOException e) { System.err.println(e); }
            // Refermer dans tous les cas la socket
            try { if (socket != null) socket.close(); }
            catch (IOException e2) { ; }
        }

    }
}
