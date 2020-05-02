package MultiThread;
public class Process2 {
	
	    public Process2() {
	    	new Thread1().start();
	    	new Thread2().start();
	    }
	    
	    public static class Thread1 extends Thread {
	    	public static int synch = 0;
	    	int a = 0;
	    	public void run() {
	    		while(true) {
	    			try{
	    				if(synch == 0) {
	    				a++;
	    				System.out.println("a = " + a);
	    				synch += 1;
	    				}
	    				sleep(2000);
	    			} catch (InterruptedException ex) {
	    			}
	    		}
	    	}
			public static int getSynch() {
				return synch;
			}
			public static void setSynch(int synch) {
				Thread1.synch = synch;
			}
	    }
	    
	    public static class Thread2 extends Thread {
	    	public void run() {
	    		int b=0;
	    		while(true) {
	    			try {
	    				if (Thread1.getSynch()==1) {
	    				b++;
		    			System.out.println("b = " + b);	
	    				}
	    				Thread1.setSynch(0);
	    				sleep(2000);
	    			} catch (InterruptedException ex) {
	    			}
	    		}
	    	}
	    }
	    public static void main(String[] args) {
	    	new Process2();
	    }
	}
