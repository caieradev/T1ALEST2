package Entities;

import java.util.LinkedList;

public class MacacoEntity
{
    private int id;
    private LinkedList<CocoEntity> cocos = new LinkedList<>();
    private int sendEven;
    private int sendOdd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<CocoEntity> getCocos() {
        return cocos;
    }

    public void setCocos(LinkedList<CocoEntity> cocos) {
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