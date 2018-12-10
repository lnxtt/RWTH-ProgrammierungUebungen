package bird.swallows;

import bird.Swallow;

public class AfricanSwallow extends Swallow 
{
	private int airSpeedVelocity = 12;

	public AfricanSwallow(Object cargo) {super(cargo);}
	
	@Override
	protected int getAirSpeedVelocity() 
	{
		return super.calculateAirspeed(airSpeedVelocity, this.getObject());
	}
	
	public static AfricanSwallow createAfricanSwallow(Object cargo)
	{
		return new AfricanSwallow(cargo);
	}

}
