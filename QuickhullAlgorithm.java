

class QuickhullAlgorithm {


    public static int[][] FindConvexHull(int[][] pointsL)
    {
        int n= pointsL.length;
        int minval = 0;


        for(int i=1;i<n;i++)
        {
            if( pointsL[i][1] < pointsL[minval][1])
                minval = i;
        }


        if(n == 1)
            return new int[][]{{-1, -1}};


        int m[] = pointsL[minval];
        pointsL[minval] = pointsL[0];
        pointsL[0] = m;
        quickSort( pointsL, 1, n-1, true);


        int stack[] = new int[n];
        int p=1;
        stack[0] = 0;stack[1]=n-1;

        for(int i=n-2;i>0;i--)
        {
            long prod = -1;
            while(prod <= 0 && p>0){
                int p1[] = pointsL[stack[p]];
                int p2[] = pointsL[stack[p-1]];
                long y1 = p1[1]-p2[1];
                long x1 = p1[0]-p2[0];
                long x2 = pointsL[i][0]-p1[0];
                long y2 = pointsL[i][1]-p1[1];

                prod = x1 * y2 - x2 * y1;

                if(prod <= 0){
                                 p--;
                             }
            }
            p++;
            stack[p] = i;
        }


        if(p+1 <=2 )
            return new int[][]{{-1, -1}};

        int result[][] = new int[p+1][2];
        for(int i=p;i>=0;i--){
            result[i] = pointsL[stack[i]];
        }
        quickSort(result,0,p,false);
        return result;
    }
    public static void quickSort(int V[][],int mini, int end,boolean flag){
        if(mini >= end)
            return;
        int p = -1;

        if(flag)
            p = partition(V, mini, end);
        else p = part(V,mini,end);

        quickSort(V, mini, p-1, flag);
        quickSort(V, p+1,end, flag);
    }
    private static int part(int V[][], int mini, int end)
    {
        int p=mini;
        for(int i=mini+1;i <= end;i++)
        {
            if((V[i][0] < V[p][0]) || (V[i][0] == V[p][0] && V[i][1]< V[p][1])){
                mini++;
                int m[] = V[mini];
                V[mini] = V[i];
                V[i] = m;
            }
        }

        int m[] = V[mini];
        V[mini] = V[p];
        V[p]=m;
            return mini;
    }
    private static double angle(int p1[], int p2[]){
        double x=p1[0]-p2[0];
        double y = p1[1] - p2[1];
        return -(x/Math.sqrt(x*x + y*y));
    }

    private static int partition(int V[][], int mini, int end){
        int p = mini;

        double a1 = angle(V[mini], V[0]);
        for(int i=mini+1;i <= end;i++){
            double a2 = angle(V[i],V[0]);
            if(a1 < a2){
                mini++;
                int m[] = V[mini];
                V[mini] = V[i];
                V[i] = m;
            }
        }
        int m[] = V[mini];
        V[mini] = V[p];
        V[p] = m;
        return mini;
    }




}
