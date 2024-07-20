public boolean isAnagram(String s, String t) {
    Map<Character,Integer> map1 = new HashMap<>();
    Map<Character,Integer> map2 = new HashMap<>();
    for (char c : s.toCharArray()) {
        map1.put(c, map1.getOrDefault(c, 0) + 1);
    }
    for (char c : t.toCharArray()) {
        map2.put(c, map2.getOrDefault(c, 0) + 1);
    }
    return map1.equals(map2);
}

public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        Integer n = map.get(target - nums[i]);
        if (null != n) {
            return new int[] {i, n};
        }
        map.put(nums[i], i);
    }
    return new int[]{};
}

public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
        }
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum < 0) {
                left += 1;
            } else if (sum > 0) {
                right -= 1; 
            } else {
                res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                while (left < right && nums[left] == nums[left + 1]) {
                    left += 1;
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right -= 1;
                }
                left += 1;
                right -= 1;
            }
        }
    }
    return res;
}