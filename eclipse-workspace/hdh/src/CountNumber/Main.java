package CountNumber;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	         
	    // Đợi người dùng nhấn một phím để bắt đầu
	    System.out.println("Nhấn phím bất kỳ để quay số");
	    scanner.nextLine();
	         
	    // Khai báo & Khởi chạy CountTheNumberThread như là một Thread thông qua
	    // phương thức start()
	    CountTheNumberThread countingThread = new CountTheNumberThread();
	    countingThread.start();
	         
	    // Đợi người dùng nhấn một phím để kết thúc
	    System.out.println("Nhấn phím bất kỳ để kết thúc quay số");
	    scanner.nextLine();
	         
	    // Ngừng Thread và xem hiện đang "quay" tới số nào
	    countingThread.end();
	    System.out.println("Con số may mắn: " + countingThread.getCount());
	}
}
