class MyQueue<E> {
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    private int head;
    private E[] queue;
    private int size;
    public MyQueue() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public MyQueue(int initialCapacity) {
        queue = (E[]) new Object[initialCapacity];
    }

    public void add(E e) {
        if (size == queue.length) {
            E[] newData = (E[]) new Object[queue.length * 2];
            System.arraycopy(queue, 0, newData, 0, size);
            queue = newData;
        }

        queue[size++] = e;
    }
    public void clear() {
        final Object[] es = queue;
        for (int i = 0, n = size; i < n; i++)
            es[i] = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public E peek() {
        return queue[head];
    }
    public E poll() {
        if (size == 0) {
            return null;
        }
        E value = queue[head];
        queue[head] = null;
        head = (head + 1) % queue.length;
        size--;
        return value;
    }
}
class TestQueue{
    public static void main(String[] args) {
        MyQueue<String> stringMyQueue = new MyQueue<>();

        stringMyQueue.add("Zero");
        stringMyQueue.add("One");
        stringMyQueue.add("Two");
        stringMyQueue.add("Three");

        System.out.println(stringMyQueue.size());
        System.out.println(stringMyQueue.peek());
        System.out.println(stringMyQueue.poll());
        System.out.println(stringMyQueue.size());

        stringMyQueue.clear();
    }

}