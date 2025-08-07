package service.impl;

import java.util.List;


import dao.impl.PorderUserDaoImpl;
import model.PorderUser;

import service.PorderUserService;






public class PorderUserServiceImpl implements PorderUserService{
	
	private static PorderUserDaoImpl pdi=new PorderUserDaoImpl();
	
	@Override
	public void addPorderUser(PorderUser porderuser) {
		pdi.add(porderuser);
		
	}

	@Override
	public List<PorderUser> findAllPorderUser() {
		
		return pdi.selectAll();
	}
	

}
