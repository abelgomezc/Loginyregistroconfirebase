package com.abelgomez.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.animation.AnimationUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Agregaranimaciones

        Animation animacion1 = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animacion2 = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);

//        Animation animacion1 = AnimationUtils.loadAnimation(This, R.anim.desplazamiento_arriba);
//
//        Animation animacion2 = AnimationUtils.loadAnimation(This, R.anim.desplazamiento_abajo);

        TextView deTextView = findViewById(R.id.txtiniciologo_de);
        TextView codeTextView = findViewById(R.id.txtiniciologo_abelcode);
        ImageView logoImageView = findViewById(R.id.imageViewlogo);


        deTextView.setAnimation(animacion2);
        codeTextView.setAnimation(animacion2);
        logoImageView.setAnimation(animacion1);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(MainActivity.this, UserActivity.class);
                    startActivity(intent);
                    finish();
                } else {

                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    Pair[] pairs = new Pair[2];
                    pairs[0] = new Pair<View, String>(logoImageView, "logoImageTrans");
                    pairs[1] = new Pair<View, String>(codeTextView, "textTrans");

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                        startActivity(intent, options.toBundle());
                    } else {
                        startActivity(intent);
                        finish();
                    }


                }


            }
        }, 4000);
    }
//

//        new Handler().postDelayed(() -> {
//
//
//
//
//
//
//
//
//            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//            Pair[] pairs = new Pair[2];
//            pairs[0] = new Pair<View, String>(logoImageView, "logoImageTrans");
//            pairs[1] = new Pair<View, String>(codeTextView, "textTrans");
//
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
//                startActivity(intent, options.toBundle());
//            } else {
//                startActivity(intent);
//                finish();
//            }
//
////            startActivity(intent);
////            finish();
//
//        }, 4000);
//    }
}