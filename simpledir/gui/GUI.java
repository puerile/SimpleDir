package simpledir.gui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import simpledir.Start;

public class GUI
{

	private JFrame frame;
	private JTextField txtSourcePath;
	private JTextField txtTargetPath;
	private JButton sourceButton;
	private JButton targetButton;
	JFileChooser fileChooser = new JFileChooser(new File(""));
	/**
	 * @wbp.nonvisual location=192,3
	 */
	private JFileChooser fileChooser_1 = new JFileChooser(new File(""));
	private JButton startButton;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					GUI window = new GUI();
					window.frame.setVisible(true);
				}
				
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public GUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
	{
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame = new JFrame("SimpleDir");
		frame.setBounds(100, 100, 410, 109);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{60, 300, 50, 0};
		gridBagLayout.rowHeights = new int[]{30, 25, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel directory = new JLabel("Directory");
		GridBagConstraints gbc_directory = new GridBagConstraints();
		gbc_directory.fill = GridBagConstraints.HORIZONTAL;
		gbc_directory.insets = new Insets(0, 0, 5, 5);
		gbc_directory.gridx = 0;
		gbc_directory.gridy = 0;
		frame.getContentPane().add(directory, gbc_directory);
		
		
//		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

//		frame.getContentPane().add(fileChooser);
		
		txtSourcePath = new JTextField();
		txtSourcePath.setEditable(false);
		txtSourcePath.setText("");
		GridBagConstraints gbc_txtSourcePath = new GridBagConstraints();
		gbc_txtSourcePath.fill = GridBagConstraints.BOTH;
		gbc_txtSourcePath.insets = new Insets(0, 0, 5, 5);
		gbc_txtSourcePath.gridx = 1;
		gbc_txtSourcePath.gridy = 0;
		frame.getContentPane().add(txtSourcePath, gbc_txtSourcePath);
		txtSourcePath.setColumns(10);
		
		sourceButton = new JButton("...");
		sourceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int state = fileChooser.showOpenDialog(null);

				if (state == JFileChooser.APPROVE_OPTION)
				{
					File file = fileChooser.getSelectedFile();
					System.out.println(file.getPath());
					txtSourcePath.setText(file.getPath());
				}
			}
		});
		
		GridBagConstraints gbc_sourceButton = new GridBagConstraints();
		gbc_sourceButton.fill = GridBagConstraints.VERTICAL;
		gbc_sourceButton.insets = new Insets(0, 0, 5, 0);
		gbc_sourceButton.gridx = 2;
		gbc_sourceButton.gridy = 0;
		frame.getContentPane().add(sourceButton, gbc_sourceButton);
		
		JLabel lblTarget = new JLabel("Target");
		GridBagConstraints gbc_lblTarget = new GridBagConstraints();
		gbc_lblTarget.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTarget.insets = new Insets(0, 0, 5, 5);
		gbc_lblTarget.gridx = 0;
		gbc_lblTarget.gridy = 1;
		frame.getContentPane().add(lblTarget, gbc_lblTarget);
		
		txtTargetPath = new JTextField();
		txtTargetPath.setEditable(false);
		GridBagConstraints gbc_txtTargetPath = new GridBagConstraints();
		gbc_txtTargetPath.fill = GridBagConstraints.BOTH;
		gbc_txtTargetPath.insets = new Insets(0, 0, 5, 5);
		gbc_txtTargetPath.gridx = 1;
		gbc_txtTargetPath.gridy = 1;
		frame.getContentPane().add(txtTargetPath, gbc_txtTargetPath);
		txtTargetPath.setColumns(10);
		
		targetButton = new JButton("...");
		targetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int state = fileChooser.showOpenDialog(fileChooser);

				if (state == JFileChooser.APPROVE_OPTION)
				{
					File file = fileChooser.getSelectedFile();
					System.out.println(file.getPath());
					txtTargetPath.setText(file.getPath());
				}
			}
		});
		
		GridBagConstraints gbc_targetButton = new GridBagConstraints();
		gbc_targetButton.insets = new Insets(0, 0, 5, 0);
		gbc_targetButton.fill = GridBagConstraints.VERTICAL;
		gbc_targetButton.gridx = 2;
		gbc_targetButton.gridy = 1;
		frame.getContentPane().add(targetButton, gbc_targetButton);
		
		startButton = new JButton("start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Start start = new Start();
				String source = txtSourcePath.getText();
				String target = txtTargetPath.getText();
				start.start(source, target);
			}
		});
		
		GridBagConstraints gbc_startButton = new GridBagConstraints();
		gbc_startButton.insets = new Insets(0, 0, 0, 5);
		gbc_startButton.gridx = 1;
		gbc_startButton.gridy = 2;
		frame.getContentPane().add(startButton, gbc_startButton);
	}
}
