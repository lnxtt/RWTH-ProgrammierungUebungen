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
                if (airspeed - ((Nut) cargo).getWeight() =<0){
                    return 0;
                }
			    else{
                    return (airspeed - ((Nut) cargo).getWeight());
                }
            }
            else {
                if (airspeed > 0) {
                    return airspeed / 2;
                }
                else{
                    return 0;
                }
            }
        }
        return airspeed;
    }

}
