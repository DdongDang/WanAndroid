package com.wan.api

import com.wan.net.ApiResponse
import com.wan.entity.User
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
/**
 * @Author: LiuWenJi
 * @Date: 2023/7/13 20:01
 * @Description:
 */
interface AuthApiService {
    @POST("user/login")
    @FormUrlEncoded
    fun login(@Field("username") username:String,@Field("password") password:String): Observable<ApiResponse<User>>
}