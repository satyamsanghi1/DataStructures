package dynamcProgramming;

public class PaintHouseI {
	
	/*
	 * There are a row of n houses, each house can be painted with one of the three colors:
	 *  red, blue or green. The cost of painting each house with a certain color is different. 
	 *  You have to paint all the houses such that no two adjacent houses have the same color,
	 *   and you need to cost the least. Return the minimum cost.

	The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 	For example, costs[0][0] is the cost of painting house 0 with color red; 
 	costs[1][2] is the cost of painting house 1 with color green, and so on...
  	Find the minimum cost to paint all houses.
	 */
	public static void main(String[] args) {
		
		int costs[][]= {{14,2,11},{11,14,5},{14,3,10}};
		
		minCost(costs);
	}
	
	public static int minCost(int[][] costs) {
        // write your code here
		
		return 0;
    }

}
