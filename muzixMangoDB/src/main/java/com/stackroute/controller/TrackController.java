package com.stackroute.controller;


import com.stackroute.domain.Track;
import com.stackroute.exceptions.GlobalException;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Autowire
@RestController
@RequestMapping("api/v1/")
public class TrackController {
    TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping(value = "track")
    public ResponseEntity<Track> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException
    {
        ResponseEntity responseEntity;
        Track savedTrack=null;
        savedTrack = trackService.savingTrack(track);
        responseEntity = new ResponseEntity<Track>(savedTrack, HttpStatus.CREATED);
        return responseEntity;
    }


    @GetMapping(value = "tracks")
    public ResponseEntity<List<Track>> getAllTracks()
    {
        List<Track> track1=trackService.getAllTracks();
        return new ResponseEntity<List<Track>>(track1,HttpStatus.OK);
    }


    @RequestMapping(value="track/{id}",method=RequestMethod.PUT)
    public ResponseEntity<Track> updateTrack(@RequestBody Track track) throws TrackNotFoundException, GlobalException {

            ResponseEntity responseEntity;
            responseEntity=new ResponseEntity<Track>(trackService.updateComment(track), HttpStatus.OK);
            return responseEntity;
        }


    @DeleteMapping("track/{id}")
    public ResponseEntity<String> deleteTrack(@RequestBody Track track) throws TrackNotFoundException
    {
        ResponseEntity responseEntity;

            boolean answer=trackService.deleteTrack(track);
            responseEntity= new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
            return responseEntity;
    }


}
