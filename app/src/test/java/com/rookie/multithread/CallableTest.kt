package com.rookie.multithread

import org.junit.Test
import java.util.concurrent.Callable
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class CallableTest {

    /**
     * 初步使用Callable
     */
    @Test
    fun testCallable() {
        val executorService = Executors.newSingleThreadExecutor()
        executorService.submit(Callable<String> {
            println("测试 Callable")
            return@Callable  "aaaa"
        })
    }


}