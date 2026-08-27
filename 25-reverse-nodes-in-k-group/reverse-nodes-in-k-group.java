class Solution {
    private ListNode gestKthNode(ListNode head,int k){//Find kth node of current group
        ListNode temp = head;
        while(temp!=null && k>1){
            temp = temp.next;
            k--; }
        return temp;
    }
    private ListNode reverse(ListNode head){ // Normal reverse function
        ListNode curr = head; ListNode prev = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next; }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy  = new ListNode(0); dummy.next = head; ListNode prevGroup = dummy;
        while(true){
            ListNode kth = gestKthNode(prevGroup.next,k);// Find kth node
            if(kth==null){ // Less than k nodes
                break; }
            ListNode nextGroup = kth.next;// Save next group
            ListNode groupHead = prevGroup.next; // Start of current group
            kth.next = null; // Start of current group
            ListNode reversedHead = reverse(groupHead); // Reverse current k nodes
            prevGroup.next = reversedHead; // Connect previous group
            groupHead.next = nextGroup;// groupHead is now the last node
            prevGroup = groupHead; } // Move to next group  
        return dummy.next;
    }
}