package chenjie.leetcode.misc;

public class BestCoordinate {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int xMax = Integer.MIN_VALUE;
        int yMax = Integer.MIN_VALUE;
        for (int[] tower : towers) {
            xMax = Math.max(xMax, tower[0]);
            yMax = Math.max(yMax, tower[1]);
        }
        int maxQuality = 0;
        int cx = 0;
        int cy = 0;
        for (int i = 0; i <=xMax; i++) {
            for (int j = 0; j <= yMax; j++) {
                int[] cur = {i, j};
                int quality = 0;
                for (int[] tower : towers) {
                    int squaredDistance = calcDistance(cur, tower);
                    if (squaredDistance <= radius * radius) {
                        double distance = Math.sqrt(squaredDistance);
                        quality += (int) Math.floor(tower[2] / (1 + distance));
                    }
                }
                if (Double.compare(quality, maxQuality) == 1)  {
                    cx = i;
                    cy = j;
                    maxQuality = quality;
                }

            }
        }
        return new int[]{cx, cy};
    }

    private int calcDistance(int[] cur, int[] tower) {
        return (tower[0] - cur[0])*(tower[0] - cur[0]) + (tower[1] - cur[1])*(tower[1] - cur[1]);
    }
}
