/* **************************************Question*******************************************
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * Assume that the total area is never beyond the maximum possible value of int.
 * Figure URL: https://leetcode.com/static/images/problemset/rectangle_area.png
 * *****************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2016-01-18
 * */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int width = 0;
        int height = 0;
        if(C-A<=G-E){
            width = getIntersection(A, C, E, G);
        }else{
            width = getIntersection(E, G, A, C);
        }
        if(D-B<=H-F){
            height = getIntersection(B, D, F, H);
        }else{
            height = getIntersection(F, H, B, D);
        }
        
        return (C-A)*(D-B)+(G-E)*(H-F)-(width * height);
    }
    
    public int getIntersection(int short1, int short2, int long1, int long2){
        if(short2 <= long1 || short1 >= long2){
            return 0;
        }
        if(short1 <= long1 && long1 <= short2){
            return short2-long1;
        }
        if(short1 <= long2 && long2 <= short2){
            return long2-short1;
        }
        if(long1 <= short1 && short2 <= long2){
            return short2-short1;
        }
        return 0;
    }
}
