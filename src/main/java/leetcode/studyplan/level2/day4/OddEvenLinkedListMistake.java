package leetcode.studyplan.level2.day4;

import leetcode.studyplan.level2.datastructure.ListNode;

public class OddEvenLinkedListMistake {

    public ListNode oddEvenList(ListNode head) {
        var isOddHead = isOdd(head.val);
        ListNode secondHead = null;
        ListNode secondTail = null;

        var currentNode = head;

        while(currentNode.next != null) {
            var nextNode = currentNode.next;
            if (isOddHead != isOdd(nextNode.val)) {
                var separatedNode = separateNode(currentNode);

                if (secondHead == null) secondHead = separatedNode;
                else secondTail.next = separatedNode;

                secondTail = getTailNode(separatedNode);
            }

            if (currentNode.next == null) {
                break;
            }

            currentNode = currentNode.next;
        }

        currentNode.next = secondHead;

        return head;
    }

    private ListNode getTailNode(ListNode head) {
        var currentNode = head;
        while (currentNode.next != null) currentNode = currentNode.next;
        return currentNode;
    }

    private ListNode separateNode(ListNode prev) {
        var target = prev.next;
        var isOddTarget = isOdd(target.val);
        var nextNode = target;

        while (nextNode.next != null && isOdd(nextNode.next.val) == isOddTarget) {
            nextNode = nextNode.next;
        }

        prev.next = nextNode.next;
        nextNode.next = null;

        return target;
    }

    private boolean isOdd(int value) {
        return value % 2 == 0;
    }
}
