package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Porder;
import service.impl.PorderServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeletePorder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField delID;
	private PorderServiceImpl psi = new PorderServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletePorder frame = new DeletePorder();
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
	public DeletePorder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(96, 62, 46, 15);
		contentPane.add(lblNewLabel);
		
		delID = new JTextField();
		delID.setBounds(172, 59, 96, 21);
		contentPane.add(delID);
		delID.setColumns(10);
		
		
		
		//Button
		JButton btnNewButton = new JButton("刪除");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int DELID=Integer.parseInt(delID.getText());
				
				Porder p=new Porder();
				p.setId(DELID);
				
				boolean isSuccess = psi.deletePorder(p);
				
				if (isSuccess) {
		        
		            JOptionPane.showMessageDialog(null, "訂單 ID: " + DELID + " 刪除成功！");
		        } else {
		           
		            JOptionPane.showMessageDialog(null, "刪除失敗，找不到訂單 ID: " + DELID);
		        }
				//psi.deletePorder(p);
				
			}
		});
		btnNewButton.setBounds(84, 181, 87, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PorderManager porderManager=new PorderManager();
				porderManager.setVisible(true);
				dispose();	
			}
		});
		btnNewButton_1.setBounds(210, 181, 87, 23);
		contentPane.add(btnNewButton_1);

	}

}
