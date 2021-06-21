package com.company;
import java.util.ArrayList;
import java.util.List;

class main4 {
    public static void main(String[] args) {

        Computer pub1 = new Computer();
        Dashboard p1 = new Dashboard(pub1);
        pub1.changeData(154);
        Computer pub2 = new Computer();
        Dashboard p2 = new Dashboard(pub2);
        pub1.changeData(843);
        Computer pub3 = new Computer();
        Dashboard p3 = new Dashboard(pub3);
        pub1.changeData(1542);

    }
}
interface Notifier{
    public void addObserver(Observer obs);
    public void notifyObserver();
}

class Computer implements Notifier{
    private List servers;
    private int sub;

    public Computer(){servers = new ArrayList(); }

    public void addObserver(Observer obs) {
        servers.add(obs);
    }

    public void notifyObserver() {
        for (int i = 0; i < servers.size(); i++){
            Observer obs = (Observer)servers.get(i);
            obs.set(sub);
        }
    }

    public void changeData(int sub){
        this.sub = sub;
        notifyObserver();
    }

}

interface Observer{
    public void set(int sub);
}

class Dashboard implements Observer{
    private Notifier notifier;
    private int sub;

    public Dashboard(Notifier notifier){
        this.notifier = notifier;
        notifier.addObserver(this);
    }

    public void set(int sub) {
        this.sub = sub;
        show();
    }

    public void show(){System.out.println("Кол-во подписчиков " + sub); }
}