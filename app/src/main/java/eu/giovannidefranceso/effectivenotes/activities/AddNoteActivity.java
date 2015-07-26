package eu.giovannidefranceso.effectivenotes.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import eu.giovannidefranceso.effectivenotes.R;
import eu.giovannidefranceso.effectivenotes.adapters.SectionsPagerAdapter;
import eu.giovannidefranceso.effectivenotes.fragments.BoardFragment;
import eu.giovannidefranceso.effectivenotes.model.Note;
import eu.giovannidefranceso.effectivenotes.model.Profile;

/**
 * Created by jibbo on 26/07/15.
 */
public class AddNoteActivity extends AppCompatActivity {

    public final static String KEY_TYPE="type";

    private String mType;

    @Bind(R.id.title)
    EditText mTitle;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.desc)
    EditText mDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        if(savedInstanceState!=null && savedInstanceState.containsKey(KEY_TYPE)){
            mType=savedInstanceState.getString(KEY_TYPE);
        }else if(getIntent().getExtras().containsKey(KEY_TYPE)){
            mType=getIntent().getStringExtra(KEY_TYPE);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if(mType!=null){
            outState.putString(KEY_TYPE,mType);
        }
        super.onSaveInstanceState(outState);
    }

    @OnClick(R.id.fabBtn)
    public void clickedFAB(){
        saveNote();
        finish();
    }

    private void saveNote(){
        Profile p = new Profile("Personal");
        p.save();
        //TODO Add color support;
        Note n = new Note(mTitle.getText().toString(), mDesc.getText().toString(), p, "#ffcc11", mType);
        n.save();
    }
}
