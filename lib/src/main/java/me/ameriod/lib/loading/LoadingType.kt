package me.ameriod.lib.loading

import android.app.Dialog
import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AppCompatActivity
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

    class BlockingDialog internal constructor(private val textResId: Int,
                                              private val text: CharSequence?) : LoadingType() {

        constructor(textResId: Int) : this(textResId, null)

        constructor(text: CharSequence) : this(0, text)

        override fun show(container: ViewGroup) {
            val dialog = getDialogFragment(container)
            if (dialog?.isAdded != true) showDialog(container)

        }

        override fun hide(container: ViewGroup) {
            val dialog = getDialogFragment(container)
            if (dialog?.isAdded == true) dialog.dismissAllowingStateLoss()
        }

        override fun add(container: ViewGroup) {
            // no op do not need to add a view
        }

        private fun getDialogFragment(viewGroup: ViewGroup): ProgressDialogFragment? =
                getFragmentManager(viewGroup).findFragmentByTag(ProgressDialogFragment.TAG) as ProgressDialogFragment?

        private fun showDialog(viewGroup: ViewGroup) {
            ProgressDialogFragment.newInstance(textResId, text)
                    .show(getFragmentManager(viewGroup), ProgressDialogFragment.TAG)
        }

        private fun getFragmentManager(viewGroup: ViewGroup) =
                (viewGroup.context as AppCompatActivity).supportFragmentManager

        internal class ProgressDialogFragment : DialogFragment() {

            override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
                    ProgressDialog(context)
                            .apply {
                                arguments?.let {
                                    setMessage(it.getCharSequence(TEXT)
                                            ?: getText(it.getInt(TEXT)))
                                }
                                setCancelable(false)
                                show()
                            }


            companion object {
                internal const val TAG = "loading_dialog"
                private const val TEXT_RES = "extra_text_res"
                private const val TEXT = "extra_text"

                @JvmStatic
                internal fun newInstance(textResId: Int,
                                         text: CharSequence?) =
                        ProgressDialogFragment().apply {
                            arguments = Bundle().apply {
                                putInt(TEXT_RES, textResId)
                                putCharSequence(TEXT, text)
                            }
                        }
            }
        }
    }

    abstract class Custom() : LoadingType()
}