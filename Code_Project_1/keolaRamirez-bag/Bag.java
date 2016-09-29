import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Bag implements Collectible {
    private Node first;
    private int n; // number of nodes
    private int total; // total number of words in this bag

    public Bag() {
        first = null;
        n = 0;
        total = 0;
    }

    public boolean isEmpty() {
        boolean bool = true;
        if (first == null) {
            return bool;
        } else {
            bool = false;
            return bool;
        } 
    }

    public int size() {
        return total;
    }

    public boolean isDouble(String word) {
        Node currentNode = first;
        boolean compare = false;
        while (currentNode != null && !compare) {
            if (!(currentNode.item.equals(word))) {
                currentNode = currentNode.next;
            } else {
                compare = true;
            }
        }
        if (currentNode == null) {
            return false;
        } else {
            currentNode.count++;
            return compare;
        }
    }

    public void add(String item) {
        if (!isDouble(item)) {
            Node next = new Node(first, item, 1);
            first = next;
            n++;
            total++;
        } else {
            total++; 
        }
    }


    public int uniqueSize() {
        return n;
    }

    public Obliterator iterator() {
        return new BagIterator(first);  
    }

    class BagIterator implements Obliterator {
        private Node current;

        public BagIterator(Node first) {
            current = first;
        }

        public boolean hasNext() { 
            return current != null;  
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Node next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node node = current;
            current = current.next; 
            return node;
        }
    }


    public static void main(String[] args) throws IOException {
        Bag bag = new Bag();
        Scanner s = null;
        try {
            s = new Scanner(System.in);
            while (s.hasNext()) {
                String item = s.next(); // Scanner splits input on whitespace, by default
                bag.add(item);
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }

        // Print bag size and distinct contents
        System.out.format("Total number of words: %d\n", bag.size());
        System.out.format("Unique number of words: %d\n", bag.uniqueSize());

        // Print distinct words in bag and their frequency
        for (Obliterator i = bag.iterator(); i.hasNext(); ) {
            Node node = i.next();
            System.out.format("%s %d\n", node.item, node.count);
        }
    }

}
