package Method.BPlusTree;

import java.util.ArrayList;
import java.util.List;

public class BPlusTree {

    private static final int MAX_KEYS = 6;

    private List<Integer> leaf = new ArrayList<>();
    private HitRecorder recorder;

    public BPlusTree(HitRecorder recorder){
        this.recorder = recorder;
    }

    public void insert(int key){

        recorder.record(Hit.K1_SEARCH);

        leaf.add(key);
        recorder.record(Hit.K2_INSERT_LEAF);

        if(leaf.size() <= MAX_KEYS){
            recorder.record(Hit.K3_LEAF_OK);
        }else{
            recorder.record(Hit.K4_LEAF_OVERFLOW);

            splitLeaf();
        }
    }

    private void splitLeaf(){

        recorder.record(Hit.K5_LEAF_SPLIT);

        leaf.clear();

        recorder.record(Hit.K6_PARENT_UPDATE);
    }
}