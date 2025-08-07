package service.impl;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService{

	public static void main(String[] args) {
		
        /*MemberServiceImpl service = new MemberServiceImpl();

        System.out.println("--- 測試1: 註冊一個新使用者 ---");
        
        Member newMember = new Member("chi", "chi23", "password123", "chichi", "0987654321");
        
        
        boolean isAddSuccess = service.addMember(newMember);
        if (isAddSuccess) {
            System.out.println("使用者 " + newMember.getUsername() + " 註冊成功！");
        } else {
            System.out.println("註冊失敗，使用者名稱 " + newMember.getUsername() + " 已被使用。");
        }

        System.out.println("\n--- 測試2: 嘗試註冊一個已存在的使用者 ---");
        
        boolean isAddSuccessAgain = service.addMember(newMember);
        if (isAddSuccessAgain) {
            System.out.println("使用者 " + newMember.getUsername() + " 註冊成功！");
        } else {
            System.out.println("註冊失敗，使用者名稱 " + newMember.getUsername() + " 已被使用。");
        }
        
        System.out.println("\n--- 測試3: 使用正確的帳號密碼登入 ---");
        Member loginMember = service.login("chi123", "password123");
        if (loginMember != null) {
            System.out.println("登入成功！歡迎, " + loginMember.getName());
        } else {
            System.out.println("登入失敗，使用者名稱或密碼錯誤。");
        }

        System.out.println("\n--- 測試4: 使用錯誤的密碼登入 ---");
        Member loginFailedMember = service.login("chi123", "wrong_password");
        if (loginFailedMember != null) {
            System.out.println("登入成功！歡迎, " + loginFailedMember.getName());
        } else {
            System.out.println("登入失敗，使用者名稱或密碼錯誤。");
        }*/
		
		System.out.println(new MemberServiceImpl().login("chi23","password123"));

	}
	
	private static MemberDaoImpl mdi=new MemberDaoImpl();

	@Override
	public boolean addMember(Member member) {
		boolean isUsernameBeenUse=false;
		Member m=mdi.select(member.getUsername());
		if(m==null)
		{
			mdi.add(member);
			isUsernameBeenUse=true;
		}
		return isUsernameBeenUse;
	}

	@Override
	public Member login(String username, String password) {
		
		return mdi.select(username, password);
	}
	
}
