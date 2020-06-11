public class WeightedQuickUnionUF {
    private int[] id;
    private int[] treeSize;

    public WeightedQuickUnionUF(int N) {
        id = new int[N];
        treeSize = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]]; // Path Compression
            i = id[i];
        }

        return i;
    }

    public boolean isConnected(int p, int q) {
        return (root(p) == root(q));
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);

        if (pRoot == qRoot) {
            return;
        }

        if (treeSize[pRoot] < treeSize[qRoot]) {
            id[pRoot] = qRoot;
            treeSize[qRoot] += treeSize[pRoot];
        } else {
            id[qRoot] = pRoot;
            treeSize[pRoot] += treeSize[qRoot];
        }
    }
}
