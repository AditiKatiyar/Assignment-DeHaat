package com.dehaat.dehaatassignment.activity

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.LinearLayoutCompat
import com.dehaat.dehaatassignment.databinding.ExpandableTextviewBinding

class ExpandableTextview @JvmOverloads constructor(context: Context,
                                                   attributeSet: AttributeSet) : LinearLayout(context, attributeSet) {

    private val binding: ExpandableTextviewBinding by lazy {
        ExpandableTextviewBinding.inflate(LayoutInflater.from(context))
    }

    private var isSeeMore: Boolean = true
    private val SEE_LESS = "See less"
    private val SEE_MORE = "See more"

    init {
        layoutParams = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT
        )
        addView(binding.root)
        this.post {
            binding.apply {
                val lines = textview.lineCount
                if (lines <= 3) {
                    seeMore.visibility = View.GONE
                } else {
                    seeMore.visibility = View.VISIBLE
                    textview.apply {
                        ellipsize = TextUtils.TruncateAt.END
                        maxLines = 3
                    }

                    seeMore.setOnClickListener {

                        if (lines > 3) {
                            if (isSeeMore) {
                                seeMore.text = SEE_LESS

                                textview.apply {
                                    ellipsize = null
                                    maxLines = Integer.MAX_VALUE
                                }

                            } else {
                                seeMore.text = SEE_MORE
                                textview.apply {
                                    ellipsize = TextUtils.TruncateAt.END
                                    maxLines = 3
                                }
                            }

                            isSeeMore = !isSeeMore
                        }
                    }
                }
            }

        }
    }

    fun setText(text: String) {
        binding.textview.text = text
    }


}