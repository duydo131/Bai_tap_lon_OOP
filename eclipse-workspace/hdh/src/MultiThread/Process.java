package MultiThread;
public class Process {
    static int counter;
    static int turn = 1 ;
    
    public Process() {
    	new Thread3();
    	new Thread4();
    	Thread3.setC1(true);
    	Thread4.setC2(false);
    	new Thread3().start();
    	new Thread4().start();
    }
    
//    public static class Thread1 extends Thread {
//    	public static boolean C1 = true;
//    	public void run() {
//    		while(true) {
//    			try{
//    				while(Thread2.C2==true) {
//    					Thread1.setC1(true);
//    				}
//    				System.out.println("Thread 1 using counter = " + counter);
//    				counter++;
//    				Thread1.setC1(false);
//    				sleep(2000);
//    			} catch (InterruptedException ex) {
//    			}
//    		}
//    	}
//		public boolean isC1() {
//			return C1;
//		}
//		public static void setC1(boolean c1) {
//			C1 = c1;
//		}
//    	
//    }
//    
//    public static class Thread2 extends Thread {
//    	public static boolean C2 = true;
//    	public void run() {
//    		while(true) {
//    			try {
//    				while(Thread1.C1==true) {
//    					Thread2.setC2(true);
//    				}
//    				System.out.println("Thread 2 using counter = " + counter);
//    				counter+=2;
//    				Thread2.setC2(false);
//    				sleep(2000);
//    			} catch (InterruptedException ex) {
//    			}
//    		}
//    	}
//    	public boolean isC2() {
//			return C2;
//		}
//		public static void setC2(boolean c2) {
//			C2 = c2;
//		}
//		public boolean getKey() {
//    		return C2;
//    	}
//    }
//    
    public static class Thread3 extends Thread {
    	public static boolean C1 = true;
    	public void run() {
    		do {
    			try {
    				Thread3.setC1(true);
    				while(Thread4.C2==true) {
    					if(turn == 2) {
    						Thread3.setC1(false);
    						while(turn==2);
    						Thread3.setC1(true);
    						}
    					}
    				System.out.println("Thread 3 using counter = " + counter);
    				counter += 3;
    				turn = 2;
    				Thread3.setC1(false);
    				sleep(2000);
    				} catch (InterruptedException ex) {
    			}
    		} while (true);
    	}
		public static boolean isC1() {
			return C1;
		}
		public static void setC1(boolean c1) {
			C1 = c1;
		}
    	
    }
    
    public static class Thread4 extends Thread {
    	public static boolean C2 = true;
    	public void run() {
    		do {
    			try {
    				Thread4.setC2(true);
    				while(Thread3.C1==true) {
    					if(turn == 1) {
    						Thread4.setC2(false);
    						while(turn==1);
    						Thread4.setC2(true);
    					}
    				}
    				System.out.println("Thread 4 using counter = " + counter);
    				counter += 1;
    				turn = 1;
    				Thread4.setC2(false);
    				sleep(2000);
    			} catch (InterruptedException ex) {
    			}
    		} while (true);
    	}
		public static boolean isC2() {
			return C2;
		}
		public static void setC2(boolean c2) {
			C2 = c2;
		}
    	
    }
//    public static void main(String[] args) {
//    	new Process();
//    }
}