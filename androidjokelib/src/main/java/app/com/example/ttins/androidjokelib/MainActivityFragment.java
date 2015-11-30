package app.com.example.ttins.androidjokelib;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.jokelib_fragment_main, container, false);

        if (getArguments() != null && getArguments().containsKey(JokeLibMainActivity.INTENT_JOKE)) {
            String joke = getArguments().getString(JokeLibMainActivity.INTENT_JOKE);
            TextView jokeTextView = (TextView) rootView.findViewById(R.id.fragment_joke_textview);
            jokeTextView.setText(joke);
        }

        return rootView;
    }
}
