class MyArrayList<E> {
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private E[] arr;
    private int size;

    public MyArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }
    public MyArrayList(int capacity) {
        arr = (E[]) new Object[capacity];
    }
    public void add(E value) {
        if (size == arr.length) {
            E[] newData = (E[]) new Object[arr.length * 2];
            System.arraycopy(arr, 0, newData, 0, size);
            arr = newData;
        }

        arr[size++] = value;
    }
    public <E> void remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        for (int i = index + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        size--;
    }
    public void clear() {
        size = 0;
    }

    public int size() {
        return size;
    }
    public E get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }
}

class MyArrayListTest{
    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();

        myArrayList.add("Hello");
        myArrayList.add("World");
        myArrayList.add("!");

        myArrayList.remove(2);
        System.out.println( myArrayList.get(0));
        myArrayList.clear();

        System.out.println(myArrayList.size());

    }
}
