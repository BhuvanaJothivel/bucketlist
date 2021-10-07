package tesing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.TouristPlace;

public class TestTouristPlace {
	
	@Test
	public void testSetInputsMethod() {
		TouristPlace tp = new TouristPlace("John","Paris","1");
		assertEquals("John",tp.getName());
		assertEquals("Paris",tp.getDestination());
		assertEquals("1",tp.getRank());
		try {
			tp.setName(null);
			tp.setDestination(null);
			tp.setRank(null);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
