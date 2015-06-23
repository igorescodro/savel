package com.escodro.savel.views;

import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

import com.escodro.savel.MusicApp;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

/**
 * Class to create blur effect in the images, using {@link Picasso} {@link Transformation}.
 *
 * @see <a href="https://gist.github.com/ryanbateman/6667995">ryanbateman GitHub - Gist 6667995</a>
 * <p/>
 * Created by ryanbateman on 23/09/13 <br> Updated by IgorEscodro on 04/07/15.
 */
public class BlurTransformation implements Transformation {

    /**
     * Constant to represent the radius of the blur effect.
     */
    private static final int RADIUS = 16;

    @Override
    public Bitmap transform(Bitmap source) {
        final Bitmap outBitmap = Bitmap.createBitmap(source);
        final RenderScript rs = RenderScript.create(MusicApp.getContext());
        final Allocation input = Allocation.createFromBitmap(rs, source, Allocation
                .MipmapControl.MIPMAP_FULL, Allocation.USAGE_SCRIPT);
        final Allocation output = Allocation.createTyped(rs, input.getType());
        final ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        blur.setInput(input);
        blur.setRadius(RADIUS);
        blur.forEach(output);
        output.copyTo(outBitmap);

        if (source != outBitmap) {
            source.recycle();
        }

        return outBitmap;
    }

    @Override
    public String key() {
        return "BlurTransformation";
    }
}
