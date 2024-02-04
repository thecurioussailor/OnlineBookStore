package com.vecv.obsapplication.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "authors")
    private String authors;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;

    @Column(name = "cover_image")
    private String coverImage;

    @Column(name = "language")
    private String language;

    @Column(name = "format")
    private String format;

    @Column(name = "page_count")
    private Integer pageCount;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genres genre;

    @Column(name = "average_rating")
    private Float averageRating;

    @Column(name = "total_ratings")
    private Integer totalRatings;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;


    // Constructors, getters, and setters


    public Book() {
    }

    public Book(String title, String description, String authors, String isbn, Integer publicationYear, String publisher, BigDecimal price, Integer quantityInStock, String coverImage, String language, String format, Integer pageCount, Genres genre, Float averageRating, Integer totalRatings, LocalDate createDate, LocalDate updateDate) {
        this.title = title;
        this.description = description;
        this.authors = authors;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.coverImage = coverImage;
        this.language = language;
        this.format = format;
        this.pageCount = pageCount;
        this.genre = genre;
        this.averageRating = averageRating;
        this.totalRatings = totalRatings;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    public Float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Float averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(Integer totalRatings) {
        this.totalRatings = totalRatings;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", authors='" + authors + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publicationYear=" + publicationYear +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                ", coverImage='" + coverImage + '\'' +
                ", language='" + language + '\'' +
                ", format='" + format + '\'' +
                ", pageCount=" + pageCount +
                ", genre=" + genre +
                ", averageRating=" + averageRating +
                ", totalRatings=" + totalRatings +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}

