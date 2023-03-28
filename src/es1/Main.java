package es1;

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Decrescente",true);
        MyThread t2 = new MyThread("Crescente",false);
        System.out.println("Thread es1.Main Ha finito. Ora lancio i due thread.");
        Thread.currentThread().interrupt();
        t1.start();
        t2.start();
    }
}
class MyThread extends Thread{
    private boolean rovescia;
    public MyThread(String name, boolean rovescia) {
        super(name);
        this.rovescia = rovescia;
    }

    @Override
    public void run() {
        if(rovescia){
            for(int i = 5; i > 0; i--){
                System.out.println("Thread decrescente: " + i);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            for(int i = 1; i <= 5; i++){
                System.out.println("Thread crescente: " + i);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}