package simpledir;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import simpledir.exceptions.FileExistsException;

/**
 * @author Yuri
 * 
 */
public class FileCreator
{
	public void writeList(File file, String list)
	{
		BufferedWriter writer;
		try
		{
			if (file.createNewFile())
			{
				writer = new BufferedWriter(new FileWriter(file, true));
				writer.write(list);
				writer.close();
			}
			else
			{
				throw new FileExistsException();
			}
		}
		catch (IOException e)
		{
			System.err.println("I/O error :(");
			System.err.println(e.getMessage());
		}
		catch (FileExistsException e)
		{
			System.err.println("file already exists");
			System.err.println(e.getMessage());
		}
	}

}
