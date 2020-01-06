import tkinter as tk
import tkinter.messagebox

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
		self.button_0 = tk.Button(self.middle_frame, text = ' ', font = 'Times 20 bold', height = 3, width = 6, command = lambda: self.buttonClick(self.button_0))
		self.button_1 = tk.Button(self.middle_frame, text = ' ', font = 'Times 20 bold', height = 3, width = 6, command = lambda: self.buttonClick(self.button_1))
		self.button_2 = tk.Button(self.middle_frame, text = ' ', font = 'Times 20 bold', height = 3, width = 6, command = lambda: self.buttonClick(self.button_2))
		self.button_3 = tk.Button(self.middle_frame, text = ' ', font = 'Times 20 bold', height = 3, width = 6, command = lambda: self.buttonClick(self.button_3))
		self.button_4 = tk.Button(self.middle_frame, text = ' ', font = 'Times 20 bold', height = 3, width = 6, command = lambda: self.buttonClick(self.button_4))
		self.button_5 = tk.Button(self.middle_frame, text = ' ', font = 'Times 20 bold', height = 3, width = 6, command = lambda: self.buttonClick(self.button_5))
		self.button_6 = tk.Button(self.middle_frame, text = ' ', font = 'Times 20 bold', height = 3, width = 6, command = lambda: self.buttonClick(self.button_6))
		self.button_7 = tk.Button(self.middle_frame, text = ' ', font = 'Times 20 bold', height = 3, width = 6, command = lambda: self.buttonClick(self.button_7))
		self.button_8 = tk.Button(self.middle_frame, text = ' ', font = 'Times 20 bold', height = 3, width = 6, command = lambda: self.buttonClick(self.button_8))

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
		self.message = tk.Label(self.bottom_frame, text = ' ', pady = 30)
		self.message.pack()


	def buttonClick(self, button):
		if button['text'] == ' ' and self.player == 1:
			button['text'] = 'X'
			self.message['text'] = " "
		elif button['text'] == ' ' and self.player == -1:
			button['text'] = 'O'
			self.message['text'] = " "
		else:
			tkinter.messagebox.showinfo('TicTacToe', 'Button already clicked!')

		if button == self.button_0:
			self.board[0][0] = self.player
		elif button == self.button_1:
			self.board[0][1] = self.player
		elif button == self.button_2:
			self.board[0][2] = self.player
		elif button == self.button_3:
			self.board[1][0] = self.player
		elif button == self.button_4:
			self.board[1][1] = self.player
		elif button == self.button_5:
			self.board[1][2] = self.player
		elif button == self.button_6:
			self.board[2][0] = self.player
		elif button == self.button_7:
			self.board[2][1] = self.player
		elif button == self.button_8:
			self.board[2][2] = self.player

		self.numMoves += 1

		checkWin = self.checkWin()
		if checkWin != 0:
			tkinter.messagebox.showinfo('TicTacToe', 'Player ' + str(1 if checkWin == 1 else 2) + ' has won!')
			return

		if self.numMoves == self.length ** 2:
			tkinter.messagebox.showinfo('TicTacToe', " It's a draw!")
			return

		self.player *= -1
		if self.aiPlayer:
			if self.player == -1:
				self.message['text'] = 'Computer making its move.'
				self.aiMove()
				checkWin = self.checkWin()
				if checkWin != 0:
					tkinter.messagebox.showinfo('TicTacToe', 'Player ' + str(1 if checkWin == 1 else 2) + ' has won!')
					return

				if self.numMoves == self.length ** 2:
					tkinter.messagebox.showinfo('TicTacToe', " It's a draw!")
					return
				self.player *= -1
				self.message['text'] = 'Player 1, make your move.'
		else:
			self.message['text'] = 'Player ' + str(1 if self.player == 1 else 2) + ' make your move.'

	def resetBoard(self):
		self.board = [[0 for j in range(3)] for i in range(3)]
		self.button_0['text'] = ' '
		self.button_1['text'] = ' '
		self.button_2['text'] = ' '
		self.button_3['text'] = ' '
		self.button_4['text'] = ' '
		self.button_5['text'] = ' '
		self.button_6['text'] = ' '
		self.button_7['text'] = ' '
		self.button_8['text'] = ' '
		self.message['text'] = ' '

	def setAI(self):
		self.aiPlayer = True
		self.message['text'] = "Let's play! Player 1, make your move."

	def setHuman(self):
		self.aiPlayer = False
		self.message['text'] = "Let's play! Player 1, make your move."

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
			return
		elif self.canBlock():
			return
		else:
			self.randomMove()
			return

	def setAiMove(self, pos):
		if pos == 0:
			self.button_0['text'] = 'O'
		elif pos == 1:
			self.button_1['text'] = 'O'
		elif pos == 2:
			self.button_2['text'] = 'O'
		elif pos == 3:
			self.button_3['text'] = 'O'
		elif pos == 4:
			self.button_4['text'] = 'O'
		elif pos == 5:
			self.button_5['text'] = 'O'
		elif pos == 6:
			self.button_6['text'] = 'O'
		elif pos == 7:
			self.button_7['text'] = 'O'
		elif pos == 8:
			self.button_8['text'] = 'O'

	def canWin(self):
		for i in range(self.length):
			for j in range(self.length):
				if self.board[i][j] == 0:
					self.board[i][j] = self.player
					if self.checkWin() == self.player:
						self.setAiMove(3 * i + j)
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
						self.setAiMove(3 * i + j)
						return True
					else:
						self.board[i][j] = 0

	def randomMove(self):
		for i in range(self.length):
			for j in range(self.length):
				if self.board[i][j] == 0:
					self.board[i][j] = self.player
					self.setAiMove(3 * i + j)
					return

if __name__ == '__main__':
	TicTacToe().mainloop()