package test;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GUI1 extends javax.swing.JFrame {

    
	private static final long serialVersionUID = 1L;
	
    public GUI1() {
        initComponents();
    }

                       
    private void initComponents() {


        jLabel3 = new javax.swing.JLabel();
        keyWord = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JContent = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        Day = new javax.swing.JComboBox<>();
        Month = new javax.swing.JComboBox<>();
        Year = new javax.swing.JComboBox<>();

        jLabel3.setText("jLabel3");

        setLocation(170, 30);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        keyWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                keyWordKeyPressed(evt);
            }
        });

        JContent.setColumns(20);
        JContent.setRows(5);
        jScrollPane1.setViewportView(JContent);

        jLabel2.setText("Ngày");

        jLabel4.setText("Tháng");

        jLabel5.setText("Năm");

        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        
        Day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        Month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        Year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(661, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(keyWord, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(Search))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(Day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keyWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(Day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }                       

    private void Search() {
    	
    	
    	String keyword = keyWord.getText();
    	String day = (String) Day.getSelectedItem();
    	String month = (String) Month.getSelectedItem();
    	
    	String date = day + "/" + month;
    	
		ArrayList<String> keywords = new ArrayList<>();

		keywords.add(keyword);
		
		Set<String> arrayline = new HashSet<String>();
		Set<String> arraydong = null;
		Input input = null;
		
		ArrayList<String> close = new ArrayList<>();
//		close.add("đóng");
//		close.add("phiên");
		
		ArrayList<String> filename = new ArrayList<>();
		
		filename.add("file/Cafef.CLASSIFIED.STOCK_CODE.txt");
		filename.add("file/Cafef.CLASSIFIED.THANHKHOAN.txt");
		filename.add("file/Cafef.CLASSIFIED.VNINDEX.txt");
		filename.add("file/TNCK.CLASSIFIED.THANHKHOAN.txt");
		filename.add("file/TNCK.CLASSIFIED.VNINDEX.txt");
		filename.add("file/Vnexpress.CLASSIFIED.ALL.txt");
		filename.add("file/Vnexpress.CLASSIFIED.STOCK_CODE.txt");
		filename.add("file/Vnexpress.CLASSIFIED.THANHKHOAN.txt");
		filename.add("file/Vnexpress.CLASSIFIED.VNINDEX.txt");
		
		
		JContent.setText("");
		for (String string : filename) {
			input = new Input(string);

			arrayline.addAll(input.Filter(keywords, date));
			
			input = null;
		}
		
		arraydong = PhienLamViec.Phien(arrayline, close);
		if(arraydong.size() == 0) {
			JContent.append("không tìm thấy");
		}else {		
			for (String string : arraydong) {
				JContent.append(string + "\n");
			}
		}
    }
    
    private void keyWordKeyPressed(java.awt.event.KeyEvent evt) {     
    	if(evt.getKeyCode() == KeyEvent.VK_ENTER && evt.isControlDown()) {
    		Search();
    	}
    }    
    
    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {  
    	Search();
    }                                      

  
    public static void main(String args[]) {
  
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JComboBox<String> Day;
    private javax.swing.JTextArea JContent;
    private javax.swing.JComboBox<String> Month;
    private javax.swing.JButton Search;
    private javax.swing.JComboBox<String> Year;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField keyWord;
    // End of variables declaration                   
}
