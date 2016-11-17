public class Set {

    class Node {
        Node next;
        String value;

        public Node(Node next, String value) {
            this.next = next;
            this.value = value;
        }
    }

    Node first;
    int n;

    public Set() {
        first = null;
        n = 0;
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

    public String removeFirst() {
        String temp = first.value;
        first = first.next;
        n--;
        return temp;
    }

    public void removeOne(String s) {
        Node current = first;
        Node prev = null;
        if (first.value.equals(s)) {
            first = first.next;
            n--;
            return;
        }
        while (current != null) {
            if (current.value.equals(s)) {
                prev.next = current.next;
                n--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}
