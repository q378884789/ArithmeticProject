package com.rookie.arithmeticproject.sort

import org.junit.Test

/**
 * @description 快速排序
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
    }

    override fun exercise(source: IntArray): IntArray {
        TODO("Not yet implemented")
    }

    /**
     * 例子：
     * 快速排序
     */
    private fun quickSort(source: IntArray): IntArray {

        return source
    }


}