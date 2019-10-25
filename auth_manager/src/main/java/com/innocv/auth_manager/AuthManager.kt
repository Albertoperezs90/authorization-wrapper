package com.innocv.auth_manager

import com.innocv.okta_android.OktaSession
import com.transfesa.auth.manager.common.AuthorizationCallback

class AuthManager private constructor() {

    var oktaSession: OktaSession? = null

    fun validateOkta(authorizationCallback: AuthorizationCallback) {
        oktaSession?.authorize(authorizationCallback)
    }

    object Builder {

        private var oktaSessionBuilder: OktaSession.Builder? = null

        fun configOkta(url: String, username: String, password: String): Builder {
            this.oktaSessionBuilder = OktaSession.Builder
                .withUrl(url)
                .withUsername(username)
                .withPassword(password)

            return this
        }

        fun build(): AuthManager {
            return AuthManager().apply {
                oktaSession = oktaSessionBuilder?.build()
            }
        }
    }
}