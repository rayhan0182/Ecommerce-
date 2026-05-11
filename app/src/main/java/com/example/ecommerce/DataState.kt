package com.example.ecommerce

sealed class DataState<T>(

    val loading: String? = null,

    val success:T? = null,

    val error: String? = null

) {

    class Success<T>(massage:T?): DataState<T>(success = massage)

    class Error<T>(e_massage: String?): DataState<T>(error = e_massage)

    class Loading<T>(uloading: String?): DataState<T>(loading = uloading)


}