
public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
        int lengthA = A.length;
        int lengthB = B.length;
        double left = (double) FindKElement(A, 0, lengthA-1, B, 0, lengthB-1, (lengthA+lengthB+1)/2);
        if((lengthA+lengthB)%2==1)
            return left;
        else
        {
            double right = (double) FindKElement(A, 0, lengthA-1, B, 0, lengthB-1, (lengthA+lengthB)/2+1);
            return (left+right)/2;
        }
        
    }
    public int FindKElement(int A[], int ax, int ay, int B[], int bx, int by, int k)
    {
        if (ay < ax)
            return B[bx+k-1];
        if (by < bx)
            return A[ax+k-1];
        int midA = (ax+ay)/2;
        int midB = (bx+by)/2;
        int lengthA = ay-ax+1;
        int lengthB = by-bx+1;
        //int midlength = (lengthA+lengthB)/2;
        if (k <= midA-ax+midB-bx+1)
        {
            if (A[midA] < B[midB])
            {
                return FindKElement(A, ax, ay, B, bx, midB-1, k);
            }
            else
            {
                return FindKElement(A, ax, midA-1, B, bx, by, k);
            }
        }
        else
        {
            if (A[midA] < B[midB])
            {
                return FindKElement(A, midA+1, ay, B, bx, by, k-(midA+1-ax));
            }
            else
            {
                return FindKElement(A, ax, ay, B, midB+1, by, k-(midB+1-bx));
            }
        }
        
        
    }
}
