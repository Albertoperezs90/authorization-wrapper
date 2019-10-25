package com.transfesa.auth.manager.common

interface AuthorizationCallback {

    fun onFailure(e: Exception)
    fun onSuccess(token: String)

}