package com.wally.android.todo.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.Rect;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Hezihao on 2017/10/9.
 * 屏幕工具类
 */

public class ScreenUtil {
    public static float displayDensity = 0.0F;
    private static Boolean _hasBigScreen = null;

    private ScreenUtil() {
    }

    public static float getDensity(Context context) {
        if (displayDensity == 0.0) {
            displayDensity = getDisplayMetrics(context).density;
        }
        return displayDensity;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    /**
     * dp转px
     *
     * @param dp
     * @return
     */
    public static float dpToPixel(Context context, float dp) {
        return dp * (getDisplayMetrics(context).densityDpi / 160F);
    }

    /**
     * sp转px
     *
     * @param spValue
     * @return
     */
    public static int spToPixel(Context context, float spValue) {
        final float fontScale = getDisplayMetrics(context).scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * xp转dp
     *
     * @param f
     * @return
     */
    public static float pixelsToDp(Context context, float f) {
        return f / (getDisplayMetrics(context).densityDpi / 160F);
    }

    /**
     * 获取屏幕高度，不包括NavigationBar
     *
     * @return
     */
    public static float getScreenHeight(Context context) {
        return getDisplayMetrics(context).heightPixels;
    }

    /**
     * 获取屏幕宽度
     *
     * @return
     */
    public static float getScreenWidth(Context context) {
        return getDisplayMetrics(context).widthPixels;
    }

    /**
     * 获取屏幕原始尺寸高度，包括虚拟功能键高度
     */
    public static int getScreenHeightWithNavigationBar(Activity activity) {
        return (int) (getScreenHeight(activity.getApplicationContext())
                + NavigationBarUtil.getNavigationBarHeight(activity));
    }

    /**
     * 设置全屏
     *
     * @param activity
     */
    public static void setFullScreen(Activity activity) {
        WindowManager.LayoutParams params = activity.getWindow().getAttributes();
        params.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        activity.getWindow().setAttributes(params);
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    /**
     * 退出全屏
     *
     * @param activity
     */
    public static void cancelFullScreen(Activity activity) {
        WindowManager.LayoutParams params = activity.getWindow().getAttributes();
        params.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
        activity.getWindow().setAttributes(params);
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    /**
     * 是否是横屏
     *
     * @param context
     * @return
     */
    public static boolean isLandscape(Context context) {
        boolean flag;
        flag = context.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
        return flag;
    }

    /**
     * 是否是竖屏
     *
     * @param context
     * @return
     */
    public static boolean isPortrait(Context context) {
        boolean flag = true;
        if (context.getResources().getConfiguration().orientation
                != Configuration.ORIENTATION_PORTRAIT)
            flag = false;
        return flag;
    }

    /**
     * Whether the Status bar is hidden or not,the method always helps you get
     * the height of Status bar.
     * 获得状态栏的高度
     *
     * @param context The context to use. Usually your
     *                {@link android.app.Application} or
     *                {@link Activity} object.
     * @return Return the height of Status bar.
     */
    public static int getStatusHeight(Context context) {
        int statusHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int id = (Integer) (clazz.getField("status_bar_height").get(object));
            statusHeight = context.getResources().getDimensionPixelSize(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }

    /**
     * 功能描述：获取整块屏幕的高度
     *
     * @param context
     * @return int
     */
    public static int getRealScreenHeight(Context context) {
        int dpi = 0;
        Display display = ((Activity) context).getWindowManager()
                .getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        @SuppressWarnings("rawtypes")
        Class c;
        try {
            c = Class.forName("android.view.Display");
            @SuppressWarnings("unchecked") Method method = c.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(display, dm);
            dpi = dm.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dpi;
    }

    /**
     * 功能描述：获取虚拟按键区域的高度
     *
     * @param context
     * @return int 如果有虚拟按键则返回其高度否则返回0；
     */
    public static int getNavigationAreaHeight(Context context) {
        int realScreenHeight = getRealScreenHeight(context);
        int screenHeight = (int) getScreenHeight(context);
        return realScreenHeight - screenHeight;
    }

    /**
     * 获取导航栏高度
     *
     * @param context
     * @return
     */
    public static int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        return resources.getDimensionPixelOffset(identifier);
    }

    /**
     * 获取当前屏幕截图，包含状态栏
     */
    public static Bitmap snapShotWithStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        int width = (int) getScreenWidth(activity);
        int height = (int) getScreenHeight(activity);
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, 0, width, height);
        view.destroyDrawingCache();
        return bp;

    }

    /**
     * 获取当前屏幕截图，不包含状态栏
     */
    public static Bitmap snapShotWithoutStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        int width = (int) getScreenWidth(activity);
        int height = (int) getScreenHeight(activity);
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height - statusBarHeight);
        view.destroyDrawingCache();
        return bp;
    }

    /**
     * 获得标题栏高度
     *
     * @param context 上下文，为Activity对象
     * @return 标题栏高度
     */
    public static int getTitleBarHeight(Activity context) {
        int contentTop = context.getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
        return contentTop - getStatusBarHeight(context);
    }

    /**
     * 获取通知栏高度
     *
     * @param context 上下文
     * @return 通知栏高度
     */
    public static int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object obj = clazz.newInstance();
            Field field = clazz.getField("status_bar_height");
            int temp = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusBarHeight;
    }

    /**
     * 获取指定Activity的截屏，保存到png文件
     *
     * @param activity activity
     * @return 截屏Bitmap
     */
    private static Bitmap takeScreenShot(Activity activity) {
        // View是你需要截图的View
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap b1 = view.getDrawingCache();

        // 获取状态栏高度
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        Log.i("TAG", "" + statusBarHeight);

        // 获取屏幕长和高
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay()
                .getHeight();
        Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, width, height
                - statusBarHeight);
        view.destroyDrawingCache();
        return b;
    }

    /**
     * 保存bitmap
     *
     * @param b           bitmap
     * @param strFileName 文件名
     * @return 是否保存成功
     */
    private static boolean savePic(Bitmap b, String strFileName) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(strFileName);
            if (null != fos) {
                b.compress(Bitmap.CompressFormat.PNG, 90, fos);
                fos.flush();
                fos.close();
                return true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 截取webView快照(webView加载的整个内容的大小)
     *
     * @param webView webview
     * @return 截屏bitmap
     */
    private static Bitmap captureWebView(WebView webView) {
        Picture snapShot = webView.capturePicture();

        Bitmap bmp = Bitmap.createBitmap(snapShot.getWidth(), snapShot.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        snapShot.draw(canvas);
        return bmp;
    }

    /**
     * 根据毫秒获得格式化日期
     *
     * @param time   毫秒数
     * @param format 格式化字符串
     * @return 格式化后的字符串
     */
    private static String getDate(long time, String format) {
        Date date = new Date(time);
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String daystr = formatter.format(date);
        return daystr;
    }

    /**
     * 是否存在sd卡
     *
     * @return 是否存在sd卡
     */
    private static Boolean isExistsSD() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
            return true;
        return false;
    }

    /**
     * 获得文件名
     *
     * @param context 上下文
     * @return 文件名
     */
    private static String getFileName(Context context) {
        String fileName = getDate(System.currentTimeMillis(), "yyyyMMddHHmmss") + ".png";
        final String localPath;
        if (isExistsSD()) {
            localPath = context.getExternalCacheDir() + File.separator + fileName;
        } else {
            localPath = context.getFilesDir() + fileName;
        }

        return localPath;
    }

    /**
     * 截屏并保存
     *
     * @param a activity
     * @return 保存的路径
     */
    public static String shoot(Activity a) {
        String localPath = getFileName(a);
        boolean ret = savePic(takeScreenShot(a), localPath);
        if (ret) {
            return localPath;
        } else {
            return "";
        }
    }

    /**
     * 截屏并保存
     *
     * @param context 上下文
     * @param webView webview
     * @return 保存的路径
     */
    public static String shootWebView(Context context, WebView webView) {
        String localPath = getFileName(context);
        boolean ret = savePic(captureWebView(webView), localPath);
        if (ret) {
            return localPath;
        } else {
            return "";
        }
    }
}
