
public class Spidder {
	//unchanging
	private double maxSize, density, legRatio;
	
	//changing
	private double age, size, speed, metabolism, turnSpeed, hunger, thirst, mass, angle, x, y;
	
	private SpidderAction nextAction;
	
	public Spidder(double maxSize, double density, double legRatio){
		this.maxSize = maxSize;
		this.density = density;
		this.legRatio = legRatio;
		
		calculateInitialDependentStats();
	}

	private void calculateInitialDependentStats() {
		x = Math.random()*200;
		y = Math.random()*200;
		age = 0;
		nextAction = SpidderAction.FORWARD;
		
		angle = Math.random()*Math.PI*2;
		size = maxSize/10;
		speed = size*density*legRatio;
		metabolism = size * speed;
		turnSpeed = (1/density) * metabolism;
		mass = size * size * (1-legRatio);
	}
	
	private void moveAwayFrom(Spidder other){
		nextAction = SpidderAction.LEFT;
	}
	
	public void act(){
		switch(nextAction){
		case EAT:
			break;
		case FORWARD: walkForward();
			break;
		case LEFT:
			break;
		case RIGHT:
			break;
		case STOP:
			break;
		default:
			break;
		}
	}

	private void walkForward() {
		x += Math.sin(angle) * speed;
		y += Math.cos(angle) * speed;
	}

	private void turnLeft() {
		angle += turnSpeed;
		if(angle > Math.PI*2){
			angle -= Math.PI*2;
		}
	}
	
	private void turnRight() {
		angle -= turnSpeed;
		if(angle < 0){
			angle += Math.PI*2;
		}
	}
	
	private enum SpidderAction{
		LEFT(),
		RIGHT(),
		FORWARD(),
		STOP(),
		EAT();
	}
}
