/*
 * Tic Tac Toe:
 *
 * Your project, should you choose to code it, is implement Tic Tac Toe.
 * The game should be playable by two people on the command line.
 * Run the program by opening
 */


// Some magic to get a 'prompt' method, that gives you input
var prompt = require('prompt-sync')();

// The 3x3 game board of Tic Tac Toe.
// Value of 0 is no move made
//          1 is Player 1 'O'
//         -1 is Player 2 'X'
var board = [[0, 0, 0], 
			 [0, 0, 0], 
			 [0, 0, 0]];

/* Printed board should look like this: 
 O | X | 
 ---------
   | O |  
 ---------
   |   | Os
*/

// Tracks the current player (1 for 'Player 1', -1 for 'Player 2')
var player = 1;
var numMoves = 0;

function printBoard(board) {
	/* Write code here to print the gameboard to screen using
	   the console.log() command.
	   Returns nothing
	 */

	for(var i = 0; i < board.length; i++) {
		var row = " ";
		for(var j = 0; j < board.length; j++) {	
			if(j !== 0) {
				row += "|";		
			}
			if(board[i][j] === 1) {
				row += " O ";
			}
			else if(board[i][j] === -1) {
				row += " X ";
			}
			else {
				row += "   ";
			}
		}
			if(i !== 0) {
				console.log("-------------");
			}
			console.log(row);
	}
}

function checkCols(board) {
	/* Write code to check if either player has a column win
	   Return 1 or -1 for the player who won 
	 */
	 for(var j = 0; j < board.length; j++) {
	 	var sum = 0;
	 	for(var i = 0; i < board.length; i++) {
	 		sum += board[i][j];
	 	}
	 	// console.log("Completed column "+ i + " " + board[i] + " sum = " + sum)
 		if(sum === board.length || sum === -(board.length)) {
 			return (sum / board.length);
 		}

	 }
	return 0; 
}

function checkRows(board) {
	/* Write code to check if either player has a row win
	   Return 1 or -1 for the player who won 
	 */
	 for(var i = 0; i < board.length; i++) {
	 	var sum = 0;
	 	for(var j = 0; j < board.length; j++) {
	 		sum += board[i][j];
	 	}
	 	// console.log("Completed column "+ i + " " + board[i] + " sum = " + sum)
 		if(sum === board.length || sum === -(board.length)) {
 			return (sum / board.length);
 		}

	 }
	return 0;
}

function checkDiags(board) {
	/* Write code to check if either player has a diag win
	   Return 1 or -1 for the player who won 
	 */
	var sum1 = 0;
	var sum2 = 0;
	for(var i = 0; i < board.length; i++) {
	 	sum1 += board[i][i];
	 	sum2 += board[i][board.length - i - 1];		
	}
	if(sum1 === board.length || sum1 === -(board.length)) {
 		return (sum1 / board.length);
 	}
 	else if(sum2 === board.length || sum2 === -(board.length)) {
 		return (sum2 / board.length);
 	}
 	return 0;

}

function checkWin(board) {
	/* Write code here to call checkCols, checkRows, checkDiags
	   and see if either player has won.
	   Return 1 or -1 for the player who won
	*/
	var win1 = checkCols(board);
	if(win1 !== 0) {
		return checkCols(board);
	}
	var win2 = checkRows(board);
	if(win2 !== 0) {
		return checkRows(board);
	}
	var win3 = checkDiags(board);
	if(win3 !== 0) {
		return checkDiags(board);
	}
	return 0;
}

function ifCanWinMove(board) {
	for(var i = 0; i < board.length; i++) {
		for(var j = 0; j < board.length; j++) {
			if(board[i][j] === 0) {
				board[i][j] = player;
				if(checkWin(board) == player) {
					return true;
				}
				else {
					board[i][j] = 0;
				}
			}
		}
	}
}

function ifCanBlockMove(board) {
	//console.log("AI cannot make winning move, attempting block as " + player)
	for(var i = 0; i < board.length; i++) {
		for(var j = 0; j < board.length; j++) {
			if(board[i][j] === 0) {
				board[i][j] = player * -1;
				if(checkWin(board) == player * -1) {
					board[i][j] = player;
					return true;
				}
				else {
					board[i][j] = 0;
				}
			}
		}
	}
}

function randomAIMove(board) {
	//console.log("AI making random move as " + player)
	for(var i = 0; i < board.length; i++) {
		for(var j = 0; j < board.length; j++) {
			if(board[i][j] === 0) {
				board[i][j] = player;
				return true;
			}
		}
	}
}

function aiMove(board) {
	//console.log("AI making move as player " + player)
	numMoves++;
	if(ifCanWinMove(board)) {
		//console.log("AI makng winning move as " + player)
		return board;
	}
	else if(ifCanBlockMove(board)) {
		//console.log("AI making blocking move as " + player)
		return board;
	}
	else {
		randomAIMove(board);
		return board;
	}
}

function makeMove(board) {
	/* Write code here, to ask the player for a move,
	   then attempt to place their move on the gameboard
	   Return the gameboard
	 */
	var needInput = true;
	var x;
	var y;
	while(needInput) {
		console.log("Please make a move, Player " + (player == 1 ? 1 : 2) + ". (e.g; a1, b2, c3...)");
		var input = prompt();
		switch(input[0]) {
		 	case "a":
		 		x = 0;
		 		break;
		 	case "b":
		 		x = 1;
		 		break;
		 	case "c":
		 		x = 2;
		 		break;	 		
		 }
		y = input[1] - 1;
		
		if(x >= 0 && x < board.length && y >= 0 && y < board.length && board[x][y] === 0) {
			needInput = false;
			board[x][y] = player;
			numMoves++;
		}		
	}
	return board;
}

function startGame() {
	/* Make the game run in this function
	 * You can delete my code from below:
	 */
	 var answer = prompt("Hello, do you want to play a game of TicTacToe? [yes/no]");
	 if(answer === "yes") {
	 	console.log("Great! Let's start!");
		while(true) {
			printBoard(board);
			if(player == 1) {
				makeMove(board);
			}
			else {
				aiMove(board);				
			}
			
			console.log(checkWin(board));
			if(checkWin(board) !== 0) {
				printBoard(board);
				console.log("Player " + (checkWin(board) == 1 ? 1 : 2) + " has won!");
				return false; 
			}
			
			if(numMoves=== board.length * board.length) {
				printBoard(board);
				console.log("It's a draw!");
				return false;
			}
			player *= -1;
		}

	 }
	else if(answer === "no") {
		console.log("Aww...");
	}
	else {
		console.log("Sorry, I didn't understand that...");
	}

}

startGame();