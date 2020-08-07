# 1. 数据结构

[数组与字符串](https://leetcode-cn.com/leetbook/detail/array-and-string/)—>[队列和栈](https://leetcode-cn.com/leetbook/detail/queue-stack/)—>[链表](https://leetcode-cn.com/leetbook/detail/linked-list/) —> [二叉树](https://leetcode-cn.com/leetbook/detail/data-structure-binary-tree/)



**参考完成：**

- [labuladong的算法小抄 第二章数据结构系列](https://labuladong.gitbook.io/algo/)    [专栏地址](https://labuladong.gitbook.io/algo/)

- [CyC2018的Leetcode题解中的数据结构相关]([https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E7%9B%AE%E5%BD%95.md](https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode 题解 - 目录.md))

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
# python
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
# python
```

```go
// go
```

```javascript
//JavaScript
```

-  [ https://leetcode-cn.com/problems/two-sum/](https://leetcode-cn.com/problems/two-sum/)  (两数之和)

```java
//java
```

```python
# python
```

```go
// go
```

```javascript
//JavaScript
```

-  [https://leetcode-cn.com/problems/3sum/ ](https://leetcode-cn.com/problems/3sum/)(高频老题） 

```java
//java
class Solution {
    //数组中同一个元素不能使用两遍: 没有重复元素，且不能输出相同的下标。最终要返回两个下标
    public int[] twoSum(int[] nums, int target) {//对于返回下标的题可以考虑
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
```

```python
# python
```

```go
// go
```

```javascript
//JavaScript
```



# 3. Linked List 实战题目

· https://leetcode.com/problems/reverse-linked-list/

· https://leetcode.com/problems/swap-nodes-in-pairs

· https://leetcode.com/problems/linked-list-cycle  * 

· https://leetcode.com/problems/linked-list-cycle-ii

· https://leetcode.com/problems/reverse-nodes-in-k-group/

# 4. 课后作业

· https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

· https://leetcode-cn.com/problems/rotate-array/

· https://leetcode-cn.com/problems/merge-two-sorted-lists/

· https://leetcode-cn.com/problems/merge-sorted-array/

· https://leetcode-cn.com/problems/two-sum/

· https://leetcode-cn.com/problems/move-zeroes/

· https://leetcode-cn.com/problems/plus-one/