/* **************************************Question*********************************************
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * *******************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-10-26
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 * */
public class Solution {
    
    public String hash(Point p1, Point p2){
        StringBuilder sb = new StringBuilder();
        if (p1.x == p2.x) {
            sb.append("inf").append(p1.x);
        } else {
            double k = (double)(p1.y - p2.y) / (p1.x - p2.x);
            double d = p1.y - k * p1.x;
            sb.append("k").append(k).append("d").append(d);
        }
        return sb.toString();
    }
    
    public int maxPoints(Point[] points) {
        if (points == null || points.length < 1){
            return 0;
        }
        int len = points.length;
        int result = 1;
        Map<String, Set<Point>> mp = new HashMap<>();
        Collections.sort(Arrays.asList(points), (Point a, Point b) -> a.x - b.x);

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                Point p1 = points[i];
                Point p2 = points[j];
                String key = hash(p1, p2);
                Set<Point> st = mp.containsKey(key) ? mp.get(key) : new HashSet<>();
                st.add(p1);
                st.add(p2);
                mp.put(key, st);
                result = Math.max(result, st.size());
            }
        }
        return result;
    }
}
