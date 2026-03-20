package Method.BPlusTree;

import java.util.ArrayList;
import java.util.List;

public class HitRecorder {

    private List<Hit> hits = new ArrayList<>();

    public void record(Hit h){
        hits.add(h);
    }

    public List<Hit> getHits(){
        return hits;
    }

    public void clear(){
        hits.clear();
    }
}
