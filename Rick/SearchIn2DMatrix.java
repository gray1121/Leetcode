public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(null == matrix || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int i = 0;
        int j = matrix[0].length - 1;
        // from the end to the start of every rows
        while(i < matrix.length && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}