package org.caresptogo.covid_19tg.config;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.Animation;
import com.mindorks.placeholderview.annotations.Animate;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import org.caresptogo.covid_19tg.R;

import ozaydin.serkan.com.image_zoom_view.ImageViewZoom;

@NonReusable
@Layout(R.layout.gallery_item)
public class GalleryItem {

    @View(R.id.imageView)
    public ImageViewZoom imageView;

    public Drawable mDrawable;

    public GalleryItem(Drawable drawable) {
        mDrawable = drawable;
    }

    @Resolve
    public void onResolved() {
        imageView.setImageDrawable(mDrawable);
    }
}