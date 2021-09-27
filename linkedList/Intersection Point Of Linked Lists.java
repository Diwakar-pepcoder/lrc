public static int findIntersection(LinkedList one, LinkedList two){
        if(two.size > one.size){
            LinkedList tmp = one;
            one = two;
            two = tmp;
        }
        
        // one size
        
        Node n1 = one.head;
        Node n2 = two.head;
        
        int k = one.size - two.size;
        while(k>0){
            n1 = n1.next;
            k--;
        }
        
        while(n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1.data;
    }