public class P200 {
    public int numIslands(char[][] grid) {
        if (grid.length==0) return 0;
        int l = grid.length;
        int w = grid[0].length;
        int count = 0;

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    visit(grid, i, j, l, w);
                    count++;
                }
            }
        }
        return count;
    }

    private void visit(char[][] grid, int i, int j, int l, int w) {
        if (i == l || i == -1 || j == -1 || j == w) return;
        if (grid[i][j] == '1') grid[i][j] = '0'; else return;
        visit(grid, i-1, j, l, w);
        visit(grid, i+1, j, l, w);
        visit(grid, i, j+1, l, w);
        visit(grid, i, j-1, l, w);
    }
}
