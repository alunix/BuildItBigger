package app.com.example.ttins.androidjokelib;

import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class JokeLibMainActivity extends AppCompatActivity {

    public final static String INTENT_JOKE = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jokelib_activity_main);

        Intent intent = getIntent();

        if (intent != null && intent.hasExtra(INTENT_JOKE)) {
            String joke = intent.getStringExtra(INTENT_JOKE);
            FragmentManager fm = getSupportFragmentManager();
            MainActivityFragment fragment = new MainActivityFragment();
            Bundle bundle = new Bundle();
            bundle.putString(INTENT_JOKE, joke);
            fragment.setArguments(bundle);

            fm.beginTransaction().replace(R.id.fragment, fragment).commit();
        }

    }

}
