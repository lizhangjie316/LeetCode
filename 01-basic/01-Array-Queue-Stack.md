# 1. 数据结构

[数组与字符串](https://leetcode-cn.com/leetbook/detail/array-and-string/)—>[队列和栈](https://leetcode-cn.com/leetbook/detail/queue-stack/)—>[链表](https://leetcode-cn.com/leetbook/detail/linked-list/) —> [二叉树](https://leetcode-cn.com/leetbook/detail/data-structure-binary-tree/)



**参考完成：**

- [labuladong的算法小抄 第二章数据结构系列](https://labuladong.gitbook.io/algo/)    [专栏地址](https://labuladong.gitbook.io/algo/)
- [CyC2018题解目录](https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode 题解 - 目录.md)

- [Java算法4红宝书]()

  

outliers：异类，不一样的成功启示录

chunk it up:

<img src="https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200803163250.png"/>

![image-20200803163228595](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200803163228.png)



![image-20200803180538350 ](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200803180538.png)



![image-20200803180757106](C:%5CUsers%5CKeen%5CAppData%5CRoaming%5CTypora%5Ctypora-user-images%5Cimage-20200803180757106.png)

![image-20200803195314737](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200803195314.png)

![image-20200803195341109](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200803195341.png)

![image-20200803195749849](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200803195749.png)

 递归求时间复杂度：主定理法

![image-20200803200945933](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200803200946.png)

![image-20200803201109401](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200803201109.png)

o(n)

Array：

![image-20200804111008506](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200804111008.png)

List：

![image-20200804110947626](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200804110947.png)

Skip List: 在redis中应用， 对链表进行加速

链表加速：升维，空间换时间。

![image-20200804111048552](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200804111048.png)

![image-20200804111102276](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200804111102.png)

时间复杂度：O(logn)

空间复杂度：O（n）



- [Java 源码分析（ArrayList）](http://developer.classpath.org/doc/java/util/ArrayList-source.html)
- [Linked List 的标准实现代码](http://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/)
- [Linked List 示例代码](http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked Lists/code/LinkedList.java)
- [Java 源码分析（LinkedList）](http://developer.classpath.org/doc/java/util/LinkedList-source.html)
- LRU Cache - Linked list：[ LRU 缓存机制](http://leetcode-cn.com/problems/lru-cache)   [LRU缓存算法-简书](https://www.jianshu.com/p/b1ab4a170c3c)
- Redis - Skip List：[跳跃表](http://redisbook.readthedocs.io/en/latest/internal-datastruct/skiplist.html)、[为啥 Redis 使用跳表（Skip List）而不是使用 Red-Black？](http://www.zhihu.com/question/20202931)



# 2. Array 实战题目

-  https://leetcode-cn.com/problems/container-with-most-water/   （最大水面积）


```java
class Solution { //java实现
    public int maxArea(int[] height) {
        //最大水容量，双指针
        if (height == null || height.length==0) {
            return 0;
        }
        int max_area = 0;
        int area = 0;
        int j = height.length-1;
        for (int i = 0; i < j; i++) {//当不考虑i逐步递进时，可以考虑使用while循环！！！
            //i指头，j指尾
            area = (j-i) * Math.min(height[i],height[j]);
            //前边的大，则后边指针j前移
            if (height[i]>=height[j]) {
                i--; //保证i指针不后移
                j--; //确保j指针向前移
            }
            max_area = Math.max(max_area, area);

        }

        return max_area;
    }
}
```

```python
//python
class Solution:
    def maxArea(self, height: List[int]) -> int:
        s1_index, s2_index, res = 0, len(height) - 1, 0
        while s1_index < s2_index:
            if height[s1_index] < height[s2_index]:
                res = max(res, height[s1_index] * (s2_index - s1_index))
                s1_index += 1
            else:
                res = max(res, height[s2_index] * (s2_index - s1_index))
                s2_index -= 1
        return res
```

```go
// go
func maxArea(height []int) int {
	if len(height) == 0{
		return 0
	}
	i := 0
	j := len(height) - 1
	ans := 0
	for i < j{
		area := min(height[i], height[j]) * (j - i)
		ans = max(ans, area)
		if height[i] <= height[j]{
			i += 1
		}else{
			j -= 1
		}
	}
	return ans
}

func min(a, b int) int{
	if a < b{
		return a
	}
	return b
}

func max(a, b int) int{
	if a > b{
		return a
	}
	return b
}
```


-  https://leetcode-cn.com/problems/move-zeroes/

```java
//java
class Solution {
    public void moveZeroes(int[] nums)  {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < length; i++) {
            //i进行后续探索，j进行延后的定位，始终指向下一个存储位置
            if (nums[i] != 0) {//非0，则进行交换
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
```

```python
// python 列表操作
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        a1 = [] #   记录非0元素
        a2 = [] #   记录为0的元素
        for i in nums:  #   遍历list
            if i == 0:
                a2.append(i)    #   将为0的元素添加到a2
            else:
                a1.append(i)    #   将非0元素添加到a1
        nums.clear()    #   清空原列表
        nums.extend(a1 + a2)    #   将两个列表合并到nums中
// 双指针法
    def moveZeroes_1(self, nums):
            """
            :type nums: List[int]
            :rtype: None Do not return anything, modify nums in-place instead.
            """
            if not nums:
                return 0
            # 第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
            j = 0
            for i in range(len(nums)):
                if nums[i]:
                    nums[j] = nums[i]
                    j += 1
            # 非0元素统计完了，剩下的都是0了
            # 所以第二次遍历把末尾的元素都赋为0即可
            for i in range(j,len(nums)):
                nums[i] = 0

```

```go
// go
func moveZeroes(nums []int)  {
	if len(nums) < 2 {
		return
	}

	last := -1
	for i, n := range nums {
		if n == 0 && last == -1 {
			last = i
		}
		if n != 0 && last != -1 {
			nums[last], nums[i] = nums[i], nums[last]
			last++
		}
	}
}
```

```javascript
//JavaScript
```

-  https://leetcode.com/problems/climbing-stairs/

```java
//java
class Solution {  //斐波那契数列
    protected int climbStairs(int n) {
        int f1 = 1;
        int f2 = 2;
        int f3 = 0;
        if (1==n){
            return f1;
        }else if (2==n){
            return f2;
        }
        for (int i = 2; i < n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }

        return f2;
    }
}
```

```python
class Solution:
    def climbStairs(self, n: int) -> int:
        reslut =  list(range(n+1))
        for i in range(1,n+1):
            if i == 1:
                reslut[i] = 1
            elif i == 2:
                reslut[i] = 2
            else: reslut[i] = reslut[i-1] + reslut[i-2]
        return reslut[-1]
# python
```

```go
// go
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

```javascript
//JavaScript
```

-  [https://leetcode-cn.com/problems/two-sum/](https://leetcode-cn.com/problems/two-sum/)  (两数之和)

```java
//java
class Solution {
    //数组中同一个元素不能使用两遍: 没有重复元素，且不能输出相同的下标。最终要返回两个下标
    public int[] twoSum(int[] nums, int target) {//对于返回下标的题可以考虑HashMap
        if (nums == null || nums.length == 0){
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>(); //存储nums[i],i
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp = target-nums[i];
            if (map.containsKey(tmp)){
                return new int[]{i,map.get(tmp)};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
class Solution3 { //66ms 39.9M
    //数组中同一个元素不能使用两遍: 没有重复元素，且不能输出相同的下标。最终要返回两个下标
    public int[] twoSum(int[] nums, int target) {//对于返回下标的题可以考虑
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        int[] arr = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
            
        }

        return new int[0];
    }
}
```

```python
# python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        for ind, num in enumerate(nums):    # 生成字典
            hashmap[num] = ind

        for i, num in enumerate(nums):
            j = hashmap.get(target - num)  # 获取指定键值
            if j is not None and i != j and i < j:  # 如果j不为空且i和j不相等且i小于j
                return [i, j]   # 返回和为target的索引
```

```go
// go
func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for i, v := range nums {
		if j, ok := m[target - v]; ok && i != j {
			return []int{i, j}
		}
		m[v] = i
	}
	return []int{}
}
```

```javascript
//JavaScript
```

-  [https://leetcode-cn.com/problems/3sum/ ](https://leetcode-cn.com/problems/3sum/)(高频老题） 

```java
//java
class Solution4 {
    public List<List<Integer>> threeSum(int[] nums) {
        //注意：答案中不可以包含重复的三元组。需要排序处理
        //非返回索引，可以排序
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length<3) {
            return lists;
        }
        Arrays.sort(nums);


        //法1：暴力求解
        /*HashSet<List<Integer>> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        hashSet.add(list);
                    }
                }
            }
        }
        for (List<Integer> list: hashSet) {
            lists.add(list);
        }*/
        //法2：三指针
        for (int i = 0; i < nums.length; i++) {
            //判断首位，首位大于0，则没有满足的
            if (nums[i] > 0) {
                break;
            }
            //
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int L = i+1;
            int R = nums.length-1;
            while (L< R){
                //进行判断
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0){
                    lists.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    //分别去重
                    while(L<R && nums[L]==nums[L+1]) L++;
                    while (R>L && nums[R]==nums[R-1]) R--;
                    //去重之后，再移一位
                    L++;
                    R--;
                }else if (sum < 0){
                    L++;
                }else if (sum>0){
                    R--;
                }
            }
        }
        return lists;
    }
}
```

```python
# python
class Solution:
    '''
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        
        # 基于两数之和改编的方法，会超出限制。
        # :param nums:
        # :return:
        
        nums.sort()  # 排序
        hashmap = {}
        for ind, num in enumerate(nums):  # 生成字典
            hashmap[num] = ind
        result = []
        for i, num in enumerate(nums):
            for j, num1 in enumerate(nums):
                k = hashmap.get(0 - num - num1)  # 获取指定键值
                if k is not None and i != j and i < j and i != k and j != k and j < k:  # 如果j不为空且i和j不相等且i小于j
                    cur_res = [num, num1, nums[k]]
                    if cur_res not in result:
                        result.append(cur_res)  # 返回和为target的索引
                    else:
                        pass
        return result
        '''
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        if len(nums) < 3:   #   当nums中元素小于3时，直接返回空值。
            return []
        '''先对数组排序, 遍历数组遇到与前一个元素相同的情况可直接跳过'''
        nums.sort()
        curr_hash = {-x: i for i, x in enumerate(nums)}
        res = []
        res_hash = {}
        for i, first in enumerate(nums):
            '''当前元素与前一个元素相同时, 可直接跳过以优化性能'''
            if i > 0 and first == nums[i - 1]:
                continue
            for j, second in enumerate(nums[i + 1:]):
                '''检查两数之和是否存在于哈希表中'''
                if first + second in curr_hash:
                    curr_index = curr_hash[first + second]
                    if curr_index == i or curr_index == i + j + 1:
                        continue
                    '''将找到的结果存入另一个哈希表中, 避免包含重复结果'''
                    row = sorted([first, second, nums[curr_index]])
                    key = ",".join([str(x) for x in row])
                    if key not in res_hash:
                        res.append(row)
                        res_hash[key] = True
        return res

```

```go
// go
import "sort"

func threeSum(nums []int) [][]int {
	length := len(nums)
	if length < 3 {
		return nil
	}
	sort.Ints(nums)

	result := [][]int{}
	for i := 0; i < length-2; i++ {
		for i != 0 && nums[i] == nums[i-1] && i < length-2 {
			i++
		}
		target := 0 - nums[i]
		l := i + 1
		r := length - 1
		for l < r {
			if nums[l]+nums[r] == target {
				result = append(result, []int{nums[i], nums[l], nums[r]})
				l++
				r--
				for nums[l] == nums[l-1] && nums[r] == nums[r+1] && l < r {
					l++
					r--
				}
			} else if nums[l]+nums[r] < target {
				l++
				for nums[l] == nums[l-1] && l < r {
					l++
				}
			} else {
				r--
				for nums[r] == nums[r+1] && l < r {
					r--
				}
			}
		}
	}
	return result
}

```

```javascript
//JavaScript
```



# 3. Linked List 实战题目

· https://leetcode.com/problems/reverse-linked-list/


```java
class Solution {//画个图就出来了
    public ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null){
            ListNode tmp = pre.next; //探索者
            pre.next = cur;
            cur = pre;
            pre = tmp;
        }
        return cur;
    }
}

//递归的方式
```

```python
#python

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        pre = None
        cur = head
        while cur:
            temp = cur.next   # 先把原来cur.next位置存起来
            cur.next = pre
            pre = cur
            cur = temp
        return pre
```


```go
//go
func reverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	slow, fast := head, head.Next
	for fast != nil {
		tmp := fast.Next
		fast.Next = slow
		slow = fast
		fast = tmp
	}
	head.Next = nil
	return slow
}

```

· https://leetcode.com/problems/swap-nodes-in-pairs

```java
class Solution1 {
    //交换相邻的两个
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }
        //确保有两个节点了
        ListNode cur = head;
        ListNode pre = cur.next;
        ListNode back = null;
        head = cur.next;
        //返回的头已经确定
        while (cur!=null || pre!=null){
            //交换
            cur.next = pre.next;
            pre.next = cur;
            if (cur.next == null || cur.next.next==null){
                break;
            }else {//cur往前走了，但原本的cur.next无法连到下一轮的上面
                //能进到这里面说明是偶数个，需要进行偶奇相连，用back.next来提前连接好
                back = cur;
                cur = cur.next;
                pre = cur.next;
                back.next = pre;
            }
        }

        return head;
    }
}
```




```go
//go
func swapPairs(head *ListNode) *ListNode {
	if head == nil || head.Next == nil{
		return head
	}
	newHead := &ListNode{}
	newHead.Next = head
	h := newHead
	p := head
	q := head.Next
	for q != nil{
		p.Next = q.Next
		q.Next = p
		h.Next = q
		h = p
		p = p.Next
		if p == nil{
			break
		}
		q = p.Next
	}
	return newHead.Next
}
```

· https://leetcode.com/problems/linked-list-cycle  

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        HashSet<ListNode> hashSet = new HashSet<>();

        while (hashSet.add(head)){
            head = head.next;
            if (head == null){
                return false;
            }
        }

        return true;
    }
}
```



```go
//go
func hasCycle(head *ListNode) bool {
	if head == nil{
		return false
	}
	slow := head
	fast := head.Next
	for fast != nil && fast.Next != nil{
		if slow == fast{
			return true
		}
		slow = slow.Next
		fast = fast.Next.Next
	}
	return false
}
```

· https://leetcode.com/problems/linked-list-cycle-ii

```java
class Solution2 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
```



```go
//go
func detectCycle(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return nil
	}
	slow, fast := head, head

	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast {
			break
		}
	}
	if fast == nil || fast.Next == nil {
		return nil
	}
	tmp := head
	for tmp != slow {
		tmp = tmp.Next
		slow = slow.Next
	}
	return slow
}
```

· https://leetcode.com/problems/reverse-nodes-in-k-group/

```go
//go
func reverseKGroup(head *ListNode, k int) *ListNode {
	hair := &ListNode{Next: head}
	pre := hair

	for head != nil {
		tail := pre
		for i := 0; i < k; i++ {
			tail = tail.Next
			if tail == nil {
				return hair.Next
			}
		}
		nex := tail.Next
		head, tail = myReverse(head, tail)
		pre.Next = head
		tail.Next = nex
		pre = tail
		head = tail.Next
	}
	return hair.Next
}

func myReverse(head, tail *ListNode) (*ListNode, *ListNode) {
	prev := tail.Next
	p := head
	for prev != tail {
		nex := p.Next
		p.Next = prev
		prev = p
		p = nex
	}
	return tail, head
}
```

# 4. 课后作业

· https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

```go
//go
location := 1
    ll := len(nums)
    for i := 1;i < ll; i++ {
        if nums[i] == nums[i - 1]{
            continue
        } 
        nums[location] = nums[i]
        location++
    }
    return location
```

· https://leetcode-cn.com/problems/rotate-array/

```go
//go
func rotate(nums []int, k int)  {
	if nums == nil || len(nums) == 0{
		return
	}
	length := len(nums)
	k %= k % length
	reverse(nums, 0, length - k - 1)
	
	reverse(nums, length - k - 1, length - 1)
	reverse(nums, 0 , length - 1)
}

func reverse(nums []int, i, j int){
	for i < j{
		nums[i], nums[j] = nums[j], nums[i]
		i++
		j--
	}
}
```

· https://leetcode-cn.com/problems/merge-two-sorted-lists/


```go
//go
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
    head := &ListNode{}
	
	p := head
	for l1 != nil && l2 != nil{
		if l1.Val <= l2.Val{
			p.Next = l1
			l1 = l1.Next
		}else{
			p.Next = l2
			l2 = l2.Next
		}
		p = p.Next
	}
	if l1 == nil{
		p.Next = l2
	}else{
		p.Next = l1
	}
	return head.Next
}
```

· https://leetcode-cn.com/problems/merge-sorted-array/

```go
//go
func merge(nums1 []int, m int, nums2 []int, n int) {
	k := m + n
	for i := k - 1; i >= 0; i-- {
		if n == 0 {
			break
		}
		if m > 0 && nums1[m-1] > nums2[n-1] {
			nums1[i] = nums1[m-1]
			m--
		} else {
			nums1[i] = nums2[n-1]
			n--
		}
	}
}
```

· https://leetcode-cn.com/problems/two-sum/

· https://leetcode-cn.com/problems/move-zeroes/

· https://leetcode-cn.com/problems/plus-one/