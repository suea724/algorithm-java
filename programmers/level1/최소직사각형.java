class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxHeight = 0;
        int maxWidth = 0;
        
		// Math.max(int a, int b), Math.min(int a, int b) 함수를 사용하면 안쪽 for문을 사용할 필요 없고, swap 과정이 줄어든다. 
        
        for (int i = 0 ; i < sizes.length ; i ++) {
            for (int j = 0 ; j < sizes[i].length-1 ; j ++) {
                
               if (sizes[i][j] < sizes[i][j+1]) { // 가로가 세로보다 길 경우 swap
                   int temp = sizes[i][j];
                   sizes[i][j] = sizes[i][j+1];
                   sizes[i][j+1] = temp;                   
               } 
                  
               if (sizes[i][j] > maxHeight) { // 최대 높이보다 길 경우 저장
                   maxHeight = sizes[i][j];
               }

               if (sizes[i][j+1] > maxWidth) { // 최대 넓이보다 길 경우 저장
                   maxWidth = sizes[i][j+1];
               }
               
            }
        }
        
        return maxHeight * maxWidth;
    }
}