package service;

import java.util.List;

import model.Member;
import model.Porder;

public interface PorderService {

	//create
	void addPorder(Porder porder);
	
	//read
	List<Porder> findAllPorder();
	
	//update
	boolean updataPorder(Porder porder);
	
	//delete
	boolean deletePorder(Porder porder);

	
}
