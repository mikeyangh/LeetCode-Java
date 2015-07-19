/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        //if (l1 == null) return l2;
        //if (l2 == null) return l1;
        ListNode resultList = new ListNode(0);
        ListNode p = resultList;
        /*
        if (l1.val < l2.val)
        {
            resultList.next = l1;
            l1 = l1.next;
        }
        else
        {
            resultList.next = l2;
            l2 = l2.next;
        }*/
        //p = resultList;
        while (true)
        {
            if (l1 == null)
            {
                p.next = l2;
                break;
            }
            else if (l2 == null)
            {
                p.next = l1;
                break;
            }
            else 
            {
                if (l1.val < l2.val)
                {
                    p.next = l1;
                    p = l1;
                    l1 = l1.next;
                }
                else
                {
                    p.next = l2;
                    p = l2;
                    l2 = l2.next;
                }
            }
        
        }
        return resultList.next;
    }
}
