package simpledir;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Yuri
 * 
 */
public class FileCreator
{
	// create a new empty file
	public boolean createFile(File file)
	{
		boolean output = false;

		try
		{
			output = file.createNewFile();
		}
		catch (IOException e)
		{
			System.err.println("couldn't create file");
			System.err.println(e.getMessage());
		}

		return output;
	}

	public void writeList(File file, String list)
	{
		BufferedWriter writer;
		try
		{
			createFile(file);
			writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(list);
			writer.close();
		}
		catch (IOException e)
		{
			System.err.println("I/O error :(");
			System.err.println(e.getMessage());
		}
	}

}
