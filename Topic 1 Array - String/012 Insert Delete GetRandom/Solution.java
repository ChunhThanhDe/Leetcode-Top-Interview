/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-05-24 16:20:41
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;

class RandomizedSet {

    // A list to store the element
    private ArrayList<Integer> list;

    // Random object to generate random indices for the getRandom method
    private Random rand;

    // A map to store the value as the key and its index in the list as the value;
    private HashMap<Integer, Integer> map;


    // Constructor initialize the data structures
    public RandomizedSet() {
        map = new HashMap<>(); // initialize the map to store element position
        list = new ArrayList<>(); // initialize the list to store element.
        rand = new Random(); // initialize the random obj for random index generation
    }

    // Insert a value into the set
    public boolean insert(int val) {
        if (map.containsKey(val)){
            // if the map contain the value, return false
            return false;
        }

        // add the value to the last of the list
        map.put(val, list.size());
        list.add(val);
        // record the position of the value in to map, position is the current size of the list


        return true;
    }

    // remove the value of the set
    public boolean remove(int val) {

        // get the positions of the val to be removed in the map, if exists
        Integer index = map.get(val);

        // if the value not present so return false
        if (index == null) return false;

        int lastIndex = list.size() - 1;

        if (index != lastIndex){
            // if the element to remove is not the last element
            int lastElement = list.get(lastIndex); // get the last element
            list.set(index, lastElement); // move the last element to the position of the element to remove
            map.put(lastElement, index); // update the position of the last element in map
        }

        list.remove(lastIndex); // Remove the last element from the list
        map.remove(val); // remove the element of the map
        return true;
    }

    // Return a random element from the set
    public int getRandom() {

        // return value of a random index between 0 and the size of list - 1
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */