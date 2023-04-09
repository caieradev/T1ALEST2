package Entities;

import java.util.Queue;

public class MacacoEntity
{
    private int id;
    private Queue<Integer> cocos;
    private int sendEven;
    private int sendOdd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Queue<Integer> getCocos() {
        return cocos;
    }

    public void setCocos(Queue<Integer> cocos) {
        this.cocos = cocos;
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