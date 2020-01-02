import tkinter as tk

class TicTacToe(tk.Tk):
	def __init__(self):
		global board
		self.board = [[0 for j in range(3)] for i in range(3)]
		global length
		self.length = len(self.board)
		global player
		self.player = 1
		global numMoves
		self.numMoves = 0
		global aiPlayer
		self.aiPlayer = False

		tk.Tk.__init__(self)
		self.title('TicTacToe game')
		self.top_frame = tk.Frame(self, width = 409, height = 70, pady = 3)
		self.top_frame.pack()
		self.play_button = tk.Menubutton(self.top_frame, text = 'Play')
		self.play_button.pack(padx = 100, pady = 30, side = tk.LEFT)
		option = tk.Menu(self.play_button)
		option.add_command(label = 'vs computer', command = self.setAI)
		option.add_command(label = 'vs human', command = self.setHuman)
		self.play_button.config(menu = option)
		self.reset_button = tk.Button(self.top_frame, text = 'Reset', command = self.resetBoard)
		self.reset_button.pack(padx = 100, pady = 30, side = tk.LEFT)
		
		self.middle_frame = tk.Frame(self)
		self.middle_frame.pack()
		self.button_0 = tk.Button(self.middle_frame, padx = 45, pady = 45)
		self.button_1 = tk.Button(self.middle_frame, padx = 45, pady = 45)
		self.button_2 = tk.Button(self.middle_frame, padx = 45, pady = 45)
		self.button_3 = tk.Button(self.middle_frame, padx = 45, pady = 45)
		self.button_4 = tk.Button(self.middle_frame, padx = 45, pady = 45)
		self.button_5 = tk.Button(self.middle_frame, padx = 45, pady = 45)
		self.button_6 = tk.Button(self.middle_frame, padx = 45, pady = 45)
		self.button_7 = tk.Button(self.middle_frame, padx = 45, pady = 45)
		self.button_8 = tk.Button(self.middle_frame, padx = 45, pady = 45)

		self.button_0.grid(row = 0, column = 0)
		self.button_1.grid(row = 0, column = 1)
		self.button_2.grid(row = 0, column = 2)
		self.button_3.grid(row = 1, column = 0)
		self.button_4.grid(row = 1, column = 1)
		self.button_5.grid(row = 1, column = 2)
		self.button_6.grid(row = 2, column = 0)
		self.button_7.grid(row = 2, column = 1)
		self.button_8.grid(row = 2, column = 2)

		self.bottom_frame = tk.Frame(self)
		self.bottom_frame.pack()
		self.message = tk.Label(self.bottom_frame, text = 'message', pady = 30)
		self.message.pack()



				
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


	def resetBoard(self):
		self.board = [[0 for j in range(3)] for i in range(3)]

	def setAI(self):
		self.aiPlayer = True
		self.startGame()

	def setHuman(self):
		self.aiPlayer = False
		self.startGame()

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
		while True:
			self.printBoard()
			if self.aiPlayer:
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

if __name__ == '__main__':
	TicTacToe().mainloop()