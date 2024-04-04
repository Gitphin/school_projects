import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Collections;
import java.util.Random;

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> first, last;
    private int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean add(T element) {
        // for the sake of lab, let's _not_ allow null data
        if(element == null) return false;

        Node<T> newNode = new Node<>(element);

        if(size == 0)
            first = newNode;
        else
            last.setNext(newNode);

        last = newNode;
        size++;

        return true;
    }

    public String toString() {
        String ret = "[";
        Node<T> ptr = first;
        for(int i = 0; i < size; i++) {
            ret += ptr.getData().toString() + ", ";
            ptr = ptr.getNext();
        }

        return size == 0 ? ret + "]" : ret.substring(0, ret.length() - 2) + "]";
    }

    // TODO implement me!
    private class LinkedListIterator implements Iterator<T> {
        private Node<T> b;
        public LinkedListIterator() {
            this.b = first;
        }
        
        @Override
        public boolean hasNext() {
            return b != null;
        }
        @Override
        public T next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            
            T c = b.getData();
            b = b.getNext();
            return c;
        }
        
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    // TODO implement me!
    public static int[] nCopies(LinkedList<Integer> x){
        int c = 0;
        for(int n : x)
            c += n;
        int[] a = new int[c];
        
        int i = 0;
        for(int o : x) {
            int target = i + o;
            while(i < target) {
                a[i] = o;
                i++;
            }
        }
        return a;
    }

    // TODO implement me!
    public static LinkedList<Integer> countingSort(LinkedList<Integer> lst) {
        int k = Integer.MIN_VALUE;
        for(int t : lst) {
            if(t > k)
                k = t;
        }
        
        int[] counts = new int[k + 1];
        
        for(int n : lst)
            counts[n] = counts[n] + 1;
        
        LinkedList<Integer> ret = new LinkedList<Integer>();
        
        for(int i = 0; i < k + 1; i++) {
            for(int o = 0; o < counts[i]; o++) {
                ret.add(i);
            }
        }
        
        return ret;
     }

    // TODO implement me!
    public void reverse() {
        if(first == null || last == null)
            return;
                
        Node<T> A = first;
        Node<T> B;
        Node<T> C = first.getNext();
        while((B = C) != null) {
            C = B.getNext();
            B.setNext(A);
            A = B;
            B = C;
        }
        Node<T> tmp = first;
        first = last;
        last = tmp;
        last.setNext(null);
    }

    // TODO implement me!
    public void shuffle() {

    }

    public static void main(String[] args) {
        LinkedList<Integer> a1 = new LinkedList<Integer>();
        a1.add(4);
        a1.add(2);
        a1.add(1);
        a1.add(7);
        a1.add(12);
        a1.add(3);
        a1.add(8);
        System.out.println(a1);
        int[] stuff = LinkedList.nCopies(a1);
        
        System.out.print("[");
        for(int q : stuff) {
           System.out.print(q + " ");
        }
        System.out.print("]");
        System.out.println();
        
        Iterator<Integer> b1 = a1.iterator();
        System.out.println(b1.next());
        System.out.println(b1.hasNext());
        System.out.println(b1.next());
        a1.reverse();
        System.out.println(a1);
        System.out.println(LinkedList.countingSort(a1));       
    }
 }

