package me.ameriod.lib.loading

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar
import java.lang.IllegalArgumentException

sealed class LoadingType {

    abstract fun show(container: ViewGroup)

    abstract fun hide(container: ViewGroup)

    abstract fun add(container: ViewGroup)

    object IndeterminateBarTop : LoadingType() {

        override fun show(container: ViewGroup) {
            getView(container)?.apply {
                visibility = View.VISIBLE
                progressiveStart()
            }
        }

        override fun hide(container: ViewGroup) {
            getView(container)?.apply {
                visibility = View.INVISIBLE
                progressiveStop()
            }
        }

        override fun add(container: ViewGroup) {
            container.apply {
                if (getView(this) == null) {
                    val newView = View.inflate(context,
                            R.layout.loading_view_indeterminate_bar_top,
                            null)
                    when (this) {
                        is FrameLayout -> {
                            addView(newView,
                                    childCount,
                                    FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                                            FrameLayout.LayoutParams.WRAP_CONTENT)
                                            .apply {
                                                gravity = Gravity.TOP
                                            })
                        }
                        else -> throw IllegalArgumentException("Error container: $this for the IndeterminateBarTop is not valid")
                    }
                }
            }
        }

        private fun getView(container: ViewGroup) =
                container.findViewById<SmoothProgressBar>(R.id.loading_indeterminate_bar_top)

    }

    object IndeterminateBarBottom : LoadingType() {

        override fun show(container: ViewGroup) {
            getView(container)?.apply {
                visibility = View.VISIBLE
                progressiveStart()
            }
        }

        override fun hide(container: ViewGroup) {
            getView(container)?.apply {
                visibility = View.INVISIBLE
                progressiveStop()
            }
        }

        override fun add(container: ViewGroup) {
            container.apply {
                if (getView(this) == null) {
                    val newView = View.inflate(context,
                            R.layout.loading_view_indeterminate_bar_bottom,
                            null)
                    when (this) {
                        is FrameLayout -> {
                            addView(newView,
                                    childCount,
                                    FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                                            FrameLayout.LayoutParams.WRAP_CONTENT)
                                            .apply {
                                                gravity = Gravity.BOTTOM
                                            })
                        }
                        else -> throw IllegalArgumentException("Error container: $this for the IndeterminateBarTop is not valid")
                    }
                }
            }
        }

        private fun getView(container: ViewGroup) =
                container.findViewById<SmoothProgressBar>(R.id.loading_indeterminate_bar_bottom)

    }

    object IndeterminateCircle : LoadingType() {

        override fun show(container: ViewGroup) {
            getView(container)?.apply {
                visibility = View.VISIBLE
            }
        }

        override fun hide(container: ViewGroup) {
            getView(container)?.apply {
                visibility = View.GONE
            }
        }

        override fun add(container: ViewGroup) {
            container.apply {
                if (getView(this) == null) {
                    val newView = View.inflate(context,
                            R.layout.loading_view_indeterminate_circle,
                            null)
                    when (this) {
                        is FrameLayout -> {
                            addView(newView,
                                    childCount,
                                    FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                                            FrameLayout.LayoutParams.WRAP_CONTENT)
                                            .apply {
                                                gravity = Gravity.CENTER
                                            })
                        }
                        else -> throw IllegalArgumentException("Error container: $this for the IndeterminateCircle is not valid")
                    }
                }
            }
        }

        private fun getView(container: ViewGroup) =
                container.findViewById<ProgressBar>(R.id.loading_indeterminate_circle)


    }

    object IndeterminateCircleFull : LoadingType() {

        override fun show(container: ViewGroup) {
            getView(container)?.apply {
                visibility = View.VISIBLE
            }
        }

        override fun hide(container: ViewGroup) {
            getView(container)?.apply {
                visibility = View.GONE
            }
        }

        override fun add(container: ViewGroup) {
            container.apply {
                if (getView(this) == null) {
                    val newView = View.inflate(context,
                            R.layout.loading_view_indeterminate_circle_full,
                            null)
                    when (this) {
                        is FrameLayout -> {
                            addView(newView,
                                    childCount,
                                    FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                                            FrameLayout.LayoutParams.MATCH_PARENT)
                                            .apply {
                                                gravity = Gravity.CENTER
                                            })
                        }
                        else -> throw IllegalArgumentException("Error container: $this for the IndeterminateCircle is not valid")
                    }
                }
            }
        }

        private fun getView(container: ViewGroup) =
                container.findViewById<FrameLayout>(R.id.loading_indeterminate_circle_full)
    }

    object IndeterminateCircleFullTranslucent : LoadingType() {

        override fun show(container: ViewGroup) {
            getView(container)?.apply {
                visibility = View.VISIBLE
            }
        }

        override fun hide(container: ViewGroup) {
            getView(container)?.apply {
                visibility = View.GONE
            }
        }

        override fun add(container: ViewGroup) {
            container.apply {
                if (getView(this) == null) {
                    val newView = View.inflate(context,
                            R.layout.loading_view_indeterminate_circle_full_translucent,
                            null)
                    when (this) {
                        is FrameLayout -> {
                            addView(newView,
                                    childCount,
                                    FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                                            FrameLayout.LayoutParams.MATCH_PARENT)
                                            .apply {
                                                gravity = Gravity.CENTER
                                            })
                        }
                        else -> throw IllegalArgumentException("Error container: $this for the IndeterminateCircle is not valid")
                    }
                }
            }
        }

        private fun getView(container: ViewGroup) =
                container.findViewById<FrameLayout>(R.id.loading_indeterminate_circle_full_translucent)
    }

    abstract class Custom() : LoadingType()
}