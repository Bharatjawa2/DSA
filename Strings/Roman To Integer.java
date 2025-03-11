class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> roman=new HashMap<>();
        roman.put('I',1);
        roman.put('V',5);
        roman.put('X',10);
        roman.put('L',50);
        roman.put('C',100);
        roman.put('D',500);
        roman.put('M',1000);

        int res=0;
        for(int i=0;i<s.length();i++){
            int x=roman.get(s.charAt(i));
            if(i+1<s.length() && roman.get(s.charAt(i+1))>x){
                res-=x;
            }else{
                res+=x;
            }
        }
        return res;
    }
}
