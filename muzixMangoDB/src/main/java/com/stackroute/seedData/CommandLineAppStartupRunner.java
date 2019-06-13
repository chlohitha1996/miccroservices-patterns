package com.stackroute.approaches;



import com.stackroute.Domain.Track;
import com.stackroute.Repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner{

    @Value("${track.trackId}")
    private int trackId;
    @Value("${track.trackName}")
    private String trackName;
    @Value("${track.trackComments}")
    private String trackComments;

    private TrackRepository trackRepository;
    Track track=new Track();

    @Autowired
    public CommandLineAppStartupRunner(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        track.setTrackId(trackId);
        track.setTrackName(trackName);
        track.setTrackcomments(trackComments);
        trackRepository.save(track);
    }

}