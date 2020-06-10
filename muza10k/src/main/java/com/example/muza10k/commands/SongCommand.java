package com.example.muza10k.commands;

import com.example.muza10k.model.Artist;
import com.example.muza10k.model.Publisher;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class SongCommand {
    private Long id;
    private String title;
    private String genre;
    private String ismn;
    private String year;
    private Long publisherId;
    private Long artistId;
}