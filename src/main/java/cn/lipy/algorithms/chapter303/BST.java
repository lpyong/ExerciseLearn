package cn.lipy.algorithms.chapter303;

import sun.swing.plaf.windows.ClassicSortArrowIcon;

/**
 * Created by lipyong on 2018/11/26.
 */
public class BST <Key extends Comparable<Key>,Value>
{
    private Node root;
    private class Node
    {
        private Key key;//键
        private Value val;//值
        private Node left,right;//指向子树的链接
        private int N;//以该节点为根的子树中的节点总数
        public  Node(Key key,Value val,int N)
        {
            this.key = key;this.val=val;this.N=N;
        }
    }
    public int size()
    {
        return size(root);
    }
    private int size(Node x)
    {
        if (x==null) return 0;
        else         return x.N;
    }
    //二叉树查找算法的实现
    public Value get(Key key)
    {
        return get(root,key);
    }
    public Value get(Node x,Key key)
    {   //在以x为根节点的子树中查找并返回key所对应的值
        //如果找不到就返回null
        if (x==null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp<0) return get(x.left,key);
        else  if (cmp>0) return  get(x.right,key);
        else return x.val;
    }
    public void put(Key key,Value val)
    { //查找key，找到则更新它的值，否则为它创建一个新的结点
        root = put(root,key,val);

    }
    private Node put(Node x,Key key,Value val)
    {
        //如果key存在于以x为根节点的子树中则更新它的值；
        //否则将以key和val为键值对的新节点插入到该子树中
        if(x==null) return new Node(key,val,1);
        int cmp = key.compareTo(x.key);
        if (cmp<0) x.left=put(x.left,key,val) ;
        else if (cmp>0) x.right=put(x.right,key,val);
        else x.val = val;
        x.N = size(x.left)+size(x.right)+1;
        return x;

    }
    //二叉树中max（）、min()、floor()、ceiling()
    public Key min()
    {
        return min(root).key;

    }
    private Node min(Node x)
    {
        if (x.left==null) return x;
        return min(x.left);
    }
    public Key max()
    {
        return max(root).key;

    }
    private Node max(Node x)
    {
        if (x.right==null) return x;
        return max(x.right);
    }

    public Key floor(Key key)
    {
        Node x = floor(root,key);
        if (x ==null) return null;
        return x.key;
    }
    private Node floor(Node x,Key key)
    {
        if (x==null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp==0) return x;
        if (cmp<0) return floor(x.left,key);
        Node t = floor(x.right,key);
        if (t !=null) return t;
        else return x;
    }

    public Key select(int k)
    {
        return select(root,k).key;
    }
    private Node select(Node x,int k)
    {
         //返回排名为k的节点
        if (x==null) return null;
        int t = size(x.left);
        if (t>k)      return select(x.left,k);
        else if (t>k) return select(x.right,k-t-1);
        else          return x;

    }


}
