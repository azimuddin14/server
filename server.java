import java.io.*;
import java.net.*;

public class server
{
	public static void main(String args[])
	{
		String messageIn;
		String messageOut;
		
		try {
			ServerSocket ssock = new ServerSocket(57171);
			while(true)
			{
				Socket connsock = ssock.accept();
		
				InputStreamReader inStr =
					new InputStreamReader(connsock.getInputStream());
			
				BufferedReader inNet = new BufferedReader(inStr);

				DataOutputStream outNet =
					new DataOutputStream(connsock.getOutputStream());

				messageIn = inNet.readLine();
				messageOut = messageIn.toUpperCase() + "\n";
				outNet.writeBytes(messageOut);
			}
		}

		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}

