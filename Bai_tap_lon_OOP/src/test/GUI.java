
package test;

import java.util.ArrayList;

public class GUI extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
		public GUI() {
	        initComponents();
	    }
                        
	    private void initComponents() {

	        jScrollPane1 = new javax.swing.JScrollPane();
	        jContent = new javax.swing.JTextArea();
	        jkeyWord = new javax.swing.JTextField();
	        jSearch = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        setLocation(200, 100);

	        jContent.setColumns(20);
	        jContent.setRows(5);
	        jScrollPane1.setViewportView(jContent);

	        jSearch.setText("Search");
	        jSearch.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jSearchActionPerformed(evt);
	            }
	        });

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jScrollPane1)
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addGap(0, 848, Short.MAX_VALUE)
	                        .addComponent(jkeyWord, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jSearch)))
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jSearch)
	                    .addComponent(jkeyWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(20, 20, 20)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
	        );

	        pack();
	    }
	    private void jSearchActionPerformed(java.awt.event.ActionEvent evt) {                                               
	    	String keyword = jkeyWord.getText();
	    	
			String filename = "Cafef.CLASSIFIED.STOCK_CODE.txt";
			ArrayList<String> arrayline = null;
			Input input = null;
			ArrayList<String> arraykeywords = new ArrayList<>();
			
			arraykeywords.add(keyword);
			
			input = new Input(filename);
			arrayline = input.Filter(arraykeywords);
			jContent.setText("");
			if(arrayline.size() == 0) {
				jContent.setText("không tìm thấy thông tin");
			} else {
				for (String string : arrayline) {
					jContent.append(string + "\n");
				}   
			}
			                       
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
	            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	      
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new GUI().setVisible(true);
	            }
	        });
	    }

                   
	    private javax.swing.JTextArea jContent;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JButton jSearch;
	    private javax.swing.JTextField jkeyWord;
                  
	}
                       




