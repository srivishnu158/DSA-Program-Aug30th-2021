import java.util.Arrays;
class DisJointSet
{
    int[] vertexs;
    int[] rank;

    public DisJointSet(int size)
    {
        vertexs = new int[size];
        rank = new int[size];

        for(int i = 0 ; i < size ; i++)
        {
            vertexs[i] = i;
            rank[i]=1;
        }
    }

    // 0[0] -> 1 [0] -> 2 [1] -> 3[2]

    /* 
    find(3)  vertexs[3] = find(2) :: 0
           
             find(2)-> vertexs[2] = find(1) :: 0
                        
                             find(1) -> vertexs[1] = find(0) :: 0

                                     find(0) = return 0

            0[0] -> 1 [0] -> 2 [0] -> 3[0]
                        */
    public int find(int v)
    {
        if( v == vertexs[v])
        {
            return v;
        }

        vertexs[v] = find(vertexs[v]);

        return vertexs[v];
    }

    public boolean connected(int vx, int vy)
    {
        return find(vx) == find(vy);
    }

    public void union(int vx, int vy)
    {
            int rootX = find(vx);
            int rootY = find(vy);

            if(rootX != rootY)
            {
                if(rank[rootX] > rank[rootY])
                {
                    vertexs[rootY] = rootX;
                }else if(rank[rootY] > rank[rootX])
                {
                    vertexs[rootX] = rootY;
                }else
                {
                    vertexs[rootY] = rootX;
                    rank[rootX] = rank[rootX]+1;
                }
                
            }

    }

    public static void main(String args[])
    {
        DisJointSet jointSet = new DisJointSet(9);

        // 0-1-2-3-4 :: 5-6-7 :: 8

        jointSet.union(0,1);
        jointSet.union(1,2);
        jointSet.union(2,3);
        jointSet.union(3,4);

        jointSet.union(5,6);
        jointSet.union(6,7);


        System.out.println(" Expected Roots: 0[0]-1[0]-2[0]-3[0]-4[0] :: 5[5]-6[5]-7[5] :: 8[8] => "+Arrays.toString(jointSet.vertexs));
        
                // 0[0]-1[0]-2[0]-3[0]-4[0] :: 5[2]-6[1]-7[1] :: 8[1]
        System.out.println(" Expected Ranks: 0[2]-1[1]-2[1]-3[1]-4[1] :: 5[2]-6[1]-7[1] :: 8[1] => "+Arrays.toString(jointSet.rank));

                // 0-1-2-3-4 :: 5-6-7
        System.out.println(" isConnected(0,4) => "+jointSet.connected(0,4));
        System.out.println(" isConnected(4,5) => "+jointSet.connected(4,5));
        System.out.println(" isConnected(5,7) => "+jointSet.connected(5,7));

        jointSet.union(3,7);
        /*
        0-1-2-3-4
        |
        5-6-7
             */
        System.out.println(" Expected : 0[0]-1[0]-2[0]-3[0]-4[0] :: 5[0]-6[5]-7[5] :: 8[8] => "+Arrays.toString(jointSet.vertexs));
        System.out.println(" Expected Ranks: 0[3]-1[1]-2[1]-3[1]-4[1] :: 5[2]-6[1]-7[1] :: 8[1] => "+Arrays.toString(jointSet.rank));

        System.out.println(" isConnected(4,5) => "+jointSet.connected(4,5));
        System.out.println(" isConnected(7,2) ="+jointSet.connected(7,2));

        jointSet.union(7,8);

     System.out.println(" Expected : 0[0]-1[0]-2[0]-3[0]-4[0] :: 5[0]-6[5]-7[0]-8[0] => "+Arrays.toString(jointSet.vertexs));
     System.out.println(" Expected Ranks: 0[3]-1[1]-2[1]-3[1]-4[1] :: 5[2]-6[1]-7[1] :: 8[1] => "+Arrays.toString(jointSet.rank));



    }
}










 