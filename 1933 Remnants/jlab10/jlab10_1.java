import java.util.ArrayDeque;
import java.util.Stack;

public class jlab10_1 {

    // Section 1.1: Binary Searching
    public boolean BinarySearch(T x, T[] arr, int low, int high) {
        if(high < low){
            return false;
        }
        int mid = low + (high - low) / 2;
        if(arr[mid] == x) {
            return true;
        }
        if(arr[mid] > x) {
            return BinarySearch(x, low, mid - 1, arr);
        }
        return program(x, mid+1, high, arr);
    }
    // The scope of search reduces by a factor of 1/2 each time it recurses

    // Section 1.2: Intersection
    public void intersect(AList<T> other) {
        for(int i = arr.length() - 1; i >= 0; i--) {
            boolean target = true;
            for(int j = 0; j < other.length(); j++) {
                if(arr.get(i) == other.get(j)) {
                    target = false;
                    break;
                }
            }
            if(target == true) {
                arr.pop(i);
            }
        }
    }
    
    // Section 2.1: Removal
    public void removeEvery(int n) {
        int i = 0;
        for(T el : this.list) {
            if(i % n == n - 1) {
                this.list.remove(el);
            }
            i++;
        }
    }
    // Section 2.2: Extraction
    public LinkedList<LinkedList<T>> extractGroupsOf(int n) {
        LinkedList<LinkedList<T>> cool = new LinkedList<LinkedList<T>>();
        LinkedList<T> beans = new LinkedList<T>();
        if(n == 0) {
            return beans;
        }
        int i = 0;
        for(LinkedList<T> th : this.list) {
            beans.add(th);
            if(i % n == n - 1) {
                cool.add(beans);
                beans = new LinkedList<T>();
            }
            i++;
        }
    }

}
// 3.1 Stacks and Stuff
public class StackedQueue<T> {
    Stack<T> b = new Stack<T>();
    public void enqueue(T element) {
        b.add(element);
    }
    public void dequeue1() {
        b.pop();
    }
    public void peek() {
        this.b.peek();
    }
    public boolean isEmpty() {
        if(this.b.empty() == true) {
            return true;
        return false;
        }
    }
// 3.2 A Biased Queue
    Stack<String> p = new Stack<String>();
    public void enqueue(String person) {
        String n = p.peek();
        if(person.equals("Budger")) {
            p.remove(p.size() - 1);
            p.push(person);
            p.push(n);
        }
        p.push(person);
    }
    public String dequeue() {
        p.remove(0);
    }
}

// 5.1 Sorting Basics
//
// Selection Sort: Best / Worst Case - O(N^2)
// Merge Sort: Best / Worst Case - O(N * logN)
// Quick Sort Best: O(N log N), Worst: O(N^2)
//
//5.2 Time Complexity
//
// 1.) N^2
// 2.) N/2*log2(N)
// 3.) log2(N)
//
//5.4 Array List vs LinkedList
//
// ArrayList -> when you need to index unknown amount of things
// LinkedList -> when you need to iterate over unknown amount of things

























}