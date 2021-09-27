

class Main {
    
    static class Node{
        int data;
        Node left;
        Node right;
    }
    static Integer data[] = new Integer[]{50, 25, 12, null, null, 35, null, null, 75, 80, null, null, 100, null, null};
    static int i=0;

    public static Node build(){
        if(data[i] == null){
            i++;
            return null;
        }


        Node r = new Node();
        r.data = data[i];
        i++;
        r.left = build();
        r.right = build();
        return r;
    ]

    public static void main(String[] args) {
        

        Node root = build(0);

    }

}
