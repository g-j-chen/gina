import java.util.HashSet;

public class WordHunting {

	static char[][] grid;
	static String answer;
	//Set to keep track of letters (positions on the board) used
	static HashSet<String> gridPosUsed;
	//I tried to create a Pair class to hold the row and columns but
	//it wouldn't work, so I decided to use a String of the row and 
	//column together (ie row = 1, column = 2: "12"), as it would 
	//not be the same as another position

	static int[][] posChanges;

	public WordHunting(char[][] grid) {
		this.grid = grid;
		this.answer = "";
		this.gridPosUsed = new HashSet<String>();
		//Populate 2D array with changes to row and column
		//for the 8 squares around a letter
		this.posChanges = new int[][] {
							{-1, -1}, //NW
							{-1, 0},  //N
							{-1, 1},  //NE
							{0, -1},  //W
							{0, 1},   //E
							{1, -1},  //SW
							{1, 0},   //S
							{1, 1},   //SE
						};
	}

	public static String findLongestWord() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				//Clear set as starting a new word
				gridPosUsed.clear();
				gridPosUsed.add(Integer.toString(i) + Integer.toString(j));
				recursive(i, j, Character.toString(grid[i][j]));
			}
		}

		if(answer.length() > 2) {
			return answer;
		} else {
			return "No word possible";
		}
	}

	public static void recursive(int row, int col, String prefix) {
		for(int[] p : posChanges) {
			int newRow = row + p[0];
			int newCol = col + p[1];
			String newPair = Integer.toString(newRow) + Integer.toString(newCol);

			if(isValidPos(newRow, newCol) && !gridPosUsed.contains(newPair)) {
				String newPrefix = prefix + Character.toString(grid[newRow][newCol]);

				if(isWord(newPrefix) && (newPrefix.length() > answer.length())) {
					answer = newPrefix;
				}

				if(isPrefix(newPrefix)) {
					gridPosUsed.add(newPair);
					recursive(newRow, newCol, newPrefix);
				}
			}
		}
		
	}

	//Checking if position is on the board
	public static boolean isValidPos(int row, int col) {
		return (row >= 0 && row < 4 && col >= 0 && col < 4);
	}

	public static void main(String args[]) {
		char[][] grid = {{'F', 'X', 'I', 'E'}, 
						{'A', 'M', 'X', 'O'},
						{'E', 'W', 'B', 'C'},
						{'A', 'S', 'T', 'U'}};

		WordHunting wh = new WordHunting(grid);
		System.out.println("Longest word: " + wh.findLongestWord());
	}
}