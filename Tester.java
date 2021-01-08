public class Tester {
    public static void main(String[] ababa) {
        Tester.printSection("A - Node object");
        try {
            Node node1 = new Node("ABC");
            Tester.printAssert(node1.getData().equals("ABC"), 'A', "Node getData()");

            node1.setData("abcD");
            Tester.printAssert(node1.getData().equals("abcD"), 'A', "Node setData()");

            Node node0 = new Node("prev");
            Node node2 = new Node("next");

            node1.setPrev(node0);
            node1.setNext(node2);
            Tester.printAssert(node1.getPrev().getData().equals("prev"), 'A', "Node prev");
            Tester.printAssert(node1.getNext().getData().equals("next"), 'A', "Node next");
        } catch (RuntimeException e) {
            System.out.println("An exception ocurred!");
            Tester.printBad('A');
        }

        Tester.printSection("B - LinkedList constructor, add(value), and size()");
        try {
            MyLinkedList list = new MyLinkedList();
            Tester.printAssert(list.size() == 0, 'B', "LinkedList size() starts at 0");

            list.add("A");
            list.add("B");
            Tester.printAssert(list.size() == 2, 'B', "LinkedList add(value) increases the size()");
        } catch (RuntimeException e) {
            System.out.println("An exception ocurred!");
            Tester.printBad('B');
        }

        Tester.printSection("C - LinkedList add(index, value) and get(index)");
        try {
            MyLinkedList list = new MyLinkedList();
            list.add("x");
            list.add("y");
            list.add("z");
            Tester.printAssert("y".equals(list.get(1)), 'C', "LinkedList get(index)");

            for (int i = 0; i < 5; i++) {
                list.add(0, "front");
            }
            Tester.printAssert(list.size() == 8, 'C', "LinkedList add(index, value) increases the size()");
            Tester.printAssert("front".equals(list.get(0)), 'C',
                    "LinkedList add(index, value) appends to front correctly");
            Tester.printAssert("x".equals(list.get(5)), 'C', "LinkedList add(index, value) appends to front correctly");

            list.add(4, "middle");
            Tester.printAssert("middle".equals(list.get(4)), 'C',
                    "LinkedList add(index, value) inserts in the middle correctly");

            list.add(list.size(), "end");
            Tester.printAssert("end".equals(list.get(list.size() - 1)), 'C',
                    "LinkedList add(index, value) appends to end correctly");

            try {
                list.get(-2);
                System.out.println("Error: No exception thrown!");
                Tester.printBad('C');
            } catch (IndexOutOfBoundsException e) {
                Tester.printGood("get() IOOBException caught!");
            }

            try {
                list.get(10);
                System.out.println("Error: No exception thrown!");
                Tester.printBad('C');
            } catch (IndexOutOfBoundsException e) {
                Tester.printGood("get() IOOBException caught!");
            }
        } catch (RuntimeException e) {
            System.out.println("An exception ocurred!");
            Tester.printBad('C');
        }

        Tester.printSection("D - LinkedList set(index, value)");
        try {
            MyLinkedList list = new MyLinkedList();
            for (int i = 0; i < 100; i++) {
                list.add(Integer.toString(i));
            }

            String x = list.set(7, "Yay");
            Tester.printAssert(list.size() == 100, 'D', "LinkedList set(index, value) doesn't change size");
            Tester.printAssert("7".equals(x), 'D', "LinkedList set(index, value) returns value");
            Tester.printAssert("Yay".equals(list.get(7)), 'D', "LinkedList set(index, value) sets value");

            try {
                list.set(-2, null);
                System.out.println("Error: No exception thrown!");
                Tester.printBad('D');
            } catch (IndexOutOfBoundsException e) {
                Tester.printGood("set() IOOBException caught!");
            }

            try {
                list.set(108, null);
                System.out.println("Error: No exception thrown!");
                Tester.printBad('D');
            } catch (IndexOutOfBoundsException e) {
                Tester.printGood("set() IOOBException caught!");
            }
        } catch (RuntimeException e) {
            System.out.println("An exception ocurred!");
            Tester.printBad('D');
        }

        Tester.printSection("E - LinkedList toString()");
        try {
            MyLinkedList list = new MyLinkedList();
            list.add("a");
            list.add("b");
            list.add("c");

            String s = list.toString();
            String rev = list.toStringReversed();
            Tester.printAssert("[a, b, c]".equals(s), 'E', "LinkedList toString() works correctly");
            Tester.printAssert("[c, b, a]".equals(rev), 'E', "LinkedList toString() reversed works correctly");
        } catch (RuntimeException e) {
            System.out.println("An exception ocurred!");
            Tester.printBad('E');
        }
    }

    public static void printAssert(boolean assertion, char section, String comment) {
        if (assertion) {
            printGood(comment);
        } else {
            printBad(section);
        }
    }

    public static void printGood(String comment) {
        System.out.println("✔ " + comment);
    }

    public static void printBad(char section) {
        System.out.println("✘ Whoops! Something went wrong in section " + section);
    }

    public static void printSection(String section) {
        System.out.println("\nSection " + section + ":");
    }
}