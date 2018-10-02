package main;

/**
 * author: BeLINda
 * 
 * 25.09.2018 beLINda - created file
 * 02.10.2018 beLINda - comments and additional changes
 * 
 * version: 1.1
 * since: 25.09.2018
 */

import answers.Storage;
import inputHandler.InputHandler;

public class ChatBotMain
{
	private String userInput;
	private String response;
	
	/**
	 * Answer File - path
	 */
	private String fileName = "src/answers/answers.txt";
	private Storage answer;
	private InputHandler handler;
	
	public ChatBotMain()
	{
		answer = new Storage(fileName);
		
		handler = new InputHandler();
	}
	
	public void startBot()
	{
				do
				{
					/**
					 * getting the users input from the InputHandler
					 */
					userInput = handler.getUserInput();
					/**
					 * Setting the bots response from Storage
					 */
					response = answer.getResponse(userInput);
					/**
					 * Sending the bots response
					 */
					handler.sendMessage(response);
					
					if (userInput.equals("bye"))
					{
						System.exit(0);
					}
				}
				while(!userInput.equals("bye"));
	}
	/**
	 * main method
	 */
	public static void main(String[] args)
	{
		ChatBotMain bot = new ChatBotMain();
		bot.startBot();
	}
}
