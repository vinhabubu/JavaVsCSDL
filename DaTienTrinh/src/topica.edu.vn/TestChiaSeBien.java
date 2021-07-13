package topica.edu.vn;

public class TestChiaSeBien {
    public static void main(String[] args) {
        MyThread2 mt = new MyThread2();
        Thread th1 = new Thread(mt) ;
        th1.setName("Tien trinh 1, ");
        th1.start();

        Thread th2 = new Thread(mt);
        th2.setName("Tien trinh 2, ");
        th2.start();

        Thread th3 = new Thread(mt);
        th3.setName("Tien trinh 3, ");
        th3.start();

        System.out.println("x hien tai lay ra la "+ mt.getX());
    }
    
    
}
