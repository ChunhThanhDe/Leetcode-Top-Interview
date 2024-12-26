/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-05-24 16:20:41
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Initialize totalTank to keep track of the overall amount of gas filled and use
        int totalTank = 0;
        // Initialize startStation to determine the starting station index
        int startStation = 0;
        // initialize CurrentTask to track the gas use from the starting station to the nest station
        int currentTask = 0;

        // loop through all station
        for (int i = 0; i < gas.length; i++){

            // update the totalTank with difference between gas and cost from each station
            totalTank += gas[i] - cost[i];

            // update the currentTask with same difference
            currentTask += gas[i] - cost[i];

            // if currentTask is negative, this mean we can not go to next Station
            // hence, we need to reset the startStation to the next Station
            if (currentTask < 0){
                // set the new index of the start station to the next station
                startStation = i + 1;
                // reset currentTask
                currentTask = 0;
            }
        }

        // if totalTank is non-negative, it mean there is enough gas to complete the circuit
        // Otherwise, return -1 indicating that it is not possible to complete the circuit
        return totalTank >= 0 ? startStation : -1;

    }
}