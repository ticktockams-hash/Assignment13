package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.MemberDao;
import model.Member;
import util.DbConnection;

public class MemberDaoImpl implements MemberDao{

	public static void main(String[] args) {
		
		//Member m=new Member("abc","efg","1234","taipei","666");
		//new MemberDaoImpl().add(m);
		
        /*mberDaoImpl dao = new MemberDaoImpl();   
        // 假設 "efg" 的密碼是 "1234"

        System.out.println("--- 測試1: 使用者名稱與密碼登入 ---");
        // 測試 select(username, password) 方法
        Member loginMember = dao.select("efg", "1234");
        
        if (loginMember != null) {
            System.out.println("登入成功！使用者資訊：" + loginMember.getName());
        } else {
            System.out.println("登入失敗，使用者名稱或密碼錯誤。");
        }

        System.out.println("\n--- 測試2: 檢查使用者是否存在 ---");
        // 測試 select(username) 方法
        Member existMember = dao.select("efg");
        if (existMember != null) {
            System.out.println("使用者 " + existMember.getUsername() + " 已存在。");
            System.out.println("姓名: " + existMember.getName());
            System.out.println("地址: " + existMember.getAddress());
        } else {
            System.out.println("使用者不存在。");
        }*/

		
	}
	private static Connection conn=DbConnection.getDb();
	@Override
	public void add(Member member) {
		String sql="insert into member(name, username,password,address,phone)" +"values(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getUsername());
			ps.setString(3, member.getPassword());
			ps.setString(4, member.getAddress());
			ps.setString(5, member.getPhone());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Member select(String username, String password) {
		Member member=null;
		String sql="select * from member where username=? and password=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				member=new Member();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setUsername(rs.getString("password"));
				member.setPassword(rs.getString("address"));
				member.setPhone(rs.getString("Phone"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	@Override
	public Member select(String username) {
		Member member=null;
		String sql="select * from member where username=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				member=new Member();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("password"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	
	
}
