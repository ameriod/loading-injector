package me.ameriod.lib.loading

import android.app.Activity
import android.support.v4.app.Fragment
import android.view.ViewGroup
import android.widget.FrameLayout
import com.bluelinelabs.conductor.Controller

fun ViewGroup.showLoading(show: Boolean, type: LoadingType) {
    type.add(this)
    if (show) type.show(this) else type.hide(this)
}

fun Activity.showLoading(show: Boolean, type: LoadingType,
                         viewGroup: ViewGroup = findViewById<ViewGroup>(android.R.id.content).getChildAt(0) as ViewGroup) {
   viewGroup.showLoading(show, type)
}

fun Fragment.showLoading(show: Boolean, type: LoadingType) {
    val fragmentView = view
    if (fragmentView is FrameLayout) {
        fragmentView.showLoading(show, type)
    } else {
        val parent = fragmentView?.parent
        if (parent is ViewGroup) {
            parent.showLoading(show, type)
        } else {
            activity?.showLoading(show, type)
        }
    }
}

fun Controller.showLoading(show: Boolean, type: LoadingType) {
    val controllerView = view
    if (controllerView is FrameLayout) {
        controllerView.showLoading(show, type)
    } else {
        val parent = controllerView?.parent
        if (parent is ViewGroup) {
            parent.showLoading(show, type)
        } else {
            activity?.showLoading(show, type)
        }
    }
}