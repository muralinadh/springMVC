package com.murali;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.murali.logistics.model.*;
@Service
public class ProjectService {
	
	List<Logistics> logisticCollection = new ArrayList<Logistics >();
	
	public ProjectService(){
		
		Logistics l1 = new Logistics(101, "Hathway", 23.4f);
		Logistics l2 = new Logistics(102, "FedEx", 232.4f);
		Logistics l3 = new Logistics(103, "Passage", 13.4f);
		
		logisticCollection.add(l1);
		logisticCollection.add(l2);
		logisticCollection.add(l3);
		
	}
	
	public List<Logistics> getAllLogistics(){
		return logisticCollection;
	}

}
