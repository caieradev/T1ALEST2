package Entities;

public class CocoEntity {
    private boolean isEven;

    public boolean isEven() {
        return isEven;
    }

    public CocoEntity(int pedras)
    {
        this.isEven = !((pedras & 1) == 1);
    }
}
