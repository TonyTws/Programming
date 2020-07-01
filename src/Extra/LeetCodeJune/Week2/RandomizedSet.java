package Extra.LeetCodeJune.Week2;

import java.util.*;
/**
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * Example:
 *
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 *
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 *
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 *
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 *
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 *
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 *
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */

class RandomizedSet {
    Set<Integer> list = new HashSet<>();
    public static void main(String[] args) {
        RandomizedSet r =new RandomizedSet();
        System.out.println(r.insert(4));
        System.out.println(r.insert(4));
        System.out.println(r.remove(7));

    }


    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {

    }


    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        return this.list.add(val);
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        return this.list.remove(val);
//        try{
//            this.list.remove(val);
//            return true;
//        }catch (Exception e){
//            return false;
//        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        List<Integer> res = new ArrayList<>(list);
        int rnd = new Random().nextInt(list.size());
        return res.get(rnd);
    }
}

/**
 * Your Extra.LeetCodeJune.Week2.RandomizedSet object will be instantiated and called as such:
 * Extra.LeetCodeJune.Week2.RandomizedSet obj = new Extra.LeetCodeJune.Week2.RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */