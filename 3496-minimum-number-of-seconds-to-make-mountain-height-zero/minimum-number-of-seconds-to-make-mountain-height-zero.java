class Solution {
    private int mountainHeight;
    private int[] workerTimes;
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        this.mountainHeight = mountainHeight;
        this.workerTimes = workerTimes;
        long left = 1;
        long right = (long) 1e16;
        long firstTrueIndex = -1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canCompleteInTime(mid)) {
                firstTrueIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return firstTrueIndex;
    }
    private boolean canCompleteInTime(long timeLimit) {
        long totalHeightReduced = 0;
        for (int workerTime : workerTimes) {
            long maxHeightByWorker = (long) (Math.sqrt(timeLimit * 2.0 / workerTime + 0.25) - 0.5);
            totalHeightReduced += maxHeightByWorker;
        }
        return totalHeightReduced >= mountainHeight;
    }
}