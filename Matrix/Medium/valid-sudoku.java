// https://leetcode.com/problems/valid-sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            Set<Character> setRow = new HashSet<>();
            Set<Character> setCol = new HashSet<>();
            for(int j =0;j<9;j++){
                if(board[i][j] != '.'){
                    if(setRow.contains(board[i][j])){
                        return false;
                    }
                    else{
                        setRow.add(board[i][j]);
                    }
                }
                if(board[j][i] != '.'){
                    if(setCol.contains(board[j][i])){
                        return false;
                    }
                    else{
                        setCol.add(board[j][i]);
                    }
                }
                
                
            }
        }
        for(int k = 0;k<3;k++){
            for(int l=0;l<3;l++){
                int startRow = k*3; 
                int endRow = (k+1) * 3; 
                int startCol = l*3; 
                int endCol = (l+1)*3; 
                Set<Character> set = new HashSet<>();
                for(int i=startRow;i<endRow;i++){
                    for(int j =startCol;j<endCol;j++){
                        if(board[i][j] != '.'){
                            if(set.contains(board[i][j])){
                                return false;
                            }
                            else{
                                set.add(board[i][j]);
                            }
                        }
                    }
                }
            }
        }
        return true;
        
    }
}