import java.util.ArrayList;

public class Node<K extends Comparable<K>, V> {
    private K key;
    private V value;
    private Node<K, V> left, right;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public boolean equals(Node<K, V> other) {
        if (other == null) return false;
        boolean left, right;
        if (this.left == null) {
            left = other.left == null;
        }
        else {
            left = this.left.equals(other.left);
        }
        if (this.right == null) {
            right = other.right == null;
        }
        else {
            right = this.right.equals(other.right);
        }
        return left && right && this.key.equals(other.key) && this.value.equals(other.value);
    }
    // helper function, finds existing leaf
    public Node<K, V> findLeaf() {
        if(this.getLeft() == null || this.getRight() == null) {
            return this;
        }
        return this.getLeft().findLeaf();
    }
    // implemented because it caused errors
    public K min() {
        return this.findLeaf().getKey();
    }
        
    public K getKey() {
        return key;
    }
    // helper function, sets key of node
    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<K, V> getLeft() {
        return left;
    }

    public ArrayList<V> flatten() {
        // array list to store node values
        ArrayList<V> vals = new ArrayList<V>();
        // adds parent root
        vals.add(this.getValue());
        // gets left and right roots
        Node<K, V> l = this.getLeft();
        Node<K, V> r = this.getRight();
        // if left node exists, adds to vals and recurses
        if(l != null) {
            vals.addAll(l.flatten());
        }
        // if the right node exists, adds to vals and recurses
        if(r != null) {
            vals.addAll(r.flatten());
        }
        // returns ArrayList vals
        return vals;
    }
    
    public boolean containsSubtree(Node<K, V> other) {
        // initial node which compares to the key from other
        Node<K, V> init = this.findNode(other.getKey());
        // checks for differences/existence between, if not matching returns false
        if(init == null || init.getKey() != other.getKey() || init.getValue() != other.getValue()) {
            return false;
        }
        // nodes and checks for left and right roots of other node
        Node<K, V> l_o = other.getLeft();
        Node<K, V> r_o = other.getRight();
        if(l_o != null && (this.getLeft () == null || !this.containsSubtree(l_o))) {
            return false;
        }
        if(r_o != null && (this.getRight() == null || !this.containsSubtree(r_o))) {
            return false;
        }
        // if passes all checks returns true
        return true;
    }

    public void setLeft(Node<K, V> left) {
        this.left = left;
    }

    public Node<K, V> getRight() {
        return right;
    }

    public void setRight(Node<K, V> right) {
        this.right = right;
    }
    
    // helper function to find Node at a key
    public Node<K, V> findNode(K key) {
        // if the key matches node, returns node.
        if(this.key == key) {
            return this;
        }
        // checks left root of node
        Node<K, V> check = this.getLeft();
        // if left root exists, recurses from check node
        if(check != null) {
            Node<K, V> f = check.findNode(key);
            // when found, returns node
            if(f != null) {
                return f;
            }
        }
        // updates to check right root of node
        check = this.getRight();
        // if right root exists, recurses from check node
        if(check != null) {
            Node<K, V> f = check.findNode(key);
            // when found, returns node
            if(f != null) {
                return f;
            }
        }
        // if no key for node, return null
        return null;
    }
    public V find(K key) {
        // temp node utilizing findNode helper function
        Node<K, V> tmp = this.findNode(key);
        // returns null if key does not exist, else returns value
        return tmp == null ? null : tmp.getValue();
    }
    public void remove(K key, Node<K, V> parent) {
        // key == this.key
        if (key.equals(this.key)) {
            if (this.left != null && this.right != null) {
                K min = this.right.min();
                this.value = this.find(min);
                this.key = min;
                this.right.remove(min, this);
            }
            else if (parent.left == this) {
                parent.left = (left != null) ? left : right;
            }
            else if (parent.right == this) {
                parent.right = (left != null) ? left : right;
            }
        }
        // key < this.key
        else if (key.compareTo(this.key) < 0 && this.left != null) {
            this.left.remove(key, this);
        }
        // key > this.key
        else if (key.compareTo(this.key) > 0 && this.right != null) {
            this.right.remove(key, this);
        }
    }
}
