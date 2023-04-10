package Entities;

public class MacacoEntity
{
    private int id;
    private int even;
    private int odd;
    private int sendEven;
    private int sendOdd;

    public int getId() {
        return id;
    }

    public int size(){
        return even + odd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOddCocos() {
        return odd;
    }

    public void removeAllCocos(){
        this.odd = 0;
        this.even = 0;
    }

    public void sumOddCocos(int oddCocos) {
        this.odd += oddCocos;
    }

    public void sumEvenCocos(int evenCocos) {
        this.even += evenCocos;
    }

    public void addOddCocos() {
        this.odd++;
    }

    public void addEvenCocos() {
        this.even++;
    }

    public int getEvenCocos() {
        return even;
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