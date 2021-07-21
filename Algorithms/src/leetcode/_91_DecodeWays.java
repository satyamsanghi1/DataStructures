package leetcode;

//high complexity
// dynamic programming solution exists
public class _91_DecodeWays {
    static int count=0;
    public static void main(String[] args) {
        
        StringBuilder sb=new StringBuilder();
        String s="81323";

        helper(0,s,sb);
        System.out.println("count "+count);
    }
    public static void helper(int index,String s,StringBuilder sb)
    {
        
        if(index==s.length())
        {    
            System.out.println(sb);
            count++;
            return ;
        }
        if(s.charAt(index)=='0')
            return ;
            sb.append(s.charAt(index));
            sb.append(",");
        helper(index+1,s,sb);
        sb.delete(sb.length()-2,sb.length());
        int val=0;
        String sub="";
        if(index+1<s.length())
        {
            sub=s.substring(index,index+2);
          
            val=Integer.valueOf(sub);
            sub+=",";
        }
        if(val>0 && val<=26)
            {  
            sb.append(sub);
            helper(index+2,s,sb);
            sb.delete(sb.length()-3,sb.length());
            }
        else
            return ;
    }
}
