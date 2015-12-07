package eu.giovannidefranceso.effectivenotes.activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import eu.giovannidefranceso.effectivenotes.R;
import eu.giovannidefranceso.effectivenotes.model.Note;
import eu.giovannidefranceso.effectivenotes.model.Profile;

/**
 * Created by jibbo on 26/07/15.
 */
public class AddNoteActivity extends AppCompatActivity {

    private String mType;

    @Bind(R.id.content)
    EditText mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        ButterKnife.bind(this);
        if(savedInstanceState!=null && savedInstanceState.containsKey(Note.TYPE_KEY)){
            mType=savedInstanceState.getString(Note.TYPE_KEY);
        }else if(getIntent().getExtras().containsKey(Note.TYPE_KEY)){
            mType=getIntent().getStringExtra(Note.TYPE_KEY);
        }
        mContent.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/HandTest.ttf"));
        if(Build.VERSION.SDK_INT>=21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(),R.color.yellow));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if(mType!=null){
            outState.putString(Note.TYPE_KEY,mType);
        }
        super.onSaveInstanceState(outState);
    }

    @OnClick(R.id.fabBtn)
    public void clickedFAB(){
        saveNote();
        finish();
    }

    private void saveNote(){
        //TODO add profiles support
        Profile p = new Profile("Personal");
        p.save();
        //TODO Add color support;
        Note n = new Note(mContent.getText().toString(), p, "#ffcc11", mType);
        n.save();
    }
}
