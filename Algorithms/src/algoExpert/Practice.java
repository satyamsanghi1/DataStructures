package algoExpert;

import java.util.ArrayList;

public class Practice {
///. Maximum Score from Performing Multiplication Operations
	public static void main(String[] args) { 

		int nums[]=new int[] {-5,-3,-3,-2,7,1};
		int multipliers[]=new int [] {-10,-5,3,4,6};

		int ans=maximumScore(nums, multipliers);
		System.out.println("ans "+ans);
	}
	public static int maximumScore(int[] nums, int[] multipliers) {

		ArrayList<Integer>list=new ArrayList<Integer>();

		for(int num:nums)
			list.add(num);

		int sum=0;


		int a=0;
		return helper(list,multipliers,0,0);

	}
	public static int helper(ArrayList<Integer>list,int []multipliers,int a,int sum)
	{
		while(list.size()>0 && a<multipliers.length)
		{
			int left=0;
			int right=list.size()-1;

			int leftSum=list.get(left)*multipliers[a];
			int rightSum=list.get(right)*multipliers[a];
			
			if(leftSum>0 && rightSum>0)
			{
				System.out.println("both positive leftSum "+leftSum+" rightSum "+rightSum+ "list "+list+" a "+a);
				  if(leftSum>rightSum)
	                {
	                    System.out.println("left "+leftSum);
	                    sum+=leftSum;
	                    list.remove(left);
	                }
	                else
	                {
	                    System.out.println("left "+rightSum);
	                    sum+=rightSum;
	                    list.remove(right);
	                }
				  a++;
				  continue;
			}
			int x=0;
			int y=0;

			System.out.println("here ");
			ArrayList<Integer>p=new ArrayList<Integer>(list);
			ArrayList<Integer>q=new ArrayList<Integer>(list);
			p.remove(0);
			q.remove(q.size()-1);
			System.out.println("P "+p);
			System.out.println("q "+q);
			System.out.println("-------p-------");
			x=helper(p,multipliers,a+1,sum);
			System.out.println("-------q-------");
			y=helper(q,multipliers,a+1,sum);

			if(x>y)
			{
				sum+=x;
				list=p;
			}
			else
			{
				sum+=y;
				list=q;
			}
			a++;
			System.out.println("_____________________");
		}


	



		return sum;

	}

}
