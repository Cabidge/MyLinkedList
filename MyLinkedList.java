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

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + "is out of bounds, use an index from 0-" + size() + " non-inclusive");
        }

        Node current = start;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    public void add(int index, String value) {
        if (index == size) {
            add(value);
            return;
        }

        size++;
        Node node = new Node(value);
        if (index == 0) {
            start.setPrev(node);
            node.setNext(start);

            start = node;
            return;
        }

        Node current = getNode(index);
        Node behind = current.getPrev();
        behind.setNext(node);
        current.setPrev(node);
        node.setNext(current);
        node.setPrev(behind);
    }
    
    public String get(int index) {
        return getNode(index).getData();
    }

    public String set(int index, String value) {
        Node current = getNode(index);
        String s = current.getData();
        current.setData(value);
        return s;
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        }
        String s = "[";
        Node current = start;
        s += current.getData();
        while (current.getNext() != null) {
            current = current.getNext();
            s += ", " + current.getData();
        }
        s += "]";
        return s;
    }

    public String toStringRev() {
        return null;
    }
}