class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
      
        // Use long to prevent integer overflow as mass accumulates
        long currentMass = mass;
      
        // Iterate through each asteroid in sorted order
        for (int asteroidMass : asteroids) {
            // Check if current mass is sufficient to destroy this asteroid
            if (currentMass < asteroidMass) {
                return false;  // Cannot destroy this asteroid, mission fails
            }
          
            // Absorb the asteroid's mass after destroying it
            currentMass += asteroidMass;
        }
      
        // All asteroids successfully destroyed
        return true;
    }
}