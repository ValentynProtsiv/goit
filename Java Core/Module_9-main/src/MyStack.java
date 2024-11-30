class MyStack <E>{
    private Node<E> head;
    public MyStack(){
        head = null;
    }
    public void push(E element){
        Node<E> node = new Node<>(element);
        node.next = head;
        head = node;
    }
    public void remove(int index){
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        Node <E> previous = null;
        Node <E> current = head;
        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }
        E value = current.item;
        if (previous == null){
            head = current.next;
        }else
            previous.next = current.next;
        current.next = null;
    }
    public void clear(){
        head = null;
    }
    public int size(){
        int size = 0;
        Node<E> node = head;
        while (node != null){
            size++;
            node = node.next;
        }
        return size;
    }
    public E peek(){
        if (head == null){
            throw new RuntimeException();
        }
        return head.item;
    }
    public E pop(){
        if (head == null){
            throw new RuntimeException();
        }
        E item = head.item;
        head = head.next;
        return item;
    }
    private static class Node<E>{
        private E item;
        private Node<E> next;
        public Node(E element){
            this.item = element;
        }
    }
}
class TestMyStack{
    public static void main(String[] args) {
        MyStack<String> stringMyStack = new MyStack<>();
        stringMyStack.push("Zero");
        stringMyStack.push("One");
        stringMyStack.push("Two");
        stringMyStack.push("Three");
        stringMyStack.push("Four");

        stringMyStack.remove(3);              // "Three"
        System.out.println(stringMyStack.size() );  // 4
        System.out.println(stringMyStack.peek());   // "Four"
        System.out.println(stringMyStack.pop());    // "Four"
        System.out.println(stringMyStack.peek());   // "Three"
        stringMyStack.clear();
        System.out.println(stringMyStack.size());
    }
}
