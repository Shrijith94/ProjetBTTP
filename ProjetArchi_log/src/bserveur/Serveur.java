package bserveur;

import java.net.Socket;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.*;

public class Serveur implements Runnable {
	private ServerSocket listen_socket;
	private Class<? extends Service> service; 
	private static int nbclient=0;
	// Cree un serveur TCP - objet de la classe ServerSocket
	public Serveur(int port, Class<? extends Service> service) throws IOException {
		listen_socket = new ServerSocket(port);
		this.service = service;
	}

	// Le serveur ecoute et accepte les connexions.
	// pour chaque connexion, il cree un ServiceInversion, 
	// qui va la traiter, et le lance

	public void run() {
		try {
			System.out.println("Lancement du serveur au port "+this.listen_socket.getLocalPort());
			
			try {				
				while(true) {	
					Socket s = listen_socket.accept();
					System.out.println("Connexion du client"+(++nbclient));
					Service inversion = this.service.getConstructor(Socket.class).newInstance(s);
					//inversion.setclient(s);
					new Thread(inversion).start();
				}

			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
		catch (IOException e) { 
			try {this.listen_socket.close();} catch (IOException e1) {}
			System.err.println("Arrêt du serveur au port "+this.listen_socket.getLocalPort());
		}
	}

	 // restituer les ressources --> finalize
	protected void finalize() throws Throwable {
		try {this.listen_socket.close();} catch (IOException e1) {}
	}

}
