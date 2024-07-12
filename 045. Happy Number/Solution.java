public class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
            if (fast == 1) return true;
        } while (slow != fast);
        
        return false;
    }
    
    private int getNext(int n) {
        int res = 0;
        while (n != 0) {
            res += (n%10)*(n%10);
            n /= 10;
        }
        return res;
    }
}