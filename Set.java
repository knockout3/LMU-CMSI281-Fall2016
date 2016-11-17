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

    public void add(String item) {
        boolean distinct = true;
        for (Obliterator i = iterator(); i.hasNext(); ) {
            Node current = i.next();
            if (current.item.equals(item)) {
                distinct = false;
                current.count++;
                break;
            }
        }
        if (distinct) {
            Node oldfirst = first;
            first = new Node(oldfirst, item, 1);
            n++;
        }
        total++;
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
