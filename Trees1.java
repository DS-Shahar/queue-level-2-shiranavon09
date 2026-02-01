import java.util.*;
	class Main 
	{

	public static void main(String[] args) 
  {
    BinNode<Integer> t15 = new BinNode<Integer>(15);
		BinNode<Integer> t14 = new BinNode<Integer>(14);
		BinNode<Integer> tree = new BinNode<Integer>(t15, 3, t14);
		BinNode<Integer> t9 = new BinNode<Integer>(9);
		tree.getLeft().setLeft(new BinNode<Integer>(t9, 6, new BinNode<Integer>(7)));
		tree.getLeft().setRight(new BinNode<Integer>(new BinNode<Integer>(34), 56, new BinNode<Integer>(12)));
		System.out.println(tree);
     System.out.println("count = "+evenWithoutUnevenSon(t));
    if(isEvenWithoutUnevenSon(t))
        System.out.println("exists at least one valid node");
    else
        System.out.println("no valid node exists");
    if(isAllEvenWithoutUnevenSon(t))
        System.out.println("all nodes are valid");
    else
        System.out.println("not all nodes are valid");
    }
    public static void printEvenWithoutUnevenSon(BinNode<Integer> t)
    {
        if(t==null)
            return;
        int v=t.getValue();
        BinNode<Integer> left=t.getLeft();
        BinNode<Integer> right=t.getRight();
        boolean leftOk=(left==null||left.getValue()%2==0);
        boolean rightOk=(right==null||right.getValue()%2==0);
        if(v%2==0&&leftOk&&rightOk)
            System.out.print(v+" ");
        printEvenWithoutUnevenSon(left);
        printEvenWithoutUnevenSon(right);
    }
    public static int countevenWithoutUnevenSon(BinNode<Integer> t)
    {
        if(t==null)
            return 0;
        if(t.getValue()%2==0 &&(t.getLeft()==null||t.getLeft().getValue()%2==0) &&(t.getRight()==null||t.getRight().getValue()%2==0))
            return 1+countevenWithoutUnevenSon(t.getLeft())+countevenWithoutUnevenSon(t.getRight());
        return countevenWithoutUnevenSon(t.getLeft())+countevenWithoutUnevenSon(t.getRight());
    }
    public static boolean isEvenWithoutUnevenSon(BinNode<Integer> t)
    {
        if(t==null)
            return false;
        if(t.getValue()%2==0 &&(t.getLeft()==null||t.getLeft().getValue()%2==0) &&(t.getRight()==null||t.getRight().getValue()%2==0))
            return true;
        return isEvenWithoutUnevenSon(t.getLeft())||isEvenWithoutUnevenSon(t.getRight());
    }
    public static boolean isAllEvenWithoutUnevenSon(BinNode<Integer> t)
    {
        if(t==null)
            return true;
        if(t.getValue()%2!=0 ||(t.getLeft()!=null&&t.getLeft().getValue()%2!=0) ||(t.getRight()!=null&&t.getRight().getValue()%2!=0))
            return false;
        return isAllEvenWithoutUnevenSon(t.getLeft())&&isAllEvenWithoutUnevenSon(t.getRight());
    }

}
