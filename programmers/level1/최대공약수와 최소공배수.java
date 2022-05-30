class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int min = n < m ? n : m;
        int max = n < m ? m : n;
        
        // 최대공약수
        for (int i = min ; i >= 1 ; i --) {
            if (n % i == 0 && m % i == 0) {
                answer[0] = i;
                break;
            }
        }
        
        // 최소공배수
        for (int i = max ; i < max*min+1 ; i ++) {
            if (i % m == 0 && i % n == 0) {
                answer[1] = i;
                break;
            }
        }
    
        return answer;
    }
}