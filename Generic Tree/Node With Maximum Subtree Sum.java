static int maxData;
  static int maxSum;
  
  static int sumCal(Node node){
      
        int s=0;
        
        for(Node child: node.children){
            s += sumCal(child);
        }
        s+= node.data;
      
        if(s > maxSum){
            maxSum = s;
            maxData = node.data;
        }
        return s;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    // write your code here
    maxSum = Integer.MIN_VALUE;
    maxData = 0;
    
    sumCal(root);
    
    System.out.println(maxData+"@"+maxSum);
    
    
    
  }

}