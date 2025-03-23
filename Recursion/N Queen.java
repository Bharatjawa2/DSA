class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        int[][] board=new int[n][n];
        solve(0,board,ans);
        return ans;
    }
    void solve(int row,int[][] board,List<List<String>> ans){
        if(row==board.length){
            ans.add(construct(board));
            return;
        }
        for(int col=0;col<board.length;col++){
            if(isSafe(row,col,board)){
                board[row][col]=1;
                solve(row+1,board,ans);
                board[row][col]=0;
            }
        }
    }
    boolean isSafe(int row,int col,int[][] board){
        for(int i=0;i<row;i++){
            if(board[i][col]==1) return false;
        }
        for(int i=row,j=col;i>=0 && j>=0; i-- ,j--){
            if(board[i][j]==1) return false;
        }
        for(int i=row,j=col;i>=0 && j<board.length;i--,j++){
            if(board[i][j]==1) return false;            
        }
        return true;
    }

    List<String> construct(int[][] board){
        List<String> ans=new ArrayList<>();
        int n=board.length;
        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++){
                if(board[i][j]==1) sb.append('Q');
                else sb.append('.');
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
