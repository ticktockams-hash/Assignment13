package service;

import model.Member;

public interface MemberService {
	//create
	boolean addMember(Member member);
	
	//read
	Member login(String username,String password);
	
	//update
	
	//delete
}
