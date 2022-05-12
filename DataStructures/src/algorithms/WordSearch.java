class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board.length==0||word.length()==0)
            return false;
        boolean isVisited[][]=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
          for(int j=0;j<board[i].length;j++){
              if(board[i][j]==word.charAt(0) && helper(board,word,i,j,isVisited)){
                 return true; 
              }
          }   
        }
        return false;
    }
    private boolean helper(char[][] board,String word,int i,int j,boolean[][] isVisited){
        if(word==null||word.length()==0)
            return true;
        if(i<0||i>=board.length||j<0||j>=board[i].length||isVisited[i][j])
            return false;
       
        boolean isValid=false;
        isVisited[i][j]=true;
        if(board[i][j]==word.charAt(0)){
            isValid|=helper(board,word.substring(1),i-1,j,isVisited);
            isValid|=helper(board,word.substring(1),i+1,j,isVisited);
            isValid|=helper(board,word.substring(1),i,j-1,isVisited);
            isValid|=helper(board,word.substring(1),i,j+1,isVisited);
        }
        isVisited[i][j]=false;
        return isValid;
    }
}
