package serveurMediatheque.Service;
import bserveur.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ServiceReserve extends Service{


    public ServiceReserve(Socket client) {
        super(client);
    }

    @Override
    public void run() {
       
	}
}
