import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.Element<K, V>> {
    private Node root;
    private int size;

    public static class Element<K, V> {
        private final K key;
        private final V value;
        public Element(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }

    private class Node {
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public int size() {
        return size;
    }

    public void put(K key, V val) {
        if (root == null) {
            root = new Node(key, val);
            size++;
            return;
        }
        Node current = root;
        Node parent = null;
        int cmp = 0;
        while (current != null) {
            parent = current;
            cmp = key.compareTo(current.key);
            if (cmp < 0) current = current.left;
            else if (cmp > 0) current = current.right;
            else {
                current.val = val;
                return;
            }
        }
        Node newNode = new Node(key, val);
        if (cmp < 0) parent.left = newNode;
        else parent.right = newNode;
        size++;
    }

    public V get(K key) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) current = current.left;
            else if (cmp > 0) current = current.right;
            else return current.val;
        }
        return null;
    }

    public void delete(K key) {
        Node current = root;
        Node parent = null;
        while (current != null && !current.key.equals(key)) {
            parent = current;
            if (key.compareTo(current.key) < 0) current = current.left;
            else current = current.right;
        }
        if (current == null) return;
        if (current.left != null && current.right != null) {
            Node successor = current.right;
            Node successorParent = current;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            current.key = successor.key;
            current.val = successor.val;
            parent = successorParent;
            current = successor;
        }
        Node child = (current.left != null) ? current.left : current.right;
        if (parent == null) root = child;
        else if (parent.left == current) parent.left = child;
        else parent.right = child;
        size--;
    }

    @Override
    public Iterator<Element<K, V>> iterator() {
        List<Element<K, V>> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(new Element<>(current.key, current.val));
            current = current.right;
        }
        return list.iterator();
    }
}
