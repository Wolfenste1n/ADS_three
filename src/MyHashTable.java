public class MyHashTable<K, V> {
    private static class HashNode<K, V> {
        public K key;
        public V value;
        public HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + '}';
        }
    };

    private HashNode<K, V>[] chainArray;
    private int M;
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % M;
    }

    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K,V> node = chainArray[index];
        while(node!=null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        node = chainArray[index];
        HashNode<K,V> newNode = new HashNode(key, value);
        newNode.next = node;
        chainArray[index] = newNode;
        size++;
    }



    public V get(K key){
        int index = hash(key);
        HashNode<K,V> node = chainArray[index];
        while(node!=null){
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        HashNode<K, V> prev = null;
        while (node != null && !node.key.equals(key)) {
            prev = node;
            node = node.next;
        }
        if (node == null) return null;
        if (prev == null) chainArray[index] = node.next;
        else prev.next = node.next;
        size--;
        return node.value;
    }

    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                if (node.value.equals(value)) return true;
                node = node.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                if (node.value.equals(value)) return node.key;
                node = node.next;
            }
        }
        return null;
    }
    public int size(){
        return size;
    }
    public int bucketSize(int index){
        int count=0;
        HashNode<K,V> node = chainArray[index];
        while(node!=null){
            count++;
            node = node.next;
        }
        return count;
    }

}
