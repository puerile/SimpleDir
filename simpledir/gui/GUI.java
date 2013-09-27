package simpledir.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JTextField;
import javax.swing.JFileChooser;

public class GUI
{

	private JFrame frame;
	private JTextField txtFthft;

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
	 * Initialize the contents of the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNjfzh = new JLabel("njfzh");
		frame.getContentPane().add(lblNjfzh);
		
		JFileChooser fileChooser = new JFileChooser(new File(""));
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int state = fileChooser.showOpenDialog(null);

		if (state == JFileChooser.APPROVE_OPTION)
		{
			File file = fileChooser.getSelectedFile();
			System.out.println(file.getPath());
//			path.setText(file.getPath());
		}
		frame.getContentPane().add(fileChooser);
		
		txtFthft = new JTextField();
		txtFthft.setText("fthft");
		frame.getContentPane().add(txtFthft);
		txtFthft.setColumns(10);
		
		JLabel label = new JLabel("");
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		frame.getContentPane().add(label_2);
	}
}
