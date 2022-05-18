
/*Time Limit Exceeded Solution*/
class Solution {
    int min;
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0)
            return -1;
        min=Integer.MAX_VALUE;
        List<Integer> list=new ArrayList<>();
        helper(coins,amount,0,0,list);
        return min==Integer.MAX_VALUE?-1:min;
    }
    private void helper(int[] coins,int amount,int sum,int start,List<Integer> coinValues){
        if(sum>amount)
            return;
        if(sum==amount){
            min=Math.min(min,coinValues.size());
            return;
        }
        for(int i=start;i<coins.length;i++){
            coinValues.add(coins[i]);
            helper(coins,amount,sum+coins[i],i,coinValues);
            coinValues.remove(coinValues.size()-1);
        }
    }
}
