# 第07课丨递归、泛型递归、树的递归

## 实战题目

· https://leetcode-cn.com/problems/climbing-stairs/

```go
func climbStairs(n int) int {
    p := 0
	q := 0
	r := 1
	for i := 1; i <= n; i++ {
		p = q
		q = r
		r = p + q
	}
	return r
}
```

· https://leetcode-cn.com/problems/generate-parentheses/

```go
func generateParenthesis(n int) []string {
	Output := new([]string)
	_generate(0, 0, n, "", Output)
	return *Output
}

func _generate(left int, right int, max int, s string, Output *[]string){
	// 递归终止条件
	if left == right && left ==  max{
		*Output = append(*Output, s)
		return
	}
	// 递归主体
	if left < max{
		_generate(left+1, right, max, s + "(", Output)
	}
	if right < left{
		_generate(left, right+1,  max, s + ")", Output)
	}
}
```

· https://leetcode-cn.com/problems/invert-binary-tree/description/

· https://leetcode-cn.com/problems/validate-binary-search-tree

· https://leetcode-cn.com/problems/maximum-depth-of-binary-tree

· https://leetcode-cn.com/problems/minimum-depth-of-binary-tree

· https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/



## 课后作业

· https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/

· https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

· https://leetcode-cn.com/problems/combinations/

· https://leetcode-cn.com/problems/permutations/

· https://leetcode-cn.com/problems/permutations-ii/