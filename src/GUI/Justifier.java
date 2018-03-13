package GUI;

import java.io.IOException;
import java.io.PrintWriter;

import GUI.Formatter.FormatterOutput;

public class Justifier {
	
	
	public static void leftJustified(String inputName, String outputName)
	{
		try {
			PrintWriter writer = new PrintWriter(outputName, "utf-8");
			FormatterOutput formatTest = new FormatterOutput();
		
			formatTest = Formatter.formatInput(inputName);
			
			for(int x = 0; x < formatTest.inputList.size(); x++)
			{
				writer.println(formatTest.inputList.get(x).lineReturn());
			}
			
			writer.close();
		
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
