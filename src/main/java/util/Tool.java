package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.Member;

public class Tool {

	public static void main(String[] args) {
		//Tool.saveFile(new Member("abc","abc","789","taipei","000"), "c:/ABC/member.txt");
		
		//System.out.println(Tool.readFile("c:/ABC/member.txt"));
		
		//Member m=(Member)Tool.readFile("c:/ABC/member.txt");
				
		//System.out.println(m.getName()+"\t"+m.getUsername()+"\t"+m.getPassword());
		
		/*
		 * 		

		// --- 測試1: 儲存並讀取 Member 物件 ---
		System.out.println("\n--- 測試1: 儲存並讀取 Member 物件 ---");
		Member memberOriginal = new Member("Ken", "ken123", "ppp111", "Tainan", "0911222333");
		String memberFileName = "member_test.dat"; // 定義存檔的檔名
		
		// 2. 呼叫 saveFile 方法進行存檔
		System.out.println("正在儲存 Member 物件: " + memberOriginal.getName());
		Tool.saveFile(memberOriginal, memberFileName);
		System.out.println("儲存成功！");

		// 3. 呼叫 readFile 方法讀取檔案
		System.out.println("正在讀取 Member 物件...");
		Object objFromFile = Tool.readFile(memberFileName);
		
		// 4. 驗證讀回來的物件
		if (objFromFile != null && objFromFile instanceof Member) {
			// 將 Object 型態強制轉型回 Member 型態
			Member memberRead = (Member) objFromFile;
			System.out.println("讀取成功！讀回來的姓名是: " + memberRead.getName());
			
			// 比對原始物件和讀回物件的內容是否一致
			if (memberOriginal.getUsername().equals(memberRead.getUsername())) {
				System.out.println("驗證成功：使用者名稱一致！");
			} else {
				System.out.println("驗證失敗：使用者名稱不一致！");
			}
		} else {
			System.out.println("讀取失敗或物件型態不符！");
		}


		// --- 測試2: 儲存並讀取 Porder 物件 ---
		System.out.println("\n--- 測試2: 儲存並讀取 Porder 物件 ---");
		// 1. 建立一個原始的 Porder 物件
		Porder porderOriginal = new Porder("Jessica", 3, 2, 1);
		porderOriginal.setId(101); // 假設 ID 是 101
		String porderFileName = "porder_test.dat";

		// 2. 存檔
		System.out.println("正在儲存 Porder 物件 (ID: " + porderOriginal.getId() + ")");
		Tool.saveFile(porderOriginal, porderFileName);
		System.out.println("儲存成功！");

		// 3. 讀檔
		System.out.println("正在讀取 Porder 物件...");
		Object porderObjFromFile = Tool.readFile(porderFileName);

		// 4. 驗證
		if (porderObjFromFile != null && porderObjFromFile instanceof Porder) {
			Porder porderRead = (Porder) porderObjFromFile;
			System.out.println("讀取成功！讀回來的訂購人是: " + porderRead.getName());
			
			if (porderOriginal.getWaffle() == porderRead.getWaffle()) {
				System.out.println("驗證成功：鬆餅數量一致！");
			} else {
				System.out.println("驗證失敗：鬆餅數量不一致！");
			}
		} else {
			System.out.println("讀取失敗或物件型態不符！");
		}
		 */

	}
	
	public static void saveFile(Object object,String fileName)
	{
		try {
			FileOutputStream fos=new FileOutputStream(fileName);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(object);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Object readFile(String fileName)
	{
		Object object=null;
		
		try {
			FileInputStream fis=new FileInputStream(fileName);
			ObjectInputStream ois=new ObjectInputStream(fis);
			object=ois.readObject();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return object;
	}
	
	public static String getCurrentTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return LocalDateTime.now().format(formatter);
	}
}
