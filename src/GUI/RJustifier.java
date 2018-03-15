package GUI;

import java.io.IOException;
import java.io.PrintWriter;

import GUI.Formatter.FormatterOutput;

public class RJustifier {

	public static String padRight(String str, int width, char spaceChar) {

		final int length = str.length();
		int bufferSpace = width - length;
		if (bufferSpace < 0) {
			// some error message if width is smaller than length
			return "";
		}

		final StringBuilder sb = new StringBuilder();
		for (int i = bufferSpace; i > 0; i--)
			sb.append(spaceChar);

		sb.append(str);
		return sb.toString();
	}

	public static FormatterOutput rightJustified(String inputName, String outputName) {
		try {

			int width = 80;
			PrintWriter writer = new PrintWriter(outputName, "utf-8");
			FormatterOutput formatTest = new FormatterOutput();

			formatTest = Formatter.formatInput(inputName);

			for (int x = 0; x < formatTest.inputList.size(); x++) {
				
//				writer.printf("%20s %" + (width - formatTest.inputList.get(x).lineReturn().length()) + "s", " ",
//						padRight(formatTest.inputList.get(x).lineReturn(), width, ' '));
//
//				writer.println();
				
				int lineLength = formatTest.inputList.get(x).getSize();
				if (lineLength < 80)
				{
					int numSpaces = width - lineLength;
					for(int y = 0; y < numSpaces; y++)
					{
						writer.print(" ");
					}
				}
				writer.println(formatTest.inputList.get(x).lineReturn());
			}

			writer.close();

			return formatTest;

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

}
