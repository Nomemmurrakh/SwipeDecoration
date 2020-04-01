package com.nomemmurrakh.swipedecor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple class for applying decoration to RecyclerView when user swipes left or right.
 * <p>
 * This class follows Builder Pattern for step-by-step creation, please use the Builder
 * class to build SwipeDecoration.
 * <p>
 * This class is tested with {@link ItemTouchHelper} utility class. You may build
 * SwipeDecoration outside of {@link ItemTouchHelper}. Always Remember to call
 * {@link SwipeDecoration#applyDecoration(Canvas, RecyclerView.ViewHolder, Float)} inside
 * <code>OnChildDraw</code> of {@link ItemTouchHelper} callback.
 * <p>
 * This class also supports {@link AnimatedVectorDrawable}.
 * <p>
 * @author Khurram Memon
 * @version 1.0
 * @since  04-01-2020 (April Fools :D)
 *
 */

public class SwipeDecoration {

    /**
     *  Static icon position, used to attach the icon at the start.
     */
    public static final int BEHAVIOUR_STATIC_START = 4;

    /**
     *  Static icon position, used to attach the icon at the end.
     */
    public static final int BEHAVIOUR_STATIC_END = 5;

    /**
     *  Static icon position, used to attach the icon at the center.
     */
    public static final int BEHAVIOUR_STATIC_CENTER = 6;

    /**
     *  Dynamic icon position, used to move the icon from the end to
     *  the center as the View is swiped.
     */
    public static final int BEHAVIOUR_DYNAMIC = 7;

    /**
     *  Icon Animation, used to apply fade effect on the icon.
     */
    public static final int ANIMATION_FADE = 8;

    /**
     *  Icon Animation, used to apply rotation effect on the icon.
     */
    public static final int ANIMATION_ROTATE = 9;

    /**
     *  Icon Animation, used when no animation is required.
     */
    public static final int NO_ANIMATION = 10;

    /**
     *  Left direction, used to detect swiping.
     */
    public static final int DIRECTION_LEFT = ItemTouchHelper.LEFT;

    /**
     *  Right direction, used to detect swiping.
     */
    public static final int DIRECTION_RIGHT = ItemTouchHelper.RIGHT;

    /**
     *  Default margin, used to apply margin to the icon from start/top/end.
     */
    public static final int MARGIN = 10;

    private Context context;

    private Integer iconLeftBehaviour;
    private Integer iconRightBehaviour;

    private Integer iconLeftAnimation;
    private Integer iconRightAnimation;

    private Drawable iconLeftDrawable;
    private Drawable iconRightDrawable;

    private AnimatedVectorDrawable iconLeftAnimDrawable;
    private AnimatedVectorDrawable iconRightAnimDrawable;

    private Integer backgroundLeftColor;
    private ColorDrawable backgroundLeftColorDrawable;
    private GradientDrawable backgroundLeftGradientDrawable;

    private Integer backgroundRightColor;
    private ColorDrawable backgroundRightColorDrawable;
    private GradientDrawable backgroundRightGradientDrawable;

    private Matrix rotationMatrix;

    // Private constructor
    private SwipeDecoration(Builder builder) {
        this.context = builder.context;
        this.iconLeftBehaviour = builder.iconLeftBehaviour;
        this.iconRightBehaviour = builder.iconRightBehaviour;
        this.iconLeftAnimation = builder.iconLeftAnimation;
        this.iconRightAnimation = builder.iconRightAnimation;
        this.iconLeftDrawable = builder.iconLeftDrawable;
        this.iconRightDrawable = builder.iconRightDrawable;
        this.iconLeftAnimDrawable = builder.iconLeftAnimDrawable;
        this.iconRightAnimDrawable = builder.iconRightAnimDrawable;
        this.backgroundLeftGradientDrawable = builder.backgroundLeftGradientDrawable;
        this.backgroundLeftColorDrawable = builder.backgroundLeftColorDrawable;
        this.backgroundLeftColor = builder.backgroundLeftColor;
        this.backgroundRightGradientDrawable = builder.backgroundRightGradientDrawable;
        this.backgroundRightColorDrawable = builder.backgroundRightColorDrawable;
        this.backgroundRightColor = builder.backgroundRightColor;
        rotationMatrix = new Matrix();
    }

    public Context getContext() {
        return context;
    }

    public Integer getIconLeftBehaviour() {
        return iconLeftBehaviour;
    }

    public Integer getIconRightBehaviour() {
        return iconRightBehaviour;
    }

    public Integer getIconLeftAnimation() {
        return iconLeftAnimation;
    }

    public Integer getIconRightAnimation() {
        return iconRightAnimation;
    }

    public Drawable getIconLeftDrawable() {
        return iconLeftDrawable;
    }

    public Drawable getIconRightDrawable() {
        return iconRightDrawable;
    }

    public AnimatedVectorDrawable getIconLeftAnimDrawable() {
        return iconLeftAnimDrawable;
    }

    public AnimatedVectorDrawable getIconRightAnimDrawable() {
        return iconRightAnimDrawable;
    }

    public Integer getBackgroundLeftColor() {
        return backgroundLeftColor;
    }

    public ColorDrawable getBackgroundLeftColorDrawable() {
        return backgroundLeftColorDrawable;
    }

    public GradientDrawable getBackgroundLeftGradientDrawable() {
        return backgroundLeftGradientDrawable;
    }

    public Integer getBackgroundRightColor() {
        return backgroundRightColor;
    }

    public ColorDrawable getBackgroundRightColorDrawable() {
        return backgroundRightColorDrawable;
    }

    public GradientDrawable getBackgroundRightGradientDrawable() {
        return backgroundRightGradientDrawable;
    }

    public static class Builder{

        private Context context;

        private Integer iconLeftBehaviour;
        private Integer iconRightBehaviour;

        private Integer iconLeftAnimation;
        private Integer iconRightAnimation;

        private Drawable iconLeftDrawable;
        private Drawable iconRightDrawable;

        private AnimatedVectorDrawable iconLeftAnimDrawable;
        private AnimatedVectorDrawable iconRightAnimDrawable;

        private Integer backgroundLeftColor;
        private ColorDrawable backgroundLeftColorDrawable;
        private GradientDrawable backgroundLeftGradientDrawable;

        private Integer backgroundRightColor;
        private ColorDrawable backgroundRightColorDrawable;
        private GradientDrawable backgroundRightGradientDrawable;


        public Builder(Context context){
            this.context = context;
            this.iconLeftBehaviour = null;
            this.iconRightBehaviour = null;
            this.iconLeftAnimation = null;
            this.iconRightAnimation = null;
            this.iconLeftDrawable = null;
            this.iconRightDrawable = null;
            this.iconLeftAnimDrawable = null;
            this.iconRightAnimDrawable = null;
            this.backgroundLeftGradientDrawable = null;
            this.backgroundLeftColorDrawable = null;
            this.backgroundLeftColor = null;
            this.backgroundRightGradientDrawable = null;
            this.backgroundRightColorDrawable = null;
            this.backgroundRightColor = null;
        }

        public Builder setIconLeftBehaviour(int iconLeftBehaviour){
            this.iconLeftBehaviour = iconLeftBehaviour;
            return this;
        }

        public Builder setIconLeftAnimation(int iconLeftAnimation){
            this.iconLeftAnimation = iconLeftAnimation;
            return this;
        }

        public Builder setIconLeftResource(@DrawableRes int iconLeftResource){
            this.iconLeftDrawable = ActivityCompat.getDrawable(context, iconLeftResource);
            return this;
        }

        public Builder setIconLeftDrawable(Drawable iconLeftDrawable){
            this.iconLeftDrawable = iconLeftDrawable;
            return this;
        }

        public Builder setIconLeftAnimDrawable(@DrawableRes int iconLeftAnimDrawable){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                this.iconLeftAnimDrawable = (AnimatedVectorDrawable) ActivityCompat.getDrawable(context, iconLeftAnimDrawable);
            }
            return this;
        }

        public Builder setIconRightBehaviour(int iconRightBehaviour){
            this.iconRightBehaviour = iconRightBehaviour;
            return this;
        }

        public Builder setIconRightAnimation(int iconRightAnimation) {
            this.iconRightAnimation = iconRightAnimation;
            return this;
        }

        public Builder setIconRightResource(@DrawableRes int iconRightResource){
            this.iconRightDrawable = ActivityCompat.getDrawable(context, iconRightResource);
            return this;
        }

        public Builder setIconRightDrawable(Drawable iconRightDrawable){
            this.iconRightDrawable = iconRightDrawable;
            return this;
        }

        public Builder setIconRightAnimDrawable(@DrawableRes int iconRightAnimDrawable){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                this.iconRightAnimDrawable = (AnimatedVectorDrawable) ActivityCompat.getDrawable(context, iconRightAnimDrawable);
            }
            return this;
        }

        public Builder setBackgroundLeftColor(Integer backgroundLeftColor){
            this.backgroundLeftColor = backgroundLeftColor;
            return this;
        }

        public Builder setBackgroundLeftColorDrawable(ColorDrawable backgroundLeftColorDrawable){
            this.backgroundLeftColorDrawable = backgroundLeftColorDrawable;
            return this;
        }

        public Builder setBackgroundLeftGradientDrawable(GradientDrawable backgroundLeftGradientDrawable){
            this.backgroundLeftGradientDrawable = backgroundLeftGradientDrawable;
            return this;
        }

        public Builder setBackgroundRightColor(Integer backgroundRightColor){
            this.backgroundRightColor = backgroundRightColor;
            return this;
        }

        public Builder setBackgroundRightColorDrawable(ColorDrawable backgroundRightColorDrawable){
            this.backgroundRightColorDrawable = backgroundRightColorDrawable;
            return this;
        }

        public Builder setBackgroundRightGradientDrawable(GradientDrawable backgroundRightGradientDrawable){
            this.backgroundRightGradientDrawable = backgroundRightGradientDrawable;
            return this;
        }

        /**
         * @return new Swipe Decoration Object
         */
        public SwipeDecoration build(){
            return new SwipeDecoration(this);
        }
    }

    /**
     * This method apply decorations to view when swiped.
     * <p>
     * Must be used inside of <code>OnChildDraw</code> of {@link ItemTouchHelper} callback.
     * @param c canvas on which decorations are applied.
     * @param viewHolder used to get the view being swiped.
     * @param dX horizontal displacement, how much has the view swiped.
     */
    public void applyDecoration(@NonNull Canvas c, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull Float dX){

        View view = viewHolder.itemView;
        int direction = dX.intValue() > 0 ? DIRECTION_RIGHT : DIRECTION_LEFT;
        float rotationAngle;
        float pivotX;
        float pivotY;
        float alpha;
        int angleConstraint;
        int absoluteDisplacement = Math.abs(dX.intValue());
        int viewLeft = view.getLeft();
        int viewTop = view.getTop();
        int viewRight = view.getRight();
        int viewBottom = view.getBottom();
        int viewWidth = view.getWidth();
        int viewHeight = view.getHeight();
        int marginStartForIconLeft;
        int marginEndForIconRight;
        int marginTop;
        int iconWidth;
        int iconHeight;

        switch (direction){
            case DIRECTION_RIGHT:

                Rect backgroundView = new Rect(viewLeft, viewTop, viewLeft + absoluteDisplacement, viewBottom);
                if (backgroundLeftGradientDrawable != null){

                    backgroundLeftGradientDrawable.setBounds(backgroundView);
                    backgroundLeftGradientDrawable.draw(c);

                }else if(backgroundLeftColorDrawable != null){

                    backgroundLeftColorDrawable.setBounds(backgroundView);
                    backgroundLeftColorDrawable.draw(c);
                }else if (backgroundLeftColor != null){

                    backgroundLeftColorDrawable = new ColorDrawable();
                    backgroundLeftColorDrawable.setColor(backgroundLeftColor);
                    backgroundLeftColorDrawable.setBounds(backgroundView);
                    backgroundLeftColorDrawable.draw(c);
                }

                if (iconLeftAnimDrawable != null){

                    iconWidth = iconLeftAnimDrawable.getIntrinsicWidth();
                    iconHeight = iconLeftAnimDrawable.getIntrinsicHeight();

                    marginStartForIconLeft = (viewWidth - iconWidth) / 2;
                    marginTop = ((viewHeight - iconHeight) / 2) + viewTop;

                    if (iconLeftBehaviour == null){
                        iconLeftBehaviour = BEHAVIOUR_STATIC_START;
                    }

                    switch (iconLeftBehaviour){
                        case BEHAVIOUR_STATIC_END:
                            iconLeftAnimDrawable.setBounds((absoluteDisplacement - iconWidth) - MARGIN, marginTop, absoluteDisplacement - MARGIN, marginTop + iconHeight);
                            iconLeftAnimDrawable.draw(c);
                            break;
                        case BEHAVIOUR_STATIC_CENTER:
                            iconLeftAnimDrawable.setBounds(marginStartForIconLeft, marginTop, marginStartForIconLeft + iconWidth, marginTop + iconHeight);
                            iconLeftAnimDrawable.draw(c);
                            break;
                        case BEHAVIOUR_DYNAMIC:
                            marginStartForIconLeft = Math.min(absoluteDisplacement, (marginStartForIconLeft + iconWidth) + MARGIN);
                            iconLeftAnimDrawable.setBounds((marginStartForIconLeft - iconWidth) - MARGIN, marginTop, marginStartForIconLeft - MARGIN, marginTop + iconHeight);
                            iconLeftAnimDrawable.draw(c);
                            break;
                        case BEHAVIOUR_STATIC_START:
                        default:
                            iconLeftAnimDrawable.setBounds(MARGIN, marginTop, iconWidth + MARGIN, marginTop + iconHeight);
                            iconLeftAnimDrawable.draw(c);
                            break;
                    }
                    iconLeftAnimDrawable.start();
                    return;
                }


                if (iconLeftDrawable != null){

                    iconWidth = iconLeftDrawable.getIntrinsicWidth();
                    iconHeight = iconLeftDrawable.getIntrinsicHeight();

                    marginStartForIconLeft = (viewWidth - iconWidth) / 2;
                    marginTop = ((viewHeight - iconHeight) / 2) + viewTop;

                    if (iconLeftBehaviour == null){
                        iconLeftBehaviour = BEHAVIOUR_STATIC_START;
                    }

                    if (iconLeftAnimation == null){
                        iconLeftAnimation = NO_ANIMATION;
                    }

                    if (iconLeftAnimation == ANIMATION_ROTATE){

                        angleConstraint = (viewWidth / 2);
                        angleConstraint = Math.min(absoluteDisplacement, angleConstraint);
                        pivotX = (iconWidth / 2.0f);
                        pivotY = (iconHeight / 2.0f);
                        rotationAngle = ((angleConstraint / (viewWidth / 2.0f)) * 360);

                        Bitmap bitmapForStart = drawableToBitmap(iconLeftDrawable);
                        rotationMatrix.setRotate(rotationAngle, pivotX, pivotY);

                        switch (iconLeftBehaviour){
                            case BEHAVIOUR_STATIC_START:
                                rotationMatrix.postTranslate(MARGIN, marginTop);
                                break;
                            case BEHAVIOUR_STATIC_END:
                                rotationMatrix.postTranslate((absoluteDisplacement - iconWidth) - MARGIN, marginTop);
                                break;
                            case BEHAVIOUR_STATIC_CENTER:
                                rotationMatrix.postTranslate(marginStartForIconLeft, marginTop);
                                break;
                            case BEHAVIOUR_DYNAMIC:
                                marginStartForIconLeft = Math.min(absoluteDisplacement, (marginStartForIconLeft + iconWidth) + MARGIN);
                                rotationMatrix.postTranslate((marginStartForIconLeft - iconWidth) - MARGIN, marginTop);
                                break;
                        }
                        c.drawBitmap(bitmapForStart, rotationMatrix, null);
                    }else{

                        if (iconLeftAnimation == ANIMATION_FADE){

                            alpha = ((absoluteDisplacement / ((viewWidth + iconWidth) / 2.0f)) * 255);
                            iconLeftDrawable.setAlpha((int)alpha);
                        }

                        switch (iconLeftBehaviour){
                            case BEHAVIOUR_STATIC_START:

                                iconLeftDrawable.setBounds(MARGIN, marginTop, iconWidth + MARGIN, marginTop + iconHeight);
                                iconLeftDrawable.draw(c);

                                break;
                            case BEHAVIOUR_STATIC_END:

                                iconLeftDrawable.setBounds((absoluteDisplacement - iconWidth) - MARGIN, marginTop, absoluteDisplacement - MARGIN, marginTop + iconHeight);
                                iconLeftDrawable.draw(c);

                                break;
                            case BEHAVIOUR_STATIC_CENTER:

                                iconLeftDrawable.setBounds(marginStartForIconLeft, marginTop, marginStartForIconLeft + iconWidth, marginTop + iconHeight);
                                iconLeftDrawable.draw(c);

                                break;
                            case BEHAVIOUR_DYNAMIC:

                                marginStartForIconLeft = Math.min(absoluteDisplacement, (marginStartForIconLeft + iconWidth) + MARGIN);
                                iconLeftDrawable.setBounds((marginStartForIconLeft - iconWidth) - MARGIN, marginTop, marginStartForIconLeft - MARGIN, marginTop + iconHeight);
                                iconLeftDrawable.draw(c);

                                break;
                        }
                    }
                }

                break;
            case DIRECTION_LEFT:

                backgroundView = new Rect(viewRight - absoluteDisplacement, viewTop, viewRight, viewBottom);
                if (backgroundRightGradientDrawable != null){

                    backgroundRightGradientDrawable.setBounds(backgroundView);
                    backgroundRightGradientDrawable.draw(c);

                }else if(backgroundRightColorDrawable != null){

                    backgroundRightColorDrawable.setBounds(backgroundView);
                    backgroundRightColorDrawable.draw(c);
                }else if (backgroundRightColor != null){

                    backgroundRightColorDrawable = new ColorDrawable();
                    backgroundRightColorDrawable.setColor(backgroundRightColor);
                    backgroundRightColorDrawable.setBounds(backgroundView);
                    backgroundRightColorDrawable.draw(c);
                }

                if (iconRightAnimDrawable != null){

                    iconWidth = iconRightAnimDrawable.getIntrinsicWidth();
                    iconHeight = iconRightAnimDrawable.getIntrinsicHeight();

                    marginEndForIconRight = (viewWidth - iconWidth) / 2;
                    marginTop = ((viewHeight - iconHeight) / 2) + viewTop;

                    if (iconRightBehaviour == null){
                        iconRightBehaviour = BEHAVIOUR_STATIC_START;
                    }

                    switch (iconRightBehaviour){
                        case BEHAVIOUR_STATIC_END:
                            iconRightAnimDrawable.setBounds((viewWidth - absoluteDisplacement) + MARGIN, marginTop, (viewWidth + iconWidth + MARGIN) - absoluteDisplacement, marginTop + iconHeight);
                            iconRightAnimDrawable.draw(c);
                            break;
                        case BEHAVIOUR_STATIC_CENTER:
                            iconRightAnimDrawable.setBounds(marginEndForIconRight, marginTop, marginEndForIconRight + iconWidth, marginTop + iconHeight);
                            iconRightAnimDrawable.draw(c);
                            break;
                        case BEHAVIOUR_DYNAMIC:
                            marginEndForIconRight = Math.min(absoluteDisplacement, (marginEndForIconRight + iconWidth) + MARGIN);
                            iconRightAnimDrawable.setBounds((viewWidth - marginEndForIconRight) + MARGIN, marginTop, (viewWidth + iconWidth + MARGIN) - marginEndForIconRight, marginTop + iconHeight);
                            iconRightAnimDrawable.draw(c);
                            break;
                        case BEHAVIOUR_STATIC_START:
                        default:
                            iconRightAnimDrawable.setBounds((viewWidth - iconWidth) - MARGIN, marginTop, viewWidth - MARGIN, marginTop + iconHeight);
                            iconRightAnimDrawable.draw(c);
                            break;
                    }
                    iconRightAnimDrawable.start();
                    return;
                }

                if (iconRightDrawable != null){

                    iconWidth = iconRightDrawable.getIntrinsicWidth();
                    iconHeight = iconRightDrawable.getIntrinsicHeight();

                    marginEndForIconRight = (viewWidth - iconWidth) / 2;
                    marginTop = ((viewHeight - iconHeight) / 2) + viewTop;

                    if (iconRightBehaviour == null){
                        iconRightBehaviour = BEHAVIOUR_STATIC_START;
                    }

                    if (iconRightAnimation == null){
                        iconRightAnimation = NO_ANIMATION;
                    }

                    if (iconRightAnimation == ANIMATION_ROTATE){

                        angleConstraint = (viewWidth / 2);
                        angleConstraint = Math.min(absoluteDisplacement, angleConstraint);
                        pivotX = (iconWidth / 2.0f);
                        pivotY = (iconHeight / 2.0f);
                        rotationAngle = ((angleConstraint / (viewWidth / 2.0f)) * 360);

                        Bitmap bitmapForStart = drawableToBitmap(iconRightDrawable);
                        rotationMatrix.setRotate(rotationAngle, pivotX, pivotY);

                        switch (iconRightBehaviour){
                            case BEHAVIOUR_STATIC_START:
                                rotationMatrix.postTranslate(viewWidth - MARGIN, marginTop);
                                break;
                            case BEHAVIOUR_STATIC_END:
                                rotationMatrix.postTranslate((viewWidth + iconWidth + MARGIN) - absoluteDisplacement, marginTop);
                                break;
                            case BEHAVIOUR_STATIC_CENTER:
                                rotationMatrix.postTranslate(marginEndForIconRight, marginTop);
                                break;
                            case BEHAVIOUR_DYNAMIC:
                                marginEndForIconRight = Math.min(absoluteDisplacement, (marginEndForIconRight + iconWidth) + MARGIN);
                                rotationMatrix.postTranslate((viewWidth + MARGIN) - marginEndForIconRight, marginTop);
                                break;
                        }
                        c.drawBitmap(bitmapForStart, rotationMatrix, null);
                    }else{

                        if (iconRightAnimation == ANIMATION_FADE){

                            alpha = ((absoluteDisplacement / ((viewWidth + iconWidth) / 2.0f)) * 255);
                            iconRightDrawable.setAlpha((int)alpha);
                        }

                        switch (iconRightBehaviour){
                            case BEHAVIOUR_STATIC_START:

                                iconRightDrawable.setBounds((viewWidth - iconWidth) - MARGIN, marginTop, viewWidth - MARGIN, marginTop + iconHeight);
                                iconRightDrawable.draw(c);


                                break;
                            case BEHAVIOUR_STATIC_END:

                                iconRightDrawable.setBounds((viewWidth + MARGIN) - absoluteDisplacement, marginTop, (viewWidth + iconWidth + MARGIN) - absoluteDisplacement, marginTop + iconHeight);
                                iconRightDrawable.draw(c);

                                break;
                            case BEHAVIOUR_STATIC_CENTER:

                                iconRightDrawable.setBounds(marginEndForIconRight, marginTop, marginEndForIconRight + iconWidth, marginTop + iconHeight);
                                iconRightDrawable.draw(c);


                                break;
                            case BEHAVIOUR_DYNAMIC:

                                marginEndForIconRight = Math.min(absoluteDisplacement, (marginEndForIconRight + iconWidth) + MARGIN);
                                iconRightDrawable.setBounds((viewWidth + MARGIN) - marginEndForIconRight, marginTop, (viewWidth + iconWidth + MARGIN) - marginEndForIconRight, marginTop + iconHeight);
                                iconRightDrawable.draw(c);

                                break;
                        }
                    }
                }

                break;
        }
    }

    /**
     * Helper method to convert a drawable to Bitmap. Bonus
     * @param drawable to convert
     * @return converted bitmap
     */
    public static Bitmap drawableToBitmap (Drawable drawable) {

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable)drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0,0,canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }
}
