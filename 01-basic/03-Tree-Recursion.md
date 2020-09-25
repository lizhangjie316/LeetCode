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
```go
func invertTree(root *TreeNode) *TreeNode {
	invert(root)
	return root
}

func invert(node *TreeNode){
	if node == nil || (node.Left == nil && node.Right == nil){
		return
	}
	temp := node.Left
	node.Left = node.Right
	node.Right = temp
	invert(node.Left)
	invert(node.Right)
}
```

· https://leetcode-cn.com/problems/validate-binary-search-tree

```go
func isValidBST(root *TreeNode) bool {
	return helper(root, math.MinInt64, math.MaxInt64)
}

func helper(root *TreeNode, lower, upper int) bool {
	if root == nil {
		return true
	}
	if root.Val <= lower || root.Val >= upper {
		return false
	}
	return helper(root.Left, lower, root.Val) && helper(root.Right, root.Val, upper)
}
```

· https://leetcode-cn.com/problems/maximum-depth-of-binary-tree

```go
func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return max(maxDepth(root.Left), maxDepth(root.Right)) + 1
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
```
· https://leetcode-cn.com/problems/minimum-depth-of-binary-tree

· https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/



## 课后作业

· https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/

· https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

· https://leetcode-cn.com/problems/combinations/

· https://leetcode-cn.com/problems/permutations/

· https://leetcode-cn.com/problems/permutations-ii/