public class strings {

    // ========================================
    // PROBLEM 1: Valid Anagram
    // ========================================
    // Check if two strings are anagrams of each other
    
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] charCount = new int[26]; // For lowercase letters
        
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }
        
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }

    // ========================================
    // PROBLEM 2: Valid Palindrome
    // ========================================
    // Check if string is a palindrome (ignoring non-alphanumeric characters and case)
    
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }

    // ========================================
    // PROBLEM 3: Longest Substring Without Repeating Characters
    // ========================================
    // Find length of longest substring without repeating characters
    
    public static int lengthOfLongestSubstring(String s) {
        java.util.HashMap<Character, Integer> map = new java.util.HashMap<>();
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If character is already in map and within current window
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                left = map.get(currentChar) + 1;
            }
            
            map.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    // ========================================
    // PROBLEM 4: Group Anagrams
    // ========================================
    // Group strings that are anagrams of each other
    
    public static java.util.List<java.util.List<String>> groupAnagrams(String[] strs) {
        java.util.HashMap<String, java.util.List<String>> map = new java.util.HashMap<>();
        
        for (String str : strs) {
            // Sort the string to use as key
            char[] chars = str.toCharArray();
            java.util.Arrays.sort(chars);
            String sortedStr = new String(chars);
            
            // Add to corresponding group
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new java.util.ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        
        return new java.util.ArrayList<>(map.values());
    }

    // ========================================
    // PROBLEM 5: Longest Palindromic Substring
    // ========================================
    // Find the longest palindromic substring
    
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Check for odd length palindromes (center is single character)
            int len1 = expandAroundCenter(s, i, i);
            // Check for even length palindromes (center is between two characters)
            int len2 = expandAroundCenter(s, i, i + 1);
            
            int maxLen = Math.max(len1, len2);
            
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    // ========================================
    // MAIN METHOD - Test Cases
    // ========================================
    
    public static void main(String[] args) {
        System.out.println("===== STRING DSA PROBLEMS =====\n");
        
        // Test Problem 1: Valid Anagram
        System.out.println("1. VALID ANAGRAM");
        String s1 = "anagram", t1 = "nagaram";
        System.out.println("Input: s = \"" + s1 + "\", t = \"" + t1 + "\"");
        System.out.println("Output: " + isAnagram(s1, t1) + "\n");
        
        // Test Problem 2: Valid Palindrome
        System.out.println("2. VALID PALINDROME");
        String s2 = "A man, a plan, a canal: Panama";
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Output: " + isPalindrome(s2) + "\n");
        
        // Test Problem 3: Longest Substring Without Repeating Characters
        System.out.println("3. LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS");
        String s3 = "abcabcbb";
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s3) + "\n");
        
        // Test Problem 4: Group Anagrams
        System.out.println("4. GROUP ANAGRAMS");
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.print("Input: [");
        for (int i = 0; i < strs.length; i++) {
            System.out.print("\"" + strs[i] + "\"");
            if (i < strs.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        java.util.List<java.util.List<String>> grouped = groupAnagrams(strs);
        System.out.println("Output: " + grouped + "\n");
        
        // Test Problem 5: Longest Palindromic Substring
        System.out.println("5. LONGEST PALINDROMIC SUBSTRING");
        String s5 = "babad";
        System.out.println("Input: \"" + s5 + "\"");
        System.out.println("Output: \"" + longestPalindrome(s5) + "\"\n");
        
        // Additional test for Problem 5
        String s5b = "cbbd";
        System.out.println("Input: \"" + s5b + "\"");
        System.out.println("Output: \"" + longestPalindrome(s5b) + "\"\n");
    }
}