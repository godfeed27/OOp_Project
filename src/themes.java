
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.text.ParseException;

	public class Themes extends JFrame{
		
		//các Container
		JPanel pn1=new JPanel(new FlowLayout(1, 50, 0));
		JPanel pn2=new JPanel();
		JPanel pn3=new JPanel();
		JPanel pn4=new JPanel();
		
		//pn1: ảnh và logo
    	JLabel anh_TrangWeb=new JLabel();
    	JLabel ten_TrangWeb=new JLabel("Banking Manager");
		
		//pn2 :các nút phần đăng nhập
		JLabel stk_label=new JLabel("Số tài khoản    ");
    	JLabel mk_label=new JLabel("Mật khẩu    ");
    	JTextField stk_textfiel=new JTextField(15);
    	JTextField mk_passfiel=new JPasswordField(15);
    	JButton dangNhap_Button=new JButton("Đăng nhập");
    	
    	//PN3:các option
    	JRadioButton so_duRadioButton=new JRadioButton("Số dư");
    	JRadioButton chuyen_tienRadioButton=new JRadioButton("Chuyển tiền");
    	JRadioButton tien_laiRadioButton=new JRadioButton("Tiền lãi");
    	JRadioButton thong_tinRadioButton=new JRadioButton("Thông tin");
    	JRadioButton dang_xuatRadioButton=new JRadioButton("Đăng xuất");
    	JButton xac_nhanButton=new JButton("Xác nhận");
    	JButton chinh_suaButton=new JButton("Chỉnh sửa");
    	JButton doi_mat_khauButton=new JButton("      Đổi mật khẩu      ");
    	
    	//Pn4: 
    	
    	//label hiện thông tin
    	JTextField tenTextField=new JTextField();
		JTextField ngay_sinhTextField=new JTextField();
		JTextField sdtTextField=new JTextField();
		JTextField dia_chiTextField=new JTextField();
		JTextField emailTextField=new JTextField();
    	//button chuyen tien
    	JButton nhap_stkButton=new JButton("Nhập số tài khoản");
    	JButton nhap_so_tienButton=new JButton("     Nhập số tiền     ");
    	JButton chuyen_tienButton=new JButton("Chuyển tiền");
    	
    	//các label báo thông tin của phần chuyển tiền
    	JLabel othe_stkLabel=new JLabel();
    	JLabel othe_tenLabel=new JLabel();
    	JLabel othe_so_tienLabel=new JLabel();
    	JLabel othe_phiLabel=new JLabel();
    	JLabel trang_thai_stkLabel=new JLabel();
    	JLabel trang_thai_so_tienLabel=new JLabel();
    	
    	//panel phụ để set up các vị trí đặc biệt
    	JPanel extraPanel1=new JPanel(new FlowLayout(0,0,22));
    	JPanel extraPanel2=new JPanel(new FlowLayout(0,50,0));
    	JPanel extraPanel3=new JPanel(new FlowLayout(0,50,0));
    	
    	// các giá trị khi chuyển tiền 
    	int so_tien_nhap_vao;
    	
    	
    	// các list ngân hàng và tỉnh thành
    	List_Account lst_acc=new List_Account();
    	
    	//layble để ngăn cách sự tự nhảy khỏi chế độ chỉnh sửa
    	JTextField xongTextField=new JTextField();	
    	
    	//chỉ số tài khoản hiện tại và tài khoản nhận tiền
		int chi_soAcc=-1;
		int chi_soAccTo=-1;
    			
	    public  Themes() {
	    	setVisible(true);
			Dieu_Khien();
			Dang_nhap_actionPerformed();
			Xu_li_lua_chon();
	    	
		}
	
	    private void Dieu_Khien() {
	
	    	// taoj jframe
	    	setTitle("Manager");
	    	setSize(900, 600);
	    	setLocationRelativeTo(null);
	    	setLayout(new GridLayout(4,1));
	    	pn1.setBackground(Color.WHITE);
	    	pn2.setBackground(Color.WHITE);
	    	pn3.setBackground(Color.WHITE);
	    	pn4.setBackground(Color.WHITE);
	    	add(pn1);
	    	add(pn2);
	    	add(pn3);
	    	add(pn4);
	    	
	    	// tạo ảnh và tên giao diện trên panel 1
	    	ImageIcon image=new ImageIcon("File Input/banh.png");
	    	anh_TrangWeb.setIcon(image);
	    	ten_TrangWeb.setFont(new Font("SVN-Amethyst", Font.LAYOUT_NO_LIMIT_CONTEXT, 75));
	    	
	    	pn1.add(anh_TrangWeb);
	    	pn1.add(ten_TrangWeb);
	        
	        //design lại các nút button
	        dangNhap_Button.setContentAreaFilled (false);
	    	dangNhap_Button.setFocusPainted (false);
	    	xac_nhanButton.setContentAreaFilled (false);
	    	xac_nhanButton.setFocusPainted (false);
	    	chinh_suaButton.setContentAreaFilled (false);
	    	chinh_suaButton.setFocusPainted (false);
	    	nhap_stkButton.setContentAreaFilled (false);
	    	nhap_stkButton.setFocusPainted (false);
	    	nhap_so_tienButton.setContentAreaFilled (false);
	    	nhap_so_tienButton.setFocusPainted (false);
	    	chuyen_tienButton.setContentAreaFilled (false);
	    	chuyen_tienButton.setFocusPainted (false);
	    	doi_mat_khauButton.setContentAreaFilled(false);
	    	doi_mat_khauButton.setFocusPainted(false);
	    	
	    	// tạo layout cho pn2
	    	GridBagLayout layout1 = new GridBagLayout();
	        GridBagConstraints gbc = new GridBagConstraints();
	    	
	    	pn2.setLayout(layout1);
	   
	    	gbc.gridx=0;
	    	gbc.gridy=0;
	    	pn2.add(stk_label,gbc);
	    	
	    	gbc.gridx=1;
	    	gbc.gridy=0;
	    	pn2.add(stk_textfiel,gbc);
	    	
	    	gbc.insets = new Insets (10,0,0,0);
	    	gbc.gridx=0;
	    	gbc.gridy=2;
	    	pn2.add(mk_label,gbc);
	    	
	    	gbc.gridx=1;
	    	gbc.gridy=2;
	    	pn2.add(mk_passfiel,gbc);
    	
	    	gbc.gridx=2;
	    	gbc.gridy=3;
	    	pn2.add(dangNhap_Button,gbc);
	    	
	    	//tạo layout cho pn3
	    	pn3.setLayout(new GridLayout(2, 3));
	    	
	    	//tạo các thành phần cho panel 3
	    	 // add vao group
	        ButtonGroup BtGp=new ButtonGroup();
	       
	        BtGp.add(so_duRadioButton);
	    	BtGp.add(chuyen_tienRadioButton);
	    	BtGp.add(tien_laiRadioButton);
	    	BtGp.add(thong_tinRadioButton);
	    	BtGp.add(dang_xuatRadioButton);
	    	
	    	//doi mau backgroud
	    	so_duRadioButton.setBackground(Color.WHITE);
	    	chuyen_tienRadioButton.setBackground(Color.WHITE);
	    	tien_laiRadioButton.setBackground(Color.WHITE);
	    	thong_tinRadioButton.setBackground(Color.WHITE);
	    	dang_xuatRadioButton.setBackground(Color.WHITE);

	    	//add vaof pn3
	    	pn3.add(so_duRadioButton);
	    	pn3.add(chuyen_tienRadioButton);
	    	pn3.add(tien_laiRadioButton);
	    	pn3.add(thong_tinRadioButton);
	    	pn3.add(dang_xuatRadioButton);
	    	
	    	//chỉnh vị trí nút xác nhận
	    	extraPanel1.setBackground(Color.WHITE);
	    	extraPanel1.add(xac_nhanButton);
	    	pn3.add(extraPanel1);
	    	
	    	// tắt pn3
	    	Tat_Panel_3();
	    	
	    	//them action để điều  chỉnh nút xác nhận
	    	so_duRadioButton.addItemListener(new CustomItemListener());
	    	chuyen_tienRadioButton.addItemListener(new CustomItemListener());
	    	tien_laiRadioButton.addItemListener(new CustomItemListener());
	    	thong_tinRadioButton.addItemListener(new CustomItemListener());
	    	dang_xuatRadioButton.addItemListener(new CustomItemListener());
	    	
	    	//các actioner của pn4
	    	
				 nhap_stkButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						String hien_stk= JOptionPane.showInputDialog(pn3, "Nhập số tài khoản"
								, "", JOptionPane.INFORMATION_MESSAGE);
						chi_soAccTo=lst_acc.getAccount(hien_stk);;
						
						if(chi_soAccTo==-1||chi_soAcc==chi_soAccTo) {
							if(chi_soAcc==chi_soAccTo) {
								JOptionPane.showMessageDialog(pn3,"Không thể gửi tiền đến tài khoản chính mình "
											+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
								trang_thai_stkLabel.setText("");
								chuyen_tienButton.setEnabled(false);
							}
							else
								JOptionPane.showMessageDialog(pn3,"Số tài khoản không xác định "
									+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
						}else if(lst_acc.lst.get(chi_soAccTo).getClass().getName().equals("Sav_Account")) {
							JOptionPane.showMessageDialog(pn3,"Số tài khoản này không được cấp phép giao dịch "
									+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
							trang_thai_stkLabel.setText("");
							chuyen_tienButton.setEnabled(false);
						}
						else {
							trang_thai_stkLabel.setText("Đã nhập số tài khoản");
							othe_stkLabel.setText("        Số tài khoản: "+lst_acc.lst.get(chi_soAccTo).getSTK());
							othe_tenLabel.setText("        Tên: "+lst_acc.lst.get(chi_soAccTo).getName());
						}
						if(trang_thai_so_tienLabel.getText().equals("Đã nhập tiền")
								&&trang_thai_stkLabel.getText().equals("Đã nhập số tài khoản")) {
							chuyen_tienButton.setEnabled(true);
						 }
					}
				});
				
				 nhap_so_tienButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						// nếu nhập vào không là kiểu số
						boolean check=false;
						while(!check) {
							try {
								so_tien_nhap_vao= Integer.parseInt(JOptionPane.showInputDialog(pn3, "Nhập số tiền"
									, "", JOptionPane.INFORMATION_MESSAGE));
								check=true;
							
							}catch (Exception ex) {
							JOptionPane.showMessageDialog(pn3,"Số tiền không hợp lệ "
									+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
							}
						}
						
						//số tiền âm hoặc số tiền + phí vượt quá số dư
						if(so_tien_nhap_vao<=0 || so_tien_nhap_vao > lst_acc.lst.get(chi_soAcc).getSoDu()
								-((Nor_Account)lst_acc.lst.get(chi_soAcc)).getFee(so_tien_nhap_vao)){
							if(so_tien_nhap_vao>lst_acc.lst.get(chi_soAcc).getSoDu()-((Nor_Account)lst_acc.lst.get(chi_soAcc)).getFee(so_tien_nhap_vao)) {
								JOptionPane.showMessageDialog(pn3,"Số dư không đủ "
										+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
								
							}
							else
								JOptionPane.showMessageDialog(pn3,"Số tiền không hợp lệ "
									+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
						}else {
							
						//thỏa mãn các điều kiện
							trang_thai_so_tienLabel.setText("Đã nhập tiền");
							//format lại để dàu phẩy ngăn cách hàng nghìn
							othe_so_tienLabel.setText("        Số tiền chuyển đi: "+String.format
									("%,d", so_tien_nhap_vao));
							othe_phiLabel.setText("        Phí: "+String.format("%,d", 
									//format lại để dàu phẩy ngăn cách hàng nghìn
										((Nor_Account)lst_acc.lst.get(chi_soAcc)).getFee(so_tien_nhap_vao)));
						}
						// có thể chuyển tiền
						if(trang_thai_so_tienLabel.getText().equals("Đã nhập tiền")
								&&trang_thai_stkLabel.getText().equals("Đã nhập số tài khoản")) {
							chuyen_tienButton.setEnabled(true);
						 }
					}
				});
			 
			 
			 chuyen_tienButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int check= JOptionPane.showConfirmDialog(pn3, "Xác nhận chuyển tiền");
					if(check==JOptionPane.YES_OPTION) {
						((Nor_Account)lst_acc.lst.get(chi_soAcc)).banking(lst_acc.lst.get(chi_soAccTo), so_tien_nhap_vao);
						chuyen_tienButton.setEnabled(false);
						trang_thai_so_tienLabel.setText("");
						
					}
				}
			});
			
	    	chinh_suaButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(chinh_suaButton.getText().equals("Chỉnh sửa")) {
						xongTextField.setVisible(true);
						doi_mat_khauButton.setVisible(true);
						chinh_suaButton.setText("Xác nhận chỉnh sửa");
						sdtTextField.setEditable(true);
						dia_chiTextField.setEditable(true);
						emailTextField.setEditable(true);
						
						
					}
					if(chinh_suaButton.getText().equals("Xác nhận chỉnh sửa")&&xongTextField.getText().equals("xong")){
						boolean check1=false;
						boolean check2=false;
						//kiểm tra xem số điện thoại có phải số không
						if(!check1) {
							try {
								int c=Integer.parseInt( sdtTextField.getText());
								check1=true;
							}catch (Exception ex) {
							JOptionPane.showMessageDialog(pn3,"Số điện thoại ko phù hợp "
									+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
							}
						}
						// kiểm tra số điện thoại có đủ 10 số không
						if(sdtTextField.getText().length()!=10)
							check1=false;
						if(dia_chiTextField.getText().equals("")||emailTextField.getText().equals("")) {
							JOptionPane.showMessageDialog(pn3,"Thiếu thông tin "
									+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
						}else {
							check2=true;
						}
						// khi đã thay đổi và thỏa mãn các điều kiện
						if(check1&&check2) {
							lst_acc.lst.get(chi_soAcc).setAddress(dia_chiTextField.getText());
							lst_acc.lst.get(chi_soAcc).setEmail(emailTextField.getText());
							lst_acc.lst.get(chi_soAcc).setPhone(sdtTextField.getText());
							
							chinh_suaButton.setText("Chỉnh sửa");
							sdtTextField.setEditable(false);
							dia_chiTextField.setEditable(false);
							emailTextField.setEditable(false);
							xongTextField.setText("");
							xongTextField.setVisible(false);
							doi_mat_khauButton.setVisible(false);
							
							
						}
							
					}
				}
			});
	    	
	    	doi_mat_khauButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					JFrame doi_mat_khauFrame=new JFrame("Đổi mật khẩu");
					doi_mat_khauFrame.setVisible(true);
					doi_mat_khauFrame.setSize(500, 200);
					doi_mat_khauFrame.setBackground(Color.WHITE);
					JLabel nhap_moi_mkJLabel=new JLabel("Nhập mật khẩu mới:");
					JLabel nhap_lai_mkJLabel=new JLabel("Nhập lại mật khẩu:");
					JTextField nhap_moi_TextField=new JTextField(15);
					JTextField nhap_lai_TextField=new JTextField(15);
					JPasswordField nhap_moi_PasswordField=new JPasswordField(15);
					JPasswordField nhap_lai_PasswordField=new JPasswordField(15);
					
					JButton xac_nhan_doi_mkButton= new JButton("Đổi mật khẩu");
					ImageIcon image1=new ImageIcon("File Input/Hien_mk.png");
					ImageIcon image2=new ImageIcon("File Input/An_mk.png");
					JButton an_hienButton=new JButton();
					an_hienButton.setIcon(image1);
					an_hienButton.setBorderPainted(false);
					an_hienButton.setContentAreaFilled(false);
					an_hienButton.setFocusPainted(false);
					xac_nhan_doi_mkButton.setContentAreaFilled(false);
			    	xac_nhan_doi_mkButton.setFocusPainted(false);
			    	
			    	
					
					GridBagLayout layout = new GridBagLayout();
			        GridBagConstraints gbc1 = new GridBagConstraints();
			    	
			    	doi_mat_khauFrame.setLayout(layout);
			    	gbc1.insets = new Insets (10,0,0,0);
			    	
			    	gbc1.gridx=0;
			    	gbc1.gridy=0;
			    	doi_mat_khauFrame.add(nhap_moi_mkJLabel,gbc1);
			    	
			    	gbc1.gridx=1;
			    	gbc1.gridy=0;
			    	doi_mat_khauFrame.add(nhap_moi_PasswordField,gbc1);
			    	
			    	
			    	gbc1.gridx=0;
			    	gbc1.gridy=1;
			    	doi_mat_khauFrame.add(nhap_lai_mkJLabel,gbc1);
			    	
			    	gbc1.gridx=1;
			    	gbc1.gridy=1;
			    	doi_mat_khauFrame.add(nhap_lai_PasswordField,gbc1);
			    	
			    	gbc1.gridx=2;
			    	gbc1.gridy=1;
			    	doi_mat_khauFrame.add(an_hienButton,gbc1);
		    	
			    	gbc1.gridx=2;
			    	gbc1.gridy=2;
			    	doi_mat_khauFrame.add(xac_nhan_doi_mkButton,gbc1);
			    	
			    	
			    	
			    	
			    	an_hienButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(an_hienButton.getIcon()==image1) {
								
								an_hienButton.setIcon(image2);
								nhap_moi_TextField.setText(nhap_moi_PasswordField.getText());
								nhap_lai_TextField.setText(nhap_lai_PasswordField.getText());
								
								gbc1.gridx=1;
						    	gbc1.gridy=0;
						    	doi_mat_khauFrame.remove(nhap_moi_PasswordField);
						    	doi_mat_khauFrame.add(nhap_moi_TextField,gbc1);
						    	
						    	
						    	xac_nhan_doi_mkButton.setText("Đổi mật khẩu ");
						    	
						    	gbc1.gridx=1;
						    	gbc1.gridy=1;
						    	doi_mat_khauFrame.remove(nhap_lai_PasswordField);
						    	doi_mat_khauFrame.add(nhap_lai_TextField,gbc1);
							}else {
								an_hienButton.setIcon(image1);
								
								nhap_moi_PasswordField.setText(nhap_moi_TextField.getText());
								nhap_lai_PasswordField.setText(nhap_lai_TextField.getText());
								
								gbc1.gridx=1;
						    	gbc1.gridy=0;
						    	doi_mat_khauFrame.remove(nhap_moi_TextField);
						    	doi_mat_khauFrame.add(nhap_moi_PasswordField,gbc1);
						    	
						    	gbc1.gridx=1;
						    	gbc1.gridy=1;
						    	doi_mat_khauFrame.remove(nhap_lai_TextField);
						    	doi_mat_khauFrame.add(nhap_lai_PasswordField,gbc1);
						    	
						    	xac_nhan_doi_mkButton.setText("Đổi mật khẩu");
							}
								
							
						}
					});
			    	
			    	xac_nhan_doi_mkButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(an_hienButton.getIcon().equals(image1)) {
								if((nhap_lai_PasswordField.getText().equals("")||nhap_lai_PasswordField.getText().equals("")))
									JOptionPane.showMessageDialog(doi_mat_khauFrame,"Thiếu thông tin "
											+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
								else if(!nhap_lai_PasswordField.getText().equals(nhap_moi_PasswordField.getText()))
										 JOptionPane.showMessageDialog(doi_mat_khauFrame,"Sai mật khẩu nhập lại "
											+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
								else if(nhap_moi_PasswordField.getText().equals
										(lst_acc.lst.get(chi_soAcc).getPassWord()))
									JOptionPane.showMessageDialog(doi_mat_khauFrame,"Mật khẩu mới không được trùng mật khẩu cũ"
											+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
								else {
									lst_acc.lst.get(chi_soAcc).setPassWord(nhap_moi_PasswordField.getText());
									doi_mat_khauFrame.dispose();
								}
							}
							else if(an_hienButton.getIcon().equals(image2)) {
								 
								 if((nhap_lai_TextField.getText().equals("")||nhap_moi_TextField.getText().equals("")))
										JOptionPane.showMessageDialog(doi_mat_khauFrame,"Thiếu thông tin "
												+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
								 else if(!nhap_lai_TextField.getText().equals(nhap_moi_TextField.getText()))
									 JOptionPane.showMessageDialog(doi_mat_khauFrame,"Sai mật khẩu nhập lại "
										+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
							
								 else if(nhap_moi_TextField.getText().equals
										(lst_acc.lst.get(chi_soAcc).getPassWord()))
									 JOptionPane.showMessageDialog(doi_mat_khauFrame,"Mật khẩu mới không được trùng mật khẩu cũ"
												+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
								 else {
										lst_acc.lst.get(chi_soAcc).setPassWord(nhap_moi_TextField.getText());
										doi_mat_khauFrame.dispose();
									}
							}
							
							
						}
					});
	    	}
	    	
			});
	    	
				
		}
	    
	    //bật panel 3
	    public void Bat_Panel_3() {
	    	xac_nhanButton.setVisible(true);
	    	so_duRadioButton.setVisible(true);
	    	chuyen_tienRadioButton.setVisible(true);
	    	tien_laiRadioButton.setVisible(true);
	    	thong_tinRadioButton.setVisible(true);
	    	dang_xuatRadioButton.setVisible(true);
	    	
	    	
	    	
	    	
		}
	    
	    // tắt panel 3
	    public void Tat_Panel_3() {
	    	xac_nhanButton.setVisible(false);
	    	so_duRadioButton.setVisible(false);
	    	chuyen_tienRadioButton.setVisible(false);
	    	tien_laiRadioButton.setVisible(false);
	    	thong_tinRadioButton.setVisible(false);
	    	dang_xuatRadioButton.setVisible(false);
	    	

		}
	    
	    public void Bat_Panel_2() {
	    	stk_textfiel.setEnabled(true);
			mk_passfiel.setEnabled(true);
			dangNhap_Button.setEnabled(true);
		}
	    
	    public void Tat_Panel_2() {
	    	stk_textfiel.setEnabled(false);
			mk_passfiel.setEnabled(false);
			dangNhap_Button.setEnabled(false);
		}
	    
	    public void Xoa_Panel_4() {
	    	pn4.removeAll();
	    	pn4.setLayout(new GridLayout(1, 1));
	    	pn4.add(new JButton(" "));
	    	pn4.removeAll();
	    	// xử lí khi thoát các quá trình đột ngột
	    	chuyen_tienButton.setEnabled(false);
	    	chinh_suaButton.setText("Chỉnh sửa");
			sdtTextField.setEditable(false);
			dia_chiTextField.setEditable(false);
			emailTextField.setEditable(false);
			xongTextField.setText("");
			xongTextField.setVisible(false);
			doi_mat_khauButton.setVisible(false);
	    	
		}
	    
	    //reset dữ liệu chuyển tiền
	    public void Tao_moi_du_lieu() {
			othe_tenLabel=new JLabel();
			othe_stkLabel=new JLabel();
			othe_so_tienLabel=new JLabel();
			othe_phiLabel=new JLabel();
			trang_thai_so_tienLabel=new JLabel();
			trang_thai_stkLabel=new JLabel();
			
		}
	    //hiện số dư
	    public void Hien_so_du() {
			JLabel so_duLabel=new JLabel("Số dư hiện tại của bạn là "+String.format
					("%,d", (lst_acc.lst.get(chi_soAcc).getSoDu())));
			pn4.setLayout(new FlowLayout(1,30,60));

			pn4.add(so_duLabel);
			
		}
	    
	    public void Hien_thong_tin() {
	    	JLabel ten_Lable=new JLabel		("Tên:");
	    	JLabel ngay_sinhLable=new JLabel("Ngày sinh:");
			JLabel sdtLable=new JLabel		("Số điện thoại:");
			JLabel dia_chiLable=new JLabel	("Địa chỉ:");
			JLabel emailLable=new JLabel	("Email:");
			
			 tenTextField.setText(lst_acc.lst.get(chi_soAcc).getName());
			 ngay_sinhTextField.setText(lst_acc.lst.get(chi_soAcc).getBirthday());		 
			 sdtTextField.setText(lst_acc.lst.get(chi_soAcc).getPhone());
			 dia_chiTextField.setText(lst_acc.lst.get(chi_soAcc).getAddress());
			 emailTextField.setText(lst_acc.lst.get(chi_soAcc).getEmail());
			 
			 //xác nhận thay đổi
			 JPanel neww_Panel=new JPanel(new GridLayout());
			 neww_Panel.setBackground(Color.WHITE);
			 xongTextField.setToolTipText("xong");
			 neww_Panel.add(xongTextField);
			
			//vô hiệu chỉnh sửa và ẩn đổi mật khẩu
			tenTextField.setEditable(false);
			ngay_sinhTextField.setEditable(false);
			sdtTextField.setEditable(false);
			dia_chiTextField.setEditable(false);
			emailTextField.setEditable(false);
			xongTextField.setVisible(false);
			doi_mat_khauButton.setVisible(false);
			
			//tạo lay out
			GridLayout layout=new GridLayout(5, 3);
			layout.setHgap(20);
			pn4.setLayout(layout);
			pn4.add(ten_Lable);
			pn4.add(tenTextField);
			pn4.add(new JLabel());
			pn4.add(ngay_sinhLable);
			pn4.add(ngay_sinhTextField);
			pn4.add(new JLabel());
			pn4.add(sdtLable);
			pn4.add(sdtTextField);
			pn4.add(extraPanel3);
			pn4.add(dia_chiLable);
			pn4.add(dia_chiTextField);
			pn4.add(neww_Panel);
			pn4.add(emailLable);
			pn4.add(emailTextField);
			
			//chinhr lại vị trí nut chỉnh sửa và đổi mật khẩu 
			extraPanel2.setBackground(Color.WHITE);
			extraPanel2.add(chinh_suaButton);
			pn4.add(extraPanel2);
			extraPanel3.setBackground(Color.WHITE);
			extraPanel3.add(doi_mat_khauButton);
			
			
			
			//chỉnh kich co chu phong chữ
			Font font=new Font("Arial", Font.BOLD, 12);
			ten_Lable.setFont(font);
			tenTextField.setFont(font);
			sdtLable.setFont(font);
			sdtTextField.setFont(font);
			ngay_sinhLable.setFont(font);
			ngay_sinhTextField.setFont(font);
			dia_chiLable.setFont(font);
			dia_chiTextField.setFont(font);
			emailLable.setFont(font);
			emailTextField.setFont(font);
			
	    
		}
	    //giao diện chuyển khoan
	    public void Hien_chuyen_khoan() {
	    	// set lại font và kích cơ chữ
	    	Font font=new Font("Arial", Font.BOLD, 12);
	    	othe_stkLabel.setFont(font);
			othe_tenLabel.setFont(font);
			othe_so_tienLabel.setFont(font);
			othe_phiLabel.setFont(font);
			
			//chỉnh layout và them các label
	    	pn4.setLayout(new GridLayout(4,3));
	    	pn4.add(nhap_stkButton);
	    	pn4.add(othe_stkLabel);	
	    	pn4.add(new JLabel());
	    	pn4.add(trang_thai_stkLabel);
	    	pn4.add(othe_tenLabel);
	    	pn4.add(new JLabel());
	    	pn4.add(nhap_so_tienButton);
	    	pn4.add(othe_so_tienLabel);
	    	pn4.add(new JLabel());
	    	pn4.add(trang_thai_so_tienLabel);
	    	pn4.add(othe_phiLabel);
	    	pn4.add(chuyen_tienButton);
	    	
	    	
		}
	    
	    //hien tiền lãi
	    public void Hien_tien_lai() {
	    	pn4.setLayout(new FlowLayout());
	    	JPanel ex=new JPanel(new GridLayout(3, 1, 25, 25));
	    	//Tạo ra biến lãi xuất dựa vào rate
	    	Double laixuat;
	    	if(((Sav_Account)lst_acc.lst.get(chi_soAcc)).getRate()==6)
				laixuat=0.004;
	    	else if(((Sav_Account)lst_acc.lst.get(chi_soAcc)).getRate()==12)
	    		laixuat=0.005;
	    	else
	    		laixuat=0.006;
	    	ex.setBackground(Color.WHITE);
	    	ex.add(new JLabel("Kì hạn gửi: "+(int)((Sav_Account)lst_acc.lst.get(chi_soAcc)).getRate()+ " tháng       Mức lãi xuất: "+laixuat));
	    	ex.add(new JLabel("Thời gian gửi: "+((Sav_Account)lst_acc.lst.get(chi_soAcc)).getDate()+
	    			"       Đã gửi được: "+((Sav_Account)lst_acc.lst.get(chi_soAcc)).countDay()+" ngày"));
	    	ex.add(new JLabel("Số dư ước tính khi hết kì hạn: "+String.format
					("%,d",((Sav_Account)lst_acc.lst.get(chi_soAcc)).interestCalc())));
	    	pn4.add(ex);
		}
	    
	    //tạo 1 customlistioner để chỉnh nút xác nhận khi thay đổi lựa chọn và xóa đi panel 4
	    class CustomItemListener implements ItemListener {

			@Override
			public void itemStateChanged(ItemEvent e) {
				xac_nhanButton.setText("Xác nhận");
				pn4.removeAll();
			    pn4.setLayout(new GridLayout(1, 1));
			    pn4.add(new JLabel(" "));
			    
				
			}
	    }
	    
	    
	    
	       
	    //các actione
	    //action khi ấn dang nhap
	    public void Dang_nhap_actionPerformed() {
	    		dangNhap_Button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					chi_soAcc=lst_acc.getAccount(stk_textfiel.getText());
					if(dangNhap_Button.getText().equals("Đăng nhập")) {
						//để trống thông tin đăng nhập
						 if(stk_textfiel.getText().equals("")||mk_passfiel.getText().equals("")){
							JOptionPane.showMessageDialog(pn3,"Xin vui lòng điền nốt thông tin đăng nhâp"
									, "cảnh báo", JOptionPane.ERROR_MESSAGE);
						 }
						//sai số tài khoản 
						 else {
							 if(chi_soAcc==-1){
						 
									JOptionPane.showMessageDialog(pn3,"Số tài khoản hoặc mật khẩu chưa chính xác "
											+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
								}
							 else {
								if(lst_acc.lst.get(chi_soAcc).getPassWord().equals(mk_passfiel.getText())){
								
									Tat_Panel_2();
									Bat_Panel_3();
									//nếu là nor_acc vô hiệu hóa tien lãi
									//nếu là sav_acc vô hiêu hóa chuyển tiền
									if(lst_acc.lst.get(chi_soAcc).getClass().getName().equals("Nor_Account"))
										tien_laiRadioButton.setEnabled(false);
									if(lst_acc.lst.get(chi_soAcc).getClass().getName().equals("Sav_Account"))
										chuyen_tienRadioButton.setEnabled(false);
									dangNhap_Button.setText("Đã đăng nhập");
								}
								
								//sai mật khẩu
							else
								JOptionPane.showMessageDialog(pn3,"Số tài khoản hoặc mật khẩu chưa chính xác "
										+ "\n Vui lòng thử lại", "cảnh báo", JOptionPane.ERROR_MESSAGE);
								
							 }	
						 }
						 	
					}
				}
				});
	    }
	    // action khi con các option		
	    public void Xu_li_lua_chon() {
	    		// đăng xuất
	    		 xac_nhanButton.addActionListener(new ActionListener() {
						
					@Override
					public void actionPerformed(ActionEvent e) {
						
						// đăng xuất
						if(dang_xuatRadioButton.isSelected()) {
							Xoa_Panel_4();
							Tat_Panel_3();
							Bat_Panel_2();
							tien_laiRadioButton.setEnabled(true);
							chuyen_tienRadioButton.setEnabled(true);
							dangNhap_Button.setText("Đăng nhập");
							
						}
						
						// hiện số dư
						 if(so_duRadioButton.isSelected()) {
							 Xoa_Panel_4();
							xac_nhanButton.setText("Đã lựa chọn: hiện số dư");
							Hien_so_du();
						}
						 
						 // hiện tông tin
						 if(thong_tinRadioButton.isSelected()) {
							 Xoa_Panel_4();
							xac_nhanButton.setText("Đã lựa chọn: hiện thông tin");
							Hien_thong_tin();
							
						

						 }
						 //hiện tiền lãi
						 if(tien_laiRadioButton.isSelected()) {	 
								Xoa_Panel_4();
								xac_nhanButton.setText("Đã lựa chọn: hiện tiền lãi");
								Hien_tien_lai();
							 
						 }
						 
						 //chuyển tiền
						 if(chuyen_tienRadioButton.isSelected()) {
							 Xoa_Panel_4();
							 xac_nhanButton.setText("Đã lựa chọn: hiện chuyển tiền");
							 Tao_moi_du_lieu();
							 Hien_chuyen_khoan();
							 
						 }
					}
				});
	    }
		
	    public static void main(String[] arg) {
			Themes a=new Themes();
			List_Account A=new List_Account();
			try {
				A.Create();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			a.lst_acc=A;
	    }
	}