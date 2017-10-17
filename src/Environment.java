import java.util.ArrayList;
import java.util.List;


public class Environment {
	private List<Spidder> spidders;
	private CensusData censusData;
	
	public Environment(CensusData censusData) {
		spidders = new ArrayList<>();
		this.censusData = censusData;
	}

	public void addSpidder(Spidder spid) {
		spidders.add(spid);
	}

	public void takeCensus() {
		censusData.record();
		//TODO
	}

	public void tick() {
		//collisions
		for(int i = 0; i < spidders.size(); i++){
			for(int j = i+1; i < spidders.size(); j++){
				collide(spidders.get(i), spidders.get(j));
			}
		}
	}

	private void collide(Spidder spidder1, Spidder spidder2) {
		// TODO Auto-generated method stub
		
	}
}
