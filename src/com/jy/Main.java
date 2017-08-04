package com.jy;

import java.util.ArrayDeque;

public class Main {

	public static void main(String[] args) {
		// 定义链表输入1->2->3->4->5
		ListNode node4 = new ListNode(5, null);
		ListNode node3 = new ListNode(4, node4);
		ListNode node2 = new ListNode(3, node3);
		ListNode node1 = new ListNode(2, node2);
		ListNode head = new ListNode(1, node1);

		System.out.print("正向输出链表：");
		ListNode listNode = head;
		while (listNode.mNext != null) {
			System.out.print(listNode.mValue + "->");
			listNode = listNode.mNext;
		}
		System.out.println(listNode.mValue);

		System.out.print("逆向输出链表：");
		printListReversingly1(head);
		
		System.out.println();
		
		System.out.print("逆向输出链表：");
		printListReversingly2(head);
	}

	/**
	 * 使用栈的方式逆向打印链表
	 * 
	 * @param head
	 *            头节点
	 */
	private static void printListReversingly1(ListNode head) {
		// 定义栈结构变量
		ArrayDeque<ListNode> stack = new ArrayDeque<>();

		ListNode listNode = head;
		while (listNode != null) {
			// 入栈
			stack.push(listNode);
			listNode = listNode.mNext;
		}

		if (stack.isEmpty())
			return;
		boolean flag = false;
		while (!stack.isEmpty()) {
			if (flag)
				System.out.print("->");
			// 出栈并输出
			System.out.print(stack.pop().mValue);
			flag = true;
		}
	}

	/**
	 * 使用递归的方式逆向打印链表
	 * 
	 * @param head
	 *            头节点
	 */
	private static void printListReversingly2(ListNode head) {
		if (head != null) {
			if (head.mNext != null)
				printListReversingly2(head.mNext);
			System.out.print(head.mValue + "->");
		}
	}

}
