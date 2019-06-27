package org.lanqiao.algo.book.cc150;

import org.assertj.core.api.Assertions;

import java.util.Stack;

/*回文链表
* 检查链表是否回文*/
public class _2_7PalindromeLinkedList {


  public static void main(String[] args) {
    ListNode node = new ListNode( 1 );
    node.next = new ListNode( 2 );
    node.next.next = new ListNode( 32 );
    node.next.next.next = new ListNode( 32 );
    node.next.next.next.next = new ListNode( 2 );
    node.next.next.next.next.next = new ListNode( 1 );
    Assertions.assertThat(new _2_7PalindromeLinkedList().isPalindrome(node)).isTrue();
  }

  public boolean isPalindrome(ListNode pHead) {
    if (pHead==null)
      return false;
    if (pHead.next==null)
      return true;
    ListNode slower = pHead;
    ListNode faster = pHead;
    Stack<ListNode> stack = new Stack<>();
    boolean isOdd=true;
    while (faster!=null&&faster.next!=null){
      stack.push(slower);//压栈
      slower = slower.next;
      faster = faster.next.next;
      if(faster==null){
        isOdd = false;
      }
    }
    // 奇数个结点，slower还要next一下
    if(isOdd)
      slower = slower.next;
    while (!stack.empty()){
      if (stack.pop().val != slower.val) {//dequeue：弹出栈
        return false;
      }else{
        slower = slower.next;
      }
    }

    return true;
  }
}
