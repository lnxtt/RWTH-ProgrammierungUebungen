package bird;

import java.util.ArrayList;

public class Flock <S extends Swallow> implements FlockInterface
{
	private ArrayList<S> birds;
	
	public Flock()
	{
		birds = new ArrayList<S>();
	}
	
	public void join (S bird)
	{
		this.birds.add(bird);
	}
	
	public double getAverageCruiseAirspeedVelocity()
	{
		double speedAll = 0;
		double counter = 1;
		for(S bird : birds)
		{
			int speed = bird.getAirSpeedVelocity();
			if(counter == 1)
			{
				speed -= 2;
			}
			else if(counter == 2)
			{
				speed -= 1;
			}
			speedAll += speed;
			counter ++;
		}
		return (speedAll / counter);
	}

}
