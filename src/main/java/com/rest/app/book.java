package com.rest.app;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book_record")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    @NonNull
    private String name;

    @NonNull
    private String sum;

    private int rate;
}
