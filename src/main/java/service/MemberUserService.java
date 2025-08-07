package service;

import model.MemberUser;

public interface MemberUserService {

	//create
	boolean addMemberUser(MemberUser memberuser);
	
	//read
	MemberUser login(String username,String password);
	
	//update
	
	//delete
}
