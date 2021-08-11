package org.example.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "reviews")
public class Review {

    @Embeddable
    public static class Id implements Serializable {
        @Column(name = "reader_id")
        Long readerId;

        @Column(name = "book_id")
        Long bookId;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Id id = (Id) o;
            return Objects.equals(readerId, id.readerId) && Objects.equals(bookId, id.bookId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(readerId, bookId);
        }
    }

    @EmbeddedId
    Id id;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    Reader reader;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;

}
