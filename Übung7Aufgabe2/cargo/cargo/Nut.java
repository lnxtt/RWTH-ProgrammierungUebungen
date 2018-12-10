package cargo;

public class Nut 
{
	private String name;
	private int weight = 0;
	
	public Nut(){
		this.name = "";
		this.weight = 0;
	}

	public Nut(String name, int weight) {
		this.name = name;
		this.weight = weight;
		if(this.name == null)
		{
			this.name = "";
		}
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getWeight()
	{
		return this.weight;
	}
	
	public void setWeight(int weight)
	{
		this.weight = weight;
	}

}
