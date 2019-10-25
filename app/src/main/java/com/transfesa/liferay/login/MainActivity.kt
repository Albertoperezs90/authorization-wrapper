package com.transfesa.liferay.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.innocv.auth_manager.AuthManager
import com.transfesa.auth.manager.common.AuthorizationCallback
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        GlobalScope.launch {
            val request = AuthManager.Builder
                .configOkta(
                    "",
                    "",
                    ""
                )
                .build()

            request.validateOkta(object : AuthorizationCallback {
                override fun onFailure(e: Exception) {
                    println(e.message)
                }

                override fun onSuccess(token: String) {
                    println(token)
                }
            })
        }

    }
}
