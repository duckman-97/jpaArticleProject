package sampleBoard.sampleBoard.service;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import sampleBoard.sampleBoard.entity.MemberEntity;
import sampleBoard.sampleBoard.repository.MemberRepository;

@Service
public class MemberService {


    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;

    }

    @Transactional
    public void saveMember(MemberEntity entity){
        memberRepository.save(entity);
    }


    @Transactional
    public void deleteMember(MemberEntity entity){
        Long memberId = entity.getMemberId();
        memberRepository.deleteById(memberId);
    }

}
