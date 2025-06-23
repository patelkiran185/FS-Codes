import java.util.LinkedList;
import java.util.Queue;

class islandPerimeter {
    public static int islandPerimeterrr(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int perimeter = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    // BFS starting point
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while(!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0];
                        int y = cell[1];

                        // Check all 4 directions
                        for(int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            // If the neighbor is out of bounds or water -> add to perimeter
                            if(nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0) {
                                perimeter++;
                            } else if(grid[nx][ny] == 1 && !visited[nx][ny]) {
                                // If neighbor is land and not visited
                                visited[nx][ny] = true;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        return perimeter;
    }
    public static void main(String[] args) {
        int[][] grid={{0,1,0,0},{1,1,0,0},{1,1,0,0},{1,0,0,0}};
        System.out.println(islandPerimeterrr(grid));
    }
}