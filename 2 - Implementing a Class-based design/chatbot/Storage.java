package answers;

/**
 * author: BeLINda
 * 
 * 25.09.2018 beLINda - created file
 * 02.10.2018 beLINda - comments and additional changes
 * 
 * version: 1.1
 * since: 25.09.2018
 * 
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Storage {

    private String fileName;
    private String[] responses = new String[0];
    private int rows;

    public Storage(String fileName)
    {
        this.fileName = fileName;
        getNumberOfRows();
        getResponsesArray();
    }

    /**
     * Returning the number of rows in the answers.txt file
     */
    private void getNumberOfRows()
    {
        int rows = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            while (br.readLine() != null)
                rows++;
        }
        catch(IOException error)
        {
            System.out.println("Error occured: " + error);
            System.exit(1);
        }

        this.rows = rows;
    }

    /**
     * Getting answers per row from the file, after User-Input
     */
    private void getResponsesArray()
    {
        int rowCount = 0;
        String row;
        String[] responsesArray = new String[rows];

        try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            do
            {
                row = br.readLine();
                if (row != null)
                {
                    responsesArray[rowCount] = row;
                    rowCount++;
                }
            }
            while (row != null);
        }
        catch (FileNotFoundException noFile)
        {
            System.out.println("File not found " + noFile);
            System.exit(1);
        }
        catch (IOException error)
        {
            System.out.println("Error ocurred: " + error);
            System.exit(1);
        }
        responses = responsesArray;
    }

    // gets simpleChatBot response to user command
    public String getResponse(String userInput)
    {
        String tag;
        String response;
        String[] array;

        for (String responserow: this.responses)
        {
            if (responserow != null)
            {
                array = responserow.split(" - ");
                tag = array[0];
                response = array[1];

                if (tag.compareToIgnoreCase(userInput) == 0)
                {
                    return response;
                }
            }
        }

        /**
         * returns if no the input isn't known in the answers.txt file
         */
        return "I am sorry, I am not able to respond to this";
    }
}
