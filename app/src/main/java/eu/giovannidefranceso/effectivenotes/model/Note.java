package eu.giovannidefranceso.effectivenotes.model;

import android.support.annotation.Nullable;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import org.json.JSONObject;

/**
 * Created by jibbo on 26/07/15.
 */

@Table(name = "Note")
public class Note extends Model {

    public final static String TYPE_KEY = "type";

    @Column(name = "content")
    public String content;
    @Column(name = "profile",onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Profile profile;
    @Column(name = "color")
    public String color;
    @Column(name = "type")
    public String type;


    public Note() {
        //TODO find a way to localize the first.
        this.profile = new Profile("Personal");
    }

    public Note(String content, @Nullable Profile profile, String color, String type) {
        this.content = content;
        if (profile == null) {
            this.profile = new Profile("Personal");
        } else {
            this.profile = profile;
        }
        this.color = color;
        this.type = type;
    }

    public ParcelableNote toParcelableNote() {
        return Note.toParcelableNote(this);
    }

    public static ParcelableNote toParcelableNote(Note n) {
        return new ParcelableNote(n.getId(),n.content, n.profile.toParcelableProfile(), n.color, n.type);
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
