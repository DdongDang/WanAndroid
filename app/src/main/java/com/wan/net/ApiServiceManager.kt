package com.wan.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @Author: LiuWenJi
 * @Date: 2023/7/13 20:01
 * @Description:
 */
class ApiServiceManager {
    private object Holder {
        val INSTANCE = ApiServiceManager()
    }

    companion object{
        val  instance = Holder.INSTANCE
    }
    fun <T> obtainService(service: Class<T>?): T {
        val client = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //Retrofit 的一个适配器，用于将 Retrofit 的网络请求结果转换为 RxJava 的 Observable 对象，方便使用 RxJava 进行异步处理。
            .addConverterFactory(ScalarsConverterFactory.create()) // Retrofit 的一个转换器，用于将网络响应的原始数据转换为字符串。
            .addConverterFactory(GsonConverterFactory.create()) //将网络响应的 JSON 数据转换为 Java 对象，使用了 Gson 库进行序列化和反序列化。
            .client(client)
            .build()
        return retrofit.create(service)
    }
}