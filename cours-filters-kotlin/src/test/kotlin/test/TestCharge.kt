package test

import com.github.kittinunf.fuel.httpGet
import kotlinx.coroutines.*
import java.time.Duration
import java.time.Instant

suspend fun main() = coroutineScope {
    val nombreAppel = 10000
    val start = Instant.now()

    val deferred = (1..nombreAppel).map {
        async {
            "http://localhost:8080/welcome/hi?nick=loadTest".httpGet().responseString()
        }
    }
    runBlocking {
        deferred.forEach { it.await() }
    }
    println("Finished in ${Duration.between(start, Instant.now()).seconds} seconds")
}



