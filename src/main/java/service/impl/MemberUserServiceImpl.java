package service.impl;

import dao.impl.MemberUserDaoImpl;

import model.MemberUser;
import service.MemberUserService;

public class MemberUserServiceImpl implements MemberUserService{

	private static MemberUserDaoImpl mdi=new MemberUserDaoImpl();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addMemberUser(MemberUser memberuser) {

	    MemberUser existingUser = mdi.select(memberuser.getUsername());

	    if (existingUser != null) {

	        return false;
	    } else {

	        mdi.add(memberuser);

	        return true;
	    }
	}

	@Override
	public MemberUser login(String username, String password) {
		// TODO Auto-generated method stub
		return mdi.select(username, password);
	}

}
