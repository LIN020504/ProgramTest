package Method.Story;

public class Phenomenon {
    private String type;
    private int intensity;

    public Phenomenon(String type, int intensity) {
        this.type = type;
        this.intensity = intensity;
    }

    public Phenomenon() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
}
