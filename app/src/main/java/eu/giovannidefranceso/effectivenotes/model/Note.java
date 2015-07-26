package eu.giovannidefranceso.effectivenotes.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by jibbo on 26/07/15.
 */
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
}
