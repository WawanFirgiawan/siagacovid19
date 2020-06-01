package mandev.com.siagacovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView ivtitle, ivsubtitle, ivbtn;
    ImageView ivsplash;
    Animation smalltobig, fromlefttoright, fleft, fhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smalltobig = AnimationUtils.loadAnimation(this, R.anim.smalltobig);
        fromlefttoright = AnimationUtils.loadAnimation(this, R.anim.fromlefttoright);
        fleft = AnimationUtils.loadAnimation(this, R.anim.fleft);
        fhelper = AnimationUtils.loadAnimation(this, R.anim.fhelper);

        Typeface logox = Typeface.createFromAsset(getAssets(), "fonts/roboto_bold.ttf");
        Typeface light = Typeface.createFromAsset(getAssets(), "fonts/roboto_light.ttf");
        Typeface regular = Typeface.createFromAsset(getAssets(), "fonts/roboto_regular.ttf");

        ivtitle = (TextView) findViewById(R.id.ivtitle);
        ivsubtitle = (TextView) findViewById(R.id.ivsubtitle);
        ivbtn = (TextView) findViewById(R.id.ivbtn);

        ivsplash = (ImageView) findViewById(R.id.ivsplash);

        ivtitle.setTypeface(logox);
        ivsubtitle.setTypeface(light);
        ivbtn.setTypeface(regular);

        ivsplash.startAnimation(smalltobig);

        ivtitle.setTranslationX(400);
        ivsubtitle.setTranslationX(400);
        ivbtn.setTranslationX(400);

        ivtitle.setAlpha(0);
        ivsubtitle.setAlpha(0);
        ivbtn.setAlpha(0);

        ivtitle.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        ivsubtitle.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        ivbtn.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(900).start();

        ivbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ax = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(ax);
                overridePendingTransition(R.anim.fleft, R.anim.fhelper);
            }
        });

    }
}
