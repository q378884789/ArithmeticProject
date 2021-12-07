package com.rookie.arithmeticproject.sort

import org.junit.Test


/**
 * @description 快速排序
 * 核心思想： 快速排序的核心就是如何找到目标值所在的位置即可
 *
 * 快速排序使用分治法（Divide and conquer）策略来把一个串行（list）分为两个子串行（sub-lists）。
 * 快速排序又是一种分而治之思想在排序算法上的典型应用。本质上来看，快速排序应该算是在冒泡排序基础上的递归分治
 *
 *  开始位置，结束位置，以第一个数作为标准，比标准大的放到左边，比标准大的放到右边，然后递归标准数位置左右两边的数组就OK了
 */
class QuickSort : BaseSort() {

    @Test
    fun testQuickSort() {
        val sourceData = getSourceData()
        // 进行快速排序并且打印
        print("排序结果： ")
        printValue(quickSort(sourceData))

        print("练习结果： ")
        printValue(exercise(sourceData))

    }

    override fun exercise(source: IntArray): IntArray {
        val exerciseSort = exerciseSort(source, 0, source.size - 1)
        return exerciseSort!!
    }

    private fun exerciseSort(source: IntArray, begin: Int, end: Int): IntArray? {
        if (begin < end) {
            // 基准值
            var key = source[begin]
            var i = begin
            var j = end

            while (i < j) {

                // 由于是以第一个为基准，所以从end开始查找
                while (i < j && source[j] > key) {
                    j--
                }
                // 如果退出了上面的while表示遇到了比key小的值，需要进行交换，
                if (i < j) {
                    swap(source, i, j)
                    i++
                }

                // 开始从起始位置遍历，找到比key大的值
                while (i < j && source[i] < key) {
                    i++
                }

                if (i < j) {
                    swap(source, i, j)
                    j--
                }

            }

            source[i] = key  // 也可以写成source[j]=key
            // 递归调用，可以去掉i，因为i已经排好序了
            exerciseSort(source, 0, i -1)
            exerciseSort(source, i + 1, end)
        }
        return source
    }

    /** -----------------------------------------分割线----------------------------------------
     * 例子：
     * 快速排序
     */
    private fun quickSort(source: IntArray): IntArray {
        val copySource = source.copyOf(source.size)

        val quickSort = quickSort(copySource, 0, copySource.size - 1)
        return quickSort!!
    }

    private fun quickSort(source: IntArray, begin: Int, end: Int): IntArray? {
        if (begin < end) {
            val key: Int = source[begin]
            var i: Int = begin
            var j: Int = end
            while (i < j) {
                while (i < j && source[j] > key) {
                    j--
                }
                if (i < j) {
                    source[i] = source[j]
                    i++
                }
                while (i < j && source[i] < key) {
                    i++
                }
                if (i < j) {
                    source[j] = source[i]
                    j--
                }
            }
            source[i] = key
            quickSort(source, begin, i - 1)
            quickSort(source, i + 1, end)
        }
        return source
    }

    /**
     * ----------------------------------简便方法-------------------------------------
     * 分割线， 下面是简便方法，与传统的优点区别
     * 核心思想是找到目标所在的位置。然后交换，最后进行递归，直到只有一个元素
     */
    private fun quickSort_bak(arr: IntArray, left: Int, right: Int): IntArray? {
        if (left < right) {
            val partitionIndex = partition(arr, left, right)
            quickSort_bak(arr, left, partitionIndex - 1)
            quickSort_bak(arr, partitionIndex + 1, right)
        }
        return arr
    }

    // 目标值为： source[left]
    private fun partition(source: IntArray, left: Int, right: Int): Int {

        var index = left + 1
        // 所有比 source[left] 小的放到index位置
        for (i in index..right) {
            if (source[i] < source[left]) {
                swap(source, i, index)
                index++
            }
        }
        // 交换left与最后一个index的位置，
        // 目的： 这样就把所有的小于source[left]的值放到了左边，大于的则在右边了，这样就确定了目标值的位置
        swap(source, left, index - 1)
        return index - 1
    }


}