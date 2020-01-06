class TicTacToe:
	def __init__(self):
		global board
		self.board = [[0 for j in range(3)] for i in range(3)]
		global length
		self.length = len(self.board)
		global player
		self.player = 1
		global numMoves
		self.numMoves = 0

	def printBoard(self):
		print('')
		for i in range(self.length):
			row = []
			for j in self.board[i]:
				if j == 0:
					row.append(' ')
				elif j == 1:
					row.append('O')
				elif j == -1:
					row.append('X')
			if i != 0:
				print(' ---------')
			print(' ' + ' | '.join(row))
		print('')


	def checkColumns(self):
		for j in range(self.length):
			sumColumn = 0
			for i in range(self.length):
				sumColumn += self.board[i][j]
			if sumColumn == self.length or sumColumn == -self.length:
				return sumColumn // self.length

		return 0

	def checkRows(self):
		for r in self.board:
			sumRow = sum(r)
			if sumRow == self.length or r == -self.length:
				return sumRow // self.length

		return 0

	def checkDiagonals(self):
		sumDiag1 = 0
		sumDiag2 = 0
		for i in range(self.length):
			sumDiag1 += self.board[i][i]
			sumDiag2 += self.board[i][self.length - i - 1]
		if sumDiag1 == self.length or sumDiag1 == -self.length:
			return sumDiag1 // self.length
		if sumDiag2 == self.length or sumDiag2 == -self.length:
			return sumDiag2 // self.length

		return 0

	def checkWin(self):
		checks = [self.checkColumns(), self.checkRows(), self.checkDiagonals()]
		for i in checks:
			if i == 1 or i == -1:
				return i

		return 0

	def aiMove(self):
		self.numMoves += 1
		if self.canWin():
			return self.board
		elif self.canBlock():
			return self.board
		else:
			self.randomMove()
			return self.board

	def canWin(self):
		for i in range(self.length):
			for j in range(self.length):
				if self.board[i][j] == 0:
					self.board[i][j] = self.player
					if self.checkWin() == self.player:
						return True
					else:
						self.board[i][j] = 0

	def canBlock(self):
		for i in range(self.length):
			for j in range(self.length):
				if self.board[i][j] == 0:
					self.board[i][j] = self.player * -1
					if self.checkWin() == self.player * -1:
						self.board[i][j] = self.player
						return True
					else:
						self.board[i][j] = 0

	def randomMove(self):
		for i in range(self.length):
			for j in range(self.length):
				if self.board[i][j] == 0:
					self.board[i][j] = self.player
					return

	def makeMove(self):
		x = -1
		y = -1
		while True:
			move = input(' Player ' + str(1 if self.player == 1 else 2) + ', please enter your move (eg a1 => a is row, 1 is column): ')
			move = move.strip()
			if len(move) != 2:
				print(' Sorry, not sure what your input is. Please try again.')
				continue
			if move[0] == 'a':
				x = 0
			elif move[0] == 'b':
				x = 1
			elif move[0] == 'c':
				x = 2
			else:
				print(' Sorry, not sure what your input is. Please try again.')
				continue
			y = int(move[1]) - 1
			if y < 0 or y > 2:
				print(' Sorry, not sure what your input is. Please try again.')
				continue
			if self.board[x][y] == 0:
				self.numMoves += 1
				self.board[x][y] = self.player
				break


	def startGame(self):
		answer = input(' Hello, do you want to play a game of TicTacToe? yes/no: ')
		if answer == 'yes':
			answer2 = input(" Great! Do you want to play against the computer? yes/no: ")
			print(" Let's start!")
			if answer2 == 'yes':
				ai = True
			else:
				ai = False
			while True:
				self.printBoard()
				if ai:
					if self.player == 1:
						self.makeMove()
					else:
						self.aiMove()

				else:
					self.makeMove()

				if self.checkWin() != 0:
					self.printBoard()
					print(' Player ' + str(1 if self.checkWin() == 1 else 2) + ' has won!')
					break

				if self.numMoves == self.length ** 2:
					self.printBoard()
					print(" It's a draw!")
					break

				self.player *= -1

		elif answer == 'no':
			print(' Aww... :(')
		else:
			print(" Sorry, I didn't understand that...")

if __name__ == '__main__':
	t = TicTacToe()
	t.startGame() 