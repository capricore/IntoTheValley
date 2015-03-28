package DepthorBreadthFirstSearch;

public class CountZeroArea {
	int countZeroArea(int[][] grid){
		int n = grid.length, m = grid[0].length;
		boolean[][] visited = new boolean[n][m];
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && grid[i][j] == 0) {
					dfs(grid,visited,i,j);
					count++;
				}
			}
		}
		return count;
	}
	
	void dfs(int[][] grid, boolean[][] visited, int x, int y)
	{
		if (x < 0 || x > grid.length-1 || y < 0 || y > grid[0].length -1) {
			return;
		}
		if (grid[x][y] == 1 || visited[x][y]) {
			return;
		}
		visited[x][y] = true;
		dfs(grid, visited, x-1, y);
		dfs(grid, visited, x, y-1);
		dfs(grid, visited, x+1, y);
		dfs(grid, visited, x, y+1);
	}
	
	public static void main(String[] args) {
		int[][] grid = {{0,1,0},{0,0,1},{0,1,1}};
		System.out.println(new CountZeroArea().countZeroArea(grid));
	}
}
