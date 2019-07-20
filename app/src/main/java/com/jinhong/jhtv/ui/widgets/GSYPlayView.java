package com.jinhong.jhtv.ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.jinhong.jhtv.R;

/**
 * @author :  Jim
 * @date :  2019-07-20
 * @description :播放，暂停按钮显示
 */
public class GSYPlayView extends View {
    public static int STATE_PLAY = 0;

    public static int STATE_PAUSE = 1;

    public static int DEFAULT_LINE_COLOR = Color.WHITE;

    public static int DEFAULT_BG_LINE_COLOR = 0xfffafafa;

    public static int DEFAULT_LINE_WIDTH = 4;

    public static int DEFAULT_BG_LINE_WIDTH = 4;

    public static int DEFAULT_DURATION = 1200;

    private int mCurrentState = STATE_PAUSE;

    private Paint mPaint, mBgPaint;

    private int mWidth, mHeight;

    private int mCenterX, mCenterY;

    private int mCircleRadius;

    private RectF mRectF, mBgRectF;

    private float mFraction = 1;

    private Path mPath, mDstPath;

    private PathMeasure mPathMeasure;

    private float mPathLength;

    private int mDuration;

    public GSYPlayView(Context context) {
        super(context);
    }

    public GSYPlayView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.play);
        int lineColor = ta.getColor(R.styleable.play_play_line_color, DEFAULT_LINE_COLOR);
        int bgLineColor = ta.getColor(R.styleable.play_play_bg_line_color, DEFAULT_BG_LINE_COLOR);
        int lineWidth = ta.getInteger(R.styleable.play_play_line_width, dp2px(DEFAULT_LINE_WIDTH));
        int bgLineWidth = ta.getInteger(R.styleable.play_play_bg_line_width, dp2px(DEFAULT_BG_LINE_WIDTH));
        ta.recycle();

        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setColor(lineColor);
        mPaint.setStrokeWidth(lineWidth);
        mPaint.setPathEffect(new CornerPathEffect(1));

        mBgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBgPaint.setStyle(Paint.Style.STROKE);
        mBgPaint.setStrokeCap(Paint.Cap.ROUND);
        mBgPaint.setColor(bgLineColor);
        mBgPaint.setStrokeWidth(bgLineWidth);

        mPath = new Path();
        mDstPath = new Path();
        mPathMeasure = new PathMeasure();

        mDuration = DEFAULT_DURATION;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w * 9 / 10;
        mHeight = h * 9 / 10;
        mCircleRadius = mWidth / dp2px(4);
        mCenterX = w / 2;
        mCenterY = h / 2;
        mRectF = new RectF(mCenterX - mCircleRadius, mCenterY + 0.6f * mCircleRadius,
                mCenterX + mCircleRadius, mCenterY + 2.6f * mCircleRadius);
        mBgRectF = new RectF(mCenterX - mWidth / 2, mCenterY - mHeight / 2, mCenterX + mWidth / 2, mCenterY + mHeight / 2);
        mPath.moveTo(mCenterX - mCircleRadius, mCenterY + 1.8f * mCircleRadius);
        mPath.lineTo(mCenterX - mCircleRadius, mCenterY - 1.8f * mCircleRadius);
        mPath.lineTo(mCenterX + mCircleRadius, mCenterY);
        mPath.close();
        mPathMeasure.setPath(mPath, false);
        mPathLength = mPathMeasure.getLength();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mCurrentState == STATE_PLAY) {
            //播放图片自定义
            setBackgroundResource(R.drawable.iv_player_stop);
        } else if (mCurrentState == STATE_PAUSE) {
            //暂停图片自定义
            setBackgroundResource(R.drawable.iv_player_play);
        }

}

    public void play() {
        if (mCurrentState == STATE_PLAY) {
            return;
        }
        mCurrentState = STATE_PLAY;
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1.f, 100.f);
//        valueAnimator.setDuration(mDuration);
//        valueAnimator.setInterpolator(new AnticipateInterpolator());
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                mFraction = 1 - valueAnimator.getAnimatedFraction();
//                invalidate();
//            }
//        });
//        if (!valueAnimator.isRunning()) {
//            valueAnimator.start();
//        }
        setBackgroundResource(R.drawable.iv_player_stop);
    }

    public void pause() {
        if (mCurrentState == STATE_PAUSE) {
            return;
        }
        mCurrentState = STATE_PAUSE;
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1.f, 100.f);
//        valueAnimator.setDuration(mDuration);
//        valueAnimator.setInterpolator(new AnticipateInterpolator());
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                mFraction = valueAnimator.getAnimatedFraction();
//                invalidate();
//            }
//        });
//        if (!valueAnimator.isRunning()) {
//            valueAnimator.start();
//        }
        setBackgroundResource(R.drawable.iv_player_play);
    }

    public int getCurrentState() {
        return mCurrentState;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getContext().getResources().getDisplayMetrics());
    }
}
