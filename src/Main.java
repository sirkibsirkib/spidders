
public class Main {
	

	private static final int NUMBER_OF_STARTING_SPIDDERS = 20;
	private static final int SIM_TICKS = 1_000;
	private static final int SIM_INTERVALS = 30;

	private static void start() {
		CensusData censusData = new CensusData();
		Environment env = new Environment(censusData);
		for(int i = 0; i < NUMBER_OF_STARTING_SPIDDERS; i++){
			env.addSpidder(startSpidder());
		}
		for(int i = 0; i < SIM_TICKS; i++){
			env.tick();
			if(i % SIM_INTERVALS == 0){
				env.takeCensus();
			}
		}
		
	}
	
	private static Spidder startSpidder() {
		return new Spidder(randRange(10, 15), randRange(10, 15), randRange(.3, .5));
	}

	private static double randRange(double from, double to) {
		if(to < from){
			double c = from;
			from = to;
			to = c;
		}
		return Math.random()*(to-from) + to;
	}

	public static void main(String[] args){
		start();
	}
}
