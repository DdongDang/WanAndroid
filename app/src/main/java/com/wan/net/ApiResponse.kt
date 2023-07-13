package com.wan.net
/**
 * @Author: LiuWenJi
 * @Date: 2023/7/13 20:01
 * @Description:与后端协商的响应内容的数据结构
 */
data class ApiResponse<T>(
    val data: T,
    val errorCode: Int,//errorCode = 0 代表执行成功，不建议依赖任何非0的 errorCode. errorCode = -1001 代表登录失效，需要重新登录。
    val errorMsg: String
)
