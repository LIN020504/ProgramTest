package Method.BPlusTree;

public enum Hit {
    K1_SEARCH,        // 查找插入位置
    K2_INSERT_LEAF,   // 插入叶节点
    K3_LEAF_OK,       // 叶节点未满
    K4_LEAF_OVERFLOW, // 叶节点溢出
    K5_LEAF_SPLIT,    // 叶节点分裂
    K6_PARENT_UPDATE, // 更新父节点
    K7_INTERNAL_OVERFLOW,
    K8_INTERNAL_SPLIT,
    K9_NEW_ROOT
}