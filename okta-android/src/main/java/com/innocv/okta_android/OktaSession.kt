package com.innocv.okta_android

import com.okta.authn.sdk.client.AuthenticationClients
import com.okta.authn.sdk.resource.AuthenticationRequest
import com.transfesa.auth.manager.common.AuthorizationCallback

class OktaSession private constructor() {

    private var url: String = ""
    private var username: String = ""
    private var password: String = ""

    fun authorize(callback: AuthorizationCallback) {

        val authenticationClient = AuthenticationClients.builder()
            .setConnectionTimeout(30)
            .setOrgUrl(url)
            .setRetryMaxAttempts(3)
            .setRetryMaxElapsed(3)
            .build()

        val request = authenticationClient.instantiate(AuthenticationRequest::class.java)
            .setUsername(username)
            .setPassword(password.toCharArray())
            .setRelayState(null)

        authenticationClient.authenticate(request, null, OktaCallbackHandler(callback))
    }

    object Builder {

        private var url: String = ""
        private var username: String = ""
        private var password: String = ""

        fun withUrl(url: String): Builder {
            this.url = url
            return this
        }

        fun withUsername(username: String): Builder {
            this.username = username
            return this
        }

        fun withPassword(password: String): Builder {
            this.password = password
            return this
        }

        fun build(): OktaSession {
            return OktaSession().apply {
                this.url = this@Builder.url
                this.username = this@Builder.username
                this.password = this@Builder.password
            }
        }
    }
}