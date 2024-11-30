class MyHashMap <K, V>{
    private Node<K,V>[] table;
    private int capacity = 4;
    private int size = 0;
    public MyHashMap(){
        table = new Node[capacity];
    }
    private static class Node<K, V>{
        K key;
        V value;
        Node<K, V> next;
        public Node(K key, V value, Node<K, V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    public void put(K key, V value){
        if (key == null)
            return;

        int hash = hash(key);
        Node<K, V> newNode = new Node<K, V>(key, value, null);

        if (table[hash] == null){
            table[hash] = newNode;
        }else {
            Node<K, V> previous = null;
            Node<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(newNode)) {
                    if (previous == null) {
                        newNode.next = current.next;
                        table[hash] = newNode;
                        return;
                    } else {
                        newNode.next = current.next;
                        previous.next = newNode;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newNode;
        }
        size++;
    }
    public boolean remove(K key){
        size--;
        int hash = hash(key);
        if (table[hash] == null){
            return false;
        }else {
            Node<K, V> previous = null;
            Node<K, V> current = table[hash];

            while (current != null){
                if (current.key.equals(key)){
                    if (previous == null){
                        table[hash] = table[hash].next;
                        return true;
                    }else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }
    }
    public void clear(){
        Node<K, V>[] tab;
        if ((tab = table) != null && size > 0){
            size = 0;
            for (int i = 0; i < tab.length; i++)
                tab[i] = null;
        }
    }
    public int size(){
        return size;
    }
    public V get(K key){
        int hash = hash(key);
        if(table[hash] == null){
            return null;
        }else {
            Node<K, V> temp = table[hash];
            while (temp != null){
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next;
            }
            return null;
        }
    }
    private int hash(K key){
        return Math.abs(key.hashCode()) % capacity;
    }
}
class TestMyHasMa{
    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();

        myHashMap.put(1, "Roman");
        myHashMap.put(2, "Vasya");
        myHashMap.put(3, "Valentyn");
        myHashMap.put(4, "Denys");
        myHashMap.put(5, "Misha");
        myHashMap.put(6, "Max");
        myHashMap.put(7, "Ostap");

        System.out.println(myHashMap.get(3));
        System.out.println(myHashMap.size());
        myHashMap.remove(3);
        System.out.println(myHashMap.get(4));
        myHashMap.clear();
        System.out.println(myHashMap.size());


    }
}
