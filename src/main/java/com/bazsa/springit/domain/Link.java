package com.bazsa.springit.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
public class Link extends Auditable{

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String url;

    @OneToMany(mappedBy = "link")
    private List< Comment> comments = new ArrayList<>();

    public Link(@NonNull String title, @NonNull String url) {
        this.title = title;
        this.url = url;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }
}
