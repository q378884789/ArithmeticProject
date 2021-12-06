package com.rookie.arithmeticproject.sort

import org.junit.Test

/**
 * 参考网址：https://www.runoob.com/w3cnote/selection-sort.html
 * 选择排序：
 *  1、首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
 *  2、再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 *  3、重复第二步，直到所有元素均排序完毕。
 */
class SelectSort : BaseSort() {

    @Test
    fun testSelectSort() {
        val sourceData = getSourceData()
        print("选择排序： ")
        printValue(selectSort(sourceData))

        print("练习结果")

    }

    override fun exercise(source: IntArray): IntArray {
        TODO("Not yet implemented")
    }

    /**
     * 选择排序
     */
    private fun selectSort(source: IntArray) : IntArray{

        return source
    }



}