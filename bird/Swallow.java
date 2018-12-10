package bird;

import cargo.*;

public abstract class Swallow 
{
	private Object cargo;
	
	public Swallow(Object cargo)
	{
		this.cargo = cargo;
	}
	
	public Object getObject()
	{
		return this.cargo;
	}
	
	public boolean isLadden()
	{
		if (this.cargo == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	protected abstract int getAirSpeedVelocity();
	
	protected int calculateAirspeed(int airspeed, Object cargo)
	{
		if (cargo instanceof Nut)
		{
			if (airspeed - ((Nut)cargo).getWeight() < 0)
			{
				return 0;
			}
			else
			{
				return (airspeed - ((Nut)cargo).getWeight());
			}
		}
		else if(cargo == null)
		{
			return airspeed;
		}
		else 
		{
			return airspeed / 2;
		}
	}
	
}
