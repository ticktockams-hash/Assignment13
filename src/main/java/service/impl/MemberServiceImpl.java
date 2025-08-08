package service.impl;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService{

	public static void main(String[] args) {
		//Member m=new Member("abc","teacher","456","高雄市","77");
		
		//System.out.println(new MemberServiceImpl().addMember(m));
		
		//System.out.println(new MemberServiceImpl().login("teacher", "45633"));

	}
	
	private static MemberDaoImpl mdi=new MemberDaoImpl();

	@Override
	public boolean addMember(Member member) {
		/*
		 * 1.判斷帳號重複->null
		 * 2.null-->註冊-->true-->成功
		 * 3.!=null-->重複-->false-->失敗
		 */
		boolean isUsernameBeeUse=false;
		Member m=mdi.select(member.getUsername());
		if(m==null)
		{
			mdi.add(member);
			isUsernameBeeUse=true;
		}
		
		return isUsernameBeeUse;
	}

	@Override
	public Member login(String username, String password) {
		return mdi.select(username, password);
	}

}
