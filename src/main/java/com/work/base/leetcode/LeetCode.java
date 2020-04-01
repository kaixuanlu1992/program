package com.work.base.leetcode;

import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public class LeetCode {
    public static void main(String[] args) {
        LeetCode leetCode = new LeetCode();
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(leetCode.twoSum(nums, 9)));

        String s = "a";
        System.out.println(leetCode.longestPalindrome2(s));

        System.out.println(leetCode.isValid("()[]{} "));


        System.out.println(leetCode.multiply("6", "501"));

        int[][] n = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(leetCode.spiralOrder(n));

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        System.out.println(leetCode.reverseList(listNode1));
        System.out.println(leetCode.isPowerOfTwo(1073741825));

    }

    /**
     * 两数之和，返回下标
     *
     * @param nums
     * @param target
     * @return 思路：使用hashmap存储值和索引，依据差值找到另一个值
     */

    private int[] twoSum(int[] nums, int target) {
        int[] rs = new int[2];
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            valueToIndex.put(nums[index], index);
        }
        for (int index = 0; index < nums.length; index++) {
            int subValue = target - nums[index];
            if (valueToIndex.get(subValue) != null && valueToIndex.get(subValue) != index) {
                rs[0] = index;
                rs[1] = valueToIndex.get(subValue);
                break;
            }
        }
        return rs;
    }

    /**
     * 最长回文子串
     *
     * @param s
     * @return 思路：
     * 1、暴力法 ： 遍历所有可能字串，判断是否为回文
     * - 时间复杂度：O（N^3）, 空间复杂度： O（1）
     * - 问题：
     * 2、动态规划
     * - f(i,j) =
     * 3、两端扩展法：由中间向两端扩散
     */
    private String longestPalindrome1(String s) {
        int len = s.length();
        int maxLen = 0;
        String rs = "";
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (isPalindrome(s, i, j)) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        rs = s.substring(i, j + 1);
                    }
                }
            }
        }
        return rs;
    }

    /**
     * 是否回文串
     *
     * @param string
     * @param start
     * @param end
     * @return
     */
    private boolean isPalindrome(String string, int start, int end) {
        while (start < end) {
            if (string.charAt(start) == string.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    private String longestPalindrome2(String s) {
        int len = s.length();
        boolean[][] tempRs = new boolean[len][len];
        int maxLen = 0;
        String rs = "";
        //初始化值
        for (int i = 0; i < len; i++) {
            tempRs[i][i] = true;
            if (i < len - 1) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    tempRs[i][i + 1] = true;
                } else {
                    tempRs[i][i + 1] = false;
                }
            }
        }
        //找到对应关系，填充值
        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && tempRs[i + 1][j - 1]) {
                    tempRs[i][j] = true;
                } else {
                    tempRs[i][j] = false;
                }
            }
        }
        //找到计算结果
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (tempRs[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    rs = s.substring(i, j + 1);
                }
            }
        }
        return rs;

    }

    /**
     * 字符串转换为数字
     *
     * @param str
     * @return
     */
    private int myAtoi(String str) {
        int rs = 0;

        return rs;
    }

    /**
     * 最长公共子串
     *
     * @param strs
     * @return
     */
    private String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        String rs = strs[0];
        for (String s : strs) {
            rs = getMyCommonPrefix(s, rs);
        }
        return rs;
    }

    /**
     * 公共子串
     *
     * @param s
     * @param rs
     * @return
     */
    private String getMyCommonPrefix(String s, String rs) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (s == null || rs == null) {
            return stringBuilder.toString();
        }
        int index = 0;
        while (index < s.length() && index < rs.length()) {
            if (s.charAt(index) == rs.charAt(index)) {
                stringBuilder.append(s.charAt(index++));
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 括号是否有效
     *
     * @param s
     * @return
     */
    private boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        if (s == null || s.length() < 1) {
            return true;
        }
        for (char myChar : s.toCharArray()) {
            if (map.values().contains(myChar)) {
                stack.push(myChar);
            } else if (stack.empty() || stack.peek() != map.get(myChar)) {
                return false;
            } else {
                stack.pop();
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除重复元素
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int current = nums[0];
        int newIndex = 1;
        for (int index = 1; index < nums.length; index++) {
            if (current == nums[index]) {
                continue;
            } else {
                current = nums[index];
                nums[newIndex] = current;
                newIndex++;
            }
        }
        return newIndex;
    }

    /**
     * 盛水最多的容器
     * 1.暴力法
     * 2.动态规划
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        if (height == null || height.length < 2) {
            return maxArea;
        }
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = getMaxArea(height, i, j);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    private int getMaxArea(int[] height, int i, int j) {
        return (j - i) * Math.min(height[i], height[j]);
    }

    private int getMaxArea1(int[] height, int i, int j) {
        int[] area = new int[j - i];
        for (int index = i + 1; index <= j; index++) {
            if (height[index - 1] > height[index]) {
                if (index == i + 1) {
                    area[j - i - 1] = height[index];
                } else {
                    area[j - i - 1] = height[index] + area[j - i - 2];
                }

            } else {
                int newIndex = index - 1;
                while (newIndex >= i) {
                    if (newIndex == i || height[newIndex] > height[index]) {
                        break;
                    }
                    newIndex--;
                }
                int currentArea = (index - newIndex) * Math.min(index, newIndex);
                int newIndexArea = newIndex == i ? 0 : area[newIndex - i - 1];
                area[index - i - 1] = currentArea + newIndexArea;
            }
        }
        return area[j - i - 1];
    }

    /**
     * 字符串相乘
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        int len = num2.length();
        String rs = "";
        for (int index = len - 1; index >= 0; index--) {
            String m = multiplyWith(num1, num2.charAt(index));
            rs = add(rs, m, len - index - 1);
        }
        if (rs.length() > 1 && rs.charAt(0) == '0') {
            return "0";
        }
        return rs;
    }

    private String add(String rs, String m, int i) {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < i; index++) {
            builder.append(rs.charAt(rs.length() - index - 1));
        }
        int carry = 0;
        char start = '0';
        int index = 0;
        while (index + i < rs.length() || index < m.length()) {
            int add = 0, beAdd = 0;
            if (index + i < rs.length()) {
                add = rs.charAt(rs.length() - 1 - i - index) - start;
            }
            if (index < m.length()) {
                beAdd = m.charAt(m.length() - 1 - index) - start;
            }
            int sum = add + beAdd + carry;
            builder.append(sum % 10);
            carry = sum / 10;
            index++;
        }
        if (carry != 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }

    private String multiplyWith(String num1, char charAt) {
        int len = num1.length();
        int carry = 0;
        char start = '0';
        if (charAt == '0') {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        for (int index = len - 1; index >= 0; index--) {
            int multiply = (charAt - start) * (num1.charAt(index) - start) + carry;
            builder.append(multiply % 10);
            carry = multiply / 10;
        }
        if (carry != 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }

    private void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    private void reverseString(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }


    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end = 0, index = 0;
        boolean newWord = true;
        while (index < s.length()) {
            if (s.charAt(index) != ' ') {
                if (newWord) {
                    start = index;
                    end = index;
                    newWord = false;
                } else {
                    end++;
                }
            }
            if (s.charAt(index) == ' ') {
                if (!newWord) {
                    reverseString(chars, start, end);
                    newWord = true;
                }
            }
            index++;
        }
        reverseString(chars, start, end);
        return chars.toString();
    }

    public boolean containsDuplicate(int[] nums) {
        boolean rs = false;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rs = new ArrayList<>();
        if (matrix == null || matrix.length < 1) {
            return rs;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        //循环次数
        int min = Math.min(m, n);
        int loop = min / 2;
        loop = min % 2 == 0 ? loop : loop + 1;
        int startLoop = 0;
        //开始结束行
        int startRow = 0, endRow = m - 1, startColumn = 0, endColumn = n - 1;

        while (startLoop < loop) {
            for (int index = startColumn; index <= endColumn; index++) {
                rs.add(matrix[startRow][index]);
            }
            startRow++;
            for (int index = startRow; index <= endRow; index++) {
                rs.add(matrix[index][endColumn]);
            }
            endColumn--;
            if (rs.size() == m * n) {
                break;
            }
            for (int index = endColumn; index >= startColumn; index--) {
                rs.add(matrix[endRow][index]);
            }
            endRow--;
            for (int index = endRow; index >= startRow; index--) {
                rs.add(matrix[index][startColumn]);
            }
            startColumn++;
            startLoop++;
        }
        return rs;
    }

    public int[][] generateMatrix(int n) {
        int[][] rs = new int[n][n];
        //循环次数
        int loop = n / 2;
        loop = n % 2 == 0 ? loop : loop + 1;
        int startLoop = 0;
        //开始结束行
        int startRow = 0, endRow = n - 1, startColumn = 0, endColumn = n - 1;

        int start = 1;
        while (startLoop < loop) {
            for (int index = startColumn; index <= endColumn; index++) {
                rs[startRow][index] = start++;
            }
            startRow++;
            for (int index = startRow; index <= endRow; index++) {
                rs[index][endColumn] = start++;
            }
            endColumn--;
            if (start >= n * n) {
                break;
            }
            for (int index = endColumn; index >= startColumn; index--) {
                rs[endRow][index] = start++;
            }
            endRow--;
            for (int index = endRow; index >= startRow; index--) {
                rs[index][startColumn] = start++;
            }
            startColumn++;
            startLoop++;
        }
        return rs;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] rs = new int[m + n];
        int start1 = 0, start2 = 0, index = 0;
        while (start1 < m || start2 < n) {
            if (start1 > m - 1) {
                System.arraycopy(nums2, start2, rs, index, n - start2);
                break;
            }
            if (start2 > n - 1) {
                System.arraycopy(nums1, start1, rs, index, m - start1);
                break;
            }
            if (nums1[start1] > nums2[start2]) {
                rs[index++] = nums2[start2++];
            } else {
                rs[index++] = nums1[start1++];
            }
        }
        System.arraycopy(rs, 0, nums1, 0, m + n);
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        //new head
        ListNode first = head, temp;
        ListNode next = head.next;
        while (next != null) {
            //反转
            temp = next.next;
            next.next = first;
            //只交换首尾
            head.next = temp;
            //下次位置
            first = next;
            next = temp;
        }
        return first;
    }

    /**
     * 两数相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum = 0;
        ListNode rs = new ListNode(0);
        ListNode current = rs;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                while (l2 != null) {
                    sum = (l2.val + carry) % 10;
                    carry = (l2.val + carry) / 10;
                    current.next = new ListNode(sum);
                    l2 = l2.next;
                    current = current.next;
                }
                if (carry != 0) {
                    current.next = new ListNode(carry);
                }
                break;
            }

            if (l2 == null) {
                while (l1 != null) {
                    sum = (l1.val + carry) % 10;
                    carry = (l1.val + carry) / 10;
                    current.next = new ListNode(sum);
                    l1 = l1.next;
                    current = current.next;
                }
                if (carry != 0) {
                    current.next = new ListNode(carry);
                }
                break;
            }
            sum = (l2.val + l1.val + carry) % 10;
            carry = (l2.val + l1.val + carry) / 10;
            current.next = new ListNode(sum);
            l2 = l2.next;
            l1 = l1.next;
            current = current.next;
            if (carry != 0) {
                current.next = new ListNode(carry);

            }
        }
        return rs.next;
    }

    /**
     * 合并有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rs = new ListNode(0);
        ListNode current = rs;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                while (l2 != null) {
                    current.next = new ListNode(l2.val);
                    l2 = l2.next;
                    current = current.next;
                }
                break;
            }
            if (l2 == null) {
                while (l1 != null) {
                    current.next = new ListNode(l1.val);
                    l1 = l1.next;
                    current = current.next;
                }
                break;
            }
            if (l1.val > l2.val) {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            current = current.next;
        }
        return rs.next;
    }

    /**
     * 合并K个有序链表
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        ListNode first = lists[0];
        for (int index = 1; index < lists.length; index++) {
            first = mergeTwoLists(first, lists[index]);
        }
        return first;
    }

    /**
     * 链表旋转
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        //链表长度
        ListNode pre = head, last = head;
        int len = 1;
        while (pre.next != null) {
            pre = pre.next;
            len++;
            last = pre;
        }
        //旋转
        k = len - k % len;
        pre = head;
        while (k > 1) {
            pre = pre.next;
            k--;
        }
        last.next = head;
        head = pre.next;
        pre.next = null;

        return head;
    }

    /**
     * 链表是否有循环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null && cur.next.next != null) {
            head = head.next;
            cur = cur.next.next;
            if (cur == head) {
                return true;
            }
        }
        return false;

    }

    /**
     * 删除链表节点
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode prv = head, cur = head.next;
        while (cur != null && cur.val != val) {
            prv = prv.next;
            cur = cur.next;
        }
        if (cur != null && cur.val == val) {
            prv.next = cur.next;
        }

        return head;
    }

    //相交链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //计算两个链表长度
        int l1 = 0, l2 = 0;
        ListNode h1 = headA, h2 = headB;
        while (h1 != null) {
            l1++;
            h1 = h1.next;
        }
        while (h2 != null) {
            l2++;
            h2 = h2.next;
        }
        //长的先走
        h1 = l1 > l2 ? headA : headB;
        h2 = l1 > l2 ? headB : headA;
        int sub = Math.abs(l1 - l2);
        while (sub > 0) {
            h1 = h1.next;
            sub--;
        }
        while (h1 != null) {
            if (h1 == h2) {
                return h1;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return null;
    }

    public int singleNumber(int[] nums) {
        int rs = nums[0];
        for (int index = 1; index < nums.length; index++) {
            rs = rs ^ nums[index];
        }
        return rs;
    }

    @Transactional
    public boolean isPowerOfTwo(int n) {
        int max = 1 << 30;
        if(n >max){
            return false;
        }
        int start = 1;
        while (start < n) {
            start = start << 1;
        }
        return start == n;
//        return n>0 && (n & (n-1))==0;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}





