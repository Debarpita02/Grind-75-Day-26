class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] result = new int[rows][cols];
        int maxDist = rows + cols; // Maximum possible distance

        // First pass: top-left to bottom-right
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] != 0) {
                    int topCell = (i > 0) ? result[i - 1][j] : maxDist;
                    int leftCell = (j > 0) ? result[i][j - 1] : maxDist;
                    result[i][j] = 1 + Math.min(topCell, leftCell);
                }
            }
        }

        // Second pass: bottom-right to top-left
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    int bottomCell = (i < rows - 1) ? result[i + 1][j] : maxDist;
                    int rightCell = (j < cols - 1) ? result[i][j + 1] : maxDist;
                    result[i][j] = Math.min(result[i][j], 1 + Math.min(bottomCell, rightCell));
                }
            }
        }

        return result;
    }
}
