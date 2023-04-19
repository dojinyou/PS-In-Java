package leetcode.studyplan.level2.day3;

import java.util.Deque;
import java.util.LinkedList;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        var doubleSpeedNode = head;
        var leftHalfSearchNode = head;

        // 달리기 시키기.
        while(doubleSpeedNode.next != null && doubleSpeedNode.next.next != null) {
            stack.push(leftHalfSearchNode);

            leftHalfSearchNode = leftHalfSearchNode.next;
            doubleSpeedNode = doubleSpeedNode.next.next;
        }

        if (doubleSpeedNode.next != null) { // 짝수라면
            stack.push(leftHalfSearchNode);
        }

        var rightHalfSearchNode = leftHalfSearchNode.next;

        while (rightHalfSearchNode != null) {
            if (stack.pop().val != rightHalfSearchNode.val) {
                return false;
            }

            rightHalfSearchNode = rightHalfSearchNode.next;
        }

        return true;
    }
}
