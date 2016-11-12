public class CircularLinkedList extends AbstractLinkedList implements CircularCollectible {

    public CircularLinkedList() {
        super();
    }

    public CircularLinkedList(String[] elements) {
        super(elements);
    }


    public boolean isEmpty() {
        if (first.equals(null) && n == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return n;
    }

    public void add(String s) {
        Node newFirst = new Node(first, s);
        first = newFirst;
        n++;
    }

    public String first() {
        return first.value;
    }

    /** remove(String s):
     *  removes the first element in the list for which
     *      element.equals(s)
     *  is true.
     */
    public void remove(String s) {
        boolean remove = false;
        Node current = first;
        for (int i = 0; i < n && !remove; i++) {
            if (current.next.value == s) {
                current.next = current.next.next;
                n--;
                remove = true;
            }
            current = current.next;
        }
    }

    /** removeAll(String s):
     *  removes all elements in the list for which
     *      element.equals(s)
     *  is true.
     */
    public void removeAll(String s) {
        Node current = first;
        for (int i = 0; i < n; i++) {
            if (current.next.value == s) {
                current.next = current.next.next;
                n--;
            }
            current = current.next;
        }
    }

    public CircularIterator iterator() {
        return new CircularLinkedListIterator();
    }

    class CircularLinkedListIterator implements CircularIterator {
        Node current;

        public CircularLinkedListIterator() {
            current = first;
        }

        public boolean hasNext() {
            return n == 0;
        }

        public String next() {
            current = current.next;
            return current.value;
        }

        /** remove():
         *  removes the last/previous element in the list
         *  (i.e. removes the element that was returned by the
         *  most recent call to next())
         */
        public void remove() {
            current.value = current.next.value;
            current.next = current.next.next;
            if (first.value == current.value) {
                first = current;
            }
            n--;
        }

        /** removeKth(int k):
         *  iterates through the next k elements and removes
         *  the kth one. The next call to removeKth would
         *  start at the node after the removed node.
         *  (i.e. kthNode.next)
         */
        public String removeKthElement(int k) {
            for (int i = 1; i < k; i++) {
                next();
            }
            String kElement = current.value;
            remove();
            return kElement;
        }

        public boolean oneElementLeft() {
            return n == 1;
        }
    }
}

