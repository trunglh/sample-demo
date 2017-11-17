package info.sample.demo.api.list;

public class LinkedList<T> {

    private LinkNode head;
    private LinkNode tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insert(T data, int index) {

        if (index > size) {
            throw new IllegalArgumentException("The index [" + index + "] is greater than the current size [" + size + "].");
        } else {

            LinkNode temp = new LinkNode(data);
            LinkNode current = getLinkNode(index);

            if (index == 0) {
                temp.setNext(head);
                head = temp;
                tail = head;
            } else {
                temp.setNext(current.getNext());
                current.setNext(temp);
            }

            if (index == size - 1) {
                tail.setNext(temp);
                tail = temp;
            }

        }

        size++;
    }

    public void append(T data) {
        insert(data, size);
    }

    public void remove(int index) {

        LinkNode temp = getLinkNode(index);
        if (index == 0) {
            head = head.getNext();
        } else if (index == size) {
            tail = getPrev(temp);
            tail.setNext(null);
        } else if (index == size - 1) {
            temp = tail;
        } else {
            temp.setNext(temp.getNext().getNext());
        }

        this.size--;
    }

    public void removeTail() {
        remove(size);
    }

    public void removeGt(T target) {
        int targetIdx = getIdx(target);
        int distance = size - targetIdx;

        if (targetIdx == size) {
            System.out.println("The target is the last element in list.");
        } else {
            for (int i = 0; i < distance; i++) {
                remove(targetIdx + 1);
            }
        }

    }

    private LinkNode getLinkNode(int index) {

        if (index > size) {
            throw new IllegalArgumentException("The index [" + index + "] is greater than the current size [" + size + "].");
        }
        LinkNode current = head;
        for (int i = 1; i < index; i++) {
            current = current.getNext();
        }

        return current;
    }

    private int getIdx(T data) {
        if (data != null) {
            for (int idx = 1; idx <= size; idx++) {
                if (getLinkNode(idx).getData().equals(data)) {
                    return idx;
                }
            }
        }
        return 0;
    }

    private LinkedList<T>.LinkNode getPrev(LinkedList<T>.LinkNode current) {
        for (int i = 1; i <= size; i++) {
            if (getLinkNode(i).equals(current) && i > 1) {
                return getLinkNode(i - 1);
            }
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        LinkNode current = head;
        while (current != null) {
            builder.append("[" + current.getData() + "]");
            current = current.getNext();
        }
        return builder.toString();

    }

    private class LinkNode {

        LinkNode next;
        T data;

        public LinkNode(T data) {
            this(data, null);
        }

        public LinkNode(T data, LinkNode next) {
            this.next = next;
            this.data = data;
        }

        public T getData() {
            return this.data;
        }

        public LinkNode getNext() {
            return this.next;
        }

        public void setNext(LinkNode nextNode) {
            this.next = nextNode;
        }

    }
}
