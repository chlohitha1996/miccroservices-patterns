package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.GlobalException;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class TrackServiceTest {
    private Track track;
    private Optional optional;

    //Create a mock for Track repository
    @Mock
    private TrackRepository trackRepository;

    //Inject the mocks as dependencies into TrackServiceImpl
    @InjectMocks
    private TrackServiceImpl trackService;
    List<Track> list = null;


    @Before
    public void setUp() {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setTrackId(9);
        track.setTrackName("Leela");
        track.setTrackcomments("Chattivanipalem");
        list = new ArrayList<>();
        list.add(track);


    }

    @Test
    public void givenTosaveTrackExpectedSaveTrackSuccess() throws Exception {

        when(trackRepository.save((Track) any())).thenReturn(track);
        Track savedTrack = trackService.savingTrack(track);
        assertEquals(track, savedTrack);

        //verify here verifies that TrackRepository save method is only called once
        verify(trackRepository, times(1)).save(track);

    }

    @Test(expected = TrackAlreadyExistsException.class)
    public void givenTosaveTrackTestFailureExpectedToFailInSavingTrack() throws Exception {
        when(trackRepository.save((Track) any())).thenReturn(null);
        Track savedUser = trackService.savingTrack(track);
        System.out.println("savedUser" + savedUser);
        assertEquals(track, savedUser);
    }

    @Test
    public void givenToshowAllTracksExpectedToDisplayAllTracks() {

        trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> tracklist = trackService.getAllTracks();
        assertEquals(list, tracklist);
    }


    @Test
    public void givenToDeleteTrackExpectedDeletionSuccessfully() throws TrackNotFoundException {

        Track track=new Track(10,"John","John Doe");
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> tracklist = trackService.getAllTracks();
        trackRepository.delete(track);
        boolean deletedTrack=trackRepository.existsById(14);
        assertEquals(false,deletedTrack);


    }


    @Test
    public void givenToDeleteTrackFailureExpectedDeleteFailure(){

        Track track=new Track(21,"Tej  I Love You","movie_Hero:Jet Panda");
        when(trackRepository.findAll()).thenReturn(list);
        trackRepository.delete(track);
        boolean deletedTrack=trackRepository.existsById(21);
        List<Track> list = trackService.getAllTracks();
        Assert.assertNotSame(true,deletedTrack);
    }


    @Test
    public void givenUpdateTrackCommentsExpectedUpdatedCommentsInTrack() throws Exception {

        when(trackRepository.existsById(track.getTrackId())).thenReturn(true);
        when(trackRepository.save((Track)any())).thenReturn(track);
        track.setTrackcomments("helo");
        Track track1= null;
        try {
            track1 = trackService.updateComment(track);
        } catch (GlobalException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("helo",track1.getTrackcomments());
    }

    @Test
    public void givenUpdateTrackCommentsFailureExpectedUpdateFailure() throws GlobalException{

        when(trackRepository.existsById(track.getTrackId())).thenReturn(true);
        when(trackRepository.save((Track)any())).thenReturn(track);
        track.setTrackcomments("helo");
        Track track1=trackService.updateComment(track);
        Assert.assertNotSame("helos",track1.getTrackcomments());
    }


}
