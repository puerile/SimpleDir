package tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import simpledir.FileList;

/**
 * @author Yuri
 *
 */
public class TestList
{
	File file;
	FileList output;
	
	@Before public void setUp()
	{
		output = new FileList();
	}

	@Test
	// test if file name is printed if we parse a file
	public void testFile()
	{
		file = new File("src\\testFolders\\testFile");
		String result = output.createDirList(file);
		assertTrue(result.equals("test.txt"));
	}
	
	@Test
	// test if directory name is printed if we parse a directory
	public void testDir()
	{
		file = new File("src\\testFolders\\testDir");
		String result = output.createDirList(file);
		assertTrue(result.equals("dir"));
	}
}
