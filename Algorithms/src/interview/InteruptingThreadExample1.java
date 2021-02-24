package interview;

public class InteruptingThreadExample1 extends Thread{


	public void run(){  
		try{  
			Thread.sleep(100000);  
			System.out.println("task"); 
			
		
		}catch(InterruptedException e){  
			System.out.println("exception occured "+e.getMessage());
		} 
		System.out.println("thread is running");
	}

	public static void main(String[] args) {

		InteruptingThreadExample1 t1=new InteruptingThreadExample1();  
		t1.start();  
		
			t1.interrupt();  
			
			StringBuilder sb=new StringBuilder();
			
			sb.append("satyam");
			  char temp=sb.charAt(0);
		        sb.setCharAt(0,sb.charAt(1));
		        sb.setCharAt(1,temp);
			
		System.out.println(sb);
	}
}

