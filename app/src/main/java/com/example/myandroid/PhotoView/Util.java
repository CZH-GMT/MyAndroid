package com.example.myandroid.PhotoView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;

import java.math.BigDecimal;


public class Util {

    private static final String TAG = Util.class.getSimpleName();

    static void checkZoomLevels(float minZoom, float midZoom,
                                float maxZoom) {
        if (minZoom >= midZoom) {
            throw new IllegalArgumentException(
                    "Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        } else if (midZoom >= maxZoom) {
            throw new IllegalArgumentException(
                    "Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    public static boolean hasDrawable(ImageView imageView) {
        return imageView.getDrawable() != null;
    }

    public static boolean isSupportedScaleType(final ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        switch (scaleType) {
            case MATRIX:
                throw new IllegalStateException("Matrix scale type is not supported");
        }
        return true;
    }

    public static int getPointerIndex(int action) {
        return (action & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
    }

    /**
     * 获取实际宽高 单位为dp 此处dp = px 不做转换
     *
     * @param d
     * @return
     */
    public static int getDrawableWidth(Drawable d) {
        int width = d.getIntrinsicWidth();
        if (width <= 0) {
            width = d.getMinimumWidth();
        }
        if (width <= 0) {
            width = d.getBounds().width();
        }
        return width;
    }

    public static int getDrawableHeight(Drawable d) {
        int height = d.getIntrinsicHeight();
        if (height <= 0) {
            height = d.getMinimumHeight();
        }
        if (height <= 0) {
            height = d.getBounds().height();
        }
        return height;
    }

    public static double div(int v1, int v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Integer.toString(v1));
        BigDecimal b2 = new BigDecimal(Integer.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static DisplayMetrics getWindowDisplay(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(outMetrics);
        int widthPixels = outMetrics.widthPixels;
        int heightPixels = outMetrics.heightPixels;
        Log.e(TAG, "widthPixels:" + widthPixels);
        Log.e(TAG, "heightPixels:" + heightPixels);
        return outMetrics;
    }
}
