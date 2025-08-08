package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.MemberUserDao;
import model.MemberUser;
import util.DbConnection;

public class MemberUserDaoImpl implements MemberUserDao{

	private static Connection conn=DbConnection.getDb();
	
	public static void main(String[] args) {
	    
  

	}

	@Override
	public void add(MemberUser memberuser) {
		String sql="insert into memberuser(name, username,password,address,phone)" +"values(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, memberuser.getName());
			ps.setString(2, memberuser.getUsername());
			ps.setString(3, memberuser.getPassword());
			ps.setString(4, memberuser.getAddress());
			ps.setString(5, memberuser.getPhone());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            }
	}

	@Override
	public MemberUser select(String username, String password) {
		MemberUser memberuser=null;
		String sql="select * from memberuser where username=? and password=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				memberuser=new MemberUser();
				memberuser.setId(rs.getInt("id"));
				memberuser.setName(rs.getString("name"));
				memberuser.setUsername(rs.getString("password"));
				memberuser.setPassword(rs.getString("address"));
				memberuser.setPhone(rs.getString("Phone"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberuser;
	}

	@Override
	public MemberUser select(String username) {
		MemberUser memberuser=null;
		String sql="select * from memberuser where username=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				memberuser=new MemberUser();
				memberuser.setId(rs.getInt("id"));
				memberuser.setName(rs.getString("name"));
				memberuser.setUsername(rs.getString("username"));
				memberuser.setPassword(rs.getString("password"));
				memberuser.setAddress(rs.getString("address"));
				memberuser.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberuser;
	}

}
