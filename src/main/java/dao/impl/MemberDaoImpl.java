package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.MemberDao;
import model.Member;
import model.Porder;
import service.impl.MemberServiceImpl;
import util.DbConnection;

public class MemberDaoImpl implements MemberDao{

	public static void main(String[] args) {
		//新增資料
		Member m=new Member("steve","abcz","4321","高雄市","3");
		
		new MemberDaoImpl().add(m);
		//Member m=new Member("john","def","1234","台北市","00023");
		
		//System.out.println(new MemberServiceImpl().addMember(m));
		
		//System.out.println(new MemberDaoImpl().select("uuoo"));

	}
	private static Connection conn=DbConnection.getDb();
	@Override
	public void add(Member member) {
		String sql="insert into member(name,username,password,address,phone) "
				+ "values(?,?,?,?,?)";
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
				member.setPassword(rs.getString("Password"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
				
				
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
				member.setUsername(rs.getString("useranme"));
				member.setPassword(rs.getString("Password"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
