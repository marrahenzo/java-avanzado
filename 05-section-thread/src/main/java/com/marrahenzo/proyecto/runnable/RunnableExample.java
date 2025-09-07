package com.marrahenzo.proyecto.runnable;

public class RunnableExample implements Runnable {

    private String name;

    public RunnableExample(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println(name + " Mensaje: " + i + " Ejecutando en: " + Thread.currentThread().getName());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        Thread thread = new Thread(new RunnableExample("Tarea A"));
        Thread thread2 = new Thread(new RunnableExample("Tarea B"));

        thread.start();
        thread2.start();

        System.out.println("Fin del hilo principal");
    }
}
