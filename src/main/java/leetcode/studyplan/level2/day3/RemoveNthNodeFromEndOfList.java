package leetcode.studyplan.level2.day3;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int targetIndex = getTargetIndex(head, n);

        var removedNode = removeNth(head, targetIndex);

        return getHeadNode(head, removedNode);
    }

    private ListNode getHeadNode(ListNode head, ListNode removedNode) {
        return removedNode != head ? head : head.next;
    }

    private int getTargetIndex(ListNode head, int n) {
        var size = 0;
        var currentNode = head;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }

        return size - n;
    }

    private ListNode removeNth(ListNode head, int n) {
        if (n == 0) return head;

        var preNode = head;
        for (int i = 1; i < n; i++) {
            preNode = preNode.next;
        }

        return removeByPrevNode(preNode);
    }

    private ListNode removeByPrevNode(ListNode prevNode) {
        var removeNode = prevNode.next;
        prevNode.next = removeNode != null ? removeNode.next : null;

        return removeNode;
    }

    public static void main(String[] args) {
        var head = new ListNode(1);
//        var cur = head;
//        for (int i = 2; i <= 5; i++) {
//            cur.next = new ListNode(i);
//            cur = cur.next;
//        }

        var newHead = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 1);
        var isNotFirst = false;

        System.out.print("[");
        while(newHead != null) {
            if (isNotFirst) {
                System.out.print(", ");
            }
            System.out.print(newHead.val);
            newHead = newHead.next;
            isNotFirst = true;
        }
        System.out.println("]");
    }
}
