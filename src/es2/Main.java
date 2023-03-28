package es2;

public class Main {
    public static void main(String[] args) {
        Corridore c1 = new Corridore("c1","Mario");
        Corridore c2 = new Corridore("c2","Luigi");
        Corridore c3 = new Corridore("c3","Roberto");
        c1.start();
        c2.start();
        c3.start();
    }
}

class Corridore extends Thread {
    private String nome;
    private int mPercorsi = 0;

    public Corridore(String name, String nome) {
        super(name);
        this.nome = nome;
    }

    @Override
    public void run() {
        int temp;
        while(mPercorsi < 1000){
            do{
                temp = (int)(Math.random() * 100) + 1;
            } while(mPercorsi + temp > 1000);
            mPercorsi += temp;
            System.out.println(this.nome + " ha percorso " + this.mPercorsi +"/1000m");
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("--> " + this.nome + " è arrivato al traguardo!");
    }
}