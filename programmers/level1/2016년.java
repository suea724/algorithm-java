import java.util.*;

class Solution {
    public String solution(int a, int b) {
		
		// 맨날 까먹는 것,,
		// - set할 때 원하는 달-1 해주기!
		// - case할 때 return문 아니면 break 꼭 걸어주기!
		
        Calendar c = Calendar.getInstance();
        c.set(2016, a-1, b);
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        
        return getDay(c);
    }
    
    private String getDay(Calendar c) {
        
        int iday = c.get(Calendar.DAY_OF_WEEK);
        String day = "";
        
        switch (iday) {
            case 1:
                day = "SUN";
                break;
            case 2:
                day = "MON";
                break;
            case 3:
                day = "TUE";
                break;
            case 4:
                day = "WED";
                break;
            case 5:
                day = "THU";
                break;
            case 6:
                day = "FRI";
                break;
            case 7:
                day = "SAT";
                break;
        }
        return day;
    }
}