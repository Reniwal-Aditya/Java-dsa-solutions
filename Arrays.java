public class ArrayDSAProblems {

    // ========================================
    // PROBLEM 1: Two Sum
    // ========================================
    // Given an array of integers and a target, return indices of two numbers that add up to target
    
    public static int[] twoSum(int[] nums, int target) {
        // Using HashMap for O(n) time complexity
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        
        return new int[] {}; // No solution found
    }

    // ========================================
    // PROBLEM 2: Best Time to Buy and Sell Stock
    // ========================================
    // Find maximum profit from buying and selling stock once
    
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        
        return maxProfit;
    }

    // ========================================
    // PROBLEM 3: Contains Duplicate
    // ========================================
    // Check if array contains any duplicates
    
    public static boolean containsDuplicate(int[] nums) {
        java.util.HashSet<Integer> set = new java.util.HashSet<>();
        
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        
        return false;
    }

    // ========================================
    // PROBLEM 4: Maximum Subarray (Kadane's Algorithm)
    // ========================================
    // Find contiguous subarray with largest sum
    
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }

    // ========================================
    // PROBLEM 5: Product of Array Except Self
    // ========================================
    // Return array where output[i] equals product of all elements except nums[i]
    // Without using division and in O(n) time
    
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Calculate left products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // Calculate right products and multiply
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        
        return result;
    }

    // ========================================
    // MAIN METHOD - Test Cases
    // ========================================
    
    public static void main(String[] args) {
        System.out.println("===== ARRAY DSA PROBLEMS =====\n");
        
        // Test Problem 1: Two Sum
        System.out.println("1. TWO SUM");
        int[] nums1 = {2, 7, 11, 15};
        int target = 9;
        int[] result1 = twoSum(nums1, target);
        System.out.println("Input: [2, 7, 11, 15], Target: 9");
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]\n");
        
        // Test Problem 2: Best Time to Buy and Sell Stock
        System.out.println("2. BEST TIME TO BUY AND SELL STOCK");
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Input: [7, 1, 5, 3, 6, 4]");
        System.out.println("Output: " + maxProfit(prices) + "\n");
        
        // Test Problem 3: Contains Duplicate
        System.out.println("3. CONTAINS DUPLICATE");
        int[] nums3 = {1, 2, 3, 1};
        System.out.println("Input: [1, 2, 3, 1]");
        System.out.println("Output: " + containsDuplicate(nums3) + "\n");
        
        // Test Problem 4: Maximum Subarray
        System.out.println("4. MAXIMUM SUBARRAY");
        int[] nums4 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]");
        System.out.println("Output: " + maxSubArray(nums4) + "\n");
        
        // Test Problem 5: Product of Array Except Self
        System.out.println("5. PRODUCT OF ARRAY EXCEPT SELF");
        int[] nums5 = {1, 2, 3, 4};
        int[] result5 = productExceptSelf(nums5);
        System.out.println("Input: [1, 2, 3, 4]");
        System.out.print("Output: [");
        for (int i = 0; i < result5.length; i++) {
            System.out.print(result5[i]);
            if (i < result5.length - 1) System.out.print(", ");
        }
        System.out.println("]\n");
    }
}