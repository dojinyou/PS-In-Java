package problemsolving.leetcode.studyplan.level2.day4;

import problemsolving.leetcode.studyplan.level2.datastructure.ListNode;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        var oddHeadNode = head;
        var oddCurrentNode = oddHeadNode;
        var evanHeadNode = head.next;
        var evanCurrentNode = evanHeadNode;

        while(evanCurrentNode != null && evanCurrentNode.next != null) { // 3번이 있다면 진행
            oddCurrentNode.next = evanCurrentNode.next; // 1번에 3번 연결
            evanCurrentNode.next = oddCurrentNode.next.next; // 2번에 4번 연결 (null일 수 있음)

            oddCurrentNode = oddCurrentNode.next;
            evanCurrentNode = evanCurrentNode.next;
        }

        oddCurrentNode.next = evanHeadNode;
        return oddHeadNode;
    }
}
