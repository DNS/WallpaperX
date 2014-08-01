

package com.danielsirait.WallpaperX;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;

public class MyWallpaperService extends WallpaperService {


    @Override
    public Engine onCreateEngine() {
        Context context = getApplicationContext();
        //return null;
        return new WallpaperEngine(context);
    }

    private class WallpaperEngine extends Engine {
        public WallpaperEngine (Context context) {
            SurfaceHolder holder = getSurfaceHolder();
            Canvas canvas = null;
            try {
                canvas = holder.lockCanvas();
                Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.grumpy_ray_small);
                canvas.drawBitmap(bmp,0.0f, 5.0f, null);
                //canvas.setBitmap(bmp);
                //canvas.drawColor(000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null)
                    holder.unlockCanvasAndPost(canvas);
            }

            Intent intent = new Intent(context, WallpaperActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
