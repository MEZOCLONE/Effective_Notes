package eu.giovannidefranceso.effectivenotes.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;
import eu.giovannidefranceso.effectivenotes.R;
import eu.giovannidefranceso.effectivenotes.model.Note;
import eu.giovannidefranceso.effectivenotes.model.ParcelableNote;

/**
 * Created by jibbo on 16/12/15.
 */
public class EditNoteActivity extends AddNoteActivity {

    public static String NOTE_KEY = "note";

    private ParcelableNote mNote;
    private static Note note;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            mNote = Parcels.unwrap(savedInstanceState.getParcelable(NOTE_KEY));
        } else if (getIntent().getExtras() != null) {
            mNote = Parcels.unwrap(getIntent().getParcelableExtra(NOTE_KEY));
        }


        refresh();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(NOTE_KEY, Parcels.wrap(mNote));
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void saveNote() {
        note = Note.load(Note.class,mNote.id);
        note.content=mContent.getText().toString();
        note.save();
    }



    private void refresh() {
        //TODO add color support
        mContent.setText(mNote.content);
    }


}
