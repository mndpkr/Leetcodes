//223. Rectangle Area
//Runtime: 2 ms, faster than 100.00% of Java online submissions for Rectangle Area.
//Memory Usage: 38.6 MB, less than 28.11% of Java online submissions for Rectangle Area.

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {        
         int a1 = (C-A)*(D-B);
        int a2 = (G-E)*(H-F);
        if(a1==0)
            return a2;
        else if(a2 ==0)
            return a1;
        else{
            int area,x1,x2,y1,y2;
            x1=x2=y1=y2=0;
            if(E<=A && A<G){
                x1=A;
                if(E<=C && C<G)
                    x2=C;
                else
                    x2=G;
            } 
            else if(E<=C && C<G){
                x1=E;
                x2=C;
            }
            else if(A<=E && E<C){
                x1=E;
                if(A<G && G<=C)
                    x2=G;
                else
                    x2=C;
            } 
            else if(A<G && G<=C){
                x1=A;
                x2=G;
            }
            else{
                return a1+a2;
            }
            
           if(F<=B && B<H){
                y1=B;
                if(D<=H)
                    y2=D;
                else
                    y2=H;
            } 
            else if(F<D && D<=H){
                y1=F;
                y2=D;
            }
            else if(B<=F && F<D){
                y1=F;
                if(H<=D)
                    y2=H;
                else
                    y2=D;
            } 
            else if(B<H && H<=D){
                y1=B;
                y2=H;
            }
            area = Math.abs(x2-x1)*Math.abs(y2-y1);
            return a1+a2-area;  
        }          
    }
}
