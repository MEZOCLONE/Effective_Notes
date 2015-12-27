package eu.giovannidefranceso.effectivenotes.activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import com.activeandroid.query.Select;
import com.squareup.otto.Subscribe;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import eu.giovannidefranceso.effectivenotes.R;
import eu.giovannidefranceso.effectivenotes.model.BackPressed;
import eu.giovannidefranceso.effectivenotes.model.EffectiveNotesApplication;
import eu.giovannidefranceso.effectivenotes.model.Note;
import eu.giovannidefranceso.effectivenotes.model.Profile;

/**
 * Created by jibbo on 26/07/15.
 */
public class AddNoteActivity extends AppCompatActivity {

    private String mType;

    @Bind(R.id.content)
    EditText mContent;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        ButterKnife.bind(this);
        if (savedInstanceState != null && savedInstanceState.containsKey(Note.TYPE_KEY)) {
            mType = savedInstanceState.getString(Note.TYPE_KEY);
        } else if (getIntent().getExtras().containsKey(Note.TYPE_KEY)) {
            mType = getIntent().getStringExtra(Note.TYPE_KEY);
        }
        mContent.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/HandTest.ttf"));
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.yellow));
        }

        prepareToolbar();
    }

    @Override
    public void onBackPressed() {
        clickedFAB();
        super.onBackPressed();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (mType != null) {
            outState.putString(Note.TYPE_KEY, mType);
        }
        super.onSaveInstanceState(outState);
    }


    @OnClick(R.id.fabBtn)
    public void clickedFAB() {
        saveNote();
        finish();
    }

    private void prepareToolbar() {
        mToolbar.inflateMenu(R.menu.menu_note);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected void saveNote() {
        if (mContent.getText().toString().trim().length() > 0) {
            //TODO add profiles support
            List tmp = new Select().from(Profile.class).where("name=?", "Personal").execute();
            Profile p;
            if (tmp == null || tmp.size() == 0) {
                p = new Profile("Personal");
                //TODO this is an hotfix for the first profile.
                p.save();
            } else {
                p = (Profile) tmp.get(0);
            }
            //TODO Add color support;

            Note n = new Note(mContent.getText().toString(), p, "#ffcc11", mType);
            n.save();
        }
    }
}
