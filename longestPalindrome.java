class Solution {
    
    public String longestPalindrome(String s) {
        int n= s.length();
        boolean[][] dp = new boolean[n][n];
        if(s==null||n==0){
            return "";
        }
        int f = 0;
        int l = 1;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){                
                dp[i][j] =false;
                if(i==j||s.charAt(j)==s.charAt(i)){
                    dp[i][j]=true;
                }
            }
        }
        System.out.println(dp[0][0]);
        int i=0;
        while(i<n){
            int j=0;int k=i;
            for(;j+1<n&&k<n&&k>0;j++,k++){
                boolean tmp =(s.charAt(j)==s.charAt(k));
                dp[j][k] = (tmp&dp[j+1][k-1]);
                //System.out.println(j+" "+ k+" :"+dp[j][k]);
                if(dp[j][k]){
                    f=j;
                    l=k+1;
                }
                
                
            }
            i++;
        }  
        
        return s.substring(f,l);
    }
}