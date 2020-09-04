package FinalProject;


	
	import java.awt.*; // Graphics, Color, Font



	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.io.FileWriter;
	import java.io.IOException;

	import javax.swing.JComponent;
	import javax.swing.JOptionPane;

	public class Connect4Game2 extends JComponent implements MouseListener {
		
		private int width;
		private int height; // the starting location of the board
		private int rectSize; // the size of a square on the board
		
		private String player1;
		private String player2; // name of players
		private int player1Score;
		private int player2Score; // number of wins
		
		private String message; // to be displayed in the window
		
		private int[][] pieces; // a 3*3 array containing info for pieces
								// 0: no piece on the square
								// 1: player1's piece on the square
								// 2: player2's piece on the square
		private boolean isPlayer1Turn; // indicate whose turn
		private int victoryType; // 0: game not over
								//1: player1 wins
								//2: player2 wins
								//3: tie	
		
		public Connect4Game2(String player1, String player2) {
			super();
			width = 75;
			height = 50;
			rectSize = 75; // the size of board would be 450 * 450
			this.player1 = player1;
			this.player2 = player2;
			player1Score = 0;
			player2Score = 0;
			message = "New Game! " + player1 + "'s turn:";
			pieces = new int[][] {
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0}
			}; // the initial board is empty.
//			pieces = new int[3][3];
			addMouseListener(this); // connect this component with mouse
			isPlayer1Turn = true; // by default, player1 goes first.
			victoryType = 0;
		}
		
	public void paintComponent(Graphics g) {
			
			Graphics2D g2D = (Graphics2D) g;
			
			// draw the game board
			drawBoard(g2D);
			
			// draw the pieces
			drawPieces(g2D);
			
			// draw the score board
			drawScoreBoard(g2D);
			
		}

//	private void drawScoreBoard(Graphics2D g2D) {
//		// First rectangle
//		g2D.setColor(Color.RED);
//		g2D.fillRect(0, 550, 670, 50);
//		
//		// Second rectangle
//		g2D.setColor(Color.WHITE);
//		g2D.fillRect(0, 600, 670, 50);
//		
//		// Third rectangle
//		g2D.setColor(Color.BLUE);
//		g2D.fillRect(0, 650, 670, 50);
//		
//		g2D.setColor(Color.ORANGE);
//		g2D.fillRect(0, 500, 670, 50);
//		
//		g2D.setColor(Color.ORANGE);
//		g2D.fillRect(0, 0, 670, 51);
//		
//		g2D.setColor(Color.ORANGE);
//		g2D.fillRect(0, 50, 76, 500);
//		
//		g2D.setColor(Color.ORANGE);
//		g2D.fillRect(600, 0, 76, 500);
//		// Draw texts
//		g2D.setColor(Color.BLACK);
//		g2D.setFont(new Font("Lucida Fax", Font.BOLD, 20));
//		// First row
//		g2D.drawString("Player1: " + player1, 20, 580);
//		g2D.drawString("Player2: " + player2, 325, 580);
//		// Second row
//		g2D.drawString("Player1 score: " + player1Score, 20, 630);
//		g2D.drawString("Player2 score: " + player2Score, 325, 630);
//		// Third row
//		g2D.drawString(message, 20, 680);
//		
//		/*g2D.drawString("Champ: "+Champ, 325, 530); */
//		
	private void drawScoreBoard(Graphics2D g2d) {
		//first rectangle
		g2d.setColor(Color.YELLOW);
		g2d.fillRect(0, 550, 600, 50);
		//g2d.fillRect(x, y, width, height);
		
		//second rectangle
		g2d.setColor(Color.CYAN);
		g2d.fillRect(0,  600, 600, 50);
		
		//third rectangle
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillRect(0, 650, 600, 50);
		
		//draw texts
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Serif", Font.BOLD, 20));
		
		//first row
		g2d.drawString("Player 1: " + player1, 20, 580);
		g2d.drawString("Player 2: " + player2, 325, 580);
		
		//second row includes score
		g2d.drawString("Player 1's score: " + player1Score, 20, 630);
		g2d.drawString("Player 2's score: " + player2Score, 325, 630);
		
		//third row
		g2d.drawString(message, 20, 680);
		
	}

	private void drawPieces(Graphics2D g2D) {
		
		int x = width;
		int y = height;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (pieces[i][j] == 1) {
					g2D.setColor(Color.RED);
					g2D.fillRect(x, y, rectSize, rectSize);
				}
				
				if (pieces[i][j] == 2) {
					g2D.setColor(Color.BLUE);
					g2D.fillRect(x, y, rectSize, rectSize);
				}
				
				x += rectSize;
			}
			x = width;
			y += rectSize;

	}
	}		
	
	private void drawBoard(Graphics2D g2d) {
		int x = width;
	int y = height;
		
		g2d.setColor(Color.BLACK);
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				g2d.drawRect(x, y, rectSize, rectSize);
				x += rectSize;
				
			}
			
			x = width;
			y += rectSize;
		}
		
		
	}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		public void names(String p1, String p2) {
			
			
			
		}
		
		public int findNewRowIndex(int rowIndex, int colIndex) {
			/*
			 * Returns the row index of the square that 
			 * the piece falls to.
			 */
			// the square we are looking for must have a piece
			// under it. Also the square should be empty
			boolean isEmpty;
			boolean hasPieceBelow;
			for (int i = 5; i >= 0; i--) {//check pieces[i][colIndex]
				isEmpty = (pieces[i][colIndex] == 0);
				if (i != 5) {
					hasPieceBelow = (pieces[i+1][colIndex] == 1 ||
								pieces[i+1][colIndex] == 2);
				} else {// if i is 5, then it is already at the bottom.
					hasPieceBelow = true;
				}
				if (isEmpty && hasPieceBelow) {
					return i;
				}
			}
			return -1; // -1 indicates that the column is already full.	
		}
		
			public void mousePressed(MouseEvent evt) {
				// extract the x and y coordinate of the click
				int x = evt.getX();
				int y = evt.getY();
				
				// TODO: End this method unless the mouse click is inside the board.
//				if (//condition to detect that the click is outside of the board){
//						return;
//			}
				
				// determine which square should be changed
				int rowIndex = (y - height) / rectSize;
				int colIndex = (x - width) / rectSize;
				
				int nri = findNewRowIndex(rowIndex, colIndex);
				int nci = colIndex;
				
				if(nri ==-1) {
					return;
				}
				// modify the corresponding number in pieces
				// TODO: prevent putting a piece on a non-empty square
				if (isPlayer1Turn) {
					pieces[/*rowIndex*/nri][nci/*colIndex*/] = 1;
					isPlayer1Turn = false; // next time it's player2's turn
				} else {
					pieces[/*rowIndex*/nri][nci/*colIndex*/] = 2;
					isPlayer1Turn = true; // next time it's palyer1's turn
				}
				
				// Detect victory
				victoryType = detectVictory();
				
				// If the game ends, update scores
				updateScore();
				updateMessage();
				
				// repaint the interface
				repaint();
				
				// If the current game ends, ask user if they want another game.
				askIfContinue();
				
				
			}
			
			public int detectVictory() {
				/*
				 * Return the victory type given the board layout.
				 * 0 - the game is not ended.
				 * 1 - Player 1 wins.
				 * 2 - Player 2 wins. 
				 * 3 - the games ends with a tie.
				 */
				
				if(doesPlayer1Win()) {
					return 1;
				} else if (doesPlayer2Win()) {
					return 2;
				} else if (hasEmptySquare()) {
					return 0;
				} else {
					return 3;
				}
				
			}
			
			public boolean doesPlayer2Win() {
				// Player 1 wins if:
				// 1. there are 4 connected 1's in a row.
				for (int i = 0; i < 6; i++) {// check row i
					// a) first four squares are 1
					if (pieces[i][0] == 2 &&
						pieces[i][1] == 2 &&
						pieces[i][2] == 2 &&
						pieces[i][3] == 2) {
						return true;
					}
					// b) square 2-5 are all 1's.
					if (pieces[i][1] == 2 &&
						pieces[i][2] == 2 &&
						pieces[i][3] == 2 &&
						pieces[i][4] == 2) {
						return true;
					}
					// c) square 3-6 are all 1's.
					if (pieces[i][2] == 2 &&
						pieces[i][3] == 2 &&
						pieces[i][4] == 2 &&
						pieces[i][5] == 2) {
						return true;
					}
					// d) last four squares are 1
					if (pieces[i][3] == 2 &&
						pieces[i][4] == 2 &&
						pieces[i][5] == 2 &&
						pieces[i][6] == 2) {
						return true;
					}
				}
				
				// 2. there are 4 connected 1's in a column.
				for (int j = 0; j < 7; j++) {// check column j
					// a) top four squares are 1
					if (pieces[0][j] == 2 &&
						pieces[1][j] == 2 &&
						pieces[2][j] == 2 &&
						pieces[3][j] == 2) {
						return true;
					}
					
					// b) middle four squares are 1
					if (pieces[1][j] == 2 &&
						pieces[2][j] == 2 &&
						pieces[3][j] == 2 &&
						pieces[4][j] == 2) {
						return true;
					}
					
					// c) bottom four squares are 1
					if (pieces[2][j] == 2 &&
						pieces[3][j] == 2 &&
						pieces[4][j] == 2 &&
						pieces[5][j] == 2) {
						return true;
					}
				}
				
				// 3. there are 4 connected 1's in a downward diagonal.
				int startRowIndex;
				int endRowIndex;
				for (int k = -3; k <= 2; k++) {//k = rowIndex - colIndex
					 if (k <= 0) {
						 startRowIndex = 0;
					 } else {
						 startRowIndex = k;
					 }
					 
					 if (k >= 0) {
						 endRowIndex = 5;
					 } else {
						 endRowIndex = k + 5;
					 }
					 
					 for (int i = startRowIndex; i < endRowIndex - 3; i++) {
//						 System.out.println("" + i + " " + k);
						 if(pieces[i][i-k] == 2 &&
							pieces[i+1][i-k+1] == 2 &&
							pieces[i+2][i-k+2] == 2 &&
							pieces[i+3][i-k+3] == 2) {
							 return true;
						 }
					 }	
				}
				
				// 4. there are 4 connected 1's in an upward diagonal.
				for (int k = 3; k <= 8; k++) {//k = rowIndex + colIndex
					 if (k <= 6) {
						 startRowIndex = 0;
					 } else {
						 startRowIndex = k - 6;
					 }
					 
					 if (k >= 6) {
						 endRowIndex = 5;
					 } else {
						 endRowIndex = k;
					 }
					 
					 for (int i = startRowIndex; i < endRowIndex - 3; i++) {
						 if(pieces[i][k-i] == 2 &&
							pieces[i+1][k-i-1] == 2 &&
							pieces[i+2][k-i-2] == 2 &&
							pieces[i+3][k-i-3] == 2) {
							 return true;
						 }
					 }	
				}	
				return false;
			}
			
			public boolean hasEmptySquare() {
				// if there is a 0 in the first row, return true;
				// if there is no 0 in the first row, then all other
				//   rows must be full as well, so return false.
				for (int j = 0; j < 7; j++) {// check pieces[0][j]
					if (pieces[0][j] == 0) {
						return true;
					}
				}
				return false;		
			}
			
			public boolean doesPlayer1Win() {
				
				for (int i = 0; i < 6; i++) {// check row i
					// a) first four squares are 1
					if (pieces[i][0] == 1 &&
						pieces[i][1] == 1 &&
						pieces[i][2] == 1 &&
						pieces[i][3] == 1) {
						return true;
					}
					// b) square 2-5 are all 1's.
					if (pieces[i][1] == 1 &&
						pieces[i][2] == 1 &&
						pieces[i][3] == 1 &&
						pieces[i][4] == 1) {
						return true;
					}
					// c) square 3-6 are all 1's.
					if (pieces[i][2] == 1 &&
						pieces[i][3] == 1 &&
						pieces[i][4] == 1 &&
						pieces[i][5] == 1) {
						return true;
					}
					// d) last four squares are 1
					if (pieces[i][3] == 1 &&
						pieces[i][4] == 1 &&
						pieces[i][5] == 1 &&
						pieces[i][6] == 1) {
						return true;
					}
				}
				
				// 2. there are 4 connected 1's in a column.
				for (int j = 0; j < 7; j++) {// check column j
					// a) top four squares are 1
					if (pieces[0][j] == 1 &&
						pieces[1][j] == 1 &&
						pieces[2][j] == 1 &&
						pieces[3][j] == 1) {
						return true;
					}
					
					// b) middle four squares are 1
					if (pieces[1][j] == 1 &&
						pieces[2][j] == 1 &&
						pieces[3][j] == 1 &&
						pieces[4][j] == 1) {
						return true;
					}
					
					// c) bottom four squares are 1
					if (pieces[2][j] == 1 &&
						pieces[3][j] == 1 &&
						pieces[4][j] == 1 &&
						pieces[5][j] == 1) {
						return true;
					}
				}
				
				// 3. there are 4 connected 1's in a downward diagonal.
				int startRowIndex;
				int endRowIndex;
				for (int k = -3; k <= 2; k++) {//k = rowIndex - colIndex
					 if (k <= 0) {
						 startRowIndex = 0;
					 } else {
						 startRowIndex = k;
					 }
					 
					 if (k >= 0) {
						 endRowIndex = 5;
					 } else {
						 endRowIndex = k + 5;
					 }
					 
					 for (int i = startRowIndex; i < endRowIndex - 3; i++) {
//						 System.out.println("" + i + " " + k);
						 if(pieces[i][i-k] == 1 &&
							pieces[i+1][i-k+1] == 1 &&
							pieces[i+2][i-k+2] == 1 &&
							pieces[i+3][i-k+3] == 1) {
							 return true;
						 }
					 }	
				}
				
				// 4. there are 4 connected 1's in an upward diagonal.
				for (int k = 3; k <= 8; k++) {//k = rowIndex + colIndex
					 if (k <= 6) {
						 startRowIndex = 0;
					 } else {
						 startRowIndex = k - 6;
					 }
					 
					 if (k >= 6) {
						 endRowIndex = 5;
					 } else {
						 endRowIndex = k;
					 }
					 
					 for (int i = startRowIndex; i < endRowIndex - 3; i++) {
						 if(pieces[i][k-i] == 1 &&
							pieces[i+1][k-i-1] == 1 &&
							pieces[i+2][k-i-2] == 1 &&
							pieces[i+3][k-i-3] == 1) {
							 return true;
						 }
					 }	
				}	
				return false;
			
				
			}
			
			private void updateScore() {
				if (victoryType == 1) {
					player1Score++;
				} else if (victoryType == 2) {
					player2Score++;
				}
			}
			
			private void updateMessage() {
				if (victoryType == 1) {
					message = player1 + " wins!";
				} else if (victoryType ==3) {
					message = "TIE!";
				} else if (victoryType == 2) {
					message = player2 + " wins!";
				} else if (victoryType == 0) {
					if (isPlayer1Turn) {
						message = player1 + "'s turn";
					} else {
						message = player2 + "'s turn";
					}
				}
				// TODO: if victoryType is 3, change message to "Game ends with a tie."
			}
			
			/*
			private void champ() {
				if(player1Score == player2Score) {
					Champ ="";
				}
				else if(player1Score > player2Score) {
					Champ = "player1";}
				else { Champ = "player2"; }
			}
			*/
			
			
			private void askIfContinue() {
				// Show a dialogbox if the game ends
				if (victoryType != 0) {
					int response = JOptionPane.showConfirmDialog(this, "Play again?", "Game Ended",
											JOptionPane.YES_NO_OPTION);
					if (response == 0) {// user clicks YES
						victoryType = 0;
						isPlayer1Turn = true;
						pieces = new int[][] {
							{0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0}
						};
						message = "New Game! " + player1 + "'s turn";
						repaint();
					} else { // user clicks NO
						print();
						System.exit(0);
					}
					}
			
		}
			
			private void print() {
			        try {
			            FileWriter writer = new FileWriter("c44.txt", true);
			            writer.write("Player 1 score"+player1Score);
			            writer.write("\r\n");   
			            writer.write("Player 2 score"+player2Score);
			            
			            if(player1Score>player2Score) {
			            	writer.write("\r\n");
			            	writer.write("player 1 is the champ");
			            	writer.write("\r\n");
			            }
			            else if(player1Score<player2Score) {
			            	writer.write("\r\n");
			            	writer.write("player 2 is the champ");
			            	writer.write("\r\n");
			            }
			            else if(player1Score==player2Score) {
			            	writer.write("\r\n");
			            	writer.write("noone is the champ");
			            	writer.write("\r\n");
			            }
			            
			            writer.close();
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			 
			    }
			/*
			private void print() throws IOException {
				FileOutputStream fileByteStream = null; // File output stream
			      PrintWriter outFS = null;               // Output stream
			      fileByteStream = new FileOutputStream("c4.txt");
			      outFS = new PrintWriter(fileByteStream);
			}
			*/
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}



