package GRAPHS.DISJOINTSET;

import java.util.Arrays;
import java.util.Stack;

public class QuickUnion_Optimised
{
    private int[] root;
    private int[] rank;

    public QuickUnion_Optimised(int size)
    {
        root = new int[size];
        rank = new int[size];

        for(int index = 0; index < size; index++)
        {
            root[index] = index;
            rank[index] = 1;
        }
    }

    public int find(int index)
    {
        Stack<Integer> stack = new Stack<>();
        while(index != root[index])
        {
            stack.push(index);
            index = root[index];
        }

        while(!stack.isEmpty())
        {
            root[stack.pop()] = index;
        }

        return index;
    }

    public boolean union(int x, int y)
    {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY)
        {
            if(rank[rootY] < rank[rootX])
            {
                root[rootY] = rootX;

            }else if(rank[rootX] < rank[rootY])
            {
                root[rootX] = rootY;
            }else
            {
                root[rootY] = rootX;
                rank[rootX]++;
            }

            return true;
        }

        return false;
    }
    public boolean isConnected(int x, int y)
    {
        return find(x) == find(y);
    }
    public static void main(String[] args) {
        QuickUnion_Optimised quickUnion = new QuickUnion_Optimised(5);
        quickUnion.union(0,1);
        quickUnion.union(1,2);
        quickUnion.union(3,4);
        System.out.println("After union of (0,1) (1,2) (3,4) parentArray --> "+ Arrays.toString(quickUnion.root)); // [0, 0, 0, 3, 3]

        System.out.println(" is(0,2) connected --> "+ quickUnion.isConnected(0,2) );
        System.out.println(" is(0,4) connected --> "+ quickUnion.isConnected(0,4) );
        System.out.println(" is(3,4) connected --> "+ quickUnion.isConnected(3,4) );
        quickUnion.union(2,3);

        System.out.println(" After(2,3) union parentArray --> "+ Arrays.toString(quickUnion.root)); // [0, 0, 0, 0, 3]
        System.out.println(" is(0,4) connected --> "+ quickUnion.isConnected(0,4) );
        System.out.println("After checking (0,4) connected path compression applied so the --> root = "+Arrays.toString(quickUnion.root)); //[0, 0, 0, 0, 0]


    }
}