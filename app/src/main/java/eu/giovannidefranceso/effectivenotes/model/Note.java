package eu.giovannidefranceso.effectivenotes.model;

import android.support.annotation.Nullable;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import org.parceler.Parcel;

/**
 * Created by jibbo on 26/07/15.
 */
@Parcel
@Table(name = "Note")
public class Note extends Model {
    @Column(name = "title")
    public String title;
    @Column(name = "content")
    public String content;
    @Column(name = "profile")
    public Profile profile;
    @Column(name = "color")
    public String color;
    @Column(name = "type")
    public String type;

    public Note() {
        //TODO find a way to localize it.
        this.profile= new Profile("Personal");
    }

    public Note(String title, String content,@Nullable Profile profile, String color, String type) {
        this.title = title;
        this.content = content;
        if(profile==null){
            this.profile= new Profile("Personal");
        }else {
            this.profile = profile;
        }
        this.color = color;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
