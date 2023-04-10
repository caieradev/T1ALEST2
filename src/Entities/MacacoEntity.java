package Entities;

import java.util.ArrayList;

public class MacacoEntity
{
    private int id;
    private ArrayList<Integer> oddCocos = new ArrayList<>();
    private ArrayList<Integer> evenCocos = new ArrayList<>();
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

    public ArrayList<Integer> getOddCocos() {
        return oddCocos;
    }

    public void removeAllCocos(){
        this.oddCocos.clear();
        this.evenCocos.clear();
    }

    public void addAllOddCocos(ArrayList<Integer> oddCocos) {
        this.oddCocos.addAll(oddCocos);
    }

    public void addAllEvenCocos(ArrayList<Integer> evenCocos) {
        this.evenCocos.addAll(evenCocos);
    }

    public void addOddCocos(int oddCocos) {
        this.oddCocos.add(oddCocos);
    }

    public void addEvenCocos(int evenCocos) {
        this.evenCocos.add(evenCocos);
    }

    public ArrayList<Integer> getEvenCocos() {
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