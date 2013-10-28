/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.io.File;
import org.junit.Test;
import simpledir.Start;

/**
 * @author Yuri
 * 
 */
public class TestStartClass
{
	File target = new File("src\\testWriter\\test.txt");
	String source = "src\\testFolders";
	Start start = new Start();

	@Test
	public void testStartClass()
	{
		start.start(source, target.getAbsolutePath());
		target.deleteOnExit();
		assertTrue(target.length() > 0);
	}

}
