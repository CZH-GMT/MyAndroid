package com.example.myandroid.PhotoView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;


/**
 * 自定義圖片顯示新需求
 * 添加点击放大
 * 从新更改显示view定义
 *
 */
@SuppressLint("AppCompatCustomView")
public class PhotoView extends ImageView {

    private PhotoViewAttacher attacher;
    private ImageView.ScaleType pendingScaleType;

    public PhotoView(Context context) {
        this(context, null);
    }

    public PhotoView(Context context, AttributeSet attr) {
        this(context, attr, 0);
    }

    public PhotoView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
        init();
    }

    private void init() {
        attacher = new PhotoViewAttacher(this);
        //We always pose as a Matrix scale type, though we can change to another scale type
        //via the attacher
        super.setScaleType(ImageView.ScaleType.MATRIX);
        //apply the previously applied scale type
        if (pendingScaleType != null) {
            setScaleType(pendingScaleType);
            pendingScaleType = null;
        }
    }


    public PhotoViewAttacher getAttacher() {
        return attacher;
    }

    @Override
    public ImageView.ScaleType getScaleType() {
        return attacher.getScaleType();
    }

    @Override
    public Matrix getImageMatrix() {
        return attacher.getImageMatrix();
    }

    @Override
    public void setOnLongClickListener(View.OnLongClickListener l) {
        attacher.setOnLongClickListener(l);
    }

    @Override
    public void setOnClickListener(View.OnClickListener l) {
        attacher.setOnClickListener(l);
    }

    @Override
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (attacher == null) {
            pendingScaleType = scaleType;
        } else {
            attacher.setScaleType(scaleType);
        }
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        // setImageBitmap calls through to this method
        if (attacher != null) {
            attacher.update();
        }
    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        if (attacher != null) {
            attacher.update();
        }
    }

    @Override
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (attacher != null) {
            attacher.update();
        }
    }

    @Override
    protected boolean setFrame(int l, int t, int r, int b) {
        boolean changed = super.setFrame(l, t, r, b);
        if (changed) {
            attacher.update();
        }
        return changed;
    }

    public void setZoomable(boolean zoomable) {
        attacher.setZoomable(zoomable);
    }

    public float getMinimumScale() {
        return attacher.getMinimumScale();
    }

    public float getMaximumScale() {
        return attacher.getMaximumScale();
    }

    public float getScale() {
        return attacher.getScale();
    }

    public void setMinimumScale(float minimumScale) {
        attacher.setMinimumScale(minimumScale);
    }

    public void setTrueScale(float trueScale) {
        attacher.setTrueScale(trueScale);
    }

    /**
     * 获取降比
     *
     * @return
     */
    private float getDawnScale(float big, float small) {
        return (big - small) / big;
    }


    private float rotation = 0.0f;

    @Override
    public float getRotation() {
        return rotation;
    }

    public double rotateScale(float rotation) {
        //获取旋转角度
        float r = Math.abs(rotation);
        this.rotation = r;
        //获取图片长宽
        int width = PhotoViewAttacher.drawableWidth;
        int height = PhotoViewAttacher.drawableHeight;
        //获取画布长宽
        int widthPixels = PhotoViewAttacher.widthPixels;
        int heightPixels = PhotoViewAttacher.heightPixels;
        //当前缩放值
        float lastScale = getMinimumScale();
        //要缩放的值
        double scale;
        //根据旋转情况改变v1v2的值
        float v1, v2;
        if (r == 0 || r == 180) {
            v1 = height;
            v2 = width;
        } else {
            v1 = width;
            v2 = height;
        }
        //判断是否需要缩放计算比,如果图片的宽大于画布宽或者图片高大于画布高需要缩放计算
        if (v1 > heightPixels) {
            //要缩放的值=现有的值-目标值
            scale = lastScale - getDawnScale(v1, heightPixels);
        } else if (v2 > widthPixels) {
            scale = lastScale - getDawnScale(v2, widthPixels);
        } else {
            //宽高都不超出画布就用默认值1.0
            scale = PhotoViewAttacher.DEFAULT_MIN_SCALE;
        }
        //计算TrueScale，v1到画布高和v2到画布宽的比
        float v1MaxScale = heightPixels / v1;
        float v2MaxScale = widthPixels / v2;
        //最大值为TrueScale
        float max = Math.max(v1MaxScale, v2MaxScale);
        //最小值为计算结果scale
        setMinimumScale((float) scale);
        setTrueScale(max);
        setScaleRotation(rotation, (float) scale);
        return scale;
    }


    public void setScale(float scale, boolean animate) {
        attacher.setScale(scale, animate);
    }

    public void setScaleRotation(float rotation, float scale) {
        attacher.setScaleRotation(rotation, scale);
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        attacher.setOnScaleChangeListener(onScaleChangedListener);
    }
}
