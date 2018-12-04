
public class Printer implements Visitor 
{
	private String print;

	public void visitFile(String name, File file) 
	{
		print = help(print, file);
		print += name;
		System.out.println(print);
		System.out.println("> " + file.readContent());
	}

	@Override
	public void visitDirectory(String name, Directory directory) 
	{
		if (print == null)
		{
			print = directory.getLastModified() + " /";
		}
		else
		{
			print = help(print, directory);
			print += name + "/";
			
		}
		System.out.println(print);

	}

	@Override
	public void visitedDirectory() 
	{
		

	}
	
	private String help(String input, Node node)
	{
		String[] g = input.split("/");
		g[0] = node.getLastModified() + " ";
		String h = "";
		for(int i = 0; i < g.length; i++)
		{
			h+= g[i] + "/";
		}
		return h;
	}
	

	private String helpagain(String input)
	{
		String[] g = input.split("/");
		String h = "";
		for(int i = 0; i < g.length - 1; i++)
		{
			h+= g[i] + "/";
		}
		return h;
	}
	
	public void reset()
	{
		print = helpagain(print);
	}

}
