package eu.giovannidefranceso.effectivenotes.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import eu.giovannidefranceso.effectivenotes.R;

/**
 * Created by jibbo on 26/07/15.
 */
public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesHolder> {

    @Override
    public NotesHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(NotesHolder notesHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class NotesHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.note_title)
        TextView noteTitle;

        Color c;

        public NotesHolder(View itemView) {
            super(itemView);
        }
    }
}
