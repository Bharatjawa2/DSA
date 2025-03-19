class Solution {
    public double myPow(double x, int n) {
        int nn=n;
        if(n<0) nn=-1*nn;
        double ans=pow(x,nn);
        if(n<0) return (double)1.0/(double)ans;
        return ans;
    }
    double pow(double a,int b){
        if(b==0) return 1;
        double temp=pow(a,b/2);

        if(b%2==0){
            return (temp*temp);
        }else{
            return (a*temp*temp);
        }
    }
}

/ LogN
