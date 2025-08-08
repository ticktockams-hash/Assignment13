package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PorderDao;
import model.Porder;
import util.DbConnection;

public class PorderDaoImpl implements PorderDao{

	public static void main(String[] args) {
	//	System.out.println(new PorderDaoImpl().selectAll());
		List<Porder> l=new PorderDaoImpl().selectAll();
		int sum=0;
		int count=0;
		for(Porder o:l)
		{
			System.out.println(o.getId()+"\t"+o.getName()+"\tlcd:"+o.getLcd());
			sum=sum+o.getLcd();
			count++;
			
		}
		System.out.println("筆數:"+count+"\tlcd共="+sum);
	}
	private static Connection conn=DbConnection.getDb();
	@Override
	public void add(Porder porder) {
		String Sql="insert into porder(name,lcd,ram,mouse) values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(Sql);
			ps.setString(1,porder.getName());
			ps.setInt(2,porder.getLcd());
			ps.setInt(3,porder.getRam());
			ps.setInt(4,porder.getMouse());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Porder> selectAll() {
		String sql="select * from porder";
		List<Porder> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Porder p=new Porder();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setLcd(rs.getInt("lcd"));
				p.setRam(rs.getInt("ram"));
				p.setMouse(rs.getInt("mouse"));
				
				l.add(p);
			
			
			}
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return l;
	}

	@Override
	public Porder selectById(int id) {
		String sql="select * from porder where id=?";
		
		
		return null;
	}

	@Override
	public void update(Porder porder) {
		String sql="update porder set lcd=?,ram=?,mouse=? where id=?";
		
	}

	@Override
	public void delete(Porder porder) {
		String sql="delete from porder where id=?";
		
	}

}