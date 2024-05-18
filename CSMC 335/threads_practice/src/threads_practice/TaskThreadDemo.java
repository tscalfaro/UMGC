package threads_practice;

public class TaskThreadDemo {

	public static void main(String[] args) {
		String [] sa = {"a", "X", "+", "."};
		for(String s : sa) {
			Runnable ps = new PrintChar(s, 200);
			Thread ts = new Thread(ps, s);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ts.start();
		}
	}
}

class PrintChar implements Runnable{
	String ch;
	int times;
	
	public PrintChar(String c, int n) {
		ch = c;
		times = n;
	}
	
	public void run() {
		for(int i = 0; i < times; i++) {
			System.out.print(ch);
			
		}
	}
}
