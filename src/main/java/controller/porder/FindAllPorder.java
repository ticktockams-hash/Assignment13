package controller.porder;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.PorderDaoImpl;
import model.Porder;
import service.impl.PorderServiceImpl;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class FindAllPorder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField lcd;
	private JTextField ram;
	private JTextField mouse;
	private static  PorderServiceImpl psi=new PorderServiceImpl();
	private JTextField delID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindAllPorder frame = new FindAllPorder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FindAllPorder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 
		
		List<Porder> l=psi.findAllPorder();
		String show="";
		int count=0;//比數
		int LCD=0;
		int RAM=0;
		int MOUSE=0;
		
		for(Porder p:l)
		{
			show=show+
					"id:"+p.getId()+"\tname:"+p.getName()+"\tlcd:"+p.getLcd()+"\tram:"+p.getRam()+"\tmouse:"+p.getMouse()+"\n";
			count++;
			LCD=LCD+p.getLcd();
			RAM=RAM+p.getRam();
			MOUSE=MOUSE+p.getMouse();
		}
		
		
		
		
		JTextArea allPorder = new JTextArea();
		allPorder.setBounds(32, 34, 633, 257);
		contentPane.add(allPorder);
		allPorder.setText(show);
		
		JLabel sum = new JLabel("");
		sum.setBounds(32, 301, 633, 45);
		contentPane.add(sum);
		
		int allSum=LCD*4999+RAM*799+MOUSE*200;
		sum.setText("筆數:"+count+"    LCD:"+LCD+"  RAM:"+RAM+"  MOUSE:"+MOUSE+"   銷售總金額:"+allSum+"元");
		
		JButton btnNewButton = new JButton("回管理頁");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PorderManager pm=new PorderManager();
				pm.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(32, 519, 87, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(32, 356, 623, 67);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 28, 32, 15);
		panel.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(37, 25, 51, 21);
		panel.add(id);
		id.setColumns(10);
		
		JLabel tt = new JLabel("lCD");
		tt.setFont(new Font("新細明體", Font.BOLD, 12));
		tt.setBounds(110, 28, 46, 15);
		panel.add(tt);
		
		lcd = new JTextField();
		lcd.setBounds(158, 25, 51, 21);
		panel.add(lcd);
		lcd.setColumns(10);
		
		JLabel lblRam = new JLabel("RAM");
		lblRam.setFont(new Font("新細明體", Font.BOLD, 12));
		lblRam.setBounds(255, 28, 46, 15);
		panel.add(lblRam);
		
		JLabel lblMouse = new JLabel("MOUSE");
		lblMouse.setFont(new Font("新細明體", Font.BOLD, 12));
		lblMouse.setBounds(374, 31, 46, 15);
		panel.add(lblMouse);
		
		ram = new JTextField();
		ram.setBounds(290, 25, 51, 21);
		panel.add(ram);
		ram.setColumns(10);
		
		mouse = new JTextField();
		mouse.setBounds(430, 25, 58, 21);
		panel.add(mouse);
		mouse.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int ID=Integer.parseInt(id.getText());
				int Lcd=Integer.parseInt(lcd.getText());
				int Ram=Integer.parseInt(ram.getText());
				int Mouse=Integer.parseInt(mouse.getText());
				Porder p=new Porder();
				p.setId(ID);
				p.setLcd(Lcd);
				p.setRam(Ram);
				p.setMouse(Mouse);
				
				psi.updatePorder(p);
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(515, 24, 87, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(32, 433, 623, 53);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 13, 32, 15);
		panel_1.add(lblNewLabel_1);
		
		delID = new JTextField();
		delID.setColumns(10);
		delID.setBounds(37, 10, 51, 21);
		panel_1.add(delID);
		
		JButton btnNewButton_2 = new JButton("刪除");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int DELID=Integer.parseInt(delID.getText());
				
				Porder p=new Porder();
				p.setId(DELID);
				
				psi.deletePorder(p);
			}
		});
		btnNewButton_2.setBounds(171, 9, 87, 23);
		panel_1.add(btnNewButton_2);

	}
}