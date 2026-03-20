package Method.Story;

public class ObjectItems {
    private String type;
    private boolean active;

    public ObjectItems(String type, boolean active) {
        this.type = type;
        this.active = active;
    }

    public ObjectItems() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void use(){
        active = true;
    }
}
