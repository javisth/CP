    /* 
    An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) is the coordinate of its bottom-left corner, and (x2, y2) is the coordinate of its top-right corner. Its top and bottom edges are parallel to the X-axis, and its left and right edges are parallel to the Y-axis.

Two rectangles overlap if the area of their intersection is positive. To be clear, two rectangles that only touch at the corner or edges do not overlap.

Given two axis-aligned rectangles rec1 and rec2, return true if they overlap, otherwise return false.
*/



    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int r1x1 = rec1[0], r1y1 = rec1[1], r1x2=rec1[2], r1y2 = rec1[3];
        int r2x1 = rec2[0], r2y1 = rec2[1], r2x2=rec2[2], r2y2 = rec2[3];
		//doens't intersect from horizontal perspective,  Rec1 on the left side of Rec2 OR Rec1 on the right side of Rec2
        if(r1x2<=r2x1 || r1x1>=r2x2) 
            return false;
		//doens't intersect from vertical perspective, Rec1 on the lower side of Rec2 OR Rec1 on the upper side of Rec2
        if(r1y2<=r2y1 || r1y1>=r2y2) 
            return false;
        return true;    
    }