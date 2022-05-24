class Solution {
    public long solution(int price, int money, int count) {

        long sum = 0;
        
        for (int i = 0 ; i < count ; i ++) {
            sum += price * (i + 1);
        }

        return sum > money ? sum - money : 0;
    }
}