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

        print("练习结果: ")
        printValue(exercise(sourceData))
    }

    override fun exercise(source: IntArray): IntArray {

        for (index in source.indices) {

            var min = index
            for (i in (index + 1) until source.size) {
                if (source[min] > source[i]) {
                    min = i
                }
            }

            if (index != min) {
                swap(source, min, index)
            }
        }

        return source
    }

    /**
     * 选择排序
     */
    private fun selectSort(src: IntArray) : IntArray{
        val source = src.copyOf()
        // 注意项： for循环的遍历方向，决定了是先选大的还是先选小的
        // 这里从小到大排序，优先选小的开始，否则后面逻辑会较为复杂
        for (index in source.indices) {

            var min = index
            // 找出最小数字，并保存
            // 1、由于签名index都是已经排序好的数字，所以可以提前过滤掉
            for ( i in index + 1 until source.size) {
                if (source[min] > source[i]) {
                    min = i
                }
            }

            // 2、交换值
            if (min != index) {
                val tmp = source[min]
                source[min] = source[index]
                source[index] = tmp
            }
        }

        return source
    }



}