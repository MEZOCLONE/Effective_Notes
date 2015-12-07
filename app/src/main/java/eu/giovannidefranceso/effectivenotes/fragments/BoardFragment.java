package eu.giovannidefranceso.effectivenotes.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.activeandroid.query.Select;

import org.parceler.Parcels;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import eu.giovannidefranceso.effectivenotes.R;
import eu.giovannidefranceso.effectivenotes.adapters.NotesAdapter;
import eu.giovannidefranceso.effectivenotes.model.Note;

/**
 * Created by jibbo on 26/07/15.
 */
public class BoardFragment extends Fragment {

    public static final String KEY_TITLE = "title";
    public static final String KEY_NOTES = "notes";

    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private String mTitle;
    private List<Note> mNotes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(KEY_TITLE)) {
                mTitle = savedInstanceState.getString(KEY_TITLE);
            }
        } else if (getArguments() != null && getArguments().containsKey(KEY_TITLE)) {
            mTitle = getArguments().getString(KEY_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View out = inflater.inflate(R.layout.fragment_board, container, false);
        ButterKnife.bind(this, out);
        return out;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (mTitle != null) {
            outState.putString(KEY_TITLE, mTitle);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mNotes != null) {
            mRecyclerView.setAdapter(new NotesAdapter(mNotes));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        refresh();
    }

    public static BoardFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString(KEY_TITLE, title);
        BoardFragment fragment = new BoardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void refresh() {
        if (mTitle != null) {
            //TODO add profiles
            mNotes = new Select().from(Note.class).where("type=?", mTitle).execute();
        }
        if (mRecyclerView.getAdapter() != null) {
            ((NotesAdapter) mRecyclerView.getAdapter()).refresh(mNotes);
        } else {
            mRecyclerView.setAdapter(new NotesAdapter(mNotes));
        }
    }
}
