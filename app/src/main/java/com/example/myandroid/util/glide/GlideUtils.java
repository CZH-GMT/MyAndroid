package com.example.myandroid.util.glide;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;
import static com.bumptech.glide.request.RequestOptions.diskCacheStrategyOf;
import static com.bumptech.glide.request.RequestOptions.errorOf;
import static com.bumptech.glide.request.RequestOptions.overrideOf;
import static com.bumptech.glide.request.RequestOptions.placeholderOf;
import static com.bumptech.glide.request.RequestOptions.skipMemoryCacheOf;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;

/**
 * Created by yanty on 2019/09/02
 * Glide.with()根据传入的fragment或activity进行绑定生命周期
 */
public class GlideUtils {
    private static final String TAG = "GlideUtils";

    /**
     * 显示图片Imageview
     *
     * @param context  上下文
     * @param errorImg 错误的资源图片
     * @param imageUrl 图片链接
     * @param imgeView 组件
     */
    public static void showImageView(Context context, int errorImg, String imageUrl,
                                     ImageView imgeView) {

        Glide.with(context)
                .asBitmap()
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .centerCrop()
                .placeholder(errorImg)
                .error(errorImg)
                //.transform(transform)
                .into(imgeView);


//        Glide.with(context).
//                load(imageUrl)
//                .apply(errorOf(errorImg))
//                .apply(placeholderOf(errorImg))
//                .apply(skipMemoryCacheOf(memoryCache))
//                .apply(diskCacheStrategyOf(cacheRule))
//                .into(imgeView);
    }

    /**
     * 圆形剪裁显示图片Imageview
     *
     * @param context  上下文
     * @param errorImg 错误的资源图片
     * @param imageUrl 图片链接
     * @param imgeView 组件
     */
    public static void showImageCircleView(Context context, int errorImg, String imageUrl,
                                           ImageView imgeView) {

        CropCircleTransformation transformation = new CropCircleTransformation(context);
        Glide.with(context)
                .asBitmap()
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .centerCrop()
                .placeholder(errorImg)
                .error(errorImg)
                .transform(transformation)
                .into(imgeView);
    }


    /**
     * 暂停加载
     *
     * @param context   上下文
     * @param imageView 将要清除的imageView
     */
    public static void clearLoad(Context context, ImageView imageView) {

        Glide.with(context).clear(imageView);
    }

    /**
     * 显示图片Imageview
     *
     * @param activity 上下文
     * @param errorImg 错误的资源图片
     * @param imageUrl 图片链接
     * @param imgeView 组件
     */
    public static void showImageView(Activity activity, int errorImg, String imageUrl,
                                     ImageView imgeView, DiskCacheStrategy cacheRule, boolean memoryCache) {
        Glide.with(activity).
                load(imageUrl)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(memoryCache))
                .apply(diskCacheStrategyOf(cacheRule))
                .into(imgeView);
    }

    /**
     * 显示图片Imageview
     *
     * @param fragment 上下文
     * @param errorImg 错误的资源图片
     * @param imageUrl 图片链接
     * @param imgeView 组件
     */
    public static void showImageView(Fragment fragment, int errorImg, String imageUrl,
                                     ImageView imgeView, DiskCacheStrategy cacheRule, boolean memoryCache) {
        Glide.with(fragment).
                load(imageUrl)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(memoryCache))
                .apply(diskCacheStrategyOf(cacheRule))
                .into(imgeView);
    }


    /**
     * 设置图片的大小，等比例缩放
     *
     * @param context   上下文
     * @param imageUrl  图片url
     * @param targetImg 需要转换的ImageView
     * @param width     图片宽
     * @param height    图片高
     */
    public static void showImageEqualScaling(Context context, String imageUrl, int errorImg, ImageView targetImg, int width, int height) {

        Glide.with(context).
                load(imageUrl)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .apply(overrideOf(width, height))
                .into(targetImg);

    }

    /**
     * 设置图片的大小，等比例缩放
     *
     * @param activity
     * @param imageUrl  图片url
     * @param targetImg 需要改变的imageview
     * @param width     图片宽
     * @param height    图片高
     */
    public static void showImageEqualScaling(Activity activity, String imageUrl, int errorImg, ImageView targetImg, int width, int height) {

        Glide.with(activity).
                load(imageUrl)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .apply(overrideOf(width, height))
                .into(targetImg);

    }

    /**
     * 设置图片的大小，等比例缩放
     *
     * @param fragment
     * @param imageUrl
     * @param targetImg
     * @param width     图片宽
     * @param height    图片高
     */
    public static void showImageEqualScaling(Fragment fragment, String imageUrl, int errorImg, ImageView targetImg, int width, int height) {

        Glide.with(fragment).
                load(imageUrl)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .apply(overrideOf(width, height))
                .into(targetImg);

    }

    /***
     * 获取圆形图片
     * @param context
     * @param imageUrl 请求路径
     * @param targetImg
     */
    public static void getCircleBitmap(Context context, int errorImg, String imageUrl, ImageView targetImg) {
        if (context != null) {
            Glide.with(context)
                    .asBitmap()
                    .load(imageUrl)
                    .apply(errorOf(errorImg))
                    .apply(placeholderOf(errorImg))
                    .apply(skipMemoryCacheOf(false))
                    .centerCrop()
                    .error(errorImg)
                    .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                    .apply(bitmapTransform(new CircleCrop()).format(DecodeFormat.PREFER_ARGB_8888))
                    .into(targetImg);
        } else {
//            LogUtils.d(TAG, "getCircleBitmap: pic load fail, context ==null");
        }


    }

    /***
     * 获取圆形图片
     * @param activity
     * @param imageUrl 请求路径
     * @param targetImg
     */
    public static void getCircleBitmap(Activity activity, String imageUrl, ImageView targetImg, int errorImg) {

        Glide.with(activity).
                load(imageUrl)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .apply(bitmapTransform(new CircleCrop()).format(DecodeFormat.PREFER_ARGB_8888))
                .into(targetImg);
    }

    /***
     * 获取圆形图片
     * @param fragment
     * @param imageUrl 请求路径
     * @param targetImg
     */
    public static void getCircleBitmap(Fragment fragment, String imageUrl, ImageView targetImg, int errorImg) {

        Glide.with(fragment).
                load(imageUrl)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .apply(bitmapTransform(new CircleCrop()).format(DecodeFormat.PREFER_ARGB_8888))
                .into(targetImg);
    }

    /***
     * 获取圆形图片
     * @param context
     * @param resId 资源id
     * @param targetImg
     */
    public static void getCircleBitmap(Context context, int resId, ImageView targetImg, int errorImg) {

        Glide.with(context).
                load(resId)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .apply(bitmapTransform(new CircleCrop()).format(DecodeFormat.PREFER_ARGB_8888))
                .into(targetImg);
    }

    /***
     * 获取圆形图片
     * @param activity
     * @param resId 资源id
     * @param targetImg
     */
    public static void getCircleBitmap(Activity activity, int resId, ImageView targetImg, int errorImg) {

        Glide.with(activity).
                load(resId)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .apply(bitmapTransform(new CircleCrop()).format(DecodeFormat.PREFER_ARGB_8888))
                .into(targetImg);
    }

    /***
     * 获取圆形图片
     * @param fragment
     * @param resId 资源id
     * @param targetImg
     */
    public static void getCircleBitmap(Fragment fragment, int resId, ImageView targetImg, int errorImg) {

        Glide.with(fragment).
                load(resId)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .apply(bitmapTransform(new CircleCrop()))
                .into(targetImg);
    }

    /**
     * 加载圆角图片，根据url加载网络图片
     *
     * @param context  上下文
     * @param url      定位符
     * @param image    控件
     * @param errorImg 错误图
     * @param radius   圆角大小
     */
    public static void loadRoundCornerBitmap(Context context, String url, ImageView image, @DrawableRes int errorImg, int radius) {

        Glide.with(context).
                load(url)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .apply(bitmapTransform(new RoundedCorners(radius)).format(DecodeFormat.PREFER_ARGB_8888))
                .into(image);

    }

    /**
     * 加载圆角图片, 根据url加载网络图片
     *
     * @param context
     * @param url
     * @param image
     * @param errorImg
     * @param radius
     */
    public static void loadRoundCornerBitmap(Context context, String url, ImageView image,
                                             @DrawableRes int errorImg, int radius, RoundedCornersTransformation.CornerType type) {
        Glide.with(context).
                load(url)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .apply(bitmapTransform(new RoundedCornersTransformation(radius, 0, type)).format(DecodeFormat.PREFER_ARGB_8888))
                .into(image);
    }

    /**
     * 加载圆角图片, 根据url加载网络图片
     *
     * @param activity
     * @param url
     * @param image
     * @param errorImg
     * @param radius
     */
    public static void loadRoundCornerBitmap(Activity activity, String url, ImageView image,
                                             @DrawableRes int errorImg, int radius, RoundedCornersTransformation.CornerType type) {
        Glide.with(activity).
                load(url)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .apply(bitmapTransform(new RoundedCornersTransformation(radius, 0, type)).format(DecodeFormat.PREFER_ARGB_8888))
                .into(image);
    }

    /**
     * 加载圆角图片, 根据url加载网络图片
     *
     * @param fragment
     * @param url
     * @param image
     * @param errorImg
     * @param radius
     */
    public static void loadRoundCornerBitmap(Fragment fragment, String url, ImageView image,
                                             @DrawableRes int errorImg, int radius, RoundedCornersTransformation.CornerType type) {
        Glide.with(fragment).
                load(url)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .apply(bitmapTransform(new RoundedCornersTransformation(radius, 0, type)).format(DecodeFormat.PREFER_ARGB_8888))
                .into(image);
    }

    /**
     * 加载圆角图片，设置请求回调监听
     *
     * @param context
     * @param url
     * @param image
     * @param errorImg
     * @param radius
     * @param type
     * @param requestListener
     */
    public static void loadRoundCornerBitmap(Context context, String url, ImageView image,
                                             @DrawableRes int errorImg, int radius, RoundedCornersTransformation.CornerType type, RequestListener requestListener) {
        Glide.with(context).
                load(url)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .listener(requestListener)
                .apply(bitmapTransform(new RoundedCornersTransformation(radius, 0, type)).format(DecodeFormat.PREFER_ARGB_8888))
                .into(image);
    }

    /**
     * 加载圆角图片，设置请求回调监听
     *
     * @param activity
     * @param url
     * @param image
     * @param errorImg
     * @param radius
     * @param type
     * @param requestListener
     */
    public static void loadRoundCornerBitmap(Activity activity, String url, ImageView image,
                                             @DrawableRes int errorImg, int radius, RoundedCornersTransformation.CornerType type, RequestListener requestListener) {
        Glide.with(activity).
                load(url)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .listener(requestListener)
                .apply(bitmapTransform(new RoundedCornersTransformation(radius, 0, type)).format(DecodeFormat.PREFER_ARGB_8888))
                .into(image);
    }

    /**
     * 加载圆角图片，设置请求回调监听
     *
     * @param fragment
     * @param url
     * @param image
     * @param errorImg
     * @param radius
     * @param type
     * @param requestListener
     */
    public static void loadRoundCornerBitmap(Fragment fragment, String url, ImageView image,
                                             @DrawableRes int errorImg, int radius,
                                             RoundedCornersTransformation.CornerType type,
                                             RequestListener requestListener) {
        Glide.with(fragment).
                load(url)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .listener(requestListener)
                .apply(bitmapTransform(new RoundedCornersTransformation(radius, 0, type)).format(DecodeFormat.PREFER_ARGB_8888))
                .into(image);
    }


    /**
     * 加载圆角图片, 根据url加载网络图片,设置固定大小
     *
     * @param context
     * @param url
     * @param image
     * @param errorImg
     * @param width
     * @param height
     * @param radius
     */
    public static void loadRoundCornerBitmap(Context context, String url, ImageView image,
                                             @DrawableRes int errorImg, int width, int height, int radius,
                                             RoundedCornersTransformation.CornerType type) {
        Glide.with(context).
                load(url)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .apply(overrideOf(width, height))
                .apply(bitmapTransform(new RoundedCornersTransformation(radius, 0, type)).format(DecodeFormat.PREFER_ARGB_8888))
                .into(image);
    }

    /**
     * 加载圆角图片, 根据url加载网络图片,设置固定大小
     *
     * @param activity
     * @param url
     * @param image
     * @param errorImg
     * @param width
     * @param height
     * @param radius
     */
    public static void loadRoundCornerBitmap(Activity activity, String url, ImageView image,
                                             @DrawableRes int errorImg, int width, int height, int radius,
                                             RoundedCornersTransformation.CornerType type) {
        Glide.with(activity).
                load(url)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .apply(overrideOf(width, height))
                .apply(bitmapTransform(new RoundedCornersTransformation(radius, 0, type)).format(DecodeFormat.PREFER_ARGB_8888))
                .into(image);
    }

    /**
     * 加载圆角图片, 根据url加载网络图片,设置固定大小
     *
     * @param fragment
     * @param url
     * @param image
     * @param errorImg
     * @param width
     * @param height
     * @param radius
     */
    public static void loadRoundCornerBitmap(Fragment fragment, String url, ImageView image,
                                             @DrawableRes int errorImg, int width, int height, int radius,
                                             RoundedCornersTransformation.CornerType type) {
        Glide.with(fragment).
                load(url)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .apply(overrideOf(width, height))
                .apply(bitmapTransform(new RoundedCornersTransformation(radius, 0, type)).format(DecodeFormat.PREFER_ARGB_8888))
                .into(image);
    }

    /**
     * 加载圆角图片, 根据资源加载本地图片
     *
     * @param context
     * @param res
     * @param image
     * @param width
     * @param height
     * @param radius
     * @param errorImg
     */
    public static void loadRoundCornerBitmap(Context context, int res, ImageView image, int width,
                                             int height, int radius, int errorImg,
                                             RoundedCornersTransformation.CornerType type) {
        Glide.with(context).
                load(res)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .apply(bitmapTransform(new RoundedCornersTransformation(radius, 0, type)).format(DecodeFormat.PREFER_ARGB_8888))
                .apply(overrideOf(width, height))
                .into(image);

    }

    /**
     * 加载圆角图片, 根据资源加载本地图片
     *
     * @param activity
     * @param res
     * @param image
     * @param width
     * @param height
     * @param radius
     * @param errorImg
     */
    public static void loadRoundCornerBitmap(Activity activity, int res, ImageView image, int width,
                                             int height, int radius, int errorImg,
                                             RoundedCornersTransformation.CornerType type) {
        Glide.with(activity).
                load(res)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .apply(bitmapTransform(new RoundedCornersTransformation(radius, 0, type)).format(DecodeFormat.PREFER_ARGB_8888))
                .apply(overrideOf(width, height))
                .into(image);

    }

    /**
     * 加载圆角图片, 根据资源加载本地图片
     *
     * @param fragment
     * @param res
     * @param image
     * @param width
     * @param height
     * @param radius
     * @param errorImg
     */
    public static void loadRoundCornerBitmap(Fragment fragment, int res, ImageView image, int width,
                                             int height, int radius, int errorImg,
                                             RoundedCornersTransformation.CornerType type) {
        Glide.with(fragment).
                load(res)
                .apply(errorOf(errorImg))
                .apply(placeholderOf(errorImg))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .apply(bitmapTransform(new RoundedCornersTransformation(radius, 0, type)).format(DecodeFormat.PREFER_ARGB_8888))
                .apply(overrideOf(width, height))
                .into(image);

    }

    /**
     * 清除图片内存缓存
     */
    public static void clearImageMemoryCache(Context context) {

        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {//只能在主线程操作
                Glide.get(context).clearMemory();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 清除图片磁盘缓存
     */
    public static void clearImageDiskCache(final Context context) {

        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.get(context).clearDiskCache();
                    }
                }).start();
            } else {
                Glide.get(context).clearDiskCache();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 暂停Glide加载请求
     * 开始滑动暂停请求，滑动停止恢复请求
     */
    public static void stopGlideRequest(Context context) {
        Glide.with(context).pauseRequests();
    }

    /**
     * 恢复Glide加载请求
     */
    public static void resumeGlideRequest(Context context) {
        Glide.with(context).resumeRequests();
    }

    /**
     * 给图片设置蒙层
     *
     * @param context
     * @param url
     * @param imageView
     * @param color
     * @param error
     * @param width
     * @param height
     * @param listener
     */
    public static void loadImgWithColorFilter(Context context, String url, final ImageView imageView, int color, final int error, int width, int height, RequestListener listener) {


        Glide.with(context)
                .load(url)
                .apply(errorOf(error))
                .apply(placeholderOf(error))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .listener(listener)
                .apply(bitmapTransform(new ColorFilterTransformation(color)))
                .apply(overrideOf(width, height))
                .into(imageView);
    }

    /**
     * 给图片设置蒙层
     *
     * @param activity
     * @param url
     * @param imageView
     * @param color
     * @param error
     * @param width
     * @param height
     * @param listener
     */
    public static void loadImgWithColorFilter(Activity activity, String url, final ImageView imageView, int color, final int error, int width, int height, RequestListener listener) {
        Glide.with(activity)
                .load(url)
                .apply(errorOf(error))
                .apply(placeholderOf(error))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .listener(listener)
                .apply(bitmapTransform(new ColorFilterTransformation(color)))
                .apply(overrideOf(width, height))
                .into(imageView);
    }

    /**
     * 给图片设置蒙层
     *
     * @param fragment
     * @param url
     * @param imageView
     * @param color
     * @param error
     * @param width
     * @param height
     * @param listener
     */
    public static void loadImgWithColorFilter(Fragment fragment, String url, final ImageView imageView, int color, final int error, int width, int height, RequestListener listener) {
        Glide.with(fragment)
                .load(url)
                .apply(errorOf(error))
                .apply(placeholderOf(error))
                .apply(skipMemoryCacheOf(false))
                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .listener(listener)
                .apply(bitmapTransform(new ColorFilterTransformation(color)))
                .apply(overrideOf(width, height))
                .into(imageView);
    }
    //    public static void loadImgWithColorFilter(Context context, String url, final ImageView imageView, int color, final int error){
//        Glide.with(context)
//                .load(url)
//                .apply(errorOf(error))
//                .apply(placeholderOf(error))
//                .apply(skipMemoryCacheOf(false))
//                .apply(diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
//                .listener(new RequestListener<Drawable>() {
//                    @Override
//                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                        imageView.setImageResource(error);
//                        return true;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//
//                        return false;
//                    }
//                })
//                .apply(bitmapTransform(new ColorFilterTransformation(color)))
//                .into(imageView);
//    }


}
