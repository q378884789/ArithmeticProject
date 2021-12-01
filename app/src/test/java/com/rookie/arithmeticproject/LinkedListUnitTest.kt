package com.rookie.arithmeticproject

import org.junit.Test

/**
 * 描叙： 将链表进行升序排列
 * 链表规则： 基数节点升序排列，偶数节点降序排列，如下：
 * 1->11->2->10->3->9->4->8->5->7->6->6->7->5->8->4
 *
 * 思想以及步骤：
 *  a、先使用构建数组，对链表进行初始化
 *  b、对基数部分，与偶数部分链表进行拆分为2个arrayList
 *  c、对偶数部分进行升序排列
 *  d、重新合并2个ArrayList，生成新的LinkList
 */
class LinkedListUnitTest {

    @Test
    fun sortLinkedList() {
        // 初始化链表数据
        val sourceLinkedList = initLinkedList()

        sourceLinkedList?.let {
            // 打印数据
            printListNode(it)

            // 拆分链表
            val spiltLinkedList: Array<ArrayList<ListNode>> = spiltLinkedList(it)

            // 重新排序列表
            val reversalList = reversalList(spiltLinkedList[1])

            // 合并，生成新的List
            val mergeList = mergeList(spiltLinkedList[0], reversalList)
            mergeList?.let { it1 -> printListNode(it1) }
        }

    }

    private fun mergeList(oneSource: ArrayList<ListNode>, twoSource: ArrayList<ListNode>): ListNode? {
        val oneSize = oneSource.size
        val twoSize = twoSource.size

        var onePosition = 0
        var twoPosition = 0
        var curr: ListNode? = null
        var head: ListNode? = null

        while (onePosition < oneSize || twoPosition < twoSize) {
            var tmpNode: ListNode? = null
            if (oneSize == onePosition || oneSource[onePosition].value!! > twoSource[twoPosition].value!!) {
                tmpNode = twoSource[twoPosition]
                twoPosition++
            } else if (twoSize == twoPosition || oneSource[onePosition].value!! <= twoSource[twoPosition].value!!) {
                tmpNode = oneSource[onePosition]
                onePosition++
            }

            if (head == null) {
                head = tmpNode
            }
            curr?.next = tmpNode
            curr = tmpNode
            // 需要赋null，避免之前的数据产生混乱
            curr?.next = null
        }
        return head
    }

    /**
     * 反转数组
     */
    private fun reversalList(source: ArrayList<ListNode>): ArrayList<ListNode> {
        val total = source.size
        for ((index, value) in source.withIndex()) {
            if (index >= total / 2) {
                val reversalNodePosition = total - index - 1
                var tmp = source[reversalNodePosition]
                source[reversalNodePosition] = value
                source[index] = tmp
            }
        }
        return source
    }

    /**
     * 拆分链表,返回2个拆分后的数组
     */
    private fun spiltLinkedList(head: ListNode): Array<ArrayList<ListNode>> {
        val ascListNodes: ArrayList<ListNode> = ArrayList()
        val desListNodes: ArrayList<ListNode> = ArrayList()

        var position: Int = 1
        var currListNode: ListNode? = head
        do {
            if (position % 2 == 0) {
                desListNodes.add(currListNode!!)
            } else {
                ascListNodes.add(currListNode!!)
            }
            position++
            currListNode = currListNode.next
        } while (currListNode != null)

        return arrayOf(ascListNodes, desListNodes)
    }

    /**
     * 构造条件，初始化数据
     * @return 返回头结点数据
     */
    private fun initLinkedList(): ListNode? {
        val sourceArray = intArrayOf(1, 11, 2, 10, 3, 9, 4, 8, 5, 7, 6, 6, 7, 5, 8, 4)
        var head: ListNode? = null
        var curr: ListNode? = null

        for (source in sourceArray) {
            val temp: ListNode = ListNode(source)
            if (curr != null) {
                curr.next = temp
            }
            curr = temp

            if (head == null) {
                head = curr
            }
        }
        return head
    }

    // 打印链表信息
    private fun printListNode(head: ListNode) {
        var curr: ListNode? = head;
        do {
            print(curr!!.value.toString() + "-> ")
            curr = curr.next

        } while (curr != null)
        // 打印换行符
        println()
    }

    /**
     * ListNode列表
     */
    class ListNode {

        constructor(value: Int) {
            this.value = value
        }

        var value: Int? = 0
        var next: ListNode? = null

    }

}