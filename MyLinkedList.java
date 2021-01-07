public class MyLinkedList {
    private int size = 0;
    private Node start, end;

    public MyLinkedList() { } // no need to do anything

    public int size() {
        return size;
    }

    public boolean add(String value) {
        Node node = new Node(value);
        if (size == 0) {
            start = node;
        } else {
            end.setNext(node);
            node.setPrev(end);
        }
        end = node;

        size++;

        return true;
    }

    public void add(int index, String value) {
        
    }
    
    public String get(int index) {
        return null;
    }

    public String set(int index, String value) {
        return null;
    }

    public String toString() {
        return null;
    }
}