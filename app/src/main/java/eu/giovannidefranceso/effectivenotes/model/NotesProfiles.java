package eu.giovannidefranceso.effectivenotes.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

/**
 * Created by jibbo on 26/07/15.
 */
@Table(name = "NotesProfile")
public class NotesProfiles extends Model {
    public List<Note> items() {
        return getMany(Note.class, "profile");
    }
}
