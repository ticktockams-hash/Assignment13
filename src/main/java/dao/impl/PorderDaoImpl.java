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

	        PorderDaoImpl dao = new PorderDaoImpl();

	        // --- 測試 Create (新增) ---
	        System.out.println("--- 測試新增功能 ---");
	        // 建立一個新的 Porder 物件，準備新增到資料庫
	        Porder p_add = new Porder("chi", 3, 2, 1); // 假設 Porder 的建構子是 (name, waffle, salad, sandwich)
	        dao.add(p_add);
	        System.out.println("新增訂單完成！");

	        /*// --- 測試 Read (查詢全部) ---
	        System.out.println("\n--- 測試查詢全部功能 ---");
	        // 呼叫 selectAll() 取得所有訂單
	        List<Porder> allPorders = dao.selectAll();
	        // 迴圈印出每一筆訂單，確認剛剛新增的是否在裡面
	        for (Porder p : allPorders) {
	            System.out.println("ID:" + p.getId() + ", 姓名:" + p.getName() + ", 鬆餅:" + p.getWaffle());
	        }

	        // --- 測試 Read (依 ID 查詢) ---
	        // 假設我們知道 chi 的訂單 ID 是 5 (請根據您資料庫的實際情況修改)
	        int testId = 5; 
	        System.out.println("\n--- 測試依ID查詢功能 (ID=" + testId + ") ---");
	        Porder p_select = dao.selectById(testId);
	        if (p_select != null) {
	            System.out.println("找到了！姓名：" + p_select.getName() + ", 三明治：" + p_select.getSandwich());
	        } else {
	            System.out.println("找不到 ID 為 " + testId + " 的訂單");
	        }
	        
	        // --- 測試 Update (更新) ---
	        System.out.println("\n--- 測試更新功能 ---");
	        // 我們把剛剛查到的 chi 的訂單，鬆餅數量改成 10
	        if (p_select != null) {
	            p_select.setWaffle(10); // 修改物件的內容
	            dao.update(p_select); // 呼叫 update 方法寫回資料庫
	            System.out.println("ID 為 " + p_select.getId() + " 的訂單已更新！");
	            
	            // 再次查詢，驗證是否更新成功
	            Porder p_updated = dao.selectById(testId);
	            System.out.println("更新後鬆餅數量：" + p_updated.getWaffle());
	        }

	        // --- 測試 Delete (刪除) ---
	        System.out.println("\n--- 測試刪除功能 ---");
	        // 我們把 chi 的訂單刪除
	        if (p_select != null) {
	            dao.delete(p_select);
	            System.out.println("ID 為 " + p_select.getId() + " 的訂單已刪除！");

	            // 再次查詢，驗證是否真的被刪除
	            Porder p_deleted = dao.selectById(testId);
	            if (p_deleted == null) {
	                System.out.println("確認訂單已被成功刪除。");
	            }
	        }*/
	  

	}
	private static Connection conn=DbConnection.getDb();
	@Override
	public void add(Porder porder) {
		String sql="insert into porder(name,waffle,salad,sandwich) values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, porder.getName());
			ps.setInt(2, porder.getWaffle());
			ps.setInt(3, porder.getSalad());
			ps.setInt(4, porder.getSandwich());
			
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
				Porder p =new Porder();
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
	public Porder selectById(int id) {
		String sql="select * from porder where id=?";
		Porder p=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				p=new Porder();
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
	@Override
	public void update(Porder porder) {
		String sql="update porder set waffle=?,salad=?,sandwich=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, porder.getWaffle());
			ps.setInt(2, porder.getSalad());
			ps.setInt(3, porder.getSandwich());
			ps.setInt(4, porder.getId());
			
			ps.executeUpdate();

	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void delete(Porder porder) {
		String sql="delete from porder where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, porder.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
