package com.rookie.multithread

import org.junit.Test
import java.util.concurrent.CompletableFuture
import java.util.function.Supplier

/**
 *  多线程之CompletableFuture
 *  对于新特性的使用。
 */
class CompletableFutureTest {

    /**
     * 初步使用CompletableFuture
     */
    @Test
    fun testCompletableFuture_get() {
        val future = CompletableFuture.supplyAsync<String>(Supplier {
            val name = Thread.currentThread().name
            println("当前线程: ${name}")
            Thread.sleep(1000)
            println("future 执行完毕")

//            throw Exception("测试")
            return@Supplier "bbb"
        })
//        future.complete("aaa")
        future.whenComplete { v: String?, e: Throwable? ->
            println("v=${v}")
            println("e=${e}")
        }

        val get = future.get()
        println("get=${get}")
    }

    @Test
    fun testCompletableFuture_join() {
        val future = CompletableFuture.supplyAsync(Supplier {
            val name = Thread.currentThread().name
            println("当前线程: ${name}")
            Thread.sleep(1000)
            println("future 执行完毕")

        })
        future.join()
        println("testCompletableFuture_join is end")
    }
}