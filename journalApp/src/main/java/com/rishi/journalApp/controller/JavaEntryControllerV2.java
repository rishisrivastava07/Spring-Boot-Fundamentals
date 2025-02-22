package com.rishi.journalApp.controller;

import com.rishi.journalApp.entity.JournalEntry;
import com.rishi.journalApp.entity.User;
import com.rishi.journalApp.service.JournalEntryService;
import com.rishi.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journalv2")
public class JavaEntryControllerV2 {
    //    special type of classes or components handle HTTP requests
    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

    @GetMapping("{username}")
    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String username) { // localhost:8080/journal GET
        User userFromDB = userService.findByUsername(username);
        List<JournalEntry> allEntries = userFromDB.getJournalEntries();

        if (!allEntries.isEmpty()) {
            return new ResponseEntity<>(allEntries, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("{username}")
    public ResponseEntity<?> create_entry(@RequestBody JournalEntry myEntry, @PathVariable String username) { // localhost:8080/journal POST
        try {
            journalEntryService.saveEntry(myEntry, username);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getEntryById(@PathVariable ObjectId myId) {
        Optional<JournalEntry> journalEntry = journalEntryService.getEntryById(myId);
        if (journalEntry.isPresent()) {
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("{username}/id/{myId}")
    public ResponseEntity<?> deleteEntryById(@PathVariable ObjectId myId, @PathVariable String username) {
        journalEntryService.deleteEntry(myId, username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{username}/id/{myId}")
    public ResponseEntity<JournalEntry> updateEntryById(@PathVariable ObjectId myId, @RequestBody JournalEntry newEntry, @PathVariable String username) {
        JournalEntry oldentry = journalEntryService.getEntryById(myId).orElse(null);
        if (oldentry != null) {
            oldentry.setTitle(!newEntry.getTitle().isEmpty() ? newEntry.getTitle() : oldentry.getTitle());
            oldentry.setContent(newEntry.getContent() != null && !newEntry.getContent().isEmpty() ? newEntry.getContent() : oldentry.getContent());
            journalEntryService.saveEntry(oldentry);
            return new ResponseEntity<>(oldentry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
