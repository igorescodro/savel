package com.escodro.savel.ui.common;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Custom {@link AppCompatImageView} to display an image in square format regardless of the
 * screen resolution.
 * <p>
 * Created by Igor Escodro on 09/05/17.
 *
 * @see <a href="http://stackoverflow.com/a/19449488">ImageView be a square with dynamic width? |
 * Stack Overflow</a>
 */
public class SquareImageView extends AppCompatImageView {

    public SquareImageView(Context context) {
        super(context);
    }

    public SquareImageView(Context context,
                           @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageView(Context context,
                           @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Override of {@link AppCompatImageView#onMeasure(int, int)} to ignore the measured height,
     * setting the width instead.
     *
     * @param widthMeasureSpec  measured width
     * @param heightMeasureSpec measured height
     */
    @SuppressWarnings("SuspiciousNameCombination")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        final int width = getMeasuredWidth();
        setMeasuredDimension(width, width);
    }
}
