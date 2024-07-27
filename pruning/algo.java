public void solveSudoku(char[][] board) {
    if (board == null || board.length == 0) {
        return;
    }
    solve(board);
}

public boolean solve(char[][] board) {
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] == '.') {
                for (char c = '1'; c <= '9'; c++) {
                    if (isValid(board, i, j, c)) {
                        board[i][j] = c;
                        if (solve(board)) {
                            return true;
                        } else {
                            board[i][j] = '.';
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }
}

public boolean isValid(char[][] board, int row, int col, char c) {
    for (int i = 0; i < 9; i++) {
        if (board[i][col] != '.' && board[i][col] == c) return false;
        if (board[row][i] != '.' && board[row][i] == c) return false;
        if (board[3*(row/3)+i/3][3*(col/3)+i%3] != '.' && board[3*(row/3)+i/3][3*(col/3)+i%3] == c) return false;
    }
    return true;
}

public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] != '.' && !isValid(board, i, j)) {
                return false;
            }
        }
    }
    return true;
}

public boolean isValid(char[][] board, int row, int col) {
    char c = board[row][col];
    for (int i = 0; i < 9; i++) {
        if (i != row && board[i][col] != '.' && board[i][col] == c) return false;
        if (i != col && board[row][i] != '.' && board[row][i] == c) return false;
        if (3*(row/3)+i/3 != row && 3*(col/3)+i%3 != col && board[3*(row/3)+i/3][3*(col/3)+i%3] != '.' && board[3*(row/3)+i/3][3*(col/3)+i%3] == c) return false;
    }
    return true;
}