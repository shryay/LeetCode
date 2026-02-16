class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int bitPosition = 0; bitPosition < 32 && n != 0; bitPosition++) {
            int currentBit = n & 1;
            result |= currentBit << (31 - bitPosition);
            n >>>= 1;
        }
        return result;
    }
}