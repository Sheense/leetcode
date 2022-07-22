package sheen.leetcode.math;

public class 矩形面积 {
    public static void main(String[] args) {
        矩形面积 s = new 矩形面积();
        System.out.println(s.computeArea(-1500000001, 0,-1500000000,1,1500000000, 0,1500000001,1));
    }
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (D-B)*(C-A);
        int area2 = (G-E)*(H-F);
        if(A<=E&&C>=G&&B<=F&&D>=H) {
            return area1;
        }
        if(E<=A&&C<=G&&B>=F&&D<=H) {
            return area2;
        }
        long width = (long)Math.max(C,G)-Math.min(A, E);
        long height =(long)Math.max(D,H)-Math.min(B, F);
        if((width>=((long)C-A)+((long)G-E))||(height>=((long)D-B)+((long)H-F))){
            return area1 + area2;
        }

        if(C<G) {
            if(A>E) {
                int w = C-A;
                if(D<H) {
                    if(B>F) {
                        return (area1+area2) - w*(D-B);
                    }else {
                        return (area1+area2) - w*(D-F);
                    }
                }else {
                    if(B>F) {
                        return (area1+area2) - w*(H-B);
                    }else {
                        return (area1+area2) - w*(H-F);
                    }
                }
            }else {
                int w = C-E;
                if(D<H) {
                    if(B>F) {
                        return (area1+area2) - w*(D-B);
                    }else {
                        return (area1+area2) - w*(D-F);
                    }
                }else {
                    if(B>F) {
                        return (area1+area2) - w*(H-B);
                    }else {
                        return (area1+area2) - w*(H-F);
                    }
                }
            }
        }else {
            if(A<E) {
                int w = G - E;
                if(D<H) {
                    if(B>F) {
                        return (area1+area2) - w*(D-B);
                    }else {
                        return (area1+area2) - w*(D-F);
                    }
                }else {
                    if(B>F) {
                        return (area1+area2) - w*(H-B);
                    }else {
                        return (area1+area2) - w*(H-F);
                    }
                }
            }else {
                int w = G-A;
                if(D<H) {
                    if(B>F) {
                        return (area1+area2) - w*(D-B);
                    }else {
                        return (area1+area2) - w*(D-F);
                    }
                }else {
                    if(B>F) {
                        return (area1+area2) - w*(H-B);
                    }else {
                        return (area1+area2) - w*(H-F);
                    }
                }
            }
        }
    }
}
