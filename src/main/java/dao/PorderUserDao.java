package dao;

import java.util.List;

import model.PorderUser;

public interface PorderUserDao {

	//create
	void add(PorderUser porder);
	
	//read
	List<PorderUser> selectAll();
	PorderUser selectById(int id);

	//update

	
	//delete

	
}
