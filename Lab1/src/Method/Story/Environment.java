package Method.Story;

import java.util.ArrayList;
import java.util.List;

public class Environment {
    private String smell;
    private String sound;
    private List<Phenomenon> phenomenon = new ArrayList<>();

    public Environment(String smell, String sound) {
        this.smell = smell;
        this.sound = sound;
    }

    public Environment() {
    }

    public String getSmell() {
        return smell;
    }

    public void setSmell(String smell) {
        this.smell = smell;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public List<Phenomenon> getPhenomenon() {
        return phenomenon;
    }

    public void setPhenomenon(List<Phenomenon> phenomenon) {
        this.phenomenon = phenomenon;
    }

    public void addPhenomenon(Phenomenon p){
        phenomenon.add(p);
    }
}
