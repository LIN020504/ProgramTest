package Test;

import Method.BPlusTree.BPlusTree;
import Method.BPlusTree.Hit;
import Method.BPlusTree.HitRecorder;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BPlusTreeTest {

    @Test
    void testSimpleInsert(){

        HitRecorder recorder = new HitRecorder();
        BPlusTree tree = new BPlusTree(recorder);

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        List<Hit> expected = List.of(
                Hit.K1_SEARCH, Hit.K2_INSERT_LEAF, Hit.K3_LEAF_OK,
                Hit.K1_SEARCH, Hit.K2_INSERT_LEAF, Hit.K3_LEAF_OK,
                Hit.K1_SEARCH, Hit.K2_INSERT_LEAF, Hit.K3_LEAF_OK
        );

        assertEquals(expected, recorder.getHits());
    }

    @Test
    void testLeafSplit(){

        HitRecorder recorder = new HitRecorder();
        BPlusTree tree = new BPlusTree(recorder);

        int[] data = {10,20,30,40,50,60,70};

        for(int x : data){
            tree.insert(x);
        }

        List<Hit> hits = recorder.getHits();

        assertTrue(hits.contains(Hit.K4_LEAF_OVERFLOW));
        assertTrue(hits.contains(Hit.K5_LEAF_SPLIT));
        assertTrue(hits.contains(Hit.K6_PARENT_UPDATE));
    }
}
