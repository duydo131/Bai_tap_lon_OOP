package oop_chap1;
import javax.swing.JOptionPane;
public class Bai3{
	public static void main(String[] args) {
		String result;
		result = JOptionPane.showInputDialog("Hay nhap ten cua ban");
		JOptionPane.showMessageDialog(null,"Chao " + result);
	}
}