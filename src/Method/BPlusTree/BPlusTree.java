package Method.BPlusTree;

import java.util.ArrayList;
import java.util.List;

public class BPlusTree {

    private static final int MAX_KEYS = 6;

    private Node root;
    private HitRecorder recorder;

    public BPlusTree(HitRecorder recorder) {
        this.recorder = recorder;
        this.root = new LeafNode();
    }

    // ---------- 插入 ----------
    public void insert(int key) {
        recorder.record(Hit.K1_SEARCH);
        SplitResult result = root.insert(key, recorder);
        if (result != null) {
            // 根节点分裂，创建新根
            InternalNode newRoot = new InternalNode();
            newRoot.keys.add(result.middleKey);
            newRoot.children.add(result.left);
            newRoot.children.add(result.right);
            root = newRoot;
            recorder.record(Hit.K6_PARENT_UPDATE);
        }
    }

    // ---------- 查询 ----------
    public boolean search(int key) {
        return root.search(key, recorder);
    }

    // ---------- 打印树 ----------
    public void printTree() {
        root.print("", true);
    }

    // ---------- 节点抽象类 ----------
    private abstract static class Node {
        List<Integer> keys = new ArrayList<>();
        abstract SplitResult insert(int key, HitRecorder recorder);
        abstract boolean search(int key, HitRecorder recorder);
        abstract boolean isOverflow();
        abstract void print(String prefix, boolean isTail);
    }

    // ---------- 内部节点 ----------
    private static class InternalNode extends Node {
        List<Node> children = new ArrayList<>();

        @Override
        SplitResult insert(int key, HitRecorder recorder) {
            int idx = 0;
            while (idx < keys.size() && key >= keys.get(idx)) idx++;
            SplitResult result = children.get(idx).insert(key, recorder);

            if (result != null) {
                keys.add(idx, result.middleKey);
                children.set(idx, result.left);
                children.add(idx + 1, result.right);
            }

            if (isOverflow()) {
                int mid = keys.size() / 2;
                InternalNode left = new InternalNode();
                InternalNode right = new InternalNode();

                left.keys.addAll(keys.subList(0, mid));
                left.children.addAll(children.subList(0, mid + 1));

                right.keys.addAll(keys.subList(mid + 1, keys.size()));
                right.children.addAll(children.subList(mid + 1, children.size()));

                return new SplitResult(keys.get(mid), left, right);
            }
            return null;
        }

        @Override
        boolean search(int key, HitRecorder recorder) {
            int idx = 0;
            while (idx < keys.size() && key >= keys.get(idx)) idx++;
            return children.get(idx).search(key, recorder);
        }

        @Override
        boolean isOverflow() {
            return keys.size() > MAX_KEYS;
        }

        @Override
        void print(String prefix, boolean isTail) {
            System.out.println(prefix + (isTail ? "└─ " : "├─ ") + "Internal " + keys);
            for (int i = 0; i < children.size(); i++) {
                children.get(i).print(prefix + (isTail ? "    " : "│   "), i == children.size() - 1);
            }
        }
    }

    // ---------- 叶子节点 ----------
    private static class LeafNode extends Node {
        List<Integer> values = new ArrayList<>();
        LeafNode next;

        @Override
        SplitResult insert(int key, HitRecorder recorder) {
            int idx = 0;
            while (idx < keys.size() && key > keys.get(idx)) idx++;
            keys.add(idx, key);
            values.add(idx, key);
            recorder.record(Hit.K2_INSERT_LEAF);

            if (isOverflow()) {
                recorder.record(Hit.K4_LEAF_OVERFLOW);
                int mid = keys.size() / 2;
                LeafNode right = new LeafNode();
                right.keys.addAll(keys.subList(mid, keys.size()));
                right.values.addAll(values.subList(mid, values.size()));

                this.keys = new ArrayList<>(keys.subList(0, mid));
                this.values = new ArrayList<>(values.subList(0, mid));

                right.next = this.next;
                this.next = right;

                return new SplitResult(right.keys.get(0), this, right);
            } else {
                recorder.record(Hit.K3_LEAF_OK);
            }
            return null;
        }

        @Override
        boolean search(int key, HitRecorder recorder) {
            for (int k : keys) {
                if (k == key) return true;
            }
            return false;
        }

        @Override
        boolean isOverflow() {
            return keys.size() > MAX_KEYS;
        }

        @Override
        void print(String prefix, boolean isTail) {
            System.out.println(prefix + (isTail ? "└─ " : "├─ ") + "Leaf " + keys);
        }
    }

    // ---------- 分裂结果 ----------
    private static class SplitResult {
        int middleKey;
        Node left;
        Node right;

        SplitResult(int key, Node left, Node right) {
            this.middleKey = key;
            this.left = left;
            this.right = right;
        }
    }
}