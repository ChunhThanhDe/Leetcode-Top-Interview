class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // can traval if 4 - 1 + 5 - 2 + 1 - 3 + 2 - 4 + 3 - 5 >= 0
        // gas          (3)     (4)     (0)     (1)     (2)
        // cost             (3)     (4)     (0)     (1)     (2)
        //
        // gas - cost      3       3      -2      -2      -2
        
        int n = gas.length;
        int totalDiff = 0; // Total gas - cost difference
        int currentDiff = 0; // Cumulative difference at each location
        int startStation = 0; // Starting position

        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            totalDiff += diff;
            currentDiff += diff;

            // If the accumulated fuel amount is less than 0, it is not possible 
            // to go from the current position -> go to the next position
            //  and reset the accumulated fuel amount to zero
            if (currentDiff < 0) {
                startStation = i + 1;
                currentDiff = 0;
            }
        }

        // If the total difference is less than 0, there is no satisfactory starting position
        if (totalDiff < 0) {
            return -1;
        }

        return startStation;
    }
}