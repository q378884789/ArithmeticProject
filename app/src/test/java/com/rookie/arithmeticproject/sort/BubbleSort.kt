package com.rookie.arithmeticproject.sort

import org.junit.Test

/**
 * @description 冒泡排序
 * 两两比较，大的右移，比出最大的，然后重新开始比
 */
class BubbleSort {

    @Test
    fun testBubbleSort() {

        var source = intArrayOf(100, 1, 10, 11, 2, 3, 4, 9, 4, 2, 5, 1)

        val bubbleSort = bubbleSort(source)

        printValue(bubbleSort)
    }

    /**
     * 冒泡排序方法
     */
    private fun bubbleSort(source: IntArray): IntArray {
        for (index in 1 until source.size) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            var flag = true

            for (i in 0 until source.size - 1) {
                if (source[i] > source[i + 1]) {
                    // 交换位置
                    val tmp = source[i]
                    source[i] = source[i + 1]
                    source[i + 1] = tmp

                    flag = false
                }
            }

            if (flag) {
                break;
            }

        }
        return source
    }

    private fun printValue(source: IntArray) {
        for (value in source) {
            print("$value ")
        }
    }

}