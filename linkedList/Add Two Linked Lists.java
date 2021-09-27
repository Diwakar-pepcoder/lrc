public static int addTwoLists(Node one, Node two, int o, int t, LinkedList ans) {
        if(one == null )return 0;
        
        if(o == t){
            int c = addTwoLists(one.next, two.next, o-1, t-1, ans);
            int d = one.data+two.data+c;
            ans.addFirst(d%10);
            return d/10;
        }else if(o < t){
            int c = addTwoLists(one, two.next, o, t-1, ans);
            int d = 0+two.data+c;
            ans.addFirst(d%10);
            return d/10;
        }else{
            int c = addTwoLists(one.next, two, o-1, t, ans);
            int d = 0+one.data+c;
            ans.addFirst(d%10);
            return d/10;
        }
        
    }

    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
        LinkedList ans = new LinkedList();
        int carry = addTwoLists(one.head, two.head, one.size(), two.size(), ans);
        
        if(carry > 0){
            ans.addFirst(carry);
        }
        return ans;
    }