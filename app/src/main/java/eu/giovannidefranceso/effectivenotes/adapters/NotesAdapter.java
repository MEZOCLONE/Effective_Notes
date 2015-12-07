package eu.giovannidefranceso.effectivenotes.adapters;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import eu.giovannidefranceso.effectivenotes.R;
import eu.giovannidefranceso.effectivenotes.model.Note;

/**
 * Created by jibbo on 26/07/15.
 */
public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesHolder> {

    private List<Note> mNotes;

    public NotesAdapter(List<Note> notes) {
        mNotes = notes;
    }

    @Override
    public NotesHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // create a new view
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_note, viewGroup, false);
        // set the view's size, margins, paddings and layout parameters
        NotesHolder nh = new NotesHolder(v);
        nh.noteTitle.setTypeface(Typeface.createFromAsset(viewGroup.getContext().getAssets(), "fonts/HandTest.ttf"));
        return nh;
    }

    @Override
    public void onBindViewHolder(NotesHolder notesHolder, int position) {
        final Note n = mNotes.get(position);
        notesHolder.noteTitle.setText(n.content);
        if (n.color != null) {
            notesHolder.noteTitle.setBackgroundColor(Color.parseColor(n.color));
        }

    }

    @Override
    public int getItemCount() {
        if (mNotes == null) {
            return 0;
        }
        return mNotes.size();
    }

    public void refresh(List<Note> notes) {
        mNotes = notes;
        notifyDataSetChanged();
    }

    public class NotesHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.note_title)
        public TextView noteTitle;

        public NotesHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
