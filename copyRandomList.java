import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
    }
}

class Main {
    // approch 1 using hashMap
    private static HashMap<Node, Node> map = new HashMap<>();

    // {node -> copyNode}
    public static Node copyRandomList1(Node head) {
        // null case
        if (head == null)
            return null;

        // make a clone of the head node
        Node copyHead = clone(head);
        // pointer for travelling further in list
        Node curr = head;
        // current pointer for copy
        Node copyCurr = copyHead;
        // traversing in original list
        while (curr != null) {
            // make a copy of current's next node and set it next to the copyCurr
            copyCurr.next = clone(curr.next);
            // and also make a copy of random and set it to random of the copyCurr
            copyCurr.random = clone(curr.random);
            // go further
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        // return copyHead
        return copyHead;
    }

    // clone the node
    private static Node clone(Node node) {
        if (node == null)
            return null;
        // here we check if new node is already created than we return
        // reference of this node
        if (map.containsKey(node))
            return map.get(node);
        // else we make a new entry in map and return newNode
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }

    // approch 2 without using hashMap
    public static Node copyRandomList(Node head) {
        // null case
        if (head == null)
            return null;
        // add a copy of a node inbetween current nodes
        // first pass make a copy of node and set a next pointer of each node
        Node curr = head;
        while (curr != null) {
            // make a copy of the current Node
            Node newNode = new Node(curr.val);
            // newNode -> curr.next
            newNode.next = curr.next;
            // curr -> newNode
            curr.next = newNode;
            // go two steps further as we added one element extra
            curr = curr.next.next;
        }
        // second pass set the random pointer for each node
        curr = head;
        while (curr != null) {
            // here each node and its copy is next to each other so
            // to set a random pointer curr's next(copy) random pointer points to the
            // curr's random pointer's next
            // also check if random is not null
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        curr = head;
        // copyHead node
        Node copyHead = head.next;
        // copyCurr Node
        Node copyCurr = copyHead;
        // third pass defrangmentation
        while (curr != null) {
            // make current skip every next node
            curr.next = curr.next.next;
            // to handle the last
            if (copyCurr.next != null) {
                // make copyCurr skip every next node
                copyCurr.next = copyCurr.next.next;

            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;

    }

    public static void main(String[] args) {

    }
}