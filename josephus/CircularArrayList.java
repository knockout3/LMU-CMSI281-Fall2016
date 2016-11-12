public class CircularArrayList extends AbstractArrayList implements CircularCollectible {

    public CircularArrayList() {
        super();
    }

    public CircularArrayList(String[] elements) {
        super(elements);
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(String s) {
        if (size < arraySize) {
            elements[size] = s;
            size++;
        } else {
            arraySize = arraySize * 2;
            String[] doubleElements = new String[arraySize];

            for (int i = 0; i < size; i++) {
                doubleElements[i] = elements[i];
            }

            elements = doubleElements;
            elements[size] = s;
            size++;
        }
    }
    
    public String first() {
        int i;
        for (i = 0; elements[i] == null || i < size; i++);
        return elements[i];
    }

    /** remove(String s):
     *  removes the first element in the list for which
     *      element.equals(s)
     *  is true.
     */
    public void remove(String s) {
        boolean remove = false;
        for (int i = 0; i < size && !remove; i++) {
            if (elements[i] == s) {
                remove = true;
                elements[i] = null;
            }
        }
    }

    /** removeAll(String s):
     *  removes all elements in the list for which
     *      element.equals(s)
     *  is true.
     */
    public void removeAll(String s) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == s) {
                elements[i] = null;
            }
        }
    }

    public CircularIterator iterator() {
        return new CircularArrayListIterator();
    }

    class CircularArrayListIterator implements CircularIterator {
        int index;

        public CircularArrayListIterator() {
            index = 0;
        }
        
        public boolean hasNext() {
            return size == 0;
        }

        public String next() {
            while (elements[index] == null) {
                index++;
                if (index >= arraySize) {
                    index -= arraySize;
                }
            }
            return elements[index];
        }

        /** remove():
         *  removes the last/previous element in the list
         *  (i.e. removes the element that was returned by the
         *  most recent call to next())
         */
        public void remove() {
            elements[index] = null;
            size--;
            next();
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
            String kElement = elements[index];
            remove();
            return kElement;
        }

        public boolean oneElementLeft() {
            return size == 1;
        }
    }

}
