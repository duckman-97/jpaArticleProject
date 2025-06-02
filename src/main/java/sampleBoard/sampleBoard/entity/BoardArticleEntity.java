package sampleBoard.sampleBoard.entity;
import java.time.LocalDateTime;


import jakarta.persistence.*;

@Entity
@Table(name = "boardArticle")
public class BoardArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    
    //제목
    private String articleTitle;

    //내용
    private String articleContent;

    //작성자
    private String articleWriter;

    //작성일시
    private LocalDateTime  createdDate;

    //수정일시
    private LocalDateTime  updatedDate;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleWriter() {
        return articleWriter;
    }

    public void setArticleWriter(String articleWriter) {
        this.articleWriter = articleWriter;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "BoardArticleEntity{" +
                "articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleWriter='" + articleWriter + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
