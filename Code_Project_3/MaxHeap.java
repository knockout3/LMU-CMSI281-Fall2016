import java.util.*;

public class MaxHeap {
    private int[] Heap;
    private int size;
    private int maxsize;
 
    private static final int FRONT = 1;
 
    public MaxHeap(int num) {
        this.maxsize = num;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }
 
    private int parent(int val) {
        return val / 2;
    }
 
    private int leftChild(int val) {
        return (2 * val);
    }
 
    private int rightChild(int val) {
        return (2 * val) + 1;
    }
 
    private boolean isLeaf(int val) {
        if (val >=  (size / 2)  &&  val <= size)
        {
            return true;
        }
        return false;
    }
 
    private void swap(int first,int second) {
        int temp;
        temp = Heap[first];
        Heap[first] = Heap[second];
        Heap[second] = temp;
    }
 
    private void maxHeapify(int val) {
        if (!isLeaf(val))
        { 
            if ( Heap[val] < Heap[leftChild(val)]  || Heap[val] < Heap[rightChild(val)])
            {
                if (Heap[leftChild(val)] > Heap[rightChild(val)])
                {
                    swap(val, leftChild(val));
                    maxHeapify(leftChild(val));
                }else
                {
                    swap(val, rightChild(val));
                    maxHeapify(rightChild(val));
                }
            }
        }
    }
 
    public void insert(int element) {
        Heap[++size] = element;
        int current = size;
 
        while(Heap[current] > Heap[parent(current)])
        {
            swap(current,parent(current));
            current = parent(current);
        }   
    }
 
    public void print() {
        for (int i = 1; i <= size / 2; i++ )
        {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2*i]
                  + " RIGHT CHILD :" + Heap[2 * i  + 1]);
            System.out.println();
        }
    }   

    public void maxHeap() {
        for (int pos = (size / 2); pos >= 1; pos--)
        {
            maxHeapify(pos);
        }
    }
 
    public int remove() {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--]; 
        maxHeapify(FRONT);
        return popped;
    }
 
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Max Heap Test\n");
        System.out.println("Enter size of Heap: ");
        int maxSize = scan.nextInt() + 1;
        MaxHeap mh = new MaxHeap(maxSize + 1);
        int size = 0;

        char ch;
        do {
            System.out.println("\nMax Heap Operations");
            System.out.println("1. insert");
            System.out.println("2. remove\n");

            int choice = scan.nextInt();

            switch (choice) {
                case 1: 
                    try {
                        System.out.println("\nEnter integer element to insert: ");
                        mh.insert(scan.nextInt());
                        size++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2: 
                    try {
                        System.out.println("\nElement removed: " + mh.remove());
                        size--;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
            mh.maxHeap();
            mh.print();

            System.out.println("\nSize of Heap: " + size);
            System.out.println("\nDo you want to continue (Type y or n): ");
            ch = scan.next().charAt(0);                        
        } while ((ch == 'Y'|| ch == 'y') && (size + 1 < maxSize)); 

        System.out.println("\nThe Max Heap is: ");
        mh.print();
    }
}
