class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String[] arr=s.split("\\s+"); // It splits whenever it encounters a words
        StringBuilder sb=new StringBuilder();
        for(int i=arr.length-1;i>0;i--){
            sb.append(arr[i]+" ");
        }
        sb.append(arr[0]);
        //for(int i=0;i<arr.length;i++) System.out.println(arr[i]+" "+arr[i].length());
        return sb.toString();
    }
}
