# 第06课丨树、二叉树、二叉搜索树

· https://leetcode-cn.com/problems/binary-tree-inorder-traversal/

```go
func inorderTraversal(root *TreeNode) []int {
	result := make([]int, 0)
	result = recursive(root, result)
	return result
}

func recursive(root *TreeNode, result []int) []int{
	if root != nil{
		result = recursive(root.Left, result)
		result = append(result, root.Val)
		result = recursive(root.Right, result)
	}
	return result
}
```

· https://leetcode-cn.com/problems/binary-tree-preorder-traversal/

```go
func preorderTraversal(root *TreeNode) []int {
    result := make([]int, 0)
	result = recursive(root, result)
	return result
}

func recursive(root *TreeNode, result []int) []int{
	if root != nil{
        result = append(result, root.Val)
		result = recursive(root.Left, result)
		result = recursive(root.Right, result)
	}
	return result
}
```

· https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/

```go
func postorder(root *Node) []int {
	result := make([]int, 0)
	result = recursive(root, result)
	return result
}

func recursive(root *Node, result []int) []int{
	if root != nil{
		for i := 0; i<len(root.Children); i++{
			result = recursive(root.Children[i], result)
		}
        result = append(result, root.Val)
	}
	return result
}
```

· [https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description)

```go
func preorder(root *Node) []int {
	result := make([]int, 0)
	result = recursive(root, result)
	return result
}

func recursive(root *Node, result []int) []int{
	if root != nil{
		result = append(result, root.Val)
		for i := 0; i<len(root.Children); i++{
			result = recursive(root.Children[i], result)
		}
	}
	return result
}
```

· https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/

```go
func levelOrder(root *Node) [][]int {
	if root == nil {
		return nil
	} else if root.Children == nil {
		return [][]int{{root.Val}}
	}
	result := make([][]int, 0)
	firstLevel := make([]*Node, 0)
	secondLevel := make([]*Node, 0)
	firstLevel = append(firstLevel, root)
	value := make([]int, 0)
	for len(firstLevel) != 0{
		temp := firstLevel[0]
		firstLevel = firstLevel[1:]
		value = append(value, temp.Val)
		if temp.Children != nil{
			secondLevel = append(secondLevel, temp.Children...)
		}
		if len(firstLevel) == 0{
			result = append(result, value)
			value = make([]int, 0)
			firstLevel = secondLevel
			secondLevel = make([]*Node, 0)
		}
	}
	return result
}
```