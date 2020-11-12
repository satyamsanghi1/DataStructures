
public class StringPractice {

	
	public static int[] check()
	{
		int nums[]= {2, 7, 11, 15};
		int target=9;
		int arr[]=new int[2];
		for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                	arr[0]=i;
                	arr[1]=j;
                	return arr;
               
                }
            }
            
        }
		return null;
	}
	
	public static void main(String arg[])
	{

		System.out.println(check()[0]+","+check()[1]);
	}
}
