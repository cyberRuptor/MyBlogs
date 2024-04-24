import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.URL;
import java.net.URI;
 
public class SSLHealthPoke {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: " + SSLHealthPoke.class.getName() + " <health-check-url>");
            System.exit(1);
        }
        try {
            // Parse the health check URL
            URL url = new URL(args[0]);
            String host = url.getHost();
            int port = url.getPort();
            if (port == -1) {
                port = url.getDefaultPort();
            }
 
            // Create SSL socket factory and socket
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket(host, port);
 
            // Set endpoint identification algorithm
            SSLParameters sslparams = new SSLParameters();
            sslparams.setEndpointIdentificationAlgorithm("HTTPS");
            sslsocket.setSSLParameters(sslparams);
 
            // Get input and output streams
            InputStream in = sslsocket.getInputStream();
            OutputStream out = sslsocket.getOutputStream();
 
            // Write a test byte to get a reaction
            out.write(1);
 
            // Print the response
            while (in.available() > 0) {
                System.out.print(in.read());
            }
            System.out.println("Successfully connected");
 
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(1);
        }
    }
}
