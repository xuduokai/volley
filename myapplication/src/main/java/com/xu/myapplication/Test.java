package com.xu.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

/**
 * Created by xuduokai on 2017/3/21.
 */

public class Test {
    public void testImageLoad(Context context, ImageView imageView) {
        RequestQueue queue = Volley.newRequestQueue(context);

        ImageLoader imageLoader = new ImageLoader(queue, new BitmapCache());

        ImageLoader.ImageListener listener = ImageLoader.getImageListener(imageView, R.drawable.like, R.drawable.unlike);

        imageLoader.get("http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg", listener);
    }

    public void testNetworkImageView(Activity activity) {
        RequestQueue queue = Volley.newRequestQueue(activity);

        ImageLoader imageLoader = new ImageLoader(queue, new BitmapCache());

        NetworkImageView networkImageView = (NetworkImageView) activity.findViewById(R.id.network_image);

        networkImageView.setDefaultImageResId(R.drawable.like);
        networkImageView.setErrorImageResId(R.drawable.unlike);
        networkImageView.setImageUrl("http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg", imageLoader);
    }
}
