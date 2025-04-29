//O notation
//Readme
//time complexity
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int buckets = 100;
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(buckets);
        Random rnd = new Random();
        for (int i = 0; i < 10000; i++) {
            int key = rnd.nextInt(1000000);
            table.put(new MyTestingClass(key), new Student("Name" + i, rnd.nextInt(30) + 18));
        }
        for (int i = 0; i < buckets; i++) {
            System.out.println("Bucket " + i + ": " + table.bucketSize(i) + " elements");
        }
    }
}