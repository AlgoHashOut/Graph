package GRAPHS.DISJOINTSET;

import java.util.Arrays;

public class QuickFind {
    int[] parentArray;

    public QuickFind(int size)
    {
        parentArray = new int[size];

        for(int index = 0; index < size; index++)
        {
            parentArray[index] = index;
        }
    }

    public int find(int index)
    {
        return parentArray[index];
    }

    public void union(int x, int y)
    {
        int parentX = find(x);
        int parentY = find(y);
        if(parentX != parentY)
        {
            for(int index = 0; index < parentArray.length; index++)
            {
                if(parentArray[index] == parentY)
                {
                    parentArray[index] = parentX;
                }
            }
        }
    }

    public boolean isConnected(int x, int y)
    {
        return find(x) == find(y);
    }
    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(5);
        quickFind.union(0,1);
        quickFind.union(1,2);
        quickFind.union(3,4);
        System.out.println("After union of (0,1) (1,2) (3,4) parentArray --> "+ Arrays.toString(quickFind.parentArray));

        System.out.println(" is(0,2) connected --> "+ quickFind.isConnected(0,2) );
        System.out.println(" is(0,4) connected --> "+ quickFind.isConnected(0,4) );
        System.out.println(" is(3,4) connected --> "+ quickFind.isConnected(3,4) );
        quickFind.union(2,3);

        System.out.println(" After(2,3) union parentArray --> "+ Arrays.toString(quickFind.parentArray));
        System.out.println(" is(0,4) connected --> "+ quickFind.isConnected(0,4) );



    }

}