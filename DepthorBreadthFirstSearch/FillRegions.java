package DepthorBreadthFirstSearch;

public class FillRegions {
	void fillRegions(char[][] grid){
		int m = grid.length, n = grid[0].length;
		boolean[][] visited = new boolean [m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 'O' && (i == 0 || i == m-1 || j == 0 || j == n-1)) {
					dfs(grid, visited, i, j);
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 'O' && !visited[i][j]) {
					grid[i][j] = 'X';
				}
			}
		}
	}
	
	void dfs(char[][] grid, boolean[][] visited, int x, int y){
		if (x < 0 || x > grid.length-1 || y < 0 || y > grid[0].length-1) {
			return;
		}
		if (visited[x][y]) {
			return;
		}
		if (grid[x][y] == 'X') {
			visited[x][y] = true;
			return;
		}
		visited[x][y] = true;
		dfs(grid, visited, x-1, y);
		dfs(grid, visited, x+1, y);
		dfs(grid, visited, x, y-1);
		dfs(grid, visited, x, y+1);
	}
	
	public static void main(String[] args) {
		char[][] grid = {{'O','X','X','X'},{'X','O','O','X'},{'O','X','O','X'},{'O','X','X','X'}};
		FillRegions fillRegions = new FillRegions();
		fillRegions.fillRegions(grid);
		for (char[] cs : grid) {
			System.out.println(cs);
		}
	}
}
