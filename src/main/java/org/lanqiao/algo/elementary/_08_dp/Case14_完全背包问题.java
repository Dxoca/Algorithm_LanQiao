package org.lanqiao.algo.elementary._08_dp;

/**
 * 物品数量无限
 * 完全背包问题
 * 首先在初始化最后一行的时候有所不同：初始化时，当只考虑一件物品a时，state[row][j] = values[row]*j/weight[row]
 * 然后在递推的时候有些不同：state[row][j] = max{state[row+1][j],state[row][j-weight[row]]+values[row]}，即不抓时用现在的容量去匹配下面行
 * 要抓的时候，先抓到这个物品的价值，然后用剩下的容量去匹配同一行，为什么匹配同一行，这是因为剩下的容量可以重复抓当前物品（不限数量）
 * <p>
 * 同时必须理解，抓一个之后用剩余的容量重新考虑当前可选的所有物品其实包含了抓2个甚至更多的情况！！！
 *
 * @author zhengwei
 */
public class Case14_完全背包问题 {

    static int[] values = {9, 5, 3, 1};
    static int[] weights = {7, 4, 3, 2};
    static int n = 4;
    static int total = 10;

    public static void main(String[] args) {
        // weights = Util.getRandomArr(100, 1, 50);
        // Util.print(weights);
        // values = Util.getRandomArr(100, 1, 30);
        // Util.print(values);
        // total = 100;
        // for (int i = 0; i < state.length; i++) {
        //   for (int j = 0; j < state[i].length; j++) {
        //     state[i][j]=-1;
        //   }
        // }
        // int x = f_m(total, weights.length - 1);
        // System.out.println(x);
        dp();
    }

    static int[][] state = new int[n][total + 1];//不同的物品范围下不同的容量能装出来的最大价值

    /***
     * 递推
     */
    static void dp() {
        // row 行号
        int row = n - 1;
        //v是容量
        int v = 1;
        int w = weights[row];
        for (; v < total + 1; v++) {
            state[row][v] = values[row] * v / w;
        }

        for (int r = row - 1; r >= 0; r--) {
            //r 当前处理的行，也是当前处理的物品
            w = weights[r];
            for (int c = 1; c < total + 1; c++) {
                //c 当前处理的容量
                //能抓
                if (c >= w) {
                    //  要抓
                    int v1 = values[r] + state[r][c - w];
                    // 不抓
                    int v2 = state[r + 1][c];
                    state[r][c] = Math.max(v1, v2);
                } else { // 不能抓
                    state[r][c] = state[r + 1][c];
                }
            }
        }
        System.out.println(state[0][total]);
    }
}
