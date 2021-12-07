package com.rookie.arithmeticproject.sort

import org.junit.Test


/**
 * 归并排序的步骤
 * 1、申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
 * 2、设定两个指针，最初位置分别为两个已经排序序列的起始位置；
 * 3、比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
 * 4、重复步骤 3 直到某一指针达到序列尾；
 * 5、将另一序列剩下的所有元素直接复制到合并序列尾。
 */
class MergeSort : BaseSort() {

    @Test
    fun testMergeSort() {
        val sourceData = getSourceData()
        printValue(mergeSort(sourceData))
    }

    override fun exercise(source: IntArray): IntArray {
        TODO("Not yet implemented")
    }


    private fun mergeSort(src: IntArray): IntArray {
        val source = src.copyOf()

        if (source.size < 2) {
            return source
        }

        var middle: Int = source.size / 2

        val left = source.copyOfRange(0, middle)
        val right = source.copyOfRange(middle, source.size)

        var mergeSortLeft = mergeSort(left)
        var mergeSortRight = mergeSort(right)

        return merge(mergeSortLeft, mergeSortRight)
    }

    /**
     * 合并2个数组
     */
    private fun merge(left: IntArray, right: IntArray): IntArray {
        val result = IntArray(left.size + right.size)

        var posResult = 0

        var posLeft = 0
        var posRight = 0

        while (posLeft < left.size || posRight < right.size) {

            if (posLeft == left.size) {
                result[posResult] = right[posRight]
                posRight++

            } else if (posRight == right.size) {
                result[posResult] = left[posLeft]
                posLeft++

            } else if (right[posRight] < left[posLeft]) {
                result[posResult] = right[posRight]
                posRight++

            } else if (left[posLeft] < right[posRight]) {
                result[posResult] = left[posLeft]
                posLeft++

            }
            posResult++
        }
        return result
    }

}