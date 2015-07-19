/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode p = l1;
        ListNode q = l2;
        ListNode result_list = new ListNode(0);
        //ListNode new_node;
        ListNode cur_node = result_list;
        int x,y;
        int carry = 0;
        while(p!=null || q!=null || carry!=0)
        {
            if(p!=null)
            {
                x = p.val;
            }
            else x = 0;
            if(q!=null)
            {
                y = q.val;
            }
            else y = 0;
            int sum = (x + y + carry)%10;
            carry = (x + y + carry)/10;
            ListNode new_node = new ListNode(0);
            new_node.val = sum;
            cur_node.next = new_node;
            cur_node = new_node;
            
            if(p!=null)
                p = p.next;
            if(q!=null)
                q = q.next;
        }
        return result_list.next;
    }
}
