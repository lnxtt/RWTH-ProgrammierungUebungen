package bird.swallows;

import bird.Swallow;

public class EuropeanSwallow extends Swallow {

	private int airSpeedVelocity = 11;
	
	public EuropeanSwallow(Object cargo)
	{
		super(cargo);
	}
	
	@Override
	protected int getAirSpeedVelocity() 
	{
		return super.calculateAirspeed(airSpeedVelocity, this.getObject());
	}
	
	public static EuropeanSwallow createEuropeanSwallow(Object cargo)
	{
		return new EuropeanSwallow(cargo);
	}

}
