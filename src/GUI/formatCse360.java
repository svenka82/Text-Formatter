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
	
	/*public static void main(String[] args) throws IOException
	{
		InputStream is = new FileInputStream(args[0]);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader stdin = new BufferedReader(isr);
		
		PrintWriter writer = new PrintWriter("testOuput.txt", "utf-8");
		outputItem = new formatCse360Project();
		
		outputItem.inputList = new LinkedList<formatCse360SubClass>();
		int x = 0;
		char tempChar = 'a';
		String tempStr = new String();
		outputItem.linesRem = 0;
		
		input1 = stdin.readLine();
		
		do
		{
			formatCse360SubClass newLine = new formatCse360SubClass();
			
			if (x >= input1.length())
			{
				outputItem.linesRem++;
			}
			else
			{
				tempChar = input1.charAt(x);
				while(x < input1.length())
				{
					if (Character.isWhitespace(tempChar))
					{
						x++;
						if (x >= input1.length())
						{
							break;
						}
						else
						{
							tempChar = input1.charAt(x);
						}
					}
					else if(tempChar == '\t')
					{
						x++;
						if (x >= input1.length())
						{
							break;
						}
						else
						{
							tempChar = input1.charAt(x);
						}
					}
					else
					{
						tempStr = "" + tempChar;
						x++;
						tempChar = input1.charAt(x);
						
						while((!Character.isWhitespace(tempChar)) && (tempChar != '\t'))
						{
							tempStr += tempChar;
							x++;
							if (x >= input1.length())
							{
								break;
							}
							else
							{
								tempChar = input1.charAt(x);
							}
						}
						newLine.addWord(tempStr);
						
						x++;
						if (x >= input1.length());
						else
						{
							tempChar = input1.charAt(x);
						}
					}
				}
				outputItem.inputList.add(newLine);
				//end of line
				x = 0;
			}
			
		}while ((input1 = stdin.readLine()) != null); //end of file
		
		
		for(int y = 0; y < outputItem.inputList.size(); y++)
		{
			writer.println(outputItem.inputList.get(y).lineReturn());
		}
		
		writer.write("Lines Removed(Blank): " + outputItem.linesRem);
		writer.close();
		stdin.close();
		
	}
	*/
	
	public static formatCse360Project formatInput(String fileName) throws IOException
	{
		
		//outputItem.inputList = new LinkedList<formatCse360SubClass>();
		
		InputStream is = new FileInputStream(fileName);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader stdin = new BufferedReader(isr);
		
		outputItem = new formatCse360Project();
		
		outputItem.inputList = new LinkedList<formatCse360SubClass>();
		int x = 0;
		char tempChar = 'a';
		String tempStr = new String();
		outputItem.linesRem = 0;
		
		input1 = stdin.readLine();
		
		do
		{
			formatCse360SubClass newLine = new formatCse360SubClass();
			
			if (x >= input1.length())
			{
				outputItem.linesRem++;
			}
			else
			{
				tempChar = input1.charAt(x);
				while(x < input1.length())
				{
					if (Character.isWhitespace(tempChar))
					{
						x++;
						if (x >= input1.length())
						{
							break;
						}
						else
						{
							tempChar = input1.charAt(x);
						}
					}
					else if(tempChar == '\t')
					{
						x++;
						if (x >= input1.length())
						{
							break;
						}
						else
						{
							tempChar = input1.charAt(x);
						}
					}
					else
					{
						tempStr = "" + tempChar;
						x++;
						tempChar = input1.charAt(x);
						
						while((!Character.isWhitespace(tempChar)) && (tempChar != '\t'))
						{
							tempStr += tempChar;
							x++;
							if (x >= input1.length())
							{
								break;
							}
							else
							{
								tempChar = input1.charAt(x);
							}
						}
						newLine.addWord(tempStr);
						
						x++;
						if (x >= input1.length());
						else
						{
							tempChar = input1.charAt(x);
						}
					}
				}
				outputItem.inputList.add(newLine);
				//end of line
				x = 0;
			}
			
		}while ((input1 = stdin.readLine()) != null); //end of file
		
		
		stdin.close();
		
		return outputItem;
		

	}

}
