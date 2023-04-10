package Entities;

import java.util.LinkedList;

public class MacacoEntity
{
    private int id;
    private LinkedList<Integer> oddCocos = new LinkedList<>();
    private LinkedList<Integer> evenCocos = new LinkedList<>();
    private int sendEven;
    private int sendOdd;

    public int getId() {
        return id;
    }

    public int size(){
        return oddCocos.size() + evenCocos.size();
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<Integer> getOddCocos() {
        return oddCocos;
    }

    public void removeAllCocos(){
        this.oddCocos.clear();
        this.evenCocos.clear();
    }

    public void addAllOddCocos(LinkedList<Integer> oddCocos) {
        this.oddCocos.addAll(oddCocos);
    }

    public void addAllEvenCocos(LinkedList<Integer> evenCocos) {
        this.evenCocos.addAll(evenCocos);
    }

    public void addOddCocos(int oddCocos) {
        this.oddCocos.add(oddCocos);
    }

    public void addEvenCocos(int evenCocos) {
        this.evenCocos.add(evenCocos);
    }

    public LinkedList<Integer> getEvenCocos() {
        return evenCocos;
    }

    public int getSendEven() {
        return sendEven;
    }

    public void setSendEven(int sendEven) {
        this.sendEven = sendEven;
    }

    public int getSendOdd() {
        return sendOdd;
    }

    public void setSendOdd(int sendOdd) {
        this.sendOdd = sendOdd;
    }
}