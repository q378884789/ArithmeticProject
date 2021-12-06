package com.rookie.arithmeticproject.sort

/*
* 数组排序的基类
 */
abstract class BaseSort {

    /**
     * 初始化数据，并打印原始内容
     */
    fun getSourceData() : IntArray {
        val source = intArrayOf(100, 22, 10, 11, 27, 3, 55, 9, 4, 2, 5, 1, 99, 101, 15)
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

    abstract fun exercise(source: IntArray) : IntArray
}