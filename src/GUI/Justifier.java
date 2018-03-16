package GUI;

import java.io.IOException;
import java.io.PrintWriter;

import GUI.Formatter.FormatterOutput;

public class Justifier {
	
	
	public static FormatterOutput leftJustified(String inputName, String outputName)
	{
		try {
			PrintWriter writer = new PrintWriter(outputName);
			FormatterOutput formatTest = new FormatterOutput();
		
			formatTest = Formatter.formatInput(inputName);
			
			for(int x = 0; x < formatTest.inputList.size(); x++)
			{
				writer.println(formatTest.inputList.get(x).lineReturn());
			}
			
			
			writer.close();
			
			return formatTest;
		
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
