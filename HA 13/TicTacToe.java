public class TicTacToe{

	private char[][] field = {{' ', ' ', ' '},
							  {' ', ' ', ' '},
							  {' ', ' ', ' '}};

	public boolean isFull(){
		boolean isFull = true;
		for (int i = 0; i < field.length; i++){
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j] == ' '){
					isFull = false;
				} 
			}
		}
		return isFull;
	}

	public boolean checkVertical(char player){
		return true;
	}

	public boolean checkHorizontal(char player){
		for (int i = 0; i < field.length ; i++) {
			for (int j = 0;j < field.length ; j++) {
				
			}
		}
		return true;
	}

	public boolean checkDiagonal(){
		return true;
	}
}