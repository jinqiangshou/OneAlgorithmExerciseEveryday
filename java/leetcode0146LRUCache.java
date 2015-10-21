/* ******************************************Question************************************************
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * **************************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-10-21
 * */
public class LRUCache {
    
    private class node{
        int val;
        int key;
        node prev, next;
        public node(int key,int val){
            this.key=key; this.val=val;
        }
    }

    private class list{
        node head, tail;
        int capacity;
        int len;

        public list(int capacity){
            this.capacity = capacity;
        }

        public void removeNode(node n){
            if (len == 1){
                head = null; 
                tail = null;
            } else {
                if (n == head){ head = head.next; }
                if (n == tail){ tail = tail.prev; }
            }
            if (n.prev == null && n.next != null){ // n is head
                n.next.prev = null;
                n.next = null;
            } else if (n.prev != null && n.next == null){ // n is tail
                n.prev.next = null;
                n.prev = null;
            } else if (n.prev != null && n.next != null){ // n is in the middle
                n.prev.next = n.next;
                n.next.prev = n.prev; 
                n.prev = null; 
                n.next = null;
            }
            this.len--;
        }

        public void addNode(node n){
            if (this.len == 0) {
                this.head = n;
            } else {
                this.tail.next = n;
                n.prev = this.tail;
            }
            this.tail = n;
            this.len++;
        }
    }

    HashMap<Integer,node> hm;
    list lst;
    
    public LRUCache(int capacity) {
        this.hm = new HashMap<>();
        this.lst = new list(capacity);
    }
    
    public int get(int key) {
        if (hm.containsKey(key)){
            node temp = hm.get(key);
            this.set(key, temp.val);
            return temp.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (hm.containsKey(key)){
            lst.removeNode(hm.get(key));
            node temp = new node(key, value);
            hm.put(key,temp);
            lst.addNode(temp);
        } else {
            node temp2 = new node(key, value);
            hm.put(key, temp2);
            lst.addNode(temp2);
            if (lst.len > lst.capacity) {
                node lru = lst.head; 
                lst.removeNode(lru);
                hm.remove(lru.key);
            }
        }
    }
}
