//O notation
//Readme
//time complexity
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int buckets = 100;
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(buckets);
        Random rnd = new Random();
        System.out.println("Testing HashTable");
        System.out.println();
        for (int i = 0; i < 10000; i++) {
            int key = rnd.nextInt(1000000);
            table.put(new MyTestingClass(key), new Student("Name" + i, rnd.nextInt(30) + 18));
        }
        for (int i = 0; i < buckets; i++) {
            System.out.println("Bucket " + i + ": " + table.bucketSize(i) + " elements");
        }

        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println("Testing BST");

        BST<Integer, String> tree = new BST<>();
        tree.put(10, "ten");
        tree.put(5, "five");
        tree.put(15, "fifteen");
        tree.put(3, "three");
        tree.put(7, "seven");

        System.out.println("BST Size: " + tree.size());
        System.out.println("Value for key 7: " + tree.get(7));

        System.out.println("BST In-order Traversal:");
        for (BST.Element<Integer, String> elem : tree) {
            System.out.println("key = " + elem.getKey() + ", value = " + elem.getValue());
        }

        tree.delete(5);
        System.out.println("After deleting key 5, BST Size: " + tree.size());
        System.out.println("In-order after deletion:");
        for (BST.Element<Integer, String> elem : tree) {
            System.out.println("key = " + elem.getKey() + ", value = " + elem.getValue());
        }
    }
}