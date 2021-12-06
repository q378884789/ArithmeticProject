package com.rookie.arithmeticproject.sort

import org.junit.Test

/**
 * @description 快速排序
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

    /**
     * 例子：
     * 快速排序
     */
    private fun quickSort(source: IntArray): IntArray {

        return source
    }

    override fun exercise(source: IntArray): IntArray {
        TODO("Not yet implemented")
    }

}