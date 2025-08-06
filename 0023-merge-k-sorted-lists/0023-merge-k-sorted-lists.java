class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        return sort(lists, 0, lists.length-1);
    }

    ListNode sort(ListNode[] lists, int l, int r){
        if(l==r) return lists[l];
        int mid=(l+r)/2;
        ListNode l1=sort(lists,l,mid);
        ListNode l2=sort(lists,mid+1,r);
        return merge(l1,l2);
    }

    ListNode merge(ListNode l1, ListNode l2){
        ListNode res;
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            res=l1;
            res.next=merge(l1.next,l2);
        }
        else{
            res=l2;
            res.next=merge(l1,l2.next);
        }
        return res;
    }

}