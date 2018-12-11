package bird;

import cargo.*;

public abstract class Swallow {
    private Object cargo;

    public Swallow(Object cargo) {
        this.cargo = cargo;
    }

    public Object getObject() {
        return this.cargo;
    }

    public boolean isLadden() {
        return this.cargo != null;
    }

    protected abstract int getAirSpeedVelocity();

    protected int calculateAirspeed(int airspeed, Object cargo) {
        if (cargo != null) {
            if (cargo instanceof Nut) {
                int speed = airspeed-((Nut)cargo).getWeight();
                if (speed<0) {return 0;}
                return speed;
            }
            return airspeed/2;

        }
        return airspeed;
    }
}
