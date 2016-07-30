package com.beauty.client.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.beauty.client.R
import com.beauty.client.api.domain.commands.RequestUserCommand
import com.beauty.client.ui.adapter.BeautyListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        beauty_list.layoutManager = LinearLayoutManager(this)
        doAsync() {
            val result = RequestUserCommand(page_size = 10).execute()
            uiThread {
                beauty_list.adapter = BeautyListAdapter(result) { toast(it.id) }
            }
        }
    }
}
