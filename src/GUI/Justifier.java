package GUI;

import java.io.IOException;
import java.io.PrintWriter;

import GUI.formatCse360.formatCse360Project;

public class leftJustificationClass {
	
	
	public static void leftJustified(String inputName, String outputName)
	{
		try {
			PrintWriter writer = new PrintWriter(outputName, "utf-8");
			formatCse360Project formatTest = new formatCse360Project();
		
			formatTest = formatCse360.formatInput(inputName);
			
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
