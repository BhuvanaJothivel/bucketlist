package service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.TouristPlace;

public class ListOperations {
	
	//Addition of places
	List<TouristPlace> list = new ArrayList<TouristPlace>();
	
	public List<TouristPlace> add(TouristPlace places) throws IOException {
		list.add(places);
		return list;
	}
	
	//Sorting by destination
	public List<TouristPlace> sortByDestination(List<TouristPlace> places) throws IOException {
		places.sort((TouristPlace p1,TouristPlace p2)-> p2.getDestination().compareTo(p1.getDestination()));
		return places;	
    }
	
	//Sorting by rank
	public List<TouristPlace> sortByRank(List<TouristPlace> places) throws IOException {
    	places.sort((TouristPlace p1,TouristPlace p2)-> p1.getRank().compareTo(p2.getRank()));
        return places;
	}
}