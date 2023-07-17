package com.wan.mvp.impl.view

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.wan.R
import com.wan.entity.User
import com.wan.mvp.impl.presenter.AuthPresenterImpl
import com.wan.mvp.inter.BaseActivity
import com.wan.mvp.inter.presenter.AuthPresenter
import com.wan.mvp.inter.view.AuthView

/**
 * @Author: LiuWenJi
 * @Date: 2023/7/17 15:44
 * @Description:登录实现类
 */
private const val TAG = "LoginActivity"

class LoginActivity : BaseActivity<AuthPresenter>(), AuthView {

    override val layoutRes: Int
        get() = R.layout.activity_login

    override fun createP(): AuthPresenter = AuthPresenterImpl(this)

    override fun recycleP() = presenter.unAttachView()


    override fun initView() {
        Log.d(TAG, "initView: ")
        var userNameEd = findViewById<EditText>(R.id.editTextPhone)
        var pwdEd = findViewById<EditText>(R.id.editTextTextPassword)
        var loginBtn = findViewById<Button>(R.id.loginBtn)
        loginBtn.setOnClickListener {
            val username = userNameEd.text.toString()
            val pwd = pwdEd.text.toString()
            Log.d(TAG, "initView-setOnClickListener: $username --  $pwd")
            presenter?.loginAction(this@LoginActivity, username, pwd)
        }
    }

    override fun loginSuccess(data: User) {
        Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show()
    }

    override fun loginFailure(msg: String) {
        Toast.makeText(this, "登录失败：$msg", Toast.LENGTH_SHORT).show()
    }

}