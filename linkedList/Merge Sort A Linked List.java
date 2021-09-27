public static Node getMid(Node head, Node tail){
        Node slow = head;
        Node fast = head;
        
        while(!(fast == tail || fast.next == tail)){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static LinkedList mergeSort(Node head, Node tail){
        if(head == tail){
            LinkedList list = new LinkedList();
            list.addFirst(head.data);
            return list;
        }
        
        Node mid = getMid(head, tail);
        
        LinkedList left = mergeSort(head, mid);
        LinkedList right = mergeSort(mid.next, tail);
        
        return mergeTwoSortedLists(left, right);
        
    }