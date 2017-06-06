package com.mrj.zy.animationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.my_photo)
    ImageView myPhoto;
    @BindView(R.id.alpha)//透明度渐变
            Button alpha;
    @BindView(R.id.rotate)//旋转渐变
            Button rotate;
    @BindView(R.id.scale)//缩放渐变
            Button scale;
    @BindView(R.id.translate)//位移渐变
            Button translate;
    @BindView(R.id.set_animation)//组合渐变
            Button setAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.alpha, R.id.rotate, R.id.scale, R.id.translate, R.id.set_animation})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.alpha://透明度渐变
                //通过AnimationUtils加载xml中的动画效果来得到实例
                AlphaAnimation alphaAnimation = (AlphaAnimation) AnimationUtils.
                        loadAnimation(this, R.anim.alpha_animation);

                alphaAnimation.setFillAfter(true);//动画结束后视图是否保持在结束的状态 TRUE为是 FALSE为回到初始状态

                myPhoto.startAnimation(alphaAnimation);//开始动画

                //直接使用代码来实现动画效果
//                //new一个AlphaAnimation实例参数1为初始透明度0为最终透明度
//                AlphaAnimation animations=new AlphaAnimation(1,0);
//
//                animations.setFillAfter(true);
//
//                animations.setDuration(2000);//设置动画持续时间
//
//                myPhoto.startAnimation(animations);
                break;
            case R.id.rotate://旋转渐变
                //通过AnimationUtils加载xml中的动画效果来得到实例
                RotateAnimation rotateAnimation = (RotateAnimation) AnimationUtils
                        .loadAnimation(this, R.anim.rotate_animation);

                myPhoto.startAnimation(rotateAnimation);//开始动画

                //代码的方式与透明度类似
                break;
            case R.id.scale://缩放渐变
                //通过AnimationUtils加载xml中的动画效果来得到实例
                ScaleAnimation scaleAnimation = (ScaleAnimation) AnimationUtils
                        .loadAnimation(this, R.anim.scale_animation);

                myPhoto.startAnimation(scaleAnimation);//开始动画

                break;
            case R.id.translate://位移渐变
                //通过AnimationUtils加载xml中的动画效果来得到实例
                TranslateAnimation translateAnimation = (TranslateAnimation) AnimationUtils
                        .loadAnimation(this, R.anim.translate_animation);

                myPhoto.startAnimation(translateAnimation);//开始动画

                break;
            case R.id.set_animation://组合渐变
                //通过AnimationUtils加载xml中的动画效果来得到实例
                AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.set_animation);

                myPhoto.startAnimation(animationSet);//开始动画

                //使用代码的方式实现组合动画的效果
//                AnimationSet animationSet=new AnimationSet(true);//TRUE表示子动画共用一个插值器
//
//                animationSet.addAnimation(new AlphaAnimation(1,0.5f));
//
//                animationSet.addAnimation(new ScaleAnimation(1.0f,0.5f,1.0f,0.5f));
//
//                animationSet.addAnimation(new RotateAnimation(0f,7200.0f,
//                        Animation.RELATIVE_TO_SELF,0.5f,
//                        Animation.RELATIVE_TO_SELF,0.5f));
//
//                animationSet.addAnimation(new TranslateAnimation(
//                        Animation.RELATIVE_TO_PARENT,0,
//                        Animation.RELATIVE_TO_PARENT,1.0f,
//                        Animation.RELATIVE_TO_PARENT,0,
//                        Animation.RELATIVE_TO_PARENT,1.0f));
//
//                animationSet.setDuration(5000);
//
//                myPhoto.startAnimation(animationSet);
                break;
        }
    }
}
