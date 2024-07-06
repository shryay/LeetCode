class Solution {
    public int passThePillow(int n, int time) {
        int i = 1;
        boolean forward = true;
        while (time > 0) {
            if (forward) {
                if (i == n) {
                    forward = false;
                    i--;
                } 
                else
                i++;
            } 
            else {
                if (i == 1) {
                    forward = true;
                    i++;
                } 
                else
                i--;
            }
            time--;
        }
        return i;
    }
}