package sampleBoard.sampleBoard.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    //회원가입 아이디
    private String memberLoginId;
    
    //비밀번호
    private String memberLoginPw;


    //생성일시
    private LocalDateTime createdDate;

    //수정일시
    private LocalDateTime  updatedDate;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberLoginId() {
        return memberLoginId;
    }

    public void setMemberLoginId(String memberLoginId) {
        this.memberLoginId = memberLoginId;
    }

    public String getMemberLoginPw() {
        return memberLoginPw;
    }

    public void setMemberLoginPw(String memberLoginPw) {
        this.memberLoginPw = memberLoginPw;
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
        return "MemberEntity{" +
                "memberId=" + memberId +
                ", memberLoginId='" + memberLoginId + '\'' +
                ", memberLoginPw='" + memberLoginPw + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}


