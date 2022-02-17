package com.rookie.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.util.concurrent.CompletableFuture

/**
 * @author rookiezhang
 * @sample
 * 此类用于练习协程使用，熟悉协程相关知识
 */
class ExerciseCoroutines {

    /**
     * 协程使用
     * 自我测试相关资料
     */
    @Test
    fun testCoroutines() {
        // blocking 阻塞；封闭；大块
        // coroutines  协同程序

        // runBlocking 相当于一个适配器，可以显示的指定器返回值
        runBlocking {
            val coroutines = launch {
                delay(100)
                var name = Thread.currentThread().name
                println("name=${name}")
            }

            println("name1=${Thread.currentThread().name}")
//            coroutines.join()
        }

        CompletableFuture.completedFuture("").join()
        println("runBlocking is end")
    }



}