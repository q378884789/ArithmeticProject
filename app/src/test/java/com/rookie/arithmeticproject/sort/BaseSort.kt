package com.rookie.arithmeticproject.sort

/*
* 数组排序的基类
 */
open class BaseSort {

    /**
     * 初始化数据，并打印原始内容
     */
    fun getSourceData() : IntArray {
        val source = intArrayOf(100, 1, 10, 11, 2, 3, 4, 9, 4, 2, 5, 1, 99, 101, 15)
        print("原始数据： ")
        printValue(source)
        return source
    }


    /**
     * 打印数组
     */
    fun printValue(source: IntArray) {
        for (value in source) {
            print("$value ")
        }
        // 增加换行
        println()
    }
}