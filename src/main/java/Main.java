class Main {
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }
  public static Queue<Integer> ex1_Sequences(Queue<Character> q) //O(n)
    {
        Queue<Integer> res=new Queue<Integer>();
        Queue<Character> temp=new Queue<Character>();
        if(q.isEmpty())
            return res;
        char prev=q.remove();
        temp.insert(prev);
        int count=1;
        while(!q.isEmpty())
        {
            char curr=q.remove();
            temp.insert(curr);
            if(curr==prev)
                count++;
            else
            {
                res.insert(count);
                count=1;
                prev=curr;
            }
        }
        res.insert(count);
        while(!temp.isEmpty())
            q.insert(temp.remove());
        return res;
    }
    public static Queue<Integer> ex5_merge(Queue<Integer> q1,Queue<Integer> q2) //O(n^2)
    {
        Queue<Integer> res=new Queue<Integer>();
        while(!q1.isEmpty()&&!q2.isEmpty())
        {
            if(q1.head()<=q2.head())
                res.insert(q1.remove());
            else
                res.insert(q2.remove());
        }
        while(!q1.isEmpty())
            res.insert(q1.remove());
        while(!q2.isEmpty())
            res.insert(q2.remove());
        return res;
    }
    public static int ex6_maxEvenSum(Queue<Integer> q)// O(n)
    {
        int maxLen=0;
        int maxSum=0;
        int currLen=0;
        int currSum=0;
        while(!q.isEmpty())
        {
            int x=q.remove();
            if(x%2==0)
            {
                currLen++;
                currSum+=x;
                if(currLen>maxLen)
                {
                    maxLen=currLen;
                    maxSum=currSum;
                }
            }
            else
            {
                currLen=0;
                currSum=0;
            }
        }
        return maxSum;
    }

}
