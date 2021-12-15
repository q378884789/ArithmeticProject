package com.rookie.arithmeticproject.linkedList

import org.junit.Test

/**
 * 此类用于练习使用，对链表进行重新排序
 * 练习时间： 20211.12.15
 */
class LinkedListUnitExercise {

    @Test
    fun sortLinkedList() {
        val head = initLinkedList()

        head?.let {
            printLinked(it)

            // 将链表进行拆分
            val splitLinked: Array<ArrayList<LinkedNode>> = splitLinked(it)

            // 反转链表
            val reversalNodes = reversalNodes(splitLinked[1])

            val mergeListNodes = mergeListNodes(splitLinked[0], reversalNodes)
            printLinked(mergeListNodes)

        }

    }

    // 合并2个链表
    private fun mergeListNodes(left: ArrayList<LinkedNode>, right: ArrayList<LinkedNode>): LinkedNode {

        var leftPosition: Int = 0
        var rightPosition: Int = 0

        var currNode: LinkedNode? = null
        var headNode: LinkedNode? = null

        while (leftPosition < left.size || rightPosition < right.size) {
            var tmp: LinkedNode? = null
            when {
                leftPosition == left.size -> {
                    tmp = right[rightPosition]
                    rightPosition++
                }
                rightPosition == right.size -> {
                    tmp = left[leftPosition]
                    leftPosition++
                }
                left[leftPosition].value!! > right[rightPosition].value!! -> {
                    tmp = right[rightPosition]
                    rightPosition++
                }
                left[leftPosition].value!! <= right[rightPosition].value!! -> {
                    tmp = left[leftPosition]
                    leftPosition++
                }
            }

            tmp?.let {
                // 需要将it.next = null否则会导致链表混乱
                it.next = null
                currNode?.next = it
                currNode = it
            }

            // 赋值头结点
            if (headNode == null) {
                headNode = currNode
            }
        }
        return headNode!!
    }

    // 反转链表
    private fun reversalNodes(sourceNodes: ArrayList<LinkedNode>): ArrayList<LinkedNode> {
        for ((index, value) in sourceNodes.withIndex()) {
            if (index < sourceNodes.size / 2) {
                val swapIndex = sourceNodes.size - index - 1
                val tmp = sourceNodes[index]
                sourceNodes[index] = sourceNodes[swapIndex]
                sourceNodes[swapIndex] = tmp
            }
        }
        return sourceNodes
    }

    // 拆分链表
    private fun splitLinked(headNode: LinkedNode): Array<ArrayList<LinkedNode>> {
        var ascNodes = ArrayList<LinkedNode>()
        var descNodes = ArrayList<LinkedNode>()

        var currNode: LinkedNode? = headNode
        var position = 1
        do {
            currNode?.let {
                if (position % 2 == 0) {
                    descNodes.add(it)
                } else {
                    ascNodes.add(it)
                }
            }

            position++
            currNode = currNode!!.next
        } while (currNode != null)
        return arrayOf(ascNodes, descNodes)
    }

    private fun printLinked(source: LinkedNode) {
        var currNode: LinkedNode? = source
        do {
            print("${currNode!!.value} ->")
            currNode = currNode.next
        } while (currNode != null)
        println("")
    }

    // 初始化链表，基数升序，偶数降序的列表
    private fun initLinkedList(): LinkedNode? {
        val sourceArray = arrayOf(1, 11, 2, 10, 3, 9, 4, 8, 5, 7, 6, 6, 7, 5, 8, 4)

        var head: LinkedNode? = null
        var currNode: LinkedNode? = null

        for (index in sourceArray.indices) {
            val node = LinkedNode(sourceArray[index])
            if (head == null) {
                head = node
            }

            if (currNode != null) {
                currNode.next = node
            }
            currNode = node
        }
        return head
    }


    class LinkedNode(value: Int) {

        var value: Int? = 0
        var next: LinkedNode? = null

        init {
            this.value = value
        }

    }

}