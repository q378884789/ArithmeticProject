package com.rookie.arithmeticproject.sort

import org.junit.Test

/**
 * @description 冒泡排序
 * 两两比较，大的右移，比出最大的，然后重新开始比
 */
class BubbleSort : BaseSort() {

    @Test
    fun testBubbleSort() {

        var source = getSourceData()

        // 冒泡排序例子
        val bubbleSort = bubbleSort(source)
        printValue(bubbleSort)

        // 冒牌排序练习
        println("下面是练习结果")
        printValue(exercise(source))
    }

    // 练习冒泡排序的 : 可删除练习
    override fun exercise(source: IntArray): IntArray {

        for (index in source.indices) {
            var flag = true

            for (i in 0 until source.size - index -1) {
                if (source[i] > source[i + 1]) {
                    swap(source, i, i+1)
                    flag = false
                }
            }

            if(flag) {
                break
            }
        }

        return source
    }

    /**
     * 例子:
     * 冒泡排序方法
     * 具体步骤：
     * 1、两两比较，较大的往前移动
     * 2、如果未发生变化，表示顺序已经正确，无需在进行遍历
     */
    private fun bubbleSort(src: IntArray): IntArray {
        val source = src.copyOf(src.size)

        for (index in 1 until source.size) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            var flag = true

            for (i in 0 until source.size - index) {
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


}