package simpledir;

import java.io.File;

/**
 * @author Yuri
 * 
 */
public class FileList
{
	int i = 0;
	
	public String createDirList(File path)
	{
		String result = "";
		result += "<ul>\n";

		if (path.isFile())
		{
			result += "<li>" + path.getName() + "</li>\n";
		}

		else if (path.isDirectory())
		{
			result += "<li>";
			result += path.getName();
			result += "</li>\n";

			if (path.list().length > 0)
			{
				result += "<li>";

				for (File file : path.listFiles())
				{
					result += createDirList(file);
				}

				result += "</li>\n";
			}
		}

		result += "</ul>";

		return result;
	}
}
