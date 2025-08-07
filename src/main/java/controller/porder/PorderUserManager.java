package controller.porder;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginUser;
import model.MemberUser; 
import model.PorderUser;  
import util.Tool;       

import javax.swing.JLabel;
import javax.swing.JOptionPane; 
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PorderUserManager extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField waffle;
    private JTextField salad;
    private JTextField sandwich;
    private MemberUser memberUser; 

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PorderUserManager frame = new PorderUserManager();
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
    public PorderUserManager() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblWelcome = new JLabel("歡迎, "); 
        lblWelcome.setFont(new Font("新細明體", Font.PLAIN, 15));
        lblWelcome.setBounds(10, 10, 200, 32); 
        contentPane.add(lblWelcome);

        
        Object obj = Tool.readFile("memberuser.txt");
        if (obj != null) {
            memberUser = (MemberUser) obj;
            lblWelcome.setText("歡迎, " + memberUser.getName()); 
        } else {
            lblWelcome.setText("歡迎, 訪客 (讀取資料失敗)");
           
        }
       

        JLabel lblNewLabel_1 = new JLabel("鬆餅套餐(119)");
        lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(29, 81, 110, 18);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("沙拉套餐(109)");
        lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(29, 135, 110, 18);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("總匯套餐(129)");
        lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 15));
        lblNewLabel_3.setBounds(33, 189, 106, 18);
        contentPane.add(lblNewLabel_3);

        waffle = new JTextField("0"); 
        waffle.setBounds(149, 80, 96, 21);
        contentPane.add(waffle);
        waffle.setColumns(10);

        salad = new JTextField("0"); 
        salad.setBounds(149, 134, 96, 21);
        contentPane.add(salad);
        salad.setColumns(10);

        sandwich = new JTextField("0");
        sandwich.setBounds(149, 188, 96, 21);
        contentPane.add(sandwich);
        sandwich.setColumns(10);
        
        
		JLabel timeLabel = new JLabel("時間載入中...");
		timeLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
		timeLabel.setBounds(244, 22, 180, 20); 
		contentPane.add(timeLabel);

		
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				timeLabel.setText(Tool.getCurrentTime());
			}
		});
		timer.start(); 

        //Button
        JButton btnNewButton = new JButton("確認");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    int Waffle = Integer.parseInt(waffle.getText());
                    int Salad = Integer.parseInt(salad.getText());
                    int Sandwich = Integer.parseInt(sandwich.getText());

                    if (memberUser == null) {
                        JOptionPane.showMessageDialog(null, "錯誤：找不到使用者資訊，請重新登入。");
                        return;
                    }

                    
                    PorderUser porderUser = new PorderUser(memberUser.getName(), Waffle, Salad, Sandwich);
                    
                  
                    Tool.saveFile(porderUser, "porderuser.txt");

                    
                    FinishUser finishuser = new FinishUser();
                    finishuser.setVisible(true);
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "數量請輸入有效的數字！");
                }
            }
        });
        btnNewButton.setBounds(284, 101, 87, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("清除");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                waffle.setText("0");
                salad.setText("0");
                sandwich.setText("0");
            }
        });
        btnNewButton_1.setBounds(284, 144, 87, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("回登入頁"); 
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginUser loginuser = new LoginUser();
                loginuser.setVisible(true);
                dispose();
            }
        });
        btnNewButton_2.setBounds(284, 187, 87, 23);
        contentPane.add(btnNewButton_2);
    }
}