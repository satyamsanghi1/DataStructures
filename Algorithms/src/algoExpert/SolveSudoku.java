package algoExpert;

import java.util.ArrayList;

public class SolveSudoku {

	public static void main(String[] args) {

	}
	public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
		// Write your code here.
		helper(board,0,0);
		return new ArrayList<ArrayList<Integer>>();
	}

	public boolean helper(ArrayList<ArrayList<Integer>> board,int row,int col)
	{
		int currentRow=row;
		int currentCol=col;
	       if(currentCol==9)
				 {
					 currentRow++;
					 currentCol=0;
					 ///when reached end of board , board is solved
					 if(currentRow==board.size())
						 return true;
				 }
		
		if(board.get(currentRow).get(currentCol)==0)
		{
			for(int i=1;i<=9;i++)
			{
				if(isValid(board,currentRow,currentCol,i))
				{
					board.get(currentRow).set(currentCol,i);
						if(helper(board,currentRow,currentCol+1))
							return true;
				}
			}
			//return false when all the values are tried at a location
			board.get(currentRow).set(currentCol,0);
				return false;
		}
		else
		{
			return helper(board,currentRow,currentCol+1);
		}
	}
	public boolean isValid(ArrayList<ArrayList<Integer>> board,int row,int col,int value)
	{
		//checking in row
		for(int i=0;i<board.get(0).size();i++)
		{
			if(value==board.get(row).get(i))
				return false;
		}
		
		//checking in column
			for(int i=0;i<board.size();i++)
		{
			if(value==board.get(i).get(col))
				return false;
		}
		
		//checking in current submatrix
		int a=row/3;
		int b=col/3;
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				int x=a*3+i;
				int y=b*3+j;
				if(board.get(x).get(y)==value)
					return false;
			}
		}
		return true;
	}

}
