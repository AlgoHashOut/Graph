package GRAPHS.DISJOINTSET;

import java.util.Arrays;

public class QuickUnion {
    int[] rootArray;

    public QuickUnion(int size)
    {
        rootArray = new int[size];

        for(int index = 0; index < size; index++)
        {
            rootArray[index] = index;
        }
    }

    public int find(int index)
    {
        while(index != rootArray[index])
        {
            index = rootArray[index];
        }
        return index;
    }


    public void union(int x, int y)
    {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY)
        {
            rootArray[rootY] = rootX;
        }
    }
    public boolean isConnected(int x, int y)
    {
        return find(x) == find(y);
    }
    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion(5);
        quickUnion.union(0,1);
        quickUnion.union(1,2);
        quickUnion.union(3,4);
        System.out.println("After union of (0,1) (1,2) (3,4) parentArray --> "+ Arrays.toString(quickUnion.rootArray));

        System.out.println(" is(0,2) connected --> "+ quickUnion.isConnected(0,2) );
        System.out.println(" is(0,4) connected --> "+ quickUnion.isConnected(0,4) );
        System.out.println(" is(3,4) connected --> "+ quickUnion.isConnected(3,4) );
        quickUnion.union(2,3);

        System.out.println(" After(2,3) union parentArray --> "+ Arrays.toString(quickUnion.rootArray));
        System.out.println(" is(0,4) connected --> "+ quickUnion.isConnected(0,4) );



    }

}