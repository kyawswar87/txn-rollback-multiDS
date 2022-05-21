package com.example.multipledb.controllers;

import com.example.multipledb.models.lyrics.LyricsModel;
import com.example.multipledb.models.request;
import com.example.multipledb.models.song.SongModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComposeController {

    @Autowired
    ComposeService composeService;

    @PostMapping
    public ResponseEntity add(@RequestBody request body) throws Exception {
        SongModel songModel = new SongModel();
        LyricsModel lyricsModel = new LyricsModel();
        songModel.setName(body.getSong());
        lyricsModel.setContent(body.getContent());

        composeService.save(songModel,lyricsModel);
        return ResponseEntity.ok(body);
    }
}
