package GUI;

//Name: Richard Simpson
//Student ID: 1211882799
//Description: Format class to handle dealing with input file

import java.io.*;
import java.util.LinkedList;
import GUI.formatCse360SubClass;

public class formatCse360 {
	
	public static class formatCse360Project
	{
		public LinkedList<formatCse360SubClass> inputList;
		public int linesRem;
	}
	
	private static String input1;
	private static formatCse360Project outputItem;
	private static formatCse360SubClass newLine;
	private static String tempStr;
	private static int x;
	private static char[] tempInput;
	private static char tempChar;
	
	public static formatCse360Project formatInput(String fileName) throws IOException
	{
		
		InputStream is = new FileInputStream(fileName);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader stdin = new BufferedReader(isr);
		
		outputItem = new formatCse360Project();
		
		outputItem.inputList = new LinkedList<formatCse360SubClass>();
		x = 0;
		tempChar = 'a';
		tempStr = new String();
		outputItem.linesRem = 0;
		
		input1 = stdin.readLine();
		
		newLine = new formatCse360SubClass();
		
		do
		{
			tempInput = input1.toCharArray();
			
			if (x >= input1.length()) //case if line is just '\r' input1 length will be 0
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
						
						while((!Character.isWhitespace(tempChar)) && (tempChar != '\t'))
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
			
		}while ((input1 = stdin.readLine()) != null); //end of file
		
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
		
		else if ((newLine.getSize() + tempStr.length()) >= 81)
		{
			outputItem.inputList.add(newLine);
			newLine = new formatCse360SubClass();
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
