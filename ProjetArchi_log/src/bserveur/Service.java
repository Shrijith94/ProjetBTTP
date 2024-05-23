package bserveur;

import java.net.Socket;

public abstract class Service implements Runnable{
	protected Socket client;
	protected static int cpt = 1;
	protected final int numero;
	
	public Service(Socket client) {
		this.numero = cpt++;
		this.client = client;
	}

	public void finalize() throws Throwable {
		 client.close(); 
	}

}
