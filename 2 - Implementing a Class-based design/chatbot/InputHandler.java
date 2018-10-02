package inputHandler;

/**
 * author: BeLINda
 * 
 * 25.09.2018 beLINda - created file
 * 
 * version: 1.0
 * since: 25.09.2018
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHandler
{
	
	/**
	 * constructor of InputHandler Class
	 */
	public InputHandler()
	{
		displayMenu(true);
	}
	
	private void displayMenu(Boolean startUp)
	{
		if (startUp)
		{
			System.out.println("Bot: Enter your message, please");
		}
		System.out.print(" ");
	}
	
	/**
	 * Method for getting the users answer/input
	 */
	public String getUserInput()
	{
		
		String userInput = null;
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			userInput = br.readLine();
		}
		catch(IOException error)
		{
			System.out.println("Error occured: " + error);
		}
		
		return userInput;
	}
	
	public void sendMessage(String message)
	{
		System.out.println("Bot: " + message);
	}
}
