package Method.Story;

public class Person {
    private String name;
    private String state;
    private int attentionLevel;

    public Person(String name, String state, int attentionLevel) {
        this.name = name;
        this.state = state;
        this.attentionLevel = attentionLevel;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAttentionLevel() {
        return attentionLevel;
    }

    public void setAttentionLevel(int attentionLevel) {
        this.attentionLevel = attentionLevel;
    }

    public void perceive(Phenomenon phenomenon){
        attentionLevel -= phenomenon.getIntensity();
    }
}
