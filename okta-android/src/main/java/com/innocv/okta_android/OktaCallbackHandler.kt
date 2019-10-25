package com.innocv.okta_android

import com.okta.authn.sdk.AuthenticationStateHandler
import com.okta.authn.sdk.resource.AuthenticationResponse
import com.transfesa.auth.manager.common.AuthorizationCallback

internal class OktaCallbackHandler(
    private val authorizationCallback: AuthorizationCallback
) : AuthenticationStateHandler {

    override fun handleMfaEnroll(authenticationResponse: AuthenticationResponse?) {
        authorizationCallback.onFailure(Exception("Okta - handleMfaEnroll"))
    }

    override fun handleRecoveryChallenge(authenticationResponse: AuthenticationResponse?) {
        authorizationCallback.onFailure(Exception("Okta - handleRecoveryChallenge"))
    }

    override fun handleUnknown(authenticationResponse: AuthenticationResponse?) {
        authorizationCallback.onFailure(Exception("Okta - handleUnknown"))
    }

    override fun handleMfaRequired(authenticationResponse: AuthenticationResponse?) {
        authorizationCallback.onFailure(Exception("Okta - handleMfaRequired"))
    }

    override fun handlePasswordExpired(authenticationResponse: AuthenticationResponse?) {
        authorizationCallback.onFailure(Exception("Okta - handlePasswordExpired"))
    }

    override fun handleLockedOut(authenticationResponse: AuthenticationResponse?) {
        authorizationCallback.onFailure(Exception("Okta - handleLockedOut"))
    }

    override fun handlePasswordReset(authenticationResponse: AuthenticationResponse?) {
        authorizationCallback.onFailure(Exception("Okta - handlePasswordReset"))
    }

    override fun handleRecovery(authenticationResponse: AuthenticationResponse?) {
        authorizationCallback.onFailure(Exception("Okta - handleRecovery"))
    }

    override fun handleSuccess(authenticationResponse: AuthenticationResponse?) {
        authenticationResponse?.let { authorizationCallback.onSuccess(it.sessionToken) }
    }

    override fun handlePasswordWarning(authenticationResponse: AuthenticationResponse?) {
        authorizationCallback.onFailure(Exception("Okta - handlePasswordWarning"))
    }

    override fun handleMfaEnrollActivate(authenticationResponse: AuthenticationResponse?) {
        authorizationCallback.onFailure(Exception("Okta - handleMfaEnrollActivate"))
    }

    override fun handleMfaChallenge(authenticationResponse: AuthenticationResponse?) {
        authorizationCallback.onFailure(Exception("Okta - handleMfaChallenge"))
    }

    override fun handleUnauthenticated(authenticationResponse: AuthenticationResponse?) {
        authorizationCallback.onFailure(Exception("Okta - handleUnauthenticated"))
    }
}