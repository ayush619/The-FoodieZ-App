package com.ayush.springmvcboot.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Document
@Data
@Builder
public class JournalEntry
{
    @MongoId
    @Indexed(unique = true)
    private ObjectId jid;

    @NonNull
    private String entry;

    @NonNull
    private LocalDateTime localDateTime;

}
