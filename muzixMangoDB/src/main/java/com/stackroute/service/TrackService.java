package com.stackroute.Service;



import com.stackroute.Domain.Track;
import com.stackroute.Exceptions.GlobalException;
import com.stackroute.Exceptions.TrackAlreadyExistsException;
import com.stackroute.Exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    public Track savingTrack(Track track) throws TrackAlreadyExistsException;
    //public List<Track> getAllTracksByNameById(String trackName, int trackId) throws TrackNotFoundException;

    public boolean deleteTrack(Track track) throws TrackNotFoundException;
    public Track searchTrack(Track track) throws TrackNotFoundException;
    public List<Track> getAllTracks();
    public Track updateComment(Track track) throws GlobalException;



}
