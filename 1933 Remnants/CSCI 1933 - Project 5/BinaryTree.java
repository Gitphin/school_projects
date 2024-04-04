import javax.swing.text.AbstractDocument.Content;

public class BinaryTree<K extends Comparable<K>, V> {
    private Node<K, V> root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node<K, V> getRoot() {
        return this.root;
    }

    public void add(K key, V value) {
        // makes new node with key and value
        Node<K, V> newNode = new Node<K, V>(key, value);
        // if parent root is null (empty tree), sets to newNode and returns
        if(this.root == null) {
            this.root.setKey(key);
            this.root.setValue(value);
            return;
        }
        // copies node associated with key
        Node<K, V> t = this.root.findNode(key);
        // if node with key already exists, updates key/value and returns
        if(t != null) {
            t.setKey(key);
            t.setValue(value);
            return;
        }
        // if key does not exist, finds a spot to add key/value and returns
        t = this.root.findLeaf();
        if(t.getLeft() == null) {
            t.setLeft(newNode);
            return;
        }
        if(t.getRight() == null) {
            t.setRight(newNode);
            return;
        }
    }

    public V find(K key) {
        // see Node file for details
        // if does not exist returns null else returns value of node of key
        return this.root == null ? null : this.root.find(key);
    }

    @SuppressWarnings("unchecked")
    public V[] flatten() {
        // see Node file for details
        // if empty tree, returns null
        if(this.root == null) {
            return null;
        }
        // converts arraylist from flatten to array
        return (V[])this.root.flatten().toArray();
    }

    public boolean containsSubtree(BinaryTree<K, V> other) {
        // see Node file for details
        return other != null && this.root.containsSubtree(other.root);
    }

    public void remove(K key) {
        if (this.root != null) {
            if (this.root.getKey().equals(key)) {
                if (this.root.getLeft() == null && this.root.getRight() == null)  {
                    this.root = null;
                } else if (this.root.getLeft() != null && this.root.getRight() == null) {
                    this.root = this.root.getLeft();
                } else if (this.root.getLeft() == null && this.root.getRight() != null) {
                    this.root = this.root.getRight();
                } else {
                    this.root.remove(key, null);
                }
            } else {
                this.root.remove(key, null);
            }
        }
    }
    // main method for testing purposes
    public static void main(String[] args) {
        // testing tree from BinaryTreeTest
        BinaryTree<Integer, String> p1Tree = new BinaryTree<Integer, String>(new Node<Integer, String>(40, "forty",
             new Node<Integer, String>(20, "twenty",
                     new Node<Integer, String>(10, "ten"), new Node<Integer, String>(30, "thirty")),
             new Node<Integer, String>(60, "sixty",
                     new Node<Integer, String>(50, "fifty"), new Node<Integer, String>(70, "seventy"))));
        // for testing purposes of containsSubtree
        Node<Integer, String> n0 = new Node<Integer, String>(0, "a");
        Node<Integer, String> n1 = new Node<Integer, String>(1, "b");
        Node<Integer, String> n2 = new Node<Integer, String>(2, "c");
        Node<Integer, String> n3 = new Node<Integer, String>(3, "d");
        Node<Integer, String> n4 = new Node<Integer, String>(4, "e");
        Node<Integer, String> n5 = new Node<Integer, String>(5, "f");
        Node<Integer, String> n6 = new Node<Integer, String>(6, "g");
        n0.setLeft(n1);
        n0.setRight(n2);
        n1.setLeft(n3);
        n2.setRight(n4);
        n2.setLeft(n5);
        n5.setLeft(n6);

        System.out.println(p1Tree.find(20));
        System.out.println(p1Tree.find(100));
        p1Tree.add(20, "twentyv2");
        p1Tree.add(100, "hundred");
        System.out.println(p1Tree.find(20));
        System.out.println(p1Tree.find(100));
        // prints out values in array from flatten
        for(Object j : p1Tree.flatten()) {
            System.out.print(j + " ");
        }
        System.out.println("\n"+ n0.containsSubtree(n2));
    }
}