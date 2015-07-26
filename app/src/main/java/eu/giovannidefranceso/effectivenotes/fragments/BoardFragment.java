package eu.giovannidefranceso.effectivenotes.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.activeandroid.query.Select;

import butterknife.ButterKnife;
import eu.giovannidefranceso.effectivenotes.model.Note;

/**
 * Created by jibbo on 26/07/15.
 */
public class BoardFragment extends ListFragment {

    public static final String KEY_TITLE = "title";

    private String mTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null && savedInstanceState.containsKey(KEY_TITLE)){
            mTitle = savedInstanceState.getString(KEY_TITLE);
        }else if( getArguments()!=null && getArguments().containsKey(KEY_TITLE)){
            mTitle = getArguments().getString(KEY_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View out = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, out);
        return out;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (mTitle != null) {
            outState.putString(KEY_TITLE,mTitle);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public static BoardFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString(KEY_TITLE, title);
        BoardFragment fragment = new BoardFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
