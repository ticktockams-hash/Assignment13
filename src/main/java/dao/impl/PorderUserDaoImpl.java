package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PorderUserDao;
import model.PorderUser;
import util.DbConnection;

public class PorderUserDaoImpl implements PorderUserDao{

	private static Connection conn=DbConnection.getDb();
	@Override
	public void add(PorderUser porderuser) {
		String sql="insert into porderuser(name,waffle,salad,sandwich) values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, porderuser.getName());
			ps.setInt(2, porderuser.getWaffle());
			ps.setInt(3, porderuser.getSalad());
			ps.setInt(4, porderuser.getSandwich());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<PorderUser> selectAll() {
		String sql="select * from porderuser";
		List<PorderUser> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				PorderUser p =new PorderUser();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setWaffle(rs.getInt("waffle"));
				p.setSalad(rs.getInt("salad"));
				p.setSandwich(rs.getInt("sandwich"));
				
				l.add(p);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public PorderUser selectById(int id) {
		String sql="select * from porderuser where id=?";
		PorderUser p=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				p=new PorderUser();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setWaffle(rs.getInt("waffle"));
				p.setSalad(rs.getInt("salad"));
				p.setSandwich(rs.getInt("sandwich"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}

}
