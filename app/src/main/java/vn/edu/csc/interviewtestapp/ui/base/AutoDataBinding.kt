package vn.edu.csc.interviewtestapp.ui.base

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

open class AutoDataBinding {

    companion object {
        @BindingAdapter("app:image")
        @JvmStatic
        fun bindImage(imageView: ImageView, image: String) {
            if (!TextUtils.isEmpty(image)) {
                Glide.with(imageView.context)
                    .load(image)
                    .circleCrop()
                    .into(imageView)
            }
        }
    }
}