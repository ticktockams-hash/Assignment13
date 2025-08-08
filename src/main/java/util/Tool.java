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

		
		System.out.println("\n--- 測試時間格式化工具 ---");
		String formattedTime = Tool.getFormattedNow(); // 呼叫我們的新方法
		System.out.println("格式化後的當前時間為: " + formattedTime);
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

	//讀取物件檔
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
	
	public static String getFormattedNow() {
		// 1. 取得當前的日期與時間
		LocalDateTime now = LocalDateTime.now();
		
		// 2. 建立一個格式化樣板
 		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年-M月-d日  HH點-mm分-ss秒");
 		
 		// 3. 使用該樣板將當前時間轉換為字串
 		String formattedDateTime = now.format(formatter);
 		
 		// 4. 回傳格式化後的字串
 		return formattedDateTime;
	}
}
