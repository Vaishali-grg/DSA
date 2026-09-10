package linkedlist;
import java.util.*;
public class LC3283_MaximumNumberOfMovesToKillAllPawns {
    public int maxMoves(int kx, int ky, int[][] positions) {
        int n = positions.length;
        int[][] allPos = new int[n + 1][2];
        allPos[0] = new int[]{kx, ky};
        for (int i = 0; i < n; i++) {
            allPos[i + 1] = positions[i];
        }

        int[][] dist = new int[n + 1][n + 1];
        int[][] dirs = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        for (int i = 0; i <= n; i++) {
            int[][] d = new int[50][50];
            for (int[] row : d) Arrays.fill(row, -1);
            Queue<int[]> q = new LinkedList<>();
            q.add(allPos[i]);
            d[allPos[i][0]][allPos[i][1]] = 0;

            while (!q.isEmpty()) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int nx = curr[0] + dir[0];
                    int ny = curr[1] + dir[1];
                    if (nx >= 0 && nx < 50 && ny >= 0 && ny < 50 && d[nx][ny] == -1) {
                        d[nx][ny] = d[curr[0]][curr[1]] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }

            for (int j = 0; j <= n; j++) {
                dist[i][j] = d[allPos[j][0]][allPos[j][1]];
            }
        }

        int[][] memo = new int[n + 1][1 << n];
        for (int[] row : memo) Arrays.fill(row, -1);

        return solve(0, 0, n, dist, memo);
    }

    private int solve(int curr, int mask, int n, int[][] dist, int[][] memo) {
        if (mask == (1 << n) - 1) return 0;
        if (memo[curr][mask] != -1) return memo[curr][mask];

        int captured = Integer.bitCount(mask);
        boolean isAlice = (captured % 2 == 0);
        int res = isAlice ? 0 : Integer.MAX_VALUE;

        for (int next = 0; next < n; next++) {
            if ((mask & (1 << next)) == 0) {
                int moves = dist[curr][next + 1] + solve(next + 1, mask | (1 << next), n, dist, memo);
                if (isAlice) {
                    res = Math.max(res, moves);
                } else {
                    res = Math.min(res, moves);
                }
            }
        }

        return memo[curr][mask] = res;
    }
}