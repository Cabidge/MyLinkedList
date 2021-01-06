import javax.xml.crypto.Data;

public class Node {
    private String data;
    private Node next, prev;

    public Node(String value) {
        data = value;
    }

    public void setData(String value) {
        data = value;
    }

    public String getData() {
        return data;
    }

    public void setNext(Node node) {
        next = node;
    }

    public Node getNext() {
        return next;
    }

    public void setPrev(Node node) {
        prev = node;
    }

    public Node getPrev() {
        return prev;
    }
}