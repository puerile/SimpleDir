/**
 * 
 */
package simpledir.exceptions;

/**
 * @author Yuri
 *
 */
public class FileExistsException extends Exception
{
	private static final long serialVersionUID = 3967152796824627441L;

	public FileExistsException()
	{
		System.err.println("file exists");
	}
}
