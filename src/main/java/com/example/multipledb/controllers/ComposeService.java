package com.example.multipledb.controllers;

import com.example.multipledb.models.lyrics.LyricsModel;
import com.example.multipledb.models.song.SongModel;
import com.example.multipledb.repositories.lyrics.LyricsRepo;
import com.example.multipledb.repositories.song.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComposeService {

    @Autowired
    LyricsRepo lyricsRepo;
    @Autowired
    SongRepo songRepo;

    @Autowired
    ChainedTransactionManager transactionManager;

    // need add roll back for exception,if not, the txn is not roll back.
    @Transactional(rollbackFor = {Exception.class,Throwable.class},value="chainedTransactionManager", propagation = Propagation.REQUIRES_NEW)
    public void save(SongModel songModel, LyricsModel lyricsModel) throws Exception{

//        will insert in Song DB
        songRepo.save(songModel);
//        will insert in Lyrics DB
        lyricsRepo.save(lyricsModel);
        // intentionally throw exception to simulate the rollback case.
        throw new Exception("this is fake throw");
    }
}
