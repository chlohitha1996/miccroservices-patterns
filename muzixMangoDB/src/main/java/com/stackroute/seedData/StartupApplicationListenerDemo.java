package com.stackroute.approaches;

import com.stackroute.Domain.Track;
import com.stackroute.Repository.TrackRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class StartupApplicationListenerDemo implements
        ApplicationListener<ContextRefreshedEvent> {

    private TrackRepository trackRepository;

    @Autowired
    private Environment environment;

    public StartupApplicationListenerDemo(TrackRepository trackRepository, Environment environment) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Track track = new Track(Integer.parseInt(environment.getProperty("app.trackId")), environment.getProperty("app.trackName"), environment.getProperty("app.trackcomments"));
        trackRepository.save(track);
    }
}