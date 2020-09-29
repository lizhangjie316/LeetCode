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

```go
func minDepth(root *TreeNode) int {
    if root == nil {
        return 0
    }
    if root.Left == nil && root.Right == nil {
        return 1
    }
    minD := math.MaxInt32
    if root.Left != nil {
        minD = min(minDepth(root.Left), minD)
    }
    if root.Right != nil {
        minD = min(minDepth(root.Right), minD)
    }
    return minD + 1
}

func min(x, y int) int {
    if x < y {
        return x
    }
    return y
}
```

· https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/

```go
type Codec struct {
    l []string
}

func Constructor() Codec {
    return Codec{}    
}

func rserialize(root *TreeNode, str string) string {
    if root == nil {
        str += "null,"
    } else {
        str += strconv.Itoa(root.Val) + ","
        str = rserialize(root.Left, str)
        str = rserialize(root.Right, str)
    }
    return str
}

// Serializes a tree to a single string.
func (this *Codec) serialize(root *TreeNode) string {
    return rserialize(root, "")
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {
    l := strings.Split(data, ",")
    for i := 0; i < len(l); i++ {
        if l[i] != "" {
            this.l = append(this.l, l[i])
        }
    }
    return this.rdeserialize()
}

func (this *Codec) rdeserialize() *TreeNode {
    if this.l[0] == "null" {
        this.l = this.l[1:]
        return nil
    }

    val, _ := strconv.Atoi(this.l[0])
    root := &TreeNode{Val: val}
    this.l = this.l[1:]
    root.Left = this.rdeserialize()
    root.Right = this.rdeserialize()
    return root
}
```



## 课后作业

· https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
```go
func lowestCommonAncestor(root, p, q *model.TreeNode) *model.TreeNode {
	if root == nil || root == p || root == q {
		return root
	}
	left := lowestCommonAncestor(root.Left, p, q)
	right := lowestCommonAncestor(root.Right, p, q)
	if left == nil {
		return right
	}
	if right == nil {
		return left
	}
	return root
}
```

· https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

· https://leetcode-cn.com/problems/combinations/

· https://leetcode-cn.com/problems/permutations/

· https://leetcode-cn.com/problems/permutations-ii/