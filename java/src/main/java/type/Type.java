package type;

public abstract class Type implements Cloneable {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract Type clone();
}
