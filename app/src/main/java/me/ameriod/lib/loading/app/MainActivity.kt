package me.ameriod.lib.loading.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import me.ameriod.lib.loading.LoadingType
import me.ameriod.lib.loading.showLoading

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnBarBottom.setOnClickListener(this)
        btnBarTop.setOnClickListener(this)
        btnCircle.setOnClickListener(this)
        btnCircleFull.setOnClickListener(this)
        btnCircleFullTranslucent.setOnClickListener(this)
        btnBlockingDialog.setOnClickListener(this)
    }

    private fun show(loadingType: LoadingType) {
        showLoading(true, loadingType)
        rootView.postDelayed({ showLoading(false, loadingType) }, 1000L)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnBarBottom -> show(LoadingType.IndeterminateBarBottom)
            R.id.btnBarTop -> show(LoadingType.IndeterminateBarTop)
            R.id.btnCircle -> show(LoadingType.IndeterminateCircle)
            R.id.btnCircleFull -> show(LoadingType.IndeterminateCircleFull)
            R.id.btnCircleFullTranslucent -> show(LoadingType.IndeterminateCircleFullTranslucent)
            R.id.btnBlockingDialog -> show(LoadingType.BlockingDialog("Loading some stuff..."))
        }
    }
}
