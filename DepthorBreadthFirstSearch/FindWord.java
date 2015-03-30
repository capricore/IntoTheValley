package DepthorBreadthFirstSearch;

public class FindWord {
	boolean findWord(char[][] board, String word){
		int m = board.length, n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		boolean result = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == word.charAt(0)) {
					result = dfs(board, visited, i, j, word, 0);
					if (result) {
						return true;
					}
				}
			}
		}
		return result;
	}
	
	boolean dfs(char[][] board, boolean[][] visited, int x, int y, String word, int index){
		if (index == word.length()) {
			return true;
		}
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
			return false;
		}
		if (visited[x][y]) {
			return false;
		}
		visited[x][y] = true;
		if (board[x][y] == word.charAt(index) && index < word.length()) {
			return	dfs(board, visited, x-1, y, word, index+1) || dfs(board, visited, x+1, y, word, index+1) ||
			dfs(board, visited, x, y-1, word, index+1) || dfs(board, visited, x, y+1, word, index+1);
		}
		visited[x][y] = false;
		return false;
	}
	
	public static void main(String[] args) {
		char[][] board = {{'D','O','G'},{'A','Y','G'},{'C','D','B'}};
		System.out.println(new FindWord().findWord(board, "ACDBY"));
	}
}
