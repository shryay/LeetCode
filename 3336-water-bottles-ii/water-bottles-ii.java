class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int totalDrunk = 0;
        int empty = 0;

        // Drink initial full bottles
        totalDrunk += numBottles;
        empty += numBottles;

        while (empty >= numExchange) {
            // Exchange empties for 1 new bottle
            empty -= numExchange; 
            numExchange++; // cost increases after each exchange
            empty++;       // the new bottle will become empty after drinking
            totalDrunk++;  // drank 1 more
        }

        return totalDrunk;
    }
}