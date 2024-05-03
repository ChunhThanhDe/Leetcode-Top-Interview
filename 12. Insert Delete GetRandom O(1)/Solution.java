public class RandomizedSet {

    // a table to determine the position of inserted elements in the list
    private Map<Integer, Integer> map;

    // a list of added elements
    private List<Integer> list;
    private Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            System.out.println("map: " + map);
            System.out.println("list: " + list);
            return false;
        }

        map.put(val, list.size());
        list.add(val);
        System.out.println("map: " + map);
        System.out.println("list: " + list);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            System.out.println("map: " + map);
            System.out.println("list: " + list);
            return false;
        }

        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);

        System.out.println("map: " + map);
        System.out.println("list: " + list);

        list.set(index, lastElement);
        map.put(lastElement, index);
        System.out.println("B1");
        System.out.println("map: " + map);
        System.out.println("list: " + list);

        list.remove(list.size() - 1);
        map.remove(val);
        System.out.println("B2");
        System.out.println("map: " + map);
        System.out.println("list: " + list);
        return true;
    }

    public int getRandom() {
        // Take a random position in the list of elements
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}
