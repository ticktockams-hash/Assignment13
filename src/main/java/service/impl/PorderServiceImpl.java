package service.impl;

import java.util.List;

import dao.impl.PorderDaoImpl;
import model.Porder;
import service.PorderService;

public class PorderServiceImpl implements PorderService{

	public static void main(String[] args) {
		
        PorderServiceImpl service = new PorderServiceImpl();

        System.out.println("--- 測試1: 新增一筆訂單 ---");
        Porder newOrder = new Porder("Betty", 2, 1, 4); 
        service.addPorder(newOrder);
        System.out.println("新增訂單完成！");

        System.out.println("\n--- 測試2: 查詢所有訂單 ---");
        List<Porder> allOrders = service.findAllPorder();
        System.out.println("目前所有訂單列表：");
        for (Porder p : allOrders) {
            System.out.println("ID:" + p.getId() + ", 姓名:" + p.getName());
        }
        

        int bettyOrderId = allOrders.get(allOrders.size() - 1).getId();
        System.out.println("剛剛新增的 Betty 訂單 ID 為: " + bettyOrderId);

        System.out.println("\n--- 測試3: 更新 Betty 的訂單 ---");

        Porder updateInfo = new Porder("Betty", 5, 5, 5);
        updateInfo.setId(bettyOrderId); 

        boolean isUpdateSuccess = service.updatePoder(updateInfo);
        if (isUpdateSuccess) {
            System.out.println("訂單 ID " + bettyOrderId + " 更新成功！");
        } else {
            System.out.println("訂單 ID " + bettyOrderId + " 更新失敗 (可能訂單不存在)。");
        }
        
       
        PorderDaoImpl daoForCheck = new PorderDaoImpl(); 
        Porder updatedOrder = daoForCheck.selectById(bettyOrderId);
        System.out.println("更新後的鬆餅數量為: " + updatedOrder.getWaffle());


        System.out.println("\n--- 測試4: 刪除 Betty 的訂單 ---");
        Porder deleteInfo = new Porder();
        deleteInfo.setId(bettyOrderId); 

        boolean isDeleteSuccess = service.deletePorder(deleteInfo);
        if (isDeleteSuccess) {
            System.out.println("訂單 ID " + bettyOrderId + " 刪除成功！");
        } else {
            System.out.println("訂單 ID " + bettyOrderId + " 刪除失敗 (可能訂單不存在)。");
        }

        // 驗證刪除結果
        Porder deletedOrder = daoForCheck.selectById(bettyOrderId);
        if (deletedOrder == null) {
            System.out.println("確認訂單 ID " + bettyOrderId + " 已被成功刪除。");
        }

	}
	
	private static PorderDaoImpl pdi=new PorderDaoImpl();

	@Override
	public void addPorder(Porder porder) {
		pdi.add(porder);
		
	}

	@Override
	public List<Porder> findAllPorder() {
		
		return pdi.selectAll();
	}

	@Override
	public boolean updatePoder(Porder porder) {
		Porder p=pdi.selectById(porder.getId());
		boolean x=false;
		if(p!=null)
		{
			x=true;
			pdi.update(porder);
		}
		return x;
	}

	@Override
	public boolean deletePorder(Porder porder) {
		Porder p=pdi.selectById(porder.getId());
		boolean x=false;
		if(p!=null)
		{
			x=true;
			pdi.delete(porder);
		}
		return x;
	}
	
}
