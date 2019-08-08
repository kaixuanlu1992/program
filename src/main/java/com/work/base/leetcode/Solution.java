package com.work.base.leetcode;

    public class Solution {
        public static void main(String[] args){
            ListNode listNode=createListNode();
            printListNode(reverseBetween(listNode,1,4));
        }

        private static void printListNode(ListNode listNode) {
            if (listNode!=null){
                System.out.println(listNode.val);
                while (listNode.next!=null){
                    System.out.println(listNode.next.val);
                    listNode=listNode.next;
                }
            }

        }

        private static ListNode createListNode() {
            ListNode head =new ListNode(1);
            ListNode p1 =new ListNode(2);
            ListNode p2 =new ListNode(3);
            ListNode p3 =new ListNode(4);
            head.next=p1;
            p1.next=p2;
            p2.next=p3;
            return head;
        }


        public static ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode preHead=new ListNode(0);
            preHead.next=head;
            ListNode pre=preHead;
            ListNode cur=head;
            ListNode next=cur.next;
            ListNode tail=cur;
            int index1=1,index2=1;
            while(index1<m){
                pre=pre.next;
                cur=cur.next;
                next=next.next;
                tail=tail.next;
                index1++;
                index2++;
            }
            while(index2<n){
                tail.next=next.next;
                next.next=cur;
                pre.next=next;

                next=tail.next;
                cur=pre.next;
                index2++;
            }

            return preHead.next;

        }
    }

