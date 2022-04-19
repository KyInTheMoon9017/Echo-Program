import java.net.Socket;
import java.io.*;

public class EchoClient {
	public static void main(String[] args) {
		try {
			System.out.println("Client started.");
			// socket to send data to server
			Socket server = new Socket("localhost",6001);

			// waits for user input in the command line
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter a string: ");
			String data = userInput.readLine();
			System.out.println("Client: " + data);

			PrintWriter out = new PrintWriter(server.getOutputStream(), true);
			out.println(data);

			// get input from the server through the socket using getInputStream() method
			BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			String line;

			while((line = in.readLine()) != null)
				System.out.println("Server: " + line);

			/* client closes the connection
			server breaks out of the loop */
			server.close();

		}
		catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
}