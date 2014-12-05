package com.epita.mti.nuitdelinfoandroid.design;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.epita.mti.nuitdelinfoandroid.R;

/**
 * Extend of an ImageView to create a rounded one
 */
public class RoundedImageView extends ImageView {
    private static final String TAG = RoundedImageView.class.getSimpleName();

    public RoundedImageView(Context context) {
        super(context);
        setPlaceholder(getResources().getDrawable(R.drawable.picture_placeholder));
    }

    public RoundedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPlaceholder(getResources().getDrawable(R.drawable.picture_placeholder));
    }

    public RoundedImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setPlaceholder(getResources().getDrawable(R.drawable.picture_placeholder));
    }

    /**
     * Set up the placeholder for the rounded image
     */
    private void setPlaceholder(Drawable drawable) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN)
            setBackgroundDrawable(drawable);
        else
            setBackground(drawable);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();

        if (drawable == null || getWidth() == 0 || getHeight() == 0)
            return;

        Bitmap b = ((BitmapDrawable) drawable).getBitmap();
        if (b != null) {
            setPlaceholder(null);
            Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);

            int radius = getHeight() / 2;

            Bitmap roundBitmap = roundCrop(bitmap, radius);
            canvas.drawBitmap(roundBitmap, 0, 0, null);
        }
    }

    /**
     * Crop a bitmap to build a rounded one
     * @param bmp the source
     * @param radius the radius of the circle
     * @return the rounded bitmap
     */
    private Bitmap roundCrop(Bitmap bmp, int radius) {
        Bitmap scaledBmp = Bitmap.createScaledBitmap(bmp, radius * 2, radius * 2, false);
        Bitmap output = Bitmap.createBitmap(getHeight(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final Paint paint = new Paint();

        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);

        // Draws a circle to create the border
        paint.setColor(getResources().getColor(android.R.color.white));
        canvas.drawCircle(getHeight() / 2, getHeight() / 2, radius, paint);

        // Draws the image subtracting the border width
        BitmapShader s = new BitmapShader(scaledBmp, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(s);
        canvas.drawCircle(getHeight() / 2, getHeight() / 2, radius - 10f, paint);

        return output;
    }
}
