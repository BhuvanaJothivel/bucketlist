package tesing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.TouristPlace;

public class TestListOperation {
	@Test
	public void testAddMethod() {
		TouristPlace tp = new TouristPlace("John","Paris","1");
		List<TouristPlace> list = new ArrayList<TouristPlace>();
		list.add(tp);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
			assertEquals(tp.getName(),list.get(i));
			assertEquals(tp.getDestination(),list.get(i));
			assertEquals(tp.getRank(),list.get(i));
		}
		
		try {
			tp.setName(null);
			tp.setDestination(null);
			tp.setRank(null);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
