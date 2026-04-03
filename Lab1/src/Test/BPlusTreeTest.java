package Test;

import Method.BPlusTree.BPlusTree;
import Method.BPlusTree.Hit;
import Method.BPlusTree.HitRecorder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BPlusTreeTest {

    // 一个简单的 HitRecorder 实现
    static class SimpleRecorder extends HitRecorder {
        @Override
        public void record(Hit hit) {
            // 可以打印，也可以不打印
            System.out.println("Hit: " + hit);
        }
    }

    @Test
    void testInsertAndSearch() {
        HitRecorder recorder = new SimpleRecorder();
        BPlusTree tree = new BPlusTree(recorder);

        int[] keysToInsert = {10, 20, 5, 6, 12, 30, 7, 17, 25, 3};
        for (int key : keysToInsert) {
            tree.insert(key);
        }

        // 测试存在的键
        assertTrue(tree.search(10));
        assertTrue(tree.search(6));
        assertTrue(tree.search(25));

        // 测试不存在的键
        assertFalse(tree.search(15));
        assertFalse(tree.search(100));
    }

    @Test
    void testTreeStructurePrint() {
        HitRecorder recorder = new SimpleRecorder();
        BPlusTree tree = new BPlusTree(recorder);

        int[] keysToInsert = {10, 20, 5, 6, 12, 30, 7};
        for (int key : keysToInsert) {
            tree.insert(key);
        }

        // 打印树结构，不做断言，只为了可视化
        System.out.println("\n--- Tree Structure ---");
        tree.printTree();
    }
}