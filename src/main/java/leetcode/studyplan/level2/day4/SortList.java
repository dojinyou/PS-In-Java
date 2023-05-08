package leetcode.studyplan.level2.day4;

import leetcode.studyplan.level2.datastructure.ListNode;

public class SortList {

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    // T(n) = n + 2T(n/2). (단, n < 2 면 T(N) = O(1))
    // 마스터 정리에 의해 O(nlogn)
    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // get right head O(n/2)
        var rightHead = splitRightNodeListAndGetHead(head);

        // sorted left, right node line O(2 * T(n/2))
        var currentLeftNode = mergeSort(head);
        var currentRightNode = mergeSort(rightHead);

        // setup new node line O(1)
        var newHead = getMaxNode(currentLeftNode, currentRightNode);
        var newTail = newHead;

        // updateNode O(1)
        if (newHead == currentLeftNode) currentLeftNode = currentLeftNode.next;
        else currentRightNode = currentRightNode.next;

        // sorting O(n)
        while(currentLeftNode != null && currentRightNode != null) {
            ListNode winner = getMaxNode(currentLeftNode, currentRightNode);

            if (winner == currentLeftNode) currentLeftNode = currentLeftNode.next;
            else currentRightNode = currentRightNode.next;

            newTail.next = winner;
            newTail = newTail.next;
        }

        newTail.next = currentLeftNode == null ? currentRightNode : currentLeftNode;

        return newHead;
    }

    private ListNode getMaxNode(ListNode currentLeftNode, ListNode currentRightNode) {
        return currentLeftNode.val <= currentRightNode.val ? currentLeftNode : currentRightNode;
    }

    private ListNode splitRightNodeListAndGetHead(ListNode head) {
        var oneStepNode = head;
        var doubleStepNode = head;

        while(doubleStepNode.next != null && doubleStepNode.next.next != null) {
            oneStepNode = oneStepNode.next;
            doubleStepNode = doubleStepNode.next.next;
        }

        var rightNodeHead = oneStepNode.next;
        oneStepNode.next = null;

        return rightNodeHead;
    }
}
