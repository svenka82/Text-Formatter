package GUI;

import GUI.Formatter.FormatterOutput;

public class Statistics {

	public static double averageLineLength(FormatterOutput file)
	{
		int n = 0;
		int lineSize = 0;
		
		for(n = 0; file.inputList.get(n) != null; n++)
		{
			lineSize = lineSize + file.inputList.get(n).getSize();
		}
		
		double x = lineSize/file.inputList.size();
		
		return x;
	}
	
	public static double averageWordPerLine(FormatterOutput file)
	{	
		int n = 0;
		int totalWords = 0;
		
		for(n = 0; file.inputList.get(n) != null; n++)
		{
			totalWords = totalWords + file.inputList.get(n).getWordsInLine();
		}
		
		double x = totalWords/file.inputList.size();
		
		return x;
	}
	
	public static int blankLinesRemoved(FormatterOutput file)
	{
		return file.linesRem;
	}
	
	
	public static int lineCount(FormatterOutput file)
	{
		return file.inputList.size();
	}
	
	public static int wordCount(FormatterOutput file)
	{
		int n = 0;
		int totalWords = 0;
		for(n = 0; file.inputList.get(n) != null; n++)
		{
			totalWords = totalWords + file.inputList.get(n).getWordsInLine();
		}
		
		return totalWords;
	}
	
}
