class Solution {
    public double averageWaitingTime(int[][] customers) {
        int numberOfCustomers = customers.length;
        long totalWaitingTime = 0;
        long currentTime = 0;
        for (int[] customer : customers) {
            currentTime = Math.max(currentTime, customer[0]);
            currentTime += customer[1];
            totalWaitingTime += currentTime - customer[0];
        }
        return (double) totalWaitingTime / numberOfCustomers;
    }
}