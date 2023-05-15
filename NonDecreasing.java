/* You are given a 0-indexed integer array nums. In one step, remove all elements nums[i] where nums[i - 1] > nums[i]
for all 0 < i < nums.length. Return the number of steps performed until nums becomes a non-decreasing array.
* Eg 1 : nums = [5,3,4,7,3,6,11,8,5,11]              Output = 3
* Eg 2 : nums = [4,5,7,7,13]                         Output = 0
*/
import java.util.*;
public class NonDecreasing
{
      public int MinimumStepsToAscending(int nums[])
      {
            int DP[] = new int[nums.length];     //*  DP Array -> O(N)
            Stack<Integer> stack = new Stack<Integer>();     //*  Stack -> O(1)
            int value = 0, i = 1;
            DP[0] = 0;      // base value...
            stack.push(nums[0]); 
            while(i != nums.length)     //! Comparison -> O(N)
            {
                  if(nums[i] < stack.peek())
                  {     // if number is lower, we need +1 steps to remove the element...
                        value++;
                        DP[i] = value;    // Storing the value in DP array...
                  }
                  else if(nums[i] >= stack.peek())
                  {     // If number is not lower, we update the stack and the counter variable...
                        stack.pop();
                        stack.push(nums[i]);
                        value = 0;
                        DP[i] = value;
                  }
                  i++;
            }
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < DP.length; j++)    //! Comparison -> O(N)
                  max = Math.max(max, DP[j]);    // Extracting the maximum steps...
            return max = (max == 0) ? max : max + 1;     // Ternary return statement...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter number of elements in the array : ");
            x = sc.nextInt();
            int array[] = new int[x];
            for(int i = 0; i < array.length; i++)
            {
                  System.out.print("Enter number : ");
                  array[i] = sc.nextInt();
            }
            NonDecreasing nondecreasing = new NonDecreasing();     // Object creation...
            System.out.println("The Minimum Steps : "+nondecreasing.MinimumStepsToAscending(array));
            sc.close();
      }
}



//! Time Complexity -> O(N)
//* Space Complexity -> O(N)

/** //? DEDUCTIONS -
 * ? Generate the DP array to store the steps required to remove the element, if not possible then place 0...
 * ? We then take the maximum of the DP array value and take care of the base conditions...
 */