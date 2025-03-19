// Permutations
class Solution {
    int MOD=1000000007;
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;
        long first=pow(5,even)%MOD;
        long second=pow(4,odd)%MOD;
        return (int)((first*second)%MOD);
    }
    long pow(long x,long y){
        if(y==0) return 1;
        long temp=pow(x,y/2);

        if(y%2==0){
            return (temp*temp)%MOD;
        }else{
            return (x*temp*temp)%MOD;
        }
    }
} 
// LogN
