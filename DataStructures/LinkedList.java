public class LinkedList {

    private int size;
    private final ListNode head;

    public LinkedList() {
        head = new ListNode(null);
    }

    public void add(int value) {
        if (head.next == null) {
            head.next = new ListNode(value);
        } else {
            ListNode currentNode = head.next;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = new ListNode(value);
        }
        size++;
    }

    public void remove(int value) {
        if (head.next != null) {
            ListNode currentNode = head.next;
            ListNode beforeNode = head;
            while (currentNode.value != value) {
                beforeNode = beforeNode.next;
                currentNode = currentNode.next;
            }
            beforeNode.next = currentNode.next;
            size--;
        }
    }

    public void traverse() {
        if (head.next != null) {
            traverse(head.next);
        }
    }

    public void traverse(ListNode node) {
        if (node != null) {
            System.out.println(node.value);
            traverse(node.next);
        }
    }

    public int size() {
        return size;
    }

}
