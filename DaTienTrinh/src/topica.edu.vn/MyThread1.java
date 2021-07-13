package topica.edu.vn;

public class MyThread1 extends Thread {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() +"i= "+i);
            
        }
    }
     
    
}
