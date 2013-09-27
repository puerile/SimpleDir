package tests;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import simpledir.FileCreator;
import simpledir.FileList;

/**
 * @author Yuri
 * 
 */
public class TestCreator
{
	File file = new File("src\\testWriter\\test.txt");
	File file2 = new File("src\\testWriter\\test2.txt");
	File dir = new File("src\\testFolders");
	FileCreator writer = new FileCreator();
	FileList creator = new FileList();

	@Test
	// test if method writes something into the file
	public void testWrite()
	{
		String list = "test";
		writer.writeList(file, list);
		file.deleteOnExit();
		assertTrue(file.length() > 0);
	}

	@Test
	// test if method writes the correct thing into the file
	public void testWriteContent() throws IOException
	{
		String compare = "";
		String line;
		String list = "<ul><li>testFolders</li><li><ul><li>testDir</li><li><ul><li>dir</li></ul></li></ul><ul><li>testFile</li><li><ul><li>test.txt</li></ul></li></ul></li></ul>";
		
		writer.writeList(file2, creator.createDirList(dir));
		BufferedReader reader = new BufferedReader(new FileReader(file2));

		while ((line = reader.readLine()) != null)
		{
			compare += line;
		}
		
		reader.close();
		file2.deleteOnExit();
		
		assertTrue(compare.equals(list));
	}
}
