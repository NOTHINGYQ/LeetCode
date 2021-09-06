class Solution{
	//使用自定义排序，来使得字符串可以按照特定的顺序排
	public String minNumber(int[] nums){
		String[] strs = new String[nums.length];
		for(int i = 0; i < nums.length; i ++){
			strs[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(strs, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
		StringBuilder res = new StringBuilder();
		for(String s : strs){
			res.append(s);
		}
		return res.toString();
	}
}