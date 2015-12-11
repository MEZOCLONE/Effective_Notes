package eu.giovannidefranceso.effectivenotes.model;


import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by jibbo on 11/12/15.
 */
public class EffectiveNotesApplication extends com.activeandroid.app.Application {
    public static Bus eventBus = new Bus(ThreadEnforcer.MAIN);
}
