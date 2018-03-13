package GUI;

import GUI.Formatter.FormatterOutput;

public class Statistics {

	public static double averageLineLength(FormatterOutput file)
	{
		int n = 0;
		int lineSize = 0;
		
		while(n < file.inputList.size())
		{
			lineSize = lineSize + file.inputList.get(n).getSize();
			n++;
		}
		
		Double ls = new Double(lineSize);
		Double lc = new Double(file.inputList.size());
		
		double x = ls/lc;
		
		return x;
	}
	
	public static double averageWordPerLine(FormatterOutput file)
	{	
		int n = 0;
		int totalWords = 0;
		
		while(n < file.inputList.size())
		{
			totalWords = totalWords + file.inputList.get(n).getWordsInLine();
			n++;
		}
		
		Double tw = new Double(totalWords);
		Double lc = new Double(file.inputList.size());
		
		double x = tw/lc;
		
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
		
		while(n < file.inputList.size())
		{
			totalWords = totalWords + file.inputList.get(n).getWordsInLine();
			n++;
		}
		
		return totalWords;
	}
	
}
