package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import GUI.formatCse360.*;
//***************************************************************
//The formatter example is at line 109 to end of function
//***************************************************************
/**
 * Adds the UI control to select the file and format it.
 * 
 * @author SUHAS VENKATESH MURTHY VERSION 1.0 DATE 03/02/2018
 */
public class MainWindow {

	private JFrame mainFrame;
	private JTextField inputFileNametextField;
	private JTextField outputFileNameTextField;
	private JTextField averageLineTextField;
	private JTextField averageWordsTextField;
	private JTextField blankLinetextField;
	private JTextField lineCountTextField;
	private JTextField wordCountTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addMainFrame();

		JTabbedPane tabbedPane = getTabbedPane();
		mainFrame.getContentPane().add(tabbedPane);

		JPanel fileSelectionPanel = getFileSelectionPanel();
		tabbedPane.addTab("File Selection", null, fileSelectionPanel, null);

		JPanel inptFileSelectionPanel = getInputFileSelectionPanel();
		fileSelectionPanel.add(inptFileSelectionPanel);

		JButton inputFileBrowseButton = getInputFileBrowseButton(tabbedPane);
		inptFileSelectionPanel.add(inputFileBrowseButton);

		getInputFileNameTextField();
		inptFileSelectionPanel.add(inputFileNametextField);

		JPanel outputFileSelectionPanel = getOutputFileSelectionPanel();
		fileSelectionPanel.add(outputFileSelectionPanel);

		JButton outputFileBrowseButton = getOutputFIleBrowseButton(tabbedPane);
		outputFileSelectionPanel.add(outputFileBrowseButton);

		getOutputFileNameTextField();
		outputFileSelectionPanel.add(outputFileNameTextField);

		JRadioButton leftJustificationRadioButton = getLeftJustifyRdioButton();
		fileSelectionPanel.add(leftJustificationRadioButton);

		JRadioButton rightJustificationradioButton = getRightJustifyRadioButton();
		fileSelectionPanel.add(rightJustificationradioButton);

		JButton btnFormat = getFormatButton();
		fileSelectionPanel.add(btnFormat);

		JPanel outputStatsPanel = getOutputStatusPanel();
		tabbedPane.addTab("Output Stats", null, outputStatsPanel, null);

		JPanel averageLineLengthPanel = getAverageLineLengthPanel();
		outputStatsPanel.add(averageLineLengthPanel);

		JPanel averageWordspanel = getAverageWordsPanel();
		outputStatsPanel.add(averageWordspanel);

		JPanel blankLineRemovalPanel = getBlankLineRemovalPanel();
		outputStatsPanel.add(blankLineRemovalPanel);

		JPanel lineCountPanel = getLineCountPanel();
		outputStatsPanel.add(lineCountPanel);

		JPanel wordCountPanel = getWordCountPanel();
		outputStatsPanel.add(wordCountPanel);
		
		try {
			PrintWriter writer = new PrintWriter("testOuput.txt", "utf-8");
			formatCse360Project formatTest = new formatCse360Project();
		
			formatTest = formatCse360.formatInput("C:\\Users\\theri\\eclipse-workspace\\CSE360_Project\\testInput.txt");
			
			writer.println("Blanks Removed: " + formatTest.linesRem);
			for(int x = 0; x < formatTest.inputList.size(); x++)
			{
				writer.println(formatTest.inputList.get(x).lineReturn());
			}
			
			writer.close();
		
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/*
		 * Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		 * frame.setIconImage(icon);
		 */
	}

	private JPanel getWordCountPanel() {
		JPanel wordCountPanel = new JPanel();
		wordCountPanel.setBackground(SystemColor.inactiveCaption);
		wordCountPanel.setBounds(50, 373, 400, 60);
		wordCountPanel.setLayout(null);

		wordCountTextField = new JTextField();
		wordCountTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		wordCountTextField.setColumns(10);
		wordCountTextField.setBounds(new Rectangle(310, 10, 75, 40));
		wordCountTextField.setBounds(310, 10, 75, 40);
		wordCountPanel.add(wordCountTextField);

		JLabel wordCountLabel = new JLabel("Word Count");
		wordCountLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		wordCountLabel.setBounds(15, 10, 200, 40);
		wordCountPanel.add(wordCountLabel);
		return wordCountPanel;
	}

	private JPanel getLineCountPanel() {
		JPanel lineCountPanel = new JPanel();
		lineCountPanel.setBackground(SystemColor.inactiveCaption);
		lineCountPanel.setBounds(50, 297, 400, 60);
		lineCountPanel.setLayout(null);

		lineCountTextField = new JTextField();
		lineCountTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lineCountTextField.setColumns(10);
		lineCountTextField.setBounds(new Rectangle(310, 10, 75, 40));
		lineCountTextField.setBounds(310, 10, 75, 40);
		lineCountPanel.add(lineCountTextField);

		JLabel lineCountLabel = new JLabel("Line Count");
		lineCountLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lineCountLabel.setBounds(15, 10, 200, 40);
		lineCountPanel.add(lineCountLabel);
		return lineCountPanel;
	}

	private JPanel getBlankLineRemovalPanel() {
		JPanel blankLineRemovalPanel = new JPanel();
		blankLineRemovalPanel.setBackground(SystemColor.inactiveCaption);
		blankLineRemovalPanel.setBounds(50, 218, 400, 60);
		blankLineRemovalPanel.setLayout(null);

		blankLinetextField = new JTextField();
		blankLinetextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		blankLinetextField.setColumns(10);
		blankLinetextField.setBounds(new Rectangle(310, 10, 75, 40));
		blankLinetextField.setBounds(310, 10, 75, 40);
		blankLineRemovalPanel.add(blankLinetextField);

		JLabel blankLineRemovalLabel = new JLabel("Blank Line Removal Count\r\n");
		blankLineRemovalLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		blankLineRemovalLabel.setBounds(15, 10, 200, 40);
		blankLineRemovalPanel.add(blankLineRemovalLabel);

		return blankLineRemovalPanel;
	}

	private JPanel getAverageWordsPanel() {
		JPanel averageWordspanel = new JPanel();
		averageWordspanel.setBackground(SystemColor.inactiveCaption);
		averageWordspanel.setBounds(50, 142, 400, 60);
		averageWordspanel.setLayout(null);
		averageWordsTextField = new JTextField();
		averageWordsTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		averageWordsTextField.setColumns(10);
		averageWordsTextField.setBounds(new Rectangle(310, 10, 75, 40));
		averageWordsTextField.setBounds(310, 10, 75, 40);
		averageWordspanel.add(averageWordsTextField);

		JLabel averageWordsLabel = new JLabel("Average Words Per Line");
		averageWordsLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		averageWordsLabel.setBounds(15, 10, 200, 40);
		averageWordspanel.add(averageWordsLabel);
		return averageWordspanel;
	}

	private JPanel getAverageLineLengthPanel() {
		JPanel averageLineLengthPanel = new JPanel();
		averageLineLengthPanel.setBackground(SystemColor.inactiveCaption);
		averageLineLengthPanel.setBounds(50, 66, 400, 60);
		averageLineLengthPanel.setLayout(null);

		averageLineTextField = new JTextField();
		averageLineTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		averageLineTextField.setBounds(new Rectangle(310, 10, 75, 40));
		averageLineLengthPanel.add(averageLineTextField);
		averageLineTextField.setColumns(10);

		JLabel averageLineLengthLabel = new JLabel("Average Line Length");
		averageLineLengthLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		averageLineLengthLabel.setBounds(15, 10, 200, 40);
		averageLineLengthPanel.add(averageLineLengthLabel);

		return averageLineLengthPanel;
	}

	private JPanel getOutputStatusPanel() {
		JPanel outputStatsPanel = new JPanel();
		outputStatsPanel.setBackground(Color.WHITE);
		outputStatsPanel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		outputStatsPanel.setForeground(Color.WHITE);
		outputStatsPanel.setLayout(null);
		return outputStatsPanel;
	}

	private JButton getFormatButton() {
		JButton btnFormat = new JButton("Format");
		btnFormat.setBounds(393, 298, 150, 50);
		btnFormat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		return btnFormat;
	}

	private JRadioButton getRightJustifyRadioButton() {
		JRadioButton rightJustificationradioButton = new JRadioButton("Right Justification");
		rightJustificationradioButton.setBackground(Color.WHITE);
		rightJustificationradioButton.setBounds(new Rectangle(0, 0, 8, 9));
		rightJustificationradioButton.setBounds(588, 244, 190, 29);
		rightJustificationradioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		return rightJustificationradioButton;
	}

	private JRadioButton getLeftJustifyRdioButton() {
		JRadioButton leftJustificationRadioButton = new JRadioButton("Left Justification");
		leftJustificationRadioButton.setBackground(Color.WHITE);
		leftJustificationRadioButton.setBounds(new Rectangle(0, 0, 8, 9));
		leftJustificationRadioButton.setBounds(183, 244, 190, 29);
		leftJustificationRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		return leftJustificationRadioButton;
	}

	private void getOutputFileNameTextField() {
		outputFileNameTextField = new JTextField();
		outputFileNameTextField.setForeground(Color.GRAY);
		outputFileNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		outputFileNameTextField.setText("Enter File  Location and Name - Output File - .txt only");
		outputFileNameTextField.setColumns(10);
		outputFileNameTextField.setBounds(164, 7, 600, 35);
	}

	private JButton getOutputFIleBrowseButton(JTabbedPane tabbedPane) {
		JButton outputFileBrowseButton = new JButton("Browse");
		outputFileBrowseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser outputFileChooser = new JFileChooser();
				int result = outputFileChooser.showOpenDialog(tabbedPane);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedInputFile = outputFileChooser.getSelectedFile();
					outputFileNameTextField.setText(selectedInputFile.getPath());
				}
			}
		});
		outputFileBrowseButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		outputFileBrowseButton.setBounds(new Rectangle(46, 7, 100, 35));
		outputFileBrowseButton.setBackground(Color.WHITE);
		return outputFileBrowseButton;
	}

	private JPanel getOutputFileSelectionPanel() {
		JPanel outputFileSelectionPanel = new JPanel();
		outputFileSelectionPanel.setBackground(SystemColor.inactiveCaption);
		outputFileSelectionPanel.setBounds(60, 145, 850, 50);

		outputFileSelectionPanel.setLayout(null);
		return outputFileSelectionPanel;
	}

	private void getInputFileNameTextField() {
		inputFileNametextField = new JTextField();
		inputFileNametextField.setForeground(Color.GRAY);
		inputFileNametextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		inputFileNametextField.setBounds(160, 7, 600, 35);
		inputFileNametextField.setText("Enter File  Location and Name - Input File - .txt only");
		inputFileNametextField.setColumns(10);
	}

	private JButton getInputFileBrowseButton(JTabbedPane tabbedPane) {
		JButton inputFileBrowseButton = new JButton("Browse");
		inputFileBrowseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser inputFileChooser = new JFileChooser();
				int result = inputFileChooser.showOpenDialog(tabbedPane);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedInputFile = inputFileChooser.getSelectedFile();
					inputFileNametextField.setText(selectedInputFile.getPath());
				}
			}
		});
		inputFileBrowseButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		inputFileBrowseButton.setBackground(Color.WHITE);
		inputFileBrowseButton.setBounds(new Rectangle(40, 0, 0, 0));
		inputFileBrowseButton.setBounds(40, 7, 100, 35);
		return inputFileBrowseButton;
	}

	private JPanel getInputFileSelectionPanel() {
		JPanel inptFileSelectionPanel = new JPanel();
		inptFileSelectionPanel.setBackground(SystemColor.inactiveCaption);
		inptFileSelectionPanel.setBounds(60, 50, 850, 50);
		inptFileSelectionPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		inptFileSelectionPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		inptFileSelectionPanel.setLayout(null);
		return inptFileSelectionPanel;
	}

	private JPanel getFileSelectionPanel() {
		JPanel fileSelectionPanel = new JPanel();
		fileSelectionPanel.setBackground(Color.WHITE);
		fileSelectionPanel.setBorder(null);
		fileSelectionPanel.setLayout(null);
		return fileSelectionPanel;
	}

	private JTabbedPane getTabbedPane() {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tabbedPane.setOpaque(true);
		tabbedPane.setBounds(0, 0, 1015, 675);
		tabbedPane.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
			@Override
			protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
				return 50;
			}
		});
		return tabbedPane;
	}

	private void addMainFrame() {
		mainFrame = new JFrame();
		mainFrame.setResizable(false);
		mainFrame.setBounds(100, 100, 1022, 715);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setLocationRelativeTo(null);
	}
}
