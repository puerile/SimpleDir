/**
 * 
 */
package simpledir;

import java.io.File;

/**
 * @author Yuri
 * 
 */
public class Start
{
	private FileCreator creator = new FileCreator();
	private FileList list = new FileList();

	public void start(String source, String target)
	{
		creator.writeList(new File(target),
				list.createDirList(new File(source)));
	}
}
