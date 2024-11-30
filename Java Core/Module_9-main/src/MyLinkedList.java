class MyLinkedList<E>{
     private int size = 0;

    private Node<E> first;

    private Node<E> last;
    public MyLinkedList() {
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }


    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
    private E unlink(Node<E> x) {
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    public void add(E e) {
        linkLast(e);
    }
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }
}
class Test{
    public static void main(String[] args) {

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.add("Hello");
        myLinkedList.add("Hi");
        myLinkedList.add("Привіт");

        myLinkedList.remove(1); //remove "Hi"

        System.out.println(myLinkedList.size());

        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));

        myLinkedList.clear();
    }
}
