package topica.edu.vn;

public class TestMyThread2 {
    public static void main(String[] args) {
        Thread th3 = new Thread(new MyThread2());
        th3.setName("Tien trinh 3");
        th3.start();

        hread th4 = new Thread(new MyThread2());
        th4.setName("Tien trinh 4");
        th4.start();

    }
    
}
