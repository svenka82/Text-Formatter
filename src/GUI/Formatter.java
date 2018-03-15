package GUI;

//Name: Richard Simpson
//Student ID: 1211882799
//Description: Format class to handle dealing with input file

import java.io.*;
import java.util.LinkedList;
import GUI.*;

public class Formatter {
	
	public static class FormatterOutput
	{
		public LinkedList<Helper> inputList;
		public int linesRem;
	}
	
	private static String inputline;
	private static FormatterOutput outputItem;
	private static Helper newLine;
	private static String tempStr;
	private static int x;
	private static char[] tempInput;
	private static char tempChar;
	
	public static FormatterOutput formatInput(String fileName) throws IOException
	{
		
		InputStream is = new FileInputStream(fileName);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader stdin = new BufferedReader(isr);
		
		outputItem = new FormatterOutput();
		
		outputItem.inputList = new LinkedList<Helper>();
		x = 0;
		tempChar = 'a';
		tempStr = new String();
		outputItem.linesRem = 0;
		
		inputline = stdin.readLine();
		
		newLine = new Helper();
		if(inputline == null || inputline.length() == 0) {
			is.close();
			isr.close();
			stdin.close();
		  return null;
		}
		do
		{
			tempInput = inputline.toCharArray();
			
			if (x >= inputline.length()) //case if line is just '\r' input1 length will be 0
			{
				outputItem.linesRem++;
			}
			else
			{
				tempChar = tempInput[x];
				while(x < tempInput.length)
				{
					if (Character.isWhitespace(tempChar) || tempChar == '\t')
					{
						x++;
						getNextChar();
						if(x >= tempInput.length)
						{
							outputItem.linesRem++;
							break;
						}
					}
					
					else
					{
						tempStr = "" + tempChar;
						x++;
						if (x >= tempInput.length)
						{
							lineCheck();
							break;
						}
						else
						{
							getNextChar();
						}
						
						while((!Character.isWhitespace(tempChar)) && (tempChar != '\t') && (tempChar != '\n'))
						{
							tempStr += tempChar;
							x++;
							if (x >= tempInput.length)
							{
								break;
							}
							else
							{
								tempChar = tempInput[x];
							}
						}
						
						lineCheck();
						
						x++;
						getNextChar();
					}
				}
				//end of line
				x = 0;
			}
			
		}while ((inputline = stdin.readLine()) != null); //end of file
		
		outputItem.inputList.add(newLine);
		
		stdin.close();
		
		return outputItem;
	}
	
	private static void lineCheck()
	{
		if (newLine.getSize() <= 0)
		{
			newLine.addWord(tempStr);
		}
		
		else if ((newLine.getSize() + tempStr.length()) >= 80)
		{
			outputItem.inputList.add(newLine);
			newLine = new Helper();
			newLine.addWord(tempStr);
		}
		else
		{
			newLine.addWord(tempStr);
		}
	}
	
	private static void getNextChar()
	{
		if (x >= tempInput.length);
		else
		{
			tempChar = tempInput[x];
		}
	}

}
