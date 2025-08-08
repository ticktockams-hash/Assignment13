package dao;


import model.MemberUser;

public interface MemberUserDao {

	//create
	void add(MemberUser memberuser);
	//read
	MemberUser select(String username,String password);
	MemberUser select(String username);
	//update
	
	//delete
}
