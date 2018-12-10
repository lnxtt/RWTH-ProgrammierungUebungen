package people;

import bird.*;

public class Troll 
{
	private boolean confused;
	
	public Troll()
	{
		this.confused = false;
	}
	
	public void pass()
	{
		if( this.confused == false)
		{
			java.lang.System.exit(-1);
		}
	}
	
	public double askAboutAirspeedVelocity(Object asking) throws UnspecificQuestionException
	{
		if (asking instanceof FlockInterface)
		{
			return ((FlockInterface)asking).getAverageCruiseAirspeedVelocity();
		}
		else if (asking instanceof Swallow)
		{
			Flock<Swallow> flock = new Flock<Swallow>();
			flock.join((Swallow)asking);
			return flock.getAverageCruiseAirspeedVelocity() + 2;
		}
		else if(asking instanceof String)
		{
			if(((String)asking).equals("Swallow")||((String)asking).equals("Unladden Swallow")||((String)asking).equals("Europeanswallow")||((String)asking).equals("Africanswallow"));
			{
				this.confused = true;
				throw new UnspecificQuestionException();
			}
		}
		return 0;
	}

}
