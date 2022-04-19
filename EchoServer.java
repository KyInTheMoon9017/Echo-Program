import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class EchoServer {
	public static void main(String[] args) {
		try {
			System.out.println("Waiting for connection...");

			ServerSocket ss = new ServerSocket(6001);

			// Waits for client connection.
			Socket client = ss.accept();

			// Confirms if a connection is successfully established.
			System.out.println("Connected.");

			// get input from the client through the socket using getInputStream() method
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String line = in.readLine();

			// echoes the input from the client
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			out.println(line);

			client.close();

		}
		catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
}