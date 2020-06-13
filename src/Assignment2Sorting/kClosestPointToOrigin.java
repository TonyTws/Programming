package Assignment2Sorting;
import java.util.Arrays;
import java.util.Comparator;

public class kClosestPointToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        Points[] point = new Points[points.length];
        for (int i = 0; i < points.length; i++) {
            int dist = (int) (Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            point[i] = new Points(i,dist);
        }
        Arrays.sort(point, new Comparator<Points>() {
            @Override
            public int compare(Points o1, Points o2) {
                if(o1.distance == o2.distance){
                    return o1.position - o2.position;
                }else{
                    return  o1.distance - o2.distance;
                }
            }
        });


        int ans[][] = new int[K][2];
        for (int i = 0; i < K ; i++) {
            ans[i][0]=points[point[i].position][0];
            ans[i][1]=points[point[i].position][1];
        }
        return ans;
    }
}

class Points {
    int position;
    int distance;

    public Points(int position, int distance) {
        this.position = position;
        this.distance = distance;
    }
}
