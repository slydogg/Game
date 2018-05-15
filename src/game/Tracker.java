package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/**
 * Tracker Class implements StepListener.
 * @author Negar
 */
public class Tracker implements StepListener {
    
    private final WorldView view;
    private final Body body;

    public Tracker(WorldView view, Body body) {
        this.view = view;
        this.body = body;
    }

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {
        //view.setCentre(new Vec2(body.getPosition()));
        float x = body.getPosition().x;
        float y = view.getCentre().y;
        view.setCentre(new Vec2(x, y));
    }   
}
